package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.AreaVO;
import com.project.model.CityVO;
import com.project.service.AreaService;
import com.project.service.CityService;

@Controller
public class AreaController {
	
	@Autowired
	AreaService areaService;
	@Autowired
	CityService cityService;
	
	@RequestMapping(value="admin/addArea",method = RequestMethod.GET)
	   public ModelAndView addArea(CityVO cityVO)
	   {
		List ls= this.cityService.searchCity(cityVO);
		return new ModelAndView("admin/addArea","areaVO",new AreaVO()).addObject("cityList",ls);
		   
	   }

	@RequestMapping(value="admin/insertArea",method = RequestMethod.POST)
	   public ModelAndView addArea(@ModelAttribute AreaVO areaVO)
	   {
		this.areaService.insertArea(areaVO);
		return new ModelAndView("redirect:addArea");
		   
	   }
	@RequestMapping(value="admin/viewarea",method = RequestMethod.GET)
	   public ModelAndView addarea(@ModelAttribute AreaVO areaVO)
	   {
		   List ls = this.areaService.searchArea(areaVO);
		   System.out.println(ls);
		   return new ModelAndView("admin/viewarea").addObject("k",ls);
		   
	   }
	@RequestMapping(value="staff/viewarea",method = RequestMethod.GET)
	   public ModelAndView addareaStaff(@ModelAttribute AreaVO areaVO)
	   {
		   List ls = this.areaService.searchArea(areaVO);
		   System.out.println(ls);
		   return new ModelAndView("staff/viewarea").addObject("k",ls);
		   
	   }
	@RequestMapping(value="admin/deletearea",method=RequestMethod.GET)
	public ModelAndView deletecontent(@ModelAttribute AreaVO areaVO,@RequestParam("id1") int id)
	{
		System.out.println("delete function called");
		areaVO.setAreaId(id);
		
		List areaList= this.areaService.editArea(areaVO);
		areaVO= (AreaVO)areaList.get(0);
		areaVO.setStatus(false);
		this.areaService.updateArea(areaVO);
		
		this.areaService.deleteArea(areaVO);
		List ls = this.areaService.searchArea(areaVO);
		return new ModelAndView("redirect:/admin/viewarea");
	}
	@RequestMapping(value="admin/editArea",method=RequestMethod.GET)
	public ModelAndView editArea(AreaVO areaVO,@RequestParam("id1") int id)
	{
		CityVO cityVO= new CityVO();
		System.out.println("edit function called");
		areaVO.setAreaId(id);
		List ls = this.areaService.editArea(areaVO);
		List cityList= this.cityService.searchCity(cityVO);
		return new ModelAndView("admin/editarea","areaVO",(AreaVO)ls.get(0)).addObject("cityList",cityList);
	}
	
	
	@RequestMapping(value="admin/updateArea",method=RequestMethod.POST)
	public ModelAndView updateArea(@ModelAttribute AreaVO areaVO)
		{	
		    System.out.println("newdata insert function called");
		    System.out.println(areaVO.getAreaId());
			this.areaService.updateArea(areaVO);
			
			return new ModelAndView("redirect:viewarea");
		}	
	
	
	
}
