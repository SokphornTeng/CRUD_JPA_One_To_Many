package WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.BankRepo.WooriRepo;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.BankRepo.wooriBranchRepo;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Entity.BankBranch;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Entity.WooriBank;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Request.wooriBranch.shortUpdateBranchRequest;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Request.wooriBranch.wooriBranchRequest;

@Service
public class BranchService {

	private final wooriBranchRepo wbfinanceBranchRepo;
	private final WooriRepo wbfinanceRepo;
	@Autowired
    public BranchService(wooriBranchRepo wbfinanceBranchRepo, WooriRepo wbfinanceRepo) {
		super();
		this.wbfinanceBranchRepo = wbfinanceBranchRepo;
		this.wbfinanceRepo = wbfinanceRepo;
	}

	// add bank branch info that relate with bank into db of bank branch
	public BankBranch addInfoBranch(wooriBranchRequest wbReq) throws Exception {
		
//	not add as comment because one to many it need to verify of id wooriBankEntity
//	BankBranch branchWb = this.wbfinanceBranchRepo.save(wbReq.branchReq());
//	BankBranch branchWb = this.addInfoBranch(wbReq);
		
		BankBranch branchWb = wbReq.branchReq();
		WooriBank banks = this.wbfinanceRepo.findById(wbReq.getWooriId()).orElseThrow(() -> new Exception());
		branchWb.setWoori(banks);
		
		try {
			return this.wbfinanceBranchRepo.save(branchWb);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	
	// listing data of branch to see info
	public List<BankBranch> listingAll(){
		List<BankBranch> myList = this.wbfinanceBranchRepo.findAll();
		return myList;
	}
	
	// find one by one with id
	public BankBranch findByone(Long id) throws Exception {
		BankBranch findMe = this.wbfinanceBranchRepo.findById(id).orElseThrow(() -> new Exception());
		try {
			return this.wbfinanceBranchRepo.save(findMe);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	// update data with only branch not relate with bank just only branch
	public BankBranch updateBranch(Long id, shortUpdateBranchRequest shortReq) throws Exception {
   // BankBranch updates = shortReq.shortBranchReq();
		BankBranch updates = this.wbfinanceBranchRepo.findById(id).orElseThrow(() -> new Exception());
		
		updates.setProvince(shortReq.getProvince());
		
		return this.wbfinanceBranchRepo.save(updates);
	}
	
	public BankBranch deleteInfo(Long id) throws Exception {
		BankBranch deleteByOne = this.wbfinanceBranchRepo.findById(id).orElseThrow(() -> new Exception());
		try {
			 this.wbfinanceBranchRepo.deleteById(deleteByOne.getId());
		} catch (Exception e) {
			throw new Exception(e);
		}
		return deleteByOne;
	}
}
