package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.ComplaintVO;
import com.project.model.FeedbackVO;
import com.project.model.LoginVO;
import com.project.service.FeedbackService;
import com.project.service.LoginService;
import com.project.utils.Basemethods;

@Controller
public class FeedbackController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	FeedbackService feedbackService;
	
	@RequestMapping(value="/staff/loadFeedback",method=RequestMethod.GET)
	public ModelAndView loadFeedback(@ModelAttribute FeedbackVO feedbackVO)
	{
		return new ModelAndView("/staff/addFeedback","feedbackVO",new FeedbackVO());
	}
	
	@RequestMapping(value="/staff/insertRaiting",method=RequestMethod.POST)
	public ModelAndView insertFeedback(@ModelAttribute FeedbackVO feedbackVO,LoginVO loginVO)
	{
		String userName = Basemethods.getUser();

		List loginList  = loginService.searchLoginID1(userName);
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);		
		feedbackVO.setLoginVO(loginVO2);
		this.feedbackService.insertFeedback(feedbackVO);
		return new ModelAndView("redirect:/staff/loadFeedback");
	}
	
	@RequestMapping(value="admin/viewFeedback",method=RequestMethod.GET)
	public ModelAndView viewFeedback(@ModelAttribute FeedbackVO feedbackVO) {
		
		List feedbackList = this.feedbackService.viewFeedback(feedbackVO);
		
		return new ModelAndView("admin/viewFeedback","feedbackList",feedbackList);
	}
	
	@RequestMapping(value="staff/viewstaffFeedback",method=RequestMethod.GET)
	public ModelAndView viewstaffFeedback(@ModelAttribute FeedbackVO feedbackVO) {
		
		String userName = Basemethods.getUser();
		List loginList  = loginService.searchLoginID1(userName); 	
		LoginVO loginVO2 = (LoginVO) loginList.get(0);	
		feedbackVO.setLoginVO(loginVO2);
		
		List feedbackList = this.feedbackService.viewstaffFeedback(feedbackVO);
		
		return new ModelAndView("/staff/viewFeedback","feedbackList",feedbackList);
		
	}
}
