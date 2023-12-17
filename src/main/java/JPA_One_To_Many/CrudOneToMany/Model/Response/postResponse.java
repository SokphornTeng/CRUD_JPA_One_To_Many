package JPA_One_To_Many.CrudOneToMany.Model.Response;

import java.io.Serializable;

import JPA_One_To_Many.CrudOneToMany.Model.Entity.postEntity;

public class postResponse implements Serializable {

	private Long id;
	private String title;
	private String description;
	
	public postResponse(Long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public static postResponse replyPost(postEntity entity) {
		return new postResponse(entity.getId(), entity.getTitle(), entity.getDescription());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
