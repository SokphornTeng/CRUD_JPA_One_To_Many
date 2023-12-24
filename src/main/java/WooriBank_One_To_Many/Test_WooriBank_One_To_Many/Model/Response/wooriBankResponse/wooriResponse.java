package WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Response.wooriBankResponse;

import java.io.Serializable;

import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Entity.WooriBank;

public class wooriResponse implements Serializable {

	private Long id;
	private String staff;
	private String dept;
	
	public wooriResponse(Long id, String staff, String dept) {
		super();
		this.id = id;
		this.staff = staff;
		this.dept = dept;
	}

	public static wooriResponse takeDataCore(WooriBank wooriB) {
		
		return new wooriResponse(
				wooriB.getId(), 
				wooriB.getStaff(),
				wooriB.getDept()
				);
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
}
