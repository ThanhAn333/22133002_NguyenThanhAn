package vn.iostar.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT c FROM User c")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8614254998831211337L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Username", columnDefinition = "NVARCHAR(200) NOT NULL")
	private String username;
	
	@Column(name="Password", columnDefinition = "NVARCHAR(200) NOT NULL")
	private String password;
	
	@Column(name="images", columnDefinition = "NVARCHAR(200) NOT NULL")
	private String images;


	@Column(name="Fullname", columnDefinition = "NVARCHAR(200) NOT NULL")
	private String fullname;
	
	@Column(name="Email", columnDefinition = "NVARCHAR(200) NOT NULL")
	private String email;
	
	@Column(name="Phone", columnDefinition = "NVARCHAR(200) NOT NULL")
	private String phone;
	
	@Column(name="RoleId")
	private String roleid;
	
	@Column(name="CreatedDate")
	private String createdDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
