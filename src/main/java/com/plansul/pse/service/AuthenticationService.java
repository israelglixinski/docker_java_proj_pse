package com.plansul.pse.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.plansul.pse.dto.LoginUserDTO;
import com.plansul.pse.dto.RegisterUserDTO;
import com.plansul.pse.entity.User;
import com.plansul.pse.entity.UserCP;
import com.plansul.pse.repository.EmpregadoRepository;
import com.plansul.pse.repository.UserCPRepository;
import com.plansul.pse.repository.UserRepository;

import jakarta.xml.bind.DatatypeConverter;

import com.plansul.pse.entity.Empregado;
import com.plansul.pse.entity.Role;

@Service
public class AuthenticationService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserCPRepository userCpRepository;
	@Autowired    
	PasswordEncoder passwordEncoder;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	EmpregadoRepository empregadoRepository;

	public User signup(RegisterUserDTO input) {
		User user = new User(
				input.no_usuario()
				,input.matricula()
				,passwordEncoder.encode(input.password())
				);
		Optional<Empregado> emp = empregadoRepository.findByDeMatricula(Long.parseLong(input.matricula()) );

		if(emp.isPresent()) {
			user.setEmpregado(emp.get());
		}

		return userRepository.save(user);
	}

	public Optional<User> getCpUser(LoginUserDTO input){

		Optional<User> existinUser = userRepository.findByMatricula(input.matricula());
		Optional<UserCP> userCp = userCpRepository.findByDeMatricula(Long.parseLong(input.matricula()));
		boolean userInCp = false;
		User newUser = new User();

		if(userCp.isPresent() && existinUser.isEmpty()) {
			try { 
				byte[] md5Hex = DigestUtils
						.md5Digest(input.password().getBytes());

				String hashedPass = DatatypeConverter
						.printHexBinary(md5Hex).toLowerCase();

				userInCp = hashedPass.equals(userCp.get().getPassword());

				if(userInCp) {
					Optional<Empregado> emp = empregadoRepository.findByDeMatricula(Long.parseLong(input.matricula()) );
					if(emp.isPresent()) {
						User user = new User(
								emp.get().getNome()
								,input.matricula()
								,passwordEncoder.encode(input.password())
								);
						user.setEmpregado(emp.get());
						newUser = userRepository.save(user);
					}
				}

			} catch (Exception e) {
				userInCp = false;
				System.err.println(e.getMessage());
			}
			return Optional.of(newUser);
		}
		else {
			return Optional.empty();       		
		}
	}

	public User authenticate(LoginUserDTO input) {

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						input.matricula(),
						input.password()
						)
				);

		Optional<User> user = userRepository.findByMatricula(input.matricula());

		if(user.isPresent()) {
			return user.get();
		}else { return user.orElseThrow();}

	}

	
	
	
	public User concederAcesso(Role role, Long matricula) {
		Optional<User> userP = userRepository.findByMatricula(matricula.toString());
		
		if(userP.isPresent()) {
			User user = userP.get();
			
			Set<Role> roles = user.getAuthoritiesList();
			roles.add(role);
			user.setAuthorities(roles);
			
			return userRepository.save(user);			
		}else {
			return null;
		}
	}

}
