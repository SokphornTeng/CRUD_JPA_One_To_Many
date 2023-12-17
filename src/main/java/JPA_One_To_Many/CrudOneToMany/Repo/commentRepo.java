package JPA_One_To_Many.CrudOneToMany.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JPA_One_To_Many.CrudOneToMany.Model.Entity.commentEntity;

@Repository
public interface commentRepo extends JpaRepository<commentEntity, Long> {

	boolean existsByPostId(Long postId);
}
