package WooriBank_One_To_Many.Test_WooriBank_One_To_Many.BankRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Entity.WooriBank;

@Repository
public interface WooriRepo extends JpaRepository<WooriBank, Long> {

	boolean existsByStaff(String staff);
	
}
