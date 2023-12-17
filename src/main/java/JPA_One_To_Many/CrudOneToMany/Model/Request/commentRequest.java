package JPA_One_To_Many.CrudOneToMany.Model.Request;

import java.io.Serializable;

import JPA_One_To_Many.CrudOneToMany.Model.Entity.commentEntity;

public class commentRequest implements Serializable {

	private String comment;
	private Long postId;
	
	public commentEntity addData() {
		commentEntity commentEn = new commentEntity();
		commentEn.setComment(this.comment);
		return commentEn;
	}
	
	public commentRequest(String comment, Long postId) {
		super();
		this.comment = comment;
		this.postId = postId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	
	
	
}
