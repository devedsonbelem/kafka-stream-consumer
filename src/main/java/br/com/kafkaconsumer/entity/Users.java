package br.com.kafkaconsumer.entity;

 

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

 import br.com.kafkaconsumer.helper.UsersConverter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "nome", "email", "status" })
public class Users {

	@JsonProperty("id")
	private String id;
	@JsonProperty("nome")
	private String nome;
	@JsonProperty("email")
	private String email;
	@JsonProperty("status")
	private String status;

	@JsonProperty("nome")
	public String getNome() {
		return nome;
	}

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(String id, String nome, String email, String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.status = status;
	}

 
 
	
	public String toString() {
		 return   this.id + ";" +  this.nome + ";" +  this.email  + ";" + this.status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
