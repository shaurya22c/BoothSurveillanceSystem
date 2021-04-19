package com.project.dao;

import java.util.List;

import com.project.model.ComplaintVO;

public interface ComplaintDAO {

	void insertComplaint(ComplaintVO complaintVO);
	
	public List viewComplaint();

	public List searchComplaint(ComplaintVO complaintVO);

	public List seeComplaint(ComplaintVO complaintVO);
	
	public List pendingComplaint(ComplaintVO complaintVO);
	
	public List TotalComplaint(ComplaintVO complaintVO);
	
	public List userpendingComplaint(ComplaintVO complaintVO);
	
	public List userTotalComplaint(ComplaintVO complaintVO);

}
