package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Staff;
import com.example.service.StaffService;

@CrossOrigin
@RestController
public class StaffController {
	
	@Autowired
	StaffService ss;
	
	//Add staff member
	@PostMapping("/add")
	public String addStaff(@RequestBody Staff staff) {
		String added = ss.addStaff(staff);
		return added;
	}
	
	//Get all staff member list
	@GetMapping("/getstaff")
	public List<Staff> getAllStaff() {
		List<Staff> list = ss.getAllStaff();
		return list;
	}
	
	//Get Staff Member by id
	@GetMapping("/getbyid/{staffid}")
	public Staff getStaffById(@PathVariable int staffid) {
		Staff member = ss.getStaffById(staffid);
		return member;
	}
	
	//Get particular member by given id through session
	@GetMapping("/thirdmember")
	public Staff staffMember() {
		Staff member = ss.staffMember();
		return member;
	}
	
	//Staff whose salary > 20000
	@GetMapping("/greater")
	public List<Staff> greaterSalary() {
		List<Staff> list = ss.greaterSalary();
		return list;
	}
	
	//Staff whose Experience between 10-20
	@GetMapping("/between")
	public List<Staff> experienceBtw() {
		List<Staff> list = ss.experienceBtw();
		return list;
	}
	
	//Staff whose profile is Trainer
	@GetMapping("/trainer")
	public List<Staff> profileAsTrainer() {
		List<Staff> list = ss.profileAsTrainer();
		return list;
	}
	
	//Staff whose profile is Not a Trainer
	@GetMapping("/except")
	public List<Staff> exceptTrainer() {
		List<Staff> list = ss.exceptTrainer();
		return list;
	}	
	
	//Delete Record By StaffId
    @DeleteMapping("/delete/{staffid}")
	public String deleteStaff(@PathVariable int staffid) {
		return ss.deleteStaff(staffid);
	}
	
    //Update Record By StaffId
	@PutMapping("update/{staffid}")
	public String updateStaff(@PathVariable int staffid, @RequestBody Staff staff) {
		return ss.updateStaff(staffid, staff);
	}
}
