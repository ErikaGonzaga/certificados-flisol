package br.ufc.petti.certificadosflisol.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name="users")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String email;
	
	@Column
	private String senha;

	@Column
	private String nome;
	
	@Column(name = "active")
	private int active;


	@ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(
			name="users_roles",
			joinColumns = @JoinColumn(
					name="user_id", referencedColumnName="id"),
			inverseJoinColumns = @JoinColumn(
					name="role_id", referencedColumnName="id"))
	private Collection<Role> roles;

	public Usuario() {}
	
	public Usuario(Integer id, String email, String senha, String role) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = role;
	}

	public Usuario(String email, String senha, String role) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = role;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", senha=" + senha + ", nome=" + nome + "]";
	}
	
}
