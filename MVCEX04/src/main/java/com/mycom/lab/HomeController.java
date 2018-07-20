package com.mycom.lab;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	private String viewName = "hello/helloworld";
	public String getViewName() {
		return this.viewName;
	}
	
	@RequestMapping(value= "hello.do")
	public String helloworldId() {
		//home 에서 hello.do가 들어오면 컨드롤러로 넘어와서 이친구와mapping 됨.
		//페이지를 걍 스트링으로 넘겨준거임.
		return getViewName();
	}
	
	@RequestMapping(value= "hello2.do")
	public ModelAndView  helloworldId2() {
		ModelAndView mav = new ModelAndView(viewName);
		//여기에는 model과 view를 같이 넘김. 
		//모델과 뷰가 붙어서있어서 pojo + jsp가 함께 붙어있는것
		return mav;
	}
	
}
