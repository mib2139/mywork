package com.mycom.lab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycom.lab.model.person;

@Controller
public class PersonServiceController {
	private String formView = "person/personform";
	private String successView = "person/personsuccess";

	public String getFormView() {
		return this.formView;
	}


	@RequestMapping(value="person.do", method=RequestMethod.GET)
	protected String personInput(ModelMap model) throws Exception{
		model.addAttribute("personinfo", new person());
		//person객체를 생성하여 personinfo라는 이름으로 model에 넣어브려
		return getFormView();
	}

	@RequestMapping(value="/person.do", method=RequestMethod.POST)
	protected String register(@ModelAttribute("personinfo") person command,
			BindingResult errors, ModelMap model) throws Exception{
		//만약 person으로 들어오면 컨트롤러가 personinfo로 감, 그리고 person객체와 연관이 되어있음
		//이 객체들끼리 바인딩 시켜주는게 bingingREsult 임 바인딩 된거는 모델에 들어가잇음
		if (errors.hasErrors()) {
			return formView;
		}

		model.addAttribute("pinfo", command);
		//성공하면 pinfo로 successView에 연결되는 거임.
		return successView;
	}

	@RequestMapping(value="/person2.do", method=RequestMethod.GET)
	protected String personinput2(ModelMap model) throws Exception{
		model.addAttribute("personinfo", new person());
		return formView;
	}



	@RequestMapping(value="/person2/do", method = RequestMethod.POST)
	protected String register2(@RequestParam("name") String name,
			@RequestParam(value="company", required=false) String company,
			@RequestParam(value="phone", required=false) String phone,
			@RequestParam(value="email", required=false) String email,
			ModelMap model)throws Exception {

		person personinfo = new person();
		personinfo.setName(name);
		personinfo.setCompany(company);
		personinfo.setPhone(phone);
		personinfo.setEmail(email);

		model.addAttribute("pinfo", personinfo);
		return successView;

	}


	@RequestMapping(value="/person3.do", method=RequestMethod.GET)
	protected String personinput3(ModelMap model) throws Exception{

		person pobject = new person();
		pobject.setName("gntp");
		pobject.setCompany("gojapan");
		pobject.setPhone("02-1234-5678");
		pobject.setEmail("mib213@gamil.com");
		model.addAttribute("personinfo", pobject);

		return formView;
	}

	@RequestMapping(value="/person3.do", method = RequestMethod.POST)
	protected String register2(@ModelAttribute("personinfo") person command,
			BindingResult errors, ModelMap model)throws Exception {

		if (errors.hasErrors()) {
			return getFormView();
		}
		model.addAttribute("pinfo", command);
		return successView;
	}
}
