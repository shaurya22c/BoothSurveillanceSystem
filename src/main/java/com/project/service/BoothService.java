package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.BoothDAO;
import com.project.model.BoothVO;;

@Service
public class BoothService {

	@Autowired BoothDAO boothDAO;
	
	
	@Transactional
	public void insertBooth(BoothVO boothVO)
	{
		this.boothDAO.insertBooth(boothVO);
	}
	
	@Transactional
	public List searchBooth(BoothVO boothVO)
	{
		
		return this.boothDAO.searchBooth(boothVO);
		
		
	}
	@Transactional
	public void deleteBooth(BoothVO boothVO)
	{
		this.boothDAO.deleteBooth(boothVO);
	}
	@Transactional
	public List editBooth(BoothVO boothVO)
	{
		List ls= boothDAO.editBooth(boothVO);
		return ls;
	}
	@Transactional
	public void updateBooth(BoothVO boothVO)
	{
		boothDAO.updateBooth(boothVO);
	}
}
