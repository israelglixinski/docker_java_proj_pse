package com.plansul.pse.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "auth", name = "tb_usuario")
@Getter
@Setter
public class User implements UserDetails {
	@Transient
	@JsonIgnore
	String ROLE_PREFIX = "ROLE_";
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "co_usuario")
	private Long coUsuario;
	
	@Column(name = "no_usuario")	
	private String noUsuario;
	
	@Column(unique = true,name = "de_matricula")
	private String matricula;

	@Column(nullable = false)
	@JsonIgnore
	private String password;// Senha Cripitografada
	
	
    @CreationTimestamp
    @Column(updatable = false, name = "dt_criacao")
    private Date dtCriacao;

    @UpdateTimestamp
    @Column(name="dt_alteracao")
    private Date dtAlteracao;
    
    @OneToOne
    private Empregado empregado;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_acessos",
            joinColumns = {@JoinColumn(name = "co_usuario")},
            inverseJoinColumns = {@JoinColumn(name = "co_role")}
    )
    private Set<Role> authorities;
    
	
    
    
	public User() {}
	
	public User(String noUsuario, String matricula, String password ) {
		this.noUsuario = noUsuario;
		this.matricula = matricula;
		this.password = password;
	}

	@JsonIgnore
	public Set<Role> getAuthoritiesList(){
		return this.authorities;
	}
	
	@Override
	public List<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		if(this.authorities==null) {return List.of();}
		
		this.authorities.forEach(role ->{
			list.add(new SimpleGrantedAuthority(role.getAuthority()));			
		});

        return list;
	}

	@Override
	@JsonIgnore
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	@JsonIgnore
	public String getUsername() {
		// TODO Auto-generated method stub
		return matricula;
	}
	
	
    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
    
    
	
}


