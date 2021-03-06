package com.project.dao;

import java.util.List;

import com.project.model.AreaVO;

public interface AreaDAO {

	public void insertArea(AreaVO areaVO) ;
	public List searchArea(AreaVO areaVO);
	public void deleteArea(AreaVO areaVO);
	public List editArea(AreaVO areaVO);
	public void updateArea(AreaVO areaVO);
	public List getAreabycity(AreaVO areaVO);
}
