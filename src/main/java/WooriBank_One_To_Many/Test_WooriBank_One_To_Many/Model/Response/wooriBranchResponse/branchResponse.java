package WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Response.wooriBranchResponse;

import java.io.Serializable;

import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Entity.BankBranch;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Response.wooriBankResponse.wooriShortResponse;

public class branchResponse implements Serializable {

	private Long id;
	private String province;
	private wooriShortResponse woori;
	
	public branchResponse(Long id, String province, wooriShortResponse woori) {
		super();
		this.id = id;
		this.province = province;
		this.woori = woori;
	}
	
	
	public static branchResponse responseBranchBack(BankBranch responseB) {
		
		return new branchResponse(
				responseB.getId(),
				responseB.getProvince(),
				wooriShortResponse.shortWooriInfo(responseB.getWoori())
				);
	
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

	public wooriShortResponse getWoori() {
		return woori;
	}

	public void setWoori(wooriShortResponse woori) {
		this.woori = woori;
	}

	
	
	
	
}
