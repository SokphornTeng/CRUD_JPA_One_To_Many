package JPA_One_To_Many.CrudOneToMany.Model.Response;

import java.io.Serializable;

import JPA_One_To_Many.CrudOneToMany.Model.Entity.commentEntity;

public class commentResponse implements Serializable {
   
	 private Long id;
	 private String comment;
	 private shortPostResponse post;
	 
	 public static commentResponse commentBack(commentEntity comment) {
		 return new commentResponse(comment.getId(), comment.getComment(), shortPostResponse.shortPost(comment.getPost()));
	 }
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public shortPostResponse getPost() {
		return post;
	}
	public void setPost(shortPostResponse post) {
		this.post = post;
	}
	public commentResponse(Long id, String comment, shortPostResponse post) {
		super();
		this.id = id;
		this.comment = comment;
		this.post = post;
	}
	 
	 
}
