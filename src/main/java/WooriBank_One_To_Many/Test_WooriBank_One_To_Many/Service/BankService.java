package WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.BankRepo.WooriRepo;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.BankRepo.wooriBranchRepo;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Entity.WooriBank;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Request.wooriBank.wooriRequest;

@Service
public class BankService {

	private final WooriRepo wbfinanceRepo;

	
	@Autowired
	public BankService(WooriRepo wbfinanceRepo) {
		super();
		this.wbfinanceRepo = wbfinanceRepo;
	}
	
	
	public WooriBank addDataIntoCore(wooriRequest wbReq) {
		WooriBank info = this.wbfinanceRepo.save(wbReq.addInfoCore());
		return info;
	}
	
	public List<WooriBank> listAll(){
		List<WooriBank> listing = this.wbfinanceRepo.findAll();
		return listing;
	}
	
	public WooriBank findByOne(Long id) throws Exception {
		WooriBank findOne = this.wbfinanceRepo.findById(id).orElseThrow(() -> new Exception());
		try {
			return this.wbfinanceRepo.save(findOne);
		} catch (Exception e) {
		   throw new Exception(e);
		}
	}
	
	public WooriBank updateData(Long id, wooriRequest upReg) throws Exception{
		WooriBank updateInfo = upReg.addInfoCore();
		
//		if(this.wbfinanceRepo.existsByStaff(updateInfo.getStaff()));
//		throw new Exception("staff already exist");
		
		updateInfo.setStaff(upReg.getStaff());
		updateInfo.setDept(upReg.getDept());
		
		try {
		 	this.wbfinanceRepo.save(updateInfo);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return updateInfo;
	}
	
	public WooriBank deleteData(Long id) throws Exception {
		WooriBank dele = this.wbfinanceRepo.findById(id).orElseThrow(() -> new Exception());
		try {
			 this.wbfinanceRepo.deleteById(id);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return dele;
	}
}
