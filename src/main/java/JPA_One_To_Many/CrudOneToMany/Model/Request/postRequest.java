package JPA_One_To_Many.CrudOneToMany.Model.Request;

import java.io.Serializable;

import JPA_One_To_Many.CrudOneToMany.Model.Entity.postEntity;

public class postRequest implements Serializable{

	private String title;
	private String description;
	
	public postEntity fromPostEntity() {
		postEntity myPost = new postEntity();
		myPost.setTitle(this.title);
		myPost.setDescription(this.description);
		return myPost;
	}
	
	public postRequest(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
