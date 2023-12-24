package WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Request.wooriBranch;

import java.io.Serializable;

import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Entity.BankBranch;

public class wooriBranchRequest implements Serializable {

	private String province;
	private Long wooriId;
	
	public wooriBranchRequest(String province, Long wooriId) {
		super();
		this.province = province;
		this.wooriId = wooriId;
	}
	
	public BankBranch branchReq() {
		BankBranch req = new BankBranch();
		req.setProvince(this.province);
		return req;
	}
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Long getWooriId() {
		return wooriId;
	}
	public void setWooriId(Long wooriId) {
		this.wooriId = wooriId;
	}
	
	
	
}
