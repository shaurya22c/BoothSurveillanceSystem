package com.project.dao;

import java.util.List;

import com.project.model.StaffVO;

public interface StaffDAO {

	public void insertStaff(StaffVO staffVO) ;
	public List searchStaff(StaffVO staffVO);
	public void deleteStaff(StaffVO staffVO);
	public List editStaff(StaffVO staffVO);
	public void updateStaff(StaffVO staffVO);
}
