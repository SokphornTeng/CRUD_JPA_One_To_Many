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

import JPA_One_To_Many.CrudOneToMany.Model.Entity.commentEntity;
import JPA_One_To_Many.CrudOneToMany.Model.Request.commentRequest;
import JPA_One_To_Many.CrudOneToMany.Model.Request.updateCommentRequest;
import JPA_One_To_Many.CrudOneToMany.Model.Response.commentResponse;
import JPA_One_To_Many.CrudOneToMany.Model.Response.shortCommentResponse;
import JPA_One_To_Many.CrudOneToMany.Services.commentService;

@RestController
@RequestMapping("/api/comment")
public class commentController {

	private final commentService commentServ;
    @Autowired
	public commentController(commentService commentServ) {
		super();
		this.commentServ = commentServ;
	}
	
    @PostMapping
    public ResponseEntity<commentResponse> addDataInFeild(@RequestBody commentRequest reqC) throws Exception{
    	 commentEntity myEn = this.commentServ.add(reqC);
    	 return ResponseEntity.ok(commentResponse.commentBack(myEn));
    }
   
    @GetMapping
    public ResponseEntity<List<commentResponse>> showCommentAll(){
    	List<commentResponse> show = this.commentServ.showComment().stream().map(commentResponse::commentBack).toList();
    	return ResponseEntity.ok(show);
    }
	
    @GetMapping("/{id}")
	public ResponseEntity<commentResponse> findOneByOne(@PathVariable Long id) throws Exception{
		commentEntity find = this.commentServ.findByOne(id);
		return ResponseEntity.ok(commentResponse.commentBack(find));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<commentResponse> update(@PathVariable Long id, @RequestBody updateCommentRequest reqMe) throws Exception{
		
		commentEntity updateMe = this.commentServ.updateComment(id, reqMe);
		return ResponseEntity.ok(commentResponse.commentBack(updateMe));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<shortCommentResponse> delete(@PathVariable Long id) throws Exception{
		commentEntity deleteById = this.commentServ.deletePostWithComment(id);
		return ResponseEntity.ok(shortCommentResponse.shortComment(deleteById));
	}

}
