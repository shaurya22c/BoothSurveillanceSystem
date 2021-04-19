package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.project.model.AreaVO;
import com.project.model.BoothVO;
import com.project.model.CityVO;
import com.project.model.StaffVO;

@Repository
public class StaffDAOImp implements StaffDAO {
	
	@Autowired
	private SessionFactory sessionFactory;


	public void insertStaff(StaffVO staffVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(staffVO);
		
	}
	public List searchStaff(StaffVO staffVO)
	{
		List ls=new ArrayList();
		try
			{
				
			Session session = this.sessionFactory.getCurrentSession();				
			//Query q= session.createQuery("from StaffVO where loginVO_loginId NOT IN (1)");
			Query q= session.createQuery("from StaffVO where status= true");
			ls=q.list();
				
			}
		catch(Exception ex)
			{
				ex.printStackTrace();
			}
		return ls;
	}
	public void deleteStaff(StaffVO staffVO)
	{
		
		try
			{
			Session session = this.sessionFactory.getCurrentSession();		
			session.delete(staffVO);
				
			}
		catch(Exception ex)
			{
				ex.printStackTrace();
			}

	}
	
	public List editStaff(StaffVO staffVO)
	{
		List ls=new ArrayList();
		try
			{
			Session session = this.sessionFactory.getCurrentSession();		
			Query q= session.createQuery("from StaffVO where staffId= '"+staffVO.getStaffId()+"'");
			ls=q.list();		
				
			}
		catch(Exception ex)
			{
				ex.printStackTrace();
			}
		return ls;
	}
	public void updateStaff(StaffVO staffVO)
	{
		
			Session session = this.sessionFactory.getCurrentSession();		
			session.update(staffVO);
			
		
	}


}
