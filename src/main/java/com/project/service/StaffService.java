package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.BoothDAO;
import com.project.dao.StaffDAO;
import com.project.model.BoothVO;
import com.project.model.StaffVO;

@Service
public class StaffService {

	@Autowired StaffDAO staffDAO;
	
	
	@Transactional
	public void insertStaff(StaffVO staffVO)
	{
		this.staffDAO.insertStaff(staffVO);
	}
	
	@Transactional
	public List searchStaff(StaffVO staffVO)
	{
		
		return this.staffDAO.searchStaff(staffVO);
		
		
	}
	@Transactional
	public void deleteStaff(StaffVO staffVO)
	{
		this.staffDAO.deleteStaff(staffVO);
	}
	@Transactional
	public List editStaff(StaffVO staffVO)
	{
		List ls= staffDAO.editStaff(staffVO);
		return ls;
	}
	@Transactional
	public void updateStaff(StaffVO staffVO)
	{
		staffDAO.updateStaff(staffVO);
	}
}
