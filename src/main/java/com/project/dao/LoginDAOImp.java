package com.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.AllocateVO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.project.model.AreaVO;
import com.project.model.BoothVO;
import com.project.model.CityVO;
import com.project.model.LoginVO;
import com.project.model.StaffVO;

@Repository
public class LoginDAOImp implements LoginDAO {
	
	@Autowired
    SessionFactory sessionFactory;

	public void insertLogin(LoginVO loginVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(loginVO);
		
	}
	/*public List searchLogin(LoginVO loginVO)
	{
		List ls=new ArrayList();
		try
			{
				
			Session session = this.sessionFactory.getCurrentSession();				
			Query q= session.createQuery("from LoginVO");
			ls=q.list();
				
			}
		catch(Exception ex)
			{
				ex.printStackTrace();
			}
		return ls;
	}
	public void deleteLogin(LoginVO loginVO)
	{
		
		try
			{
			Session session = this.sessionFactory.getCurrentSession();		
			session.delete(loginVO);
				
			}
		catch(Exception ex)
			{
				ex.printStackTrace();
			}

	}
	
	public List editLogin(LoginVO loginVO)
	{
		List ls=new ArrayList();
		try
			{
			Session session = this.sessionFactory.getCurrentSession();		
			Query q= session.createQuery("from AllocateVO where allocateId= '"+loginVO.getLoginId()+"'");
			ls=q.list();		
				
			}
		catch(Exception ex)
			{
				ex.printStackTrace();
			}
		return ls;
	}
	public void updateLogin(LoginVO loginVO)
	{
		try
			{
			Session session = this.sessionFactory.getCurrentSession();		
			session.update(loginVO);
			}
		catch(Exception ex)
			{
				ex.printStackTrace();
			} 
	}*/

	@Override
	public List searchLoginID(LoginVO loginVO) {
		// TODO Auto-generated method stub
	
		Session session = this.sessionFactory.getCurrentSession();		
		Query q= session.createQuery("from LoginVO where username= '"+loginVO.getUsername()+"'");
		List ls=q.list();
		System.out.println(ls);
		
		return ls;


	}
	@Override
	public List searchRegister(StaffVO svo) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();		
		Query q= session.createQuery("from StaffVO where loginVO= '"+svo.getLoginVO().getLoginId()+"'");
		List ls=q.list();
		System.out.println(ls);
		
		return ls;
	}
	@Override
	public List searchLoginID1(String userName) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from LoginVO where username = '"+ userName+"' ");
		List ls = q.list();
		return ls;
	}
	
	@Override
	public void updatePassword(LoginVO loginVO) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		Query q=session.createQuery("UPDATE LoginVO set password='"+loginVO.getPassword() +"'where username='"+loginVO.getUsername() +"'");
		q.executeUpdate();
		transaction.commit();
	}
	
	@Override
	public List searchstep1(LoginVO loginVO) 
	{
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from LoginVO where username = '"+loginVO.getUsername()+"' ");
		List ls = q.list();
		return ls;
	}
	
	@Override
	public List editPassword(LoginVO loginVO) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		try
		{
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LoginVO where username='"+loginVO.getUsername()+"'");
			list = q.list(); 
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}
	

}
