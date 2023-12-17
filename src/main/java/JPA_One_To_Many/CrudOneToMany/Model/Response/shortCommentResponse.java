package JPA_One_To_Many.CrudOneToMany.Model.Response;

import java.io.Serializable;

import JPA_One_To_Many.CrudOneToMany.Model.Entity.commentEntity;

public class shortCommentResponse implements Serializable {

	 private Long id;
	 private String comment;
	 
	 public static shortCommentResponse shortComment(commentEntity enC) {
		 return new shortCommentResponse(enC.getId(), enC.getComment());
	 }
	 
	public shortCommentResponse(Long id, String comment) {
		super();
		this.id = id;
		this.comment = comment;
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
	 
	 
	
}
