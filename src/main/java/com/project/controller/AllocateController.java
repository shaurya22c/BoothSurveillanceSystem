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
import com.project.model.StaffVO;
import com.project.service.AllocateService;
import com.project.service.BoothService;
import com.project.service.CityService;
import com.project.service.StaffService;

@Controller
public class AllocateController {

	@Autowired
	AllocateService allocateService;
	@Autowired
	BoothService boothService;
	@Autowired
	StaffService staffService;

	@RequestMapping(value="admin/allocate",method = RequestMethod.GET)
	   public ModelAndView allocate(BoothVO boothVO,StaffVO staffVO)
	   {

		   List boothList = this.boothService.searchBooth(boothVO);
		   List staffList = this.staffService.searchStaff(staffVO);
		   return new ModelAndView("admin/allocate","allocateVO",new AllocateVO()).addObject("boothList",boothList).addObject("staffList",staffList);
		   
		   
	   }
	@RequestMapping(value="admin/insertAllocate",method = RequestMethod.POST)
	   public ModelAndView insertAllocate(@ModelAttribute AllocateVO allocateVO)
	   {
		this.allocateService.insertAllocate(allocateVO);
		return new ModelAndView("redirect:allocate");
		   
	   }
	@RequestMapping(value="admin/viewallocate",method = RequestMethod.GET)
	public ModelAndView viewallocate(@ModelAttribute AllocateVO allocateVO) {
		
		   List allocateList = this.allocateService.searchAllocate(allocateVO);
		   System.out.println(allocateList);
		   return new ModelAndView("admin/viewallocate").addObject("allocateList",allocateList);
		   
	   }
	@RequestMapping(value="staff/viewallocate",method = RequestMethod.GET)
	public ModelAndView viewallocateStaff(@ModelAttribute AllocateVO allocateVO) {
		
		   List allocateList = this.allocateService.searchAllocate(allocateVO);
		   System.out.println(allocateList);
		   return new ModelAndView("staff/viewallocate").addObject("allocateList",allocateList);
		   
	   }
	@RequestMapping(value="admin/deleteAllocate",method=RequestMethod.GET)
	public ModelAndView deleteAllocate(@ModelAttribute AllocateVO allocateVO,@RequestParam("id1") int id)
	{
		System.out.println("delete function called");
		allocateVO.setAllocateId(id);
		
		List allocateList= this.allocateService.editAllocate(allocateVO);
		allocateVO= (AllocateVO)allocateList.get(0);
		allocateVO.setStatus(false);
		this.allocateService.updateAllocate(allocateVO);
		
		this.allocateService.deleteAllocate(allocateVO);
		List ls = this.allocateService.searchAllocate(allocateVO);
		return new ModelAndView("redirect:/admin/viewarea");
	}

	@RequestMapping(value="admin/editAllocate",method=RequestMethod.GET)
	public ModelAndView editAllocate(AllocateVO allocateVO,@RequestParam("id1") int id)
	{
		StaffVO staffVO= new StaffVO();
		BoothVO boothVO= new BoothVO();
		System.out.println("edit function called");
		allocateVO.setAllocateId(id);
		List staffList= this.staffService.searchStaff(staffVO);
		List boothList = this.boothService.searchBooth(boothVO);
		List allocateList = this.allocateService.editAllocate(allocateVO);
		return new ModelAndView("admin/editallocate","allocateVO",(AllocateVO)allocateList.get(0)).addObject("boothList",boothList).addObject("staffList",staffList);
	}
	
	
	@RequestMapping(value="admin/updateAllocate",method=RequestMethod.POST)
	public ModelAndView updateAllocate(@ModelAttribute AllocateVO allocateVO)
		{	
		System.out.println("newdata insert function called");
		System.out.println(allocateVO.getAllocateId());
			this.allocateService.updateAllocate(allocateVO);
			
			return new ModelAndView("redirect:viewallocate");
		}
	
}
