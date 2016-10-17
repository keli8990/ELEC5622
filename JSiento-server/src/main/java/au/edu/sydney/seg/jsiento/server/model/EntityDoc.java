package au.edu.sydney.seg.jsiento.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Doctors")
public class EntityDoc implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="Id")
	private long Id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
