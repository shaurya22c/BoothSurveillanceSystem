package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

import com.project.model.ComplaintVO;

@Repository
public class ComplaintDAOImp implements ComplaintDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertComplaint(ComplaintVO complaintVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(complaintVO);
	}
	
	@Override
	public List viewComplaint() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from ComplaintVO where status = true ");
		List complaintList = q.list();
		
		return complaintList;	
	}
	
	@Override
	public List searchComplaint(ComplaintVO complaintVO) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from ComplaintVO where id = '"+complaintVO.getId()+"'");
		List complaintList = q.list();
		return complaintList;
	}
	
	@Override
	public List seeComplaint(ComplaintVO complaintVO) {
		Session session = sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from ComplaintVO where loginVO.loginId = '"+complaintVO.getLoginVO().getLoginId()+"'");
		List complainList = q.list();
		return complainList;
	   }
	@Override
	public List pendingComplaint(ComplaintVO complaintVO)
	{
		Session session = sessionFactory.getCurrentSession();
		Query q= session.createQuery("select count(id) from ComplaintVO where complaintStatus= 'PENDING'");
		List complaintList= q.list();
		return complaintList;
	}
	@Override
	public List TotalComplaint(ComplaintVO complaintVO)
	{
		Session session = sessionFactory.getCurrentSession();
		Query q= session.createQuery("select count(id) from ComplaintVO");
		List complaintList= q.list();
		return complaintList;
	}
	@Override
	public List userpendingComplaint(ComplaintVO complaintVO)
	{
		Session session = sessionFactory.getCurrentSession();
		Query q= session.createQuery("select count(id) from ComplaintVO where complaintStatus= 'PENDING' and loginVO_loginId= '"+complaintVO.getLoginVO().getLoginId()+"'");
		List complaintList= q.list();
		return complaintList;
	}
	@Override
	public List userTotalComplaint(ComplaintVO complaintVO)
	{
		Session session = sessionFactory.getCurrentSession();
		Query q= session.createQuery("select count(id) from ComplaintVO where loginVO_loginId= '"+complaintVO.getLoginVO().getLoginId()+"'");
		List complaintList= q.list();
		return complaintList;
	}
}
