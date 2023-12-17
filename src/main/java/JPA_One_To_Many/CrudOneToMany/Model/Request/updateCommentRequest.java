package JPA_One_To_Many.CrudOneToMany.Model.Request;

import java.io.Serializable;

public class updateCommentRequest implements Serializable {

	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
