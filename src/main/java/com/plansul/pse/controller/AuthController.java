package com.plansul.pse.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plansul.pse.dto.LoginResponseDTO;
import com.plansul.pse.dto.LoginUserDTO;
import com.plansul.pse.dto.RegisterUserDTO;
import com.plansul.pse.entity.Role;
import com.plansul.pse.entity.User;
import com.plansul.pse.service.AuthenticationService;
import com.plansul.pse.service.JwtService;

import jakarta.websocket.server.PathParam;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	JwtService jwtService;
	@Autowired
	AuthenticationService authenticationService; 
	
	@PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterUserDTO registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }
	

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> authenticate(@RequestBody LoginUserDTO loginUserDto) {
    	System.out.println("TESSSSSTE");
    	
    	Optional<User> userCp = authenticationService.getCpUser(loginUserDto);
    	User authenticatedUser;
    	if(userCp.isPresent()) {
    		System.out.println(loginUserDto.password());
    		LoginUserDTO tempDto = new LoginUserDTO(userCp.get().getMatricula(), loginUserDto.password());
    		authenticatedUser = authenticationService.authenticate(tempDto);    		
    	}else {
    		authenticatedUser = authenticationService.authenticate(loginUserDto);  
    	}

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDTO loginResponse = new LoginResponseDTO(
        		jwtToken
        		,jwtService.getExpirationTime()
        		);
        
        return ResponseEntity.ok(loginResponse);
    }
	
    
    
    @PostMapping("/acesso/{matricula}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<User> concederAcesso(@PathVariable Long matricula, @RequestBody Role role) {
    	System.out.println("TESSSSSTE");
    	return ResponseEntity.ok(authenticationService.concederAcesso(role, matricula));
    }
	
    
    
    
    
    
    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
    
    
    @GetMapping("/adm/test")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<String> test_adm() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        
        return new ResponseEntity<String>("Você é bacana "+currentUser.getNoUsuario(), HttpStatus.OK);
    }

    
}
