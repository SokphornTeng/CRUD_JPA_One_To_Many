package WooriBank_One_To_Many.Test_WooriBank_One_To_Many.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Woori Branch")
public class BankBranch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50, nullable = false)
	private String province;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="wbfinance", nullable = false, referencedColumnName = "id")
	private WooriBank woori;
	
	public WooriBank getWoori() {
		return woori;
	}
	public void setWoori(WooriBank woori) {
		this.woori = woori;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	
	
}
