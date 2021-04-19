package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.project.model.CityVO;
import com.project.service.CityService;

@Controller
public class CityController {

	@Autowired
	CityService cityService;

	@RequestMapping(value = "admin/loadCity")
	public ModelAndView loadCity() {

		return new ModelAndView("admin/addCity", "cityVO", new CityVO());
	}

	@RequestMapping(value = "admin/managecity2", method = RequestMethod.POST)
	public ModelAndView managecity2(@ModelAttribute CityVO cityVO) {
		this.cityService.insertCity(cityVO);
		return new ModelAndView("redirect:loadCity");
	}
	
	@RequestMapping(value="admin/viewcity",method = RequestMethod.GET)
	public ModelAndView viewcity(@ModelAttribute CityVO cityVO) {
		
		   List ls = this.cityService.searchCity(cityVO);
		   System.out.println(ls);
		   return new ModelAndView("admin/viewcity").addObject("k",ls);
		   
	   }

	@RequestMapping(value="staff/viewcity",method = RequestMethod.GET)
	public ModelAndView viewcityStaff(@ModelAttribute CityVO cityVO) {
		
		   List ls = this.cityService.searchCity(cityVO);
		   System.out.println(ls);
		   return new ModelAndView("staff/viewcity").addObject("k",ls);
		   
	   }
	@RequestMapping(value="admin/deleteCity",method=RequestMethod.GET)
	public ModelAndView deleteCity(@ModelAttribute CityVO cityVO,@RequestParam("id1") int id)
	{
		System.out.println("delete function called");
		cityVO.setCityId(id);
		
		/*for status part*/
		List cityList = this.cityService.editCity(cityVO);
		cityVO  = (CityVO)cityList.get(0);
		cityVO.setStatus(false); 
		
		this.cityService.updateCity(cityVO);
		/*List ls = this.cityService.searchCity(cityVO);*/
		
		
		return new ModelAndView("redirect:/admin/viewcity");
	}
	@RequestMapping(value="admin/editCity",method=RequestMethod.GET)
	public ModelAndView editCity(CityVO cityVO,@RequestParam("id1") int id)
	{
		System.out.println("edit function called");
		cityVO.setCityId(id);
		List ls = this.cityService.editCity(cityVO);
		return new ModelAndView("admin/edit","data2",(CityVO)ls.get(0));
	}
	
	
	@RequestMapping(value="admin/updateCity",method=RequestMethod.POST)
	public ModelAndView newdataInsert(@ModelAttribute CityVO cityVO)
		{	
		System.out.println("newdata insert function called");
		System.out.println(cityVO.getCityId());
			this.cityService.updateCity(cityVO);
			
			return new ModelAndView("redirect:viewcity");
		}	
	
}
