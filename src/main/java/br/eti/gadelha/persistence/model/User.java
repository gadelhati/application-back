package br.eti.gadelha.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Audited @AuditTable(value = "audit_user")
@Entity @Data @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
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
	private Boolean ativo;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_role",
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public User(String username, String email, String password, Boolean ativo) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.ativo = ativo;
	}
}