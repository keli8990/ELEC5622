package au.edu.sydney.seg.jsiento.server.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Users")
public class EntityUsers implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="Id")
	private int Id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;
	
	@Column(name="age")
	private int age;
	
	@Column(name="birth")
	private String birth;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="job_title")
	private String job_title;
	
	@Column(name="food_preference")
	private String food_preference;
	
	@Column(name="call_link")
	private String call_link;
	
	@Column(name="descp")
	private String descp;
	
	@Column(name="user_img")
	private String user_img;
	
	@Column(name="disease_img")
	private String disease_img;

	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getFood_preference() {
		return food_preference;
	}

	public void setFood_preference(String food_preference) {
		this.food_preference = food_preference;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCall_link() {
		return call_link;
	}

	public void setCall_link(String call_link) {
		this.call_link = call_link;
	}

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public String getUser_img() {
		return user_img;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

	public String getDisease_img() {
		return disease_img;
	}

	public void setDisease_img(String disease_img) {
		this.disease_img = disease_img;
	}
	
}
