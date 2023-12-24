package WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Response.wooriBankResponse;

import java.io.Serializable;

import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Entity.WooriBank;

public class wooriShortResponse implements Serializable{

	private Long id;
	private String staff;
	
	public wooriShortResponse(Long id, String staff) {
		super();
		this.id = id;
		this.staff = staff;
	}
	
	public static wooriShortResponse shortWooriInfo(WooriBank wb) {
		return new wooriShortResponse(wb.getId(), wb.getStaff());
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
	
	
	
}
