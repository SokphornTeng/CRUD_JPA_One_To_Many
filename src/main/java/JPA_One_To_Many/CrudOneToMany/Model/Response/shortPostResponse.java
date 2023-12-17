package JPA_One_To_Many.CrudOneToMany.Model.Response;

import java.io.Serializable;

import JPA_One_To_Many.CrudOneToMany.Model.Entity.postEntity;

public class shortPostResponse implements Serializable {
	
	private Long id;
	private String title;
	
	public static shortPostResponse shortPost(postEntity En) {
		return new shortPostResponse(En.getId(), En.getTitle());
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
	public shortPostResponse(Long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	

}
