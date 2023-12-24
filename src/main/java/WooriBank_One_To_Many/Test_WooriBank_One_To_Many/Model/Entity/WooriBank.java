package WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Woori Bank")
public class WooriBank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50, nullable = false)
	private String staff;
	@Column(length = 40, nullable = false)
	private String dept;
	
	@OneToMany(mappedBy = "woori", fetch = FetchType.LAZY)
	private List<BankBranch> branch;
	
	
	public List<BankBranch> getBranch() {
		return branch;
	}
	public void setBranch(List<BankBranch> branch) {
		this.branch = branch;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
}
