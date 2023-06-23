package com.example.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.entity.Staff;

@Repository
public class StaffDao {
	
	@Autowired
	SessionFactory sf;
	
	//Add New Staff Member
	public String addStaff(Staff staff) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(staff);
		tr.commit();
		session.close();
		return "New Staff Member Added";
		
	}

	//Get All Staff Member List
	public List<Staff> getAllStaff() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(Staff.class);
		List<Staff> list = criteria.list();
		tr.commit();
		session.close();
		return list;
	}

	//Get Staff Member By ID
	public Staff getStaffById(int staffid) {
		Session session = sf.openSession();
		Staff member = session.get(Staff.class, staffid);
		session.close();
		return member;
	}

	//Get 3rd staff member 
	public Staff staffMember() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Staff member = session.get(Staff.class, 3);
		tr.commit();
		session.close();
		return member;
	}

	//Staff whose salary > 20000
	public List<Staff> greaterSalary() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.gt("salary", 20000));
		List<Staff> list = criteria.list();
		tr.commit();
		session.close();
		return list;
	}

	//Staff whose Experience between 10-20
	public List<Staff> experienceBtw() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.between("experience", 10, 20));
		List<Staff> list = criteria.list();
		tr.commit();
		session.close();
		return list;	
	}

	//Staff whose profile is Trainer
	public List<Staff> profileAsTrainer() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.like("profile", "trainer"));
		List<Staff> list = criteria.list();	
		tr.commit();
		session.close();
		return list;
	}

	//Staff whose profile is Not a Trainer
	public List<Staff> exceptTrainer() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.ne("profile", "trainer"));
		List<Staff> list = criteria.list();
		tr.commit();
		session.close();
		return list;
	}
	
	//Update Record By StaffId
	public String updateStaff(int staffid, Staff staff) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.update(staff);
		session.save(staff);
		tr.commit();
		session.close();
		return "Record updated";
	}

	//Delete Record By StaffId
	public String deleteStaff(int staffid) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Staff member = session.get(Staff.class, staffid);
		session.delete(member);
		tr.commit();
		session.close();
		return "Record deleted";
	}
}
