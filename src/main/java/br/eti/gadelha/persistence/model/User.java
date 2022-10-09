package br.eti.gadelha.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Audited @Entity @Data @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
@Table(	name = "user",
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User extends GenericEntity {
	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;
	private Boolean active;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "om")
	private OM om;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles",
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public User(String username, String email, String password, Boolean active) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.active = active;
	}
}