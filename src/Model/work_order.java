package Model;

public class work_order {
	private Integer id;
	private Integer school_id;
	private Integer submitter_id;
	private String created_at; 
	private Integer order_type_id;
	private String content; 
	private Integer assignment_id;
	private Integer general_affairs_id;
	private String end_time;
	private String remark;
	private Integer inspector_user_id;
	private String inspector_at;
	private Integer delete_user_id;
	private Integer fake;
	private String deleted_at;
	public work_order(Integer school_id, Integer submitter_id, String created_at, Integer order_type_id, String content,
			Integer fake) {
		super();
		this.school_id = school_id;
		this.submitter_id = submitter_id;
		this.created_at = created_at;
		this.order_type_id = order_type_id;
		this.content = content;
		this.fake = fake;
	}
	public work_order() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSchool_id() {
		return school_id;
	}
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}
	public Integer getSubmitter_id() {
		return submitter_id;
	}
	public void setSubmitter_id(Integer submitter_id) {
		this.submitter_id = submitter_id;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public Integer getOrder_type_id() {
		return order_type_id;
	}
	public void setOrder_type_id(Integer order_type_id) {
		this.order_type_id = order_type_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getAssignment_id() {
		return assignment_id;
	}
	public void setAssignment_id(Integer assignment_id) {
		this.assignment_id = assignment_id;
	}
	public Integer getGeneral_affairs_id() {
		return general_affairs_id;
	}
	public void setGeneral_affairs_id(Integer general_affairs_id) {
		this.general_affairs_id = general_affairs_id;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getInspector_user_id() {
		return inspector_user_id;
	}
	public void setInspector_user_id(Integer inspector_user_id) {
		this.inspector_user_id = inspector_user_id;
	}
	public String getInspector_at() {
		return inspector_at;
	}
	public void setInspector_at(String inspector_at) {
		this.inspector_at = inspector_at;
	}
	public Integer getDelete_user_id() {
		return delete_user_id;
	}
	public void setDelete_user_id(Integer delete_user_id) {
		this.delete_user_id = delete_user_id;
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
