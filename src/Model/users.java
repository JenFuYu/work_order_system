package Model;

public class users {
	private Integer id;
	private String user_name;
	private String english_name;
	private String email;
	private String password;
	private Integer gender;
	private String birth_date;
	private String cell_phone;
	private Integer school;
	private String created_at;
	private String updated_at;
	private Integer fake; 
	private String deleted_at;
	private Integer permission_id;
	public users(String user_name, String english_name, String email, String password, Integer gender, String birth_date,
			String cell_phone, Integer school,Integer permission_id, String created_at, Integer fake) {
		super();
		this.user_name = user_name;
		this.english_name = english_name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birth_date = birth_date;
		this.cell_phone = cell_phone;
		this.school = school;
		this.permission_id = permission_id;
		this.created_at = created_at;
		this.fake = fake;
	}
	public Integer getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}
	public users() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEnglish_name() {
		return english_name;
	}
	public void setEnglish_name(String english_name) {
		this.english_name = english_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getCell_phone() {
		return cell_phone;
	}
	public void setCell_phone(String cell_phone) {
		this.cell_phone = cell_phone;
	}
	public Integer getSchool() {
		return school;
	}
	public void setSchool(Integer school) {
		this.school = school;
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
