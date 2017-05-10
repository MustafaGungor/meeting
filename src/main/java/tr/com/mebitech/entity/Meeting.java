package tr.com.mebitech.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MEETING")
@SequenceGenerator(name="seqId",sequenceName="SEQ_MEETING")
public class Meeting extends BaseEntity {
	@Column(name="NAME")
	private String name;
	
	@Column(name="DSC")
	private String dsc;
	
	@ManyToMany
	private List<Department> departmentList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	public List<Department> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

}
