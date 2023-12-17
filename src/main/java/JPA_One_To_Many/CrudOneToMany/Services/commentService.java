package JPA_One_To_Many.CrudOneToMany.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JPA_One_To_Many.CrudOneToMany.Model.Entity.commentEntity;
import JPA_One_To_Many.CrudOneToMany.Model.Entity.postEntity;
import JPA_One_To_Many.CrudOneToMany.Model.Request.commentRequest;
import JPA_One_To_Many.CrudOneToMany.Model.Request.updateCommentRequest;
import JPA_One_To_Many.CrudOneToMany.Repo.commentRepo;
import JPA_One_To_Many.CrudOneToMany.Repo.postRepo;

@Service
public class commentService {

	private final commentRepo commentRepository;
	private final postRepo postRepository;
	@Autowired
    public commentService(commentRepo commentRepository, postRepo postRepository) {
		super();
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
	}
	
	public commentEntity add(commentRequest reqCom) throws Exception {
		commentEntity comEn = reqCom.addData();
		postEntity foundPost = this.postRepository.findById(reqCom.getPostId()).orElseThrow(() -> new Exception());
		comEn.setPost(foundPost);
		try {
			return this.commentRepository.save(comEn);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public List<commentEntity> showComment(){
		List<commentEntity>  myListing = this.commentRepository.findAll();
		return myListing;
	}
	
	public commentEntity findByOne(Long id) throws Exception {
		commentEntity findMe = this.commentRepository.findById(id).orElseThrow(() -> new Exception("Already Delete"));
		return findMe;
	}
	
	public commentEntity updateComment(Long id, updateCommentRequest cReq) throws Exception {
		commentEntity newEn = this.commentRepository.findById(id).orElseThrow(() -> new Exception("Sorry It Not Found"));
		newEn.setComment(cReq.getComment());
	    return this.commentRepository.save(newEn);
	}
	
	public commentEntity deletePostWithComment(Long id) throws Exception {
		commentEntity deleteMe = this.commentRepository.findById(id).orElseThrow(() -> new Exception());
	     try {
			this.commentRepository.deleteById(deleteMe.getId());
		} catch (Exception e) {
	        throw new Exception(e);
		} 
	     return deleteMe;
	}

}
