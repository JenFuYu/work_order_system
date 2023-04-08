package Model;

public class schools {
	private Integer id;
	private String school_name;
	private String phone;
	private String created_at;
	private String updated_at;
	private Integer fake; 
	private String deleted_at;
	
	public schools(String school_name, String phone, String created_at, Integer fake) {
		super();
		this.school_name = school_name;
		this.phone = phone;
		this.created_at = created_at;
		this.fake = fake;
	}
	public schools() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public Integer getFake() {
		return fake;
	}
	public void setFake(Integer fake) {
		this.fake = fake;
	}
	public String getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}
	
	

}
