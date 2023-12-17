package JPA_One_To_Many.CrudOneToMany.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JPA_One_To_Many.CrudOneToMany.Model.Entity.postEntity;
import JPA_One_To_Many.CrudOneToMany.Model.Request.postRequest;
import JPA_One_To_Many.CrudOneToMany.Repo.commentRepo;
import JPA_One_To_Many.CrudOneToMany.Repo.postRepo;

@Service
public class postService {

	private final postRepo postRepository;
	private final commentRepo commentRepository;
	@Autowired
	public postService(postRepo postRepository, commentRepo commentRepository) {
		super();
		this.postRepository = postRepository;
		this.commentRepository = commentRepository;
	}
	
	public postEntity addDataPost(postRequest req) {
		postEntity postEn = this.postRepository.save(req.fromPostEntity());
		return postEn;
	}
	
	public List<postEntity> listData(){
		List<postEntity> list = this.postRepository.findAll();
		return list;
	}
	
	public postEntity findByOne(Long id) throws Exception {
		return this.postRepository.findById(id).orElseThrow(() -> new Exception("it not found"));
		
	}
	
	public postEntity updateData(Long id, postRequest updateReq) {
		postEntity updateEn = updateReq.fromPostEntity();
		
		updateEn.setTitle(updateReq.getTitle());
		updateEn.setDescription(updateReq.getDescription());
		
		return this.postRepository.save(updateEn);
	}
	
	public postEntity deleteData(Long id) throws Exception {
		postEntity deleteMe = this.findByOne(id);
		
		try {
		  this.postRepository.deleteById(deleteMe.getId());
		} catch (Exception e) {
			throw new Exception(e);
		}
		return deleteMe;
	}
}
