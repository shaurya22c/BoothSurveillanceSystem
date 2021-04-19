package com.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.BoothDAO;
import com.project.dao.LoginDAO;
import com.project.dao.StaffDAO;
import com.project.model.BoothVO;
import com.project.model.LoginVO;
import com.project.model.StaffVO;

@Service
public class LoginService {

	@Autowired LoginDAO loginDAO;
	
	
	@Transactional
	public void insertLogin(LoginVO loginVO)
	{
		this.loginDAO.insertLogin(loginVO);
	}
	
	/*@Transactional
	public List searchLogin(LoginVO loginVO)
	{
		
		return this.loginDAO.searchLogin(loginVO);
		
		
	}
	@Transactional
	public void deleteLogin(LoginVO loginVO)
	{
		this.loginDAO.deleteLogin(loginVO);
	}
	@Transactional
	public List editLogin(LoginVO loginVO)
	{
		List ls= loginDAO.editLogin(loginVO);
		return ls;
	}
	@Transactional
	public void updateLogin(LoginVO loginVO)
	{
		loginDAO.updateLogin(loginVO);
	}*/
	@Transactional
	public List searchLoginID(LoginVO loginVO) {
		// TODO Auto-generated method stub
	
		List ls = loginDAO.searchLoginID(loginVO);
		
		return ls;
	}
	
	@Transactional
	public List searchRegister(StaffVO svo) {
		// TODO Auto-generated method stub
		List ls = loginDAO.searchRegister(svo);
		
		return ls;
	}
	@Transactional
	public List searchLoginID1(String username) {
		// TODO Auto-generated method stub
		List ls = loginDAO.searchLoginID1(username);
		
		return ls;
	}
	
	@Transactional
	public void updatePassword(LoginVO loginVO) {
		// TODO Auto-generated method stub
		this.loginDAO.updatePassword(loginVO);
		
	}
	@Transactional
	public List searchstep1(LoginVO loginVO) 
	{
		// TODO Auto-generated method stub
		List ls = loginDAO.searchstep1(loginVO);
		
		return ls;
	}
	
	@Transactional
	public List editPassword(LoginVO loginVO) {
		// TODO Auto-generated method stub
		List ls = loginDAO.editPassword(loginVO);
		return ls;
	
	}
}
