package JPA_One_To_Many.CrudOneToMany.Controller;

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

import JPA_One_To_Many.CrudOneToMany.Model.Entity.postEntity;
import JPA_One_To_Many.CrudOneToMany.Model.Request.postRequest;
import JPA_One_To_Many.CrudOneToMany.Model.Response.postResponse;
import JPA_One_To_Many.CrudOneToMany.Services.postService;

@RestController
@RequestMapping("/api/post")
public class postController {

	private final postService postServ;
    
	@Autowired
	public postController(postService postServ) {
		super();
		this.postServ = postServ;
	}
	
	@PostMapping
	public ResponseEntity<postResponse> create(@RequestBody postRequest postReq){
		postEntity myPost = this.postServ.addDataPost(postReq);
		return ResponseEntity.ok(postResponse.replyPost(myPost));
	}
	@GetMapping
	public ResponseEntity<List<postResponse>> listingData(){
		List<postResponse> listAll = this.postServ.listData().stream().map(postResponse::replyPost).toList();
		return ResponseEntity.ok(listAll);
	}
	@GetMapping("/{id}")
	public ResponseEntity<postResponse> findWithID(@PathVariable Long id) throws Exception{
		postEntity findMe = this.postServ.findByOne(id);
		return ResponseEntity.ok(postResponse.replyPost(findMe));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<postResponse> update(@PathVariable Long id, @RequestBody postRequest reqUpdate){
		postEntity updateMe = this.postServ.updateData(id, reqUpdate);
		return ResponseEntity.ok(postResponse.replyPost(updateMe));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<postResponse> deleteAll(@PathVariable Long id) throws Exception{
		postEntity deleteMe = this.postServ.deleteData(id);
		return ResponseEntity.ok(postResponse.replyPost(deleteMe));
	}
}
