package WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Request.wooriBank;

import java.io.Serializable;

import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Entity.WooriBank;

public class wooriRequest implements Serializable {

	private String staff;
	private String dept;

	public wooriRequest(String staff, String dept) {
		super();
		this.staff = staff;
		this.dept = dept;
	}

	public WooriBank addInfoCore() {
		WooriBank addInfo = new WooriBank();
		addInfo.setStaff(this.staff);
		addInfo.setDept(this.dept);
		return addInfo;
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
