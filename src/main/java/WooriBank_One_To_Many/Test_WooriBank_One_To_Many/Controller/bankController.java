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

import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Entity.WooriBank;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Request.wooriBank.wooriRequest;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Response.wooriBankResponse.wooriResponse;
import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Service.BankService;

@RestController
@RequestMapping("/api/woori")
public class bankController {

	private final BankService wooriBankService;
    @Autowired
	public bankController(BankService wooriBankService) {
		super();
		this.wooriBankService = wooriBankService;
	}
    @PostMapping
    public ResponseEntity<wooriResponse> addInfo(@RequestBody wooriRequest wooriReq){
    	WooriBank wbfinaceInfo = this.wooriBankService.addDataIntoCore(wooriReq);
    	return ResponseEntity.ok(wooriResponse.takeDataCore(wbfinaceInfo));
    }
    
    @GetMapping
    public ResponseEntity<List<wooriResponse>> listingAllData(){
    	List<wooriResponse> showList = this.wooriBankService.listAll().stream().map(wooriResponse::takeDataCore).toList();
    	return ResponseEntity.ok(showList);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<wooriResponse> oneByOne(@PathVariable Long id) throws Exception{
    	WooriBank findOne = this.wooriBankService.findByOne(id);
    	return ResponseEntity.ok(wooriResponse.takeDataCore(findOne));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<wooriResponse> updateData(@PathVariable Long id, @RequestBody wooriRequest reqW) throws Exception{
    	WooriBank updates = this.wooriBankService.updateData(id, reqW);
    	return ResponseEntity.ok(wooriResponse.takeDataCore(updates));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<wooriResponse> deleteAllData(@PathVariable Long id) throws Exception{
    	WooriBank deletes = this.wooriBankService.deleteData(id);
    	return ResponseEntity.ok(wooriResponse.takeDataCore(deletes));
    }
}
