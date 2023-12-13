package br.com.kafkaconsumer.entity;

import java.io.Serializable;

import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

public class Message  implements Serializable, Serializer {
 
	private static final long serialVersionUID = -604142884829169157L;

	private String uuid;

	private String name;
	
	private String status;

	private String email;

	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	 
	public Message(String uuid, String name, String email) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.email = email;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return   uuid + ";" + name + ";" + status + ";" + email;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

 
 

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    @Override
    public byte[] serialize(String s, Object o) {
        return new byte[0];
    }
    
    @Override
    public byte[] serialize(String topic, Headers headers, Object data) {
        return new byte[0];
    }
	

}
