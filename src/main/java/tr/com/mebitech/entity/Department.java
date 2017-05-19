package tr.com.mebitech.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
@Entity
@Table(name="DEPARTMENT")
@SequenceGenerator(name="seqId",sequenceName="SEQ_DEPARTMENT")
public class Department extends BaseEntity {
	@Column(name="NAME")
	private String name;

	@Column(name="DSC")
	private String dsc;

	@OneToMany(mappedBy="department")
	private List<Employee> employeeList;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="RL_MEETING_AND_DEPARTMENT",
	inverseJoinColumns= {@JoinColumn(name="MEETING_ID")},
	joinColumns= {@JoinColumn(name="DEPARTMENT_ID")})
	private List<Meeting> meetingList;

	public List<Meeting> getMeetingList() {
		return meetingList;
	}
	public void setMeetingList(List<Meeting> meetingList) {
		this.meetingList = meetingList;
	}
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
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

}
