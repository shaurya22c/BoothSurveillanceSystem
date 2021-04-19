package com.project.dao;

import java.util.List;

import com.project.model.AllocateVO;
import com.project.model.AreaVO;

public interface AllocateDAO {

	public void insertAllocate(AllocateVO allocateVO) ;
	public List searchAllocate(AllocateVO allocateVO);
	public void deleteAllocate(AllocateVO allocateVO);
	public List editAllocate(AllocateVO allocateVO);
	public void updateAllocate(AllocateVO allocateVO);
}
