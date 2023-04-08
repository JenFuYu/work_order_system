package Model;

public class permission_set {
	private Integer id;
	private String position_name;
	private Integer sub_function;
	private Integer schedule_function;
	private Integer assign_function;
	private Integer affairs_function;
	private Integer inspect_function;
	private Integer history_function;
	private Integer account_mana_function;
	private Integer permission_function;
	private Integer report_function;
	public permission_set(String position_name, Integer sub_function, Integer schedule_function, Integer assign_function,Integer affairs_function,
			Integer inspect_function, Integer history_function, Integer account_mana_function,
			Integer permission_function, Integer report_function) {
		super();
		this.position_name = position_name;
		this.sub_function = sub_function;
		this.schedule_function = schedule_function;
		this.assign_function = assign_function;
		this.affairs_function = affairs_function;
		this.inspect_function = inspect_function;
		this.history_function = history_function;
		this.account_mana_function = account_mana_function;
		this.permission_function = permission_function;
		this.report_function = report_function;
	}
	public permission_set() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public Integer getAssign_function() {
		return assign_function;
	}
	public void setAssign_function(Integer assign_function) {
		this.assign_function = assign_function;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public Integer getSub_function() {
		return sub_function;
	}
	public void setSub_function(Integer sub_function) {
		this.sub_function = sub_function;
	}
	public Integer getSchedule_function() {
		return schedule_function;
	}
	public void setSchedule_function(Integer schedule_function) {
		this.schedule_function = schedule_function;
	}
	public Integer getAffairs_function() {
		return affairs_function;
	}
	public void setAffairs_function(Integer affairs_function) {
		this.affairs_function = affairs_function;
	}
	public Integer getInspect_function() {
		return inspect_function;
	}
	public void setInspect_function(Integer inspect_function) {
		this.inspect_function = inspect_function;
	}
	public Integer getHistory_function() {
		return history_function;
	}
	public void setHistory_function(Integer history_function) {
		this.history_function = history_function;
	}
	public Integer getAccount_mana_function() {
		return account_mana_function;
	}
	public void setAccount_mana_function(Integer account_mana_function) {
		this.account_mana_function = account_mana_function;
	}
	public Integer getPermission_function() {
		return permission_function;
	}
	public void setPermission_function(Integer permission_function) {
		this.permission_function = permission_function;
	}
	public Integer getReport_function() {
		return report_function;
	}
	public void setReport_function(Integer report_function) {
		this.report_function = report_function;
	}
	
	
	

}
