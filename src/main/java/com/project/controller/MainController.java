package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.ComplaintVO;
import com.project.model.FeedbackVO;
import com.project.model.LoginVO;
import com.project.model.StaffVO;
import com.project.service.ComplaintService;
import com.project.service.FeedbackService;
import com.project.service.LoginService;
import com.project.utils.Basemethods;

@Controller
public class MainController extends Basemethods {
	
	@Autowired LoginService loginService;
	@Autowired ComplaintService complaintService;
	@Autowired FeedbackService feedbackService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadLogin() {

		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView adminIndex(LoginVO loginVO,HttpSession session) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();
		loginVO.setUsername(userName);
		
		
		List ls = this.loginService.searchLoginID(loginVO);
		LoginVO lVO= (LoginVO)ls.get(0);
		
		int loginId = lVO.getLoginId();
		System.out.println("loginID>>>>>>"+loginId);

		
		LoginVO rlVO=  new LoginVO();
		rlVO.setLoginId(loginId);
		
		StaffVO svo = new StaffVO();
		svo.setLoginVO(rlVO);
		
		List rls = loginService.searchRegister(svo);
		svo = (StaffVO) rls.get(0);
		
		String fn = svo.getFirstName();
		String fileName = svo.getFileName();
		
		session.setAttribute("fname", fn);
		session.setAttribute("fileName", fileName);



System.out.println("FNAM>>>>>>>"+fn+"<<<<<<<<filename>>>>>>"+fileName);
		ComplaintVO complaintVO= new ComplaintVO();
		List pendingcomplaintList= complaintService.pendingComplaint(complaintVO);
		System.out.println(pendingcomplaintList);
		
		
		
		List totalcomplaintList= complaintService.TotalComplaint(complaintVO);
		System.out.println(totalcomplaintList);
		
		FeedbackVO feedbackVO= new FeedbackVO();
		List feedbackList= feedbackService.TotalFeedback(feedbackVO);
		System.out.println(feedbackList);
		
		return new ModelAndView("admin/index").addObject("pendingcomplaintList",pendingcomplaintList.get(0)).addObject("totalcomplaintList",totalcomplaintList.get(0)).addObject("feedbackList",feedbackList.get(0));
	}
	
	@RequestMapping(value = "/staff/index", method = RequestMethod.GET)
	public ModelAndView userIndex(LoginVO loginVO,HttpSession session) {

		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();
		loginVO.setUsername(userName);
		List ls = this.loginService.searchLoginID(loginVO);
		LoginVO lVO= (LoginVO)ls.get(0);
		int loginId = lVO.getLoginId();
		System.out.println("loginID>>>>>>"+loginId);

		
		LoginVO rlVO=  new LoginVO();
		rlVO.setLoginId(loginId);
		
		StaffVO svo = new StaffVO();
		svo.setLoginVO(rlVO);
		
		List rls = loginService.searchRegister(svo);
		StaffVO ssvo = (StaffVO) rls.get(0);
		

		String fn = ssvo.getFirstName();
		String fileName = ssvo.getFileName();

		session.setAttribute("fname", fn);
		session.setAttribute("fileName", fileName);

		

		System.out.println("FNAM>>>>>>>"+fn+"<<<<<<<<filename>>>>>>"+fileName);
		
	ComplaintVO complaintVO= new ComplaintVO();
	List pendingcomplaintList= complaintService.userpendingComplaint(complaintVO);
	System.out.println("PendingcomplaintList:  ");
	System.out.println(pendingcomplaintList);
	complaintVO.setLoginVO(rlVO); 


	List totalcomplaintList= complaintService.userTotalComplaint(complaintVO);
	System.out.println("TotalcomplaintList: ");
	System.out.println(totalcomplaintList);
	
	
	FeedbackVO feedbackVO= new FeedbackVO();
	feedbackVO.setLoginVO(rlVO);
	List feedbackList= feedbackService.userTotalFeedback(feedbackVO);
	System.out.println("FeedbackList:  ");
	System.out.println(feedbackList);

	feedbackVO.setLoginVO(rlVO);
	return new ModelAndView("staff/index").addObject("pendingcomplaintList",pendingcomplaintList.get(0)).addObject("totalcomplaintList",totalcomplaintList.get(0)).addObject("feedbackList",feedbackList.get(0));
	}
	
	@RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})	
	public String viewUserDetails(ModelMap model,HttpServletResponse response,HttpServletRequest request) {

		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	            request.getSession().invalidate();
	            request.getSession().setAttribute("tempStatus", "success");
	            request.getSession().setAttribute("statusText", "Logout Successfully!");
	}
	        return "login";
	        }
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView load() {

		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView load403() {

		return new ModelAndView("login");
	}
	@RequestMapping(value = "/admin/viewDetection", method = RequestMethod.GET)
	public ModelAndView viewDetection() {

		return new ModelAndView("admin/viewDetection");
	}
	
	
	@RequestMapping(value = "/admin/viewDetection2", method = RequestMethod.GET)
	public ModelAndView viewDetection2() {

		return new ModelAndView("admin/viewDetection2");
	}
	
	@RequestMapping(value = "/admin/viewDetectionFinal", method = RequestMethod.GET)
	public ModelAndView viewDetection3() {

		return new ModelAndView("admin/viewDetectionFinal");
	}



	
	@RequestMapping(value="intermediate", method= RequestMethod.GET)
	public ModelAndView step1(@ModelAttribute LoginVO loginVO)
	{
		return new ModelAndView("intermediate");
	}
	
	@RequestMapping(value="searchstep1",method = RequestMethod.POST)
	public ModelAndView searchstep1(@RequestParam("username") String un,LoginVO loginVO,HttpSession session)
	{
		System.out.println("USERNAME>>>"+un);
		session.setAttribute("username", un);
		loginVO.setUsername(un);

		List ls=this.loginService.searchstep1(loginVO);
		System.out.println("List size>>>>>>>>>"+ls.size());
		if(ls!=null && !ls.isEmpty())
		{
			int OTP=generateOTP(4);
			System.out.println("OTP>>>>>"+OTP);
			String subject="otp";
			String content="otp:"+OTP;
			sendMail(un,subject, content);
			session.setAttribute("generatedOTP",OTP);
			return new ModelAndView("edit");
		}
		else
		{
			return new ModelAndView("redirect:/");	
		}   
	}
	@RequestMapping(value="step2", method = RequestMethod.POST)
	public ModelAndView step2(@RequestParam("password") String pwd ,LoginVO loginVO,HttpSession session)
	{
		String userName= (String)session.getAttribute("username");
		loginVO.setUsername(userName);
		loginVO.setPassword(pwd);
		
		this.loginService.updatePassword(loginVO);
		return new ModelAndView("redirect:/");
	}
	
	
}
