package com.example.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StaffDao;
import com.example.entity.Staff;

@Service
public class StaffService {

	@Autowired
	StaffDao sd;
	
	public String addStaff(Staff staff) {
		String added = sd.addStaff(staff);
		return added;	
	}

	public List<Staff> getAllStaff() {
		List<Staff> list = sd.getAllStaff();
		return list;
	}

	public Staff getStaffById(int staffid) {
		Staff member = sd.getStaffById(staffid);
		return member;
	}

	public Staff staffMember() {
		Staff member = sd.staffMember();
		return member;
	}

	public List<Staff> greaterSalary() {
		List<Staff> list = sd.greaterSalary();
		return list;
	}

	public List<Staff> experienceBtw() {
		List<Staff> list = sd.experienceBtw();
		return list;		
	}

	public List<Staff> profileAsTrainer() {
		List<Staff> list = sd.profileAsTrainer();
		return list;
	}

	public List<Staff> exceptTrainer() {
		List<Staff> list = sd.exceptTrainer();
		return list;
	}

	public String updateStaff(int staffid, Staff staff) {
		return sd.updateStaff(staffid, staff);	
	}

	public String deleteStaff(int staffid) {
		return sd.deleteStaff(staffid);
	}



}
