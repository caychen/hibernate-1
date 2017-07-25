package entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Foo {
	private Integer id;
	private String name;
	private Double salary;
	private Date hireDate;
	private Boolean marry;
	private Timestamp lastLoginTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Boolean getMarry() {
		return marry;
	}
	public void setMarry(Boolean marry) {
		this.marry = marry;
	}
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
