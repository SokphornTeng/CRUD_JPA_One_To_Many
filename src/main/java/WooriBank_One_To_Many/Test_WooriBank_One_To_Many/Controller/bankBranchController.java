package WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Entity.BankBranch;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Request.wooriBranch.shortUpdateBranchRequest;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Request.wooriBranch.wooriBranchRequest;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Response.wooriBranchResponse.branchResponse;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Response.wooriBranchResponse.branchShortResponse;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Service.BranchService;

@RestController
@RequestMapping("/api/branch")
public class bankBranchController {
 
	private final BranchService branchWbService;
    @Autowired
	public bankBranchController(BranchService branchWbService) {
		super();
		this.branchWbService = branchWbService;
	}
	
    @PostMapping
    public ResponseEntity<branchResponse> createData(@RequestBody wooriBranchRequest reqBB) throws Exception{
    	BankBranch branchBB = this.branchWbService.addInfoBranch(reqBB);
    	return ResponseEntity.ok(branchResponse.responseBranchBack(branchBB));
    }
    
    @GetMapping
    public ResponseEntity<List<branchResponse>> listingAllData(){
    	List<branchResponse> mylisting = this.branchWbService.listingAll().stream().map(branchResponse::responseBranchBack).toList();
    	return ResponseEntity.ok(mylisting);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<branchResponse> findOneByOne(@PathVariable Long id) throws Exception{
    	BankBranch findOne = this.branchWbService.findByone(id);
    	return ResponseEntity.ok(branchResponse.responseBranchBack(findOne));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<branchShortResponse> updateList(@PathVariable Long id, @RequestBody shortUpdateBranchRequest shortReq) throws Exception{
    	BankBranch updateNew = this.branchWbService.updateBranch(id, shortReq);
    	return ResponseEntity.ok(branchShortResponse.shortResponeB(updateNew));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<branchResponse> deleteData(@PathVariable Long id) throws Exception{
    	BankBranch delete = this.branchWbService.deleteInfo(id);
    	return ResponseEntity.ok(branchResponse.responseBranchBack(delete));
    }
}
