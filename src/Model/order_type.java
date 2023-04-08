package Model;

public class order_type {
	private Integer id;
	private String type_name;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	private Integer fake;
	
	
	public order_type(String type_name, String created_at, Integer fake) {
		super();
		this.type_name = type_name;
		this.created_at = created_at;
		this.fake = fake;
	}
	public order_type() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
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
	public String getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}
	public Integer getFake() {
		return fake;
	}
	public void setFake(Integer fake) {
		this.fake = fake;
	}
	
	
	
	
}
