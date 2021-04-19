package com.project.dao;

import java.util.List;

import com.project.model.LoginVO;
import com.project.model.StaffVO;

public interface LoginDAO {

	public void insertLogin(LoginVO loginVO) ;
	/*public List searchLogin(LoginVO loginVO);
	public void deleteLogin(LoginVO loginVO);
	public List editLogin(LoginVO loginVO);
	public void updateLogin(LoginVO loginVO);*/
	public List searchLoginID(LoginVO loginVO);

	public List searchRegister(StaffVO svo);
	public List searchLoginID1(String username);
	
	public List editPassword(LoginVO loginVO);
	public void updatePassword(LoginVO loginVO);
	public List searchstep1(LoginVO loginVO);
}
