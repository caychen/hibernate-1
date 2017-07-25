package entity;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PersonKey id;//Ö÷ÊôĞÔ
	private Integer age;
	public PersonKey getId() {
		return id;
	}
	public void setId(PersonKey id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
