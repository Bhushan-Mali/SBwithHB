package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffid;
	private String name;
	private String profile;
	private int salary;
	private int experience;
	
	@Column
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	@Column
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Column
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	@Override
	public String toString() {
		return "Staff [staffid=" + staffid + ", name=" + name + ", profile=" + profile + ", salary=" + salary
				+ ", experience=" + experience + "]";
	}
	
	
}
