package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.CityDAO;
import com.project.model.CityVO;

@Service
public class CityService {

	@Autowired CityDAO cityDAO;
	
	
	@Transactional
	public void insertCity(CityVO cityVO)
	{
		this.cityDAO.insertCity(cityVO);
	}
	
	@Transactional
	public List searchCity(CityVO cityVO)
	{
		
		return this.cityDAO.searchCity(cityVO);
		
		
	}
	@Transactional
	public void deleteCity(CityVO cityVO)
	{
		this.cityDAO.deleteCity(cityVO);
	}
	@Transactional
	public List editCity(CityVO cityVO)
	{
		List ls= cityDAO.editCity(cityVO);
		return ls;
	}
	@Transactional
	public void updateCity(CityVO cityVO)
	{
		cityDAO.updateCity(cityVO);
	}
}
