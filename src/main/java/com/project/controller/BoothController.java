package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.AllocateVO;
import com.project.model.AreaVO;
import com.project.model.BoothVO;
import com.project.model.CityVO;
import com.project.service.AreaService;
import com.project.service.BoothService;
import com.project.service.CityService;

@Controller
public class BoothController {
	
	@Autowired
	AreaService areaService;
	@Autowired
	CityService cityService;
	@Autowired
	BoothService boothService;
	
	
	@RequestMapping(value="admin/loadBooth")
	   public ModelAndView loadBooth(@ModelAttribute BoothVO boothVO)
	   {
	CityVO cityVO= new CityVO();
	AreaVO areaVO= new AreaVO();
		
	List cityList = this.cityService.searchCity(cityVO);

	List areaList = this.areaService.searchArea(areaVO);
	return new ModelAndView("admin/addBoothdetails","boothVO",new BoothVO()).addObject("cityList",cityList);
	 
	   }
	@RequestMapping(value="admin/insertBooth",method = RequestMethod.POST)
	   public ModelAndView insertBooth(@ModelAttribute BoothVO boothVO)
	   {
		this.boothService.insertBooth(boothVO);
		return new ModelAndView("redirect:viewBooth");
		   
	   }
	@RequestMapping(value="admin/viewBooth",method = RequestMethod.GET)
	   public ModelAndView viewBooth(@ModelAttribute BoothVO boothVO)
	   {
		   List boothList = this.boothService.searchBooth(boothVO);
		   System.out.println(boothList);
		   return new ModelAndView("admin/viewboothdetails").addObject("k",boothList);
		   
	   }
	@RequestMapping(value="staff/viewBooth",method = RequestMethod.GET)
	   public ModelAndView viewBoothStaff(@ModelAttribute BoothVO boothVO)
	   {
		   List boothList = this.boothService.searchBooth(boothVO);
		   System.out.println(boothList);
		   return new ModelAndView("staff/viewboothdetails").addObject("k",boothList);
		   
	   }
	@RequestMapping(value="admin/deleteBooth",method=RequestMethod.GET)
	public ModelAndView deletecontent(@ModelAttribute BoothVO boothVO,@RequestParam("id1") int id)
	{
		System.out.println("delete function called");
		boothVO.setBoothId(id);
		
		List boothList= this.boothService.editBooth(boothVO);
		boothVO= (BoothVO)boothList.get(0);
		boothVO.setStatus(false);
		
		this.boothService.updateBooth(boothVO);
		this.boothService.deleteBooth(boothVO);
		List ls = this.boothService.searchBooth(boothVO);
		return new ModelAndView("redirect:/admin/viewarea");
	}
	@RequestMapping(value="admin/editBooth",method=RequestMethod.GET)
	public ModelAndView editBooth(BoothVO boothVO,@RequestParam("id1") int id)
	{
		CityVO cityVO= new CityVO();
		AreaVO areaVO= new AreaVO();
		System.out.println("edit function called");
		boothVO.setBoothId(id);
		List cityList= this.cityService.searchCity(cityVO);
		List areaList= this.areaService.searchArea(areaVO);
		List boothList = this.boothService.editBooth(boothVO);
		return new ModelAndView("admin/editbooth","boothVO",(BoothVO)boothList.get(0)).addObject("cityList",cityList).addObject("areaList",areaList);
	}
	
	
	@RequestMapping(value="admin/updateBooth",method=RequestMethod.POST)
	public ModelAndView updateBooth(@ModelAttribute BoothVO boothVO)
		{	
		    System.out.println("newdata insert function called");
		    System.out.println(boothVO.getBoothId());
			this.boothService.updateBooth(boothVO);
			
			return new ModelAndView("redirect:viewBooth");
		}	
	@RequestMapping(value= "/getarea")
	public ModelAndView getarea(@ModelAttribute BoothVO boothVO,@RequestParam("city") int id)
	{
		System.out.println("in get area function");
		System.out.println(id);
		
		CityVO cityVO= new CityVO();
		cityVO.setCityId(id);
		
		AreaVO areaVO= new AreaVO();
		areaVO.setCityVO(cityVO);
		List areaList= this.areaService.getAreabycity(areaVO);
		System.out.println(areaList);
		
		/*main line*/
		System.out.println(areaVO.getCityVO().getCityId());
		return new ModelAndView("admin/addBoothdetails","BoothVO", new BoothVO()).addObject("areaList",areaList);
	}
	
	
	
	
}
