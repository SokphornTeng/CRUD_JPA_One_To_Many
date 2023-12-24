package WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Response.wooriBranchResponse;

import java.io.Serializable;

import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Entity.BankBranch;

public class branchShortResponse implements Serializable{

	private Long id;
	private String province;
	
	public static branchShortResponse shortResponeB(BankBranch reqB) {
		return new branchShortResponse(reqB.getId(), reqB.getProvince());
	}
	
	public branchShortResponse(Long id, String province) {
		super();
		this.id = id;
		this.province = province;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	
	
}
