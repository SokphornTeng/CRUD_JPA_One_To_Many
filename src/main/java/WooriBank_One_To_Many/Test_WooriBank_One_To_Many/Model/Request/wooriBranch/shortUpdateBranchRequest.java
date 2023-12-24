package WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Request.wooriBranch;

import java.io.Serializable;

import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Entity.BankBranch;

public class shortUpdateBranchRequest implements Serializable{

	private String province;

	public BankBranch shortBranchReq() {
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
	
	
	
}
