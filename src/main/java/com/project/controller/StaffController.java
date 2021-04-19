package com.project.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.AreaVO;
import com.project.model.BoothVO;
import com.project.model.CityVO;
import com.project.model.LoginVO;
import com.project.model.StaffVO;
import com.project.service.AreaService;
import com.project.service.BoothService;
import com.project.service.CityService;
import com.project.service.LoginService;
import com.project.service.StaffService;

@Controller
public class StaffController {
	
	@Autowired
	StaffService staffService;
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="admin/loadStaff")
	   public ModelAndView loadStaff()
	   {

		return new ModelAndView("admin/addStaff","staffVO",new StaffVO());
	   }
	

	@RequestMapping(value = "admin/insertStaff")
	public ModelAndView insertStaff(@ModelAttribute StaffVO staffVO,LoginVO loginVO,@RequestParam ("file")MultipartFile file,HttpSession session) 
	{
		
		String path = session.getServletContext().getRealPath("/");
		
		String finalPath = path + "document\\demo\\";
		
		String fileName = file.getOriginalFilename();
		
		try
		{
			byte b[] = file.getBytes();
			
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(finalPath+"/"+fileName));
			System.out.println(finalPath+"/"+fileName);
			bufferedOutputStream.write(b);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
		}
		catch (Exception e) {
			System.out.println("Hey I'm Error");
		}
		
	    staffVO.setFileName(fileName);
	    staffVO.setFilePath(finalPath);
	   
	    loginVO.setUsername(staffVO.getLoginVO().getUsername());
	    loginVO.setPassword(staffVO.getLoginVO().getPassword());
	    loginVO.setEnabled("1");
	    loginVO.setRole("ROLE_STAFF");
	    
	    this.loginService.insertLogin(loginVO);
	    
	    staffVO.setLoginVO(loginVO);
	    staffVO.setEmail(staffVO.getLoginVO().getUsername());
	    staffVO.setPassword(staffVO.getLoginVO().getPassword());
	    
		this.staffService.insertStaff(staffVO);
		return new ModelAndView("redirect:loadStaff");
	}
	   	  @RequestMapping(value="admin/viewStaff",method = RequestMethod.GET)
	   public ModelAndView viewStaff(@ModelAttribute BoothVO boothVO)
	   {
		   StaffVO staffVO= new StaffVO();
		   List staffList = this.staffService.searchStaff(staffVO);
		   System.out.println(staffList);
		   return new ModelAndView("admin/viewstaff").addObject("staffList",staffList);
		   
	   }
	   	@RequestMapping(value="staff/viewStaff",method = RequestMethod.GET)
		   public ModelAndView viewStaff2(@ModelAttribute BoothVO boothVO)
		   {
			   StaffVO staffVO= new StaffVO();
			   List staffList = this.staffService.searchStaff(staffVO);
			   System.out.println(staffList);
			   return new ModelAndView("staff/viewstaff").addObject("staffList",staffList);
			   
		   }
	@RequestMapping(value="admin/deleteStaff",method=RequestMethod.GET)
	public ModelAndView deleteStaff(@ModelAttribute StaffVO staffVO,@RequestParam("id1") int id)
	{
		System.out.println("delete function called");
		staffVO.setStaffId(id);
		
		
		List staffList= this.staffService.editStaff(staffVO);
		staffVO= (StaffVO)staffList.get(0);
		staffVO.setStatus(false);
		
		
		/*this.staffService.deleteStaff(staffVO);
		List staffList = this.staffService.searchStaff(staffVO);*/
		
		this.staffService.updateStaff(staffVO);
		return new ModelAndView("redirect:/admin/viewStaff");
	}
	@RequestMapping(value="admin/editStaff",method=RequestMethod.GET)
	public ModelAndView editStaff(StaffVO staffVO,@RequestParam("id1") int id)
	{
		
		System.out.println("edit function called");
		staffVO.setStaffId(id);
		List staffList = this.staffService.editStaff(staffVO);
		return new ModelAndView("admin/editstaff","staffVO",(StaffVO)staffList.get(0));
	}
	
	
	@RequestMapping(value="admin/updateStaff",method=RequestMethod.POST)
	public ModelAndView updateStaff(@ModelAttribute StaffVO staffVO,@RequestParam ("file")MultipartFile file,HttpSession session)
		{	
			String path = session.getServletContext().getRealPath("/");
			
			String finalPath = path + "document\\demo\\";
			
			String fileName = file.getOriginalFilename();
			
			try
			{
				byte b[] = file.getBytes();
				
				BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(finalPath+"/"+fileName));
				System.out.println(finalPath+"/"+fileName);
				bufferedOutputStream.write(b);
				bufferedOutputStream.flush();
				bufferedOutputStream.close();
			}
			catch (Exception e) {
				System.out.println("Hey I'm Error");
			}
			
		    staffVO.setFileName(fileName);
		    staffVO.setFilePath(finalPath);
			
		    System.out.println("newdata insert function called");
		    System.out.println(staffVO.getStaffId());
			this.staffService.updateStaff(staffVO);
			
			return new ModelAndView("redirect:viewStaff");
		}	

	
	
	
	
}
