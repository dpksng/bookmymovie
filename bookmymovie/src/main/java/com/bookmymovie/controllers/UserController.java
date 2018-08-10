package com.bookmymovie.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bookmymovie.dao.entity.BookingDetails;
import com.bookmymovie.dao.entity.Roles;
import com.bookmymovie.dao.entity.User;
import com.bookmymovie.dao.impl.BookingDetailsDaoImpl;
import com.bookmymovie.dao.impl.RolesDaoImpl;
import com.bookmymovie.dao.impl.UserDaoImpl;
import com.bookmymovie.service.DateTime;

@Controller
@SessionAttributes(value = {"su"})
public class UserController {
	
	@Autowired
	private DateTime dt;
	@Autowired
	private UserDaoImpl ui;
	@Autowired
	private RolesDaoImpl ri;
	@Autowired
	private BookingDetailsDaoImpl bi;
		
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView getRegister(@ModelAttribute("user") User user,Map<String, Object> model){
		ModelAndView m=new ModelAndView("register");
		List<String> g= new ArrayList<String>();
	    g.add("male");
	    g.add("female");
	    List<String> q1= new ArrayList<String>();
	    q1.add("What was your childhood nickname?");
	    q1.add("What is the name of your favorite childhood friend?");
	    q1.add("What is the middle name of your oldest child?");
	    q1.add("In what city or town did your mother and father meet?");
	    q1.add("What is your favorite movie?");
	    q1.add("What is your pet’s name?");
	    q1.add("In what town was your first job?");
	    q1.add("What was your favorite food as a child?");
		List<String> q2= new ArrayList<String>();
		q2.add("What was your favorite food as a child?");
		q2.add("What was your childhood nickname?");
	    q2.add("What is the name of your favorite childhood friend?");
	    q2.add("What is the middle name of your oldest child?");
	    q2.add("In what city or town did your mother and father meet?");
	    q2.add("What is your favorite movie?");
	    q2.add("What is your pet’s name?");
	    q2.add("In what town was your first job?");
		model.put("gender",g);
		model.put("question1",q1);
		model.put("question2",q2);
	    return m;
	}
	
	@RequestMapping("/performRegistration")
	public ModelAndView performRegistration(User user){
		user.setDate(dt.date());
		user.setTime(dt.time());
		Roles role=new Roles();
		boolean res=ui.insert(user);
		role.setEmail(user.getEmail());
		role.setRole("ROLE_USER");
		if(res==true){
			ModelAndView m=new ModelAndView("redirect:/user-login");
			ri.insert(role);
			m.addObject("msg","Registered Successfully");
			return m;
		}else{
			ModelAndView m=new ModelAndView("redirect:/register");
			m.addObject("msg","Registration Failed");
			return m;
		}
	}
	
	@RequestMapping("/user-login")
	public String getLogin(){
		return "user-login";
	}
	
	@RequestMapping(value=("loginProcess"),method=RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request,@ModelAttribute User user){
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		user=ui.getUserById(email);
		String confirm=user.getPwd();
		if(password.equals(confirm)){
			ModelAndView m=new ModelAndView("redirect:/");
			m.addObject("su",user);
			return m;
		}else{
			ModelAndView m=new ModelAndView("redirect:/user-login");
			return m; 
		}
	}
	
	@RequestMapping("/edit-profile/{email:.+}")
	public ModelAndView editProfile(@PathVariable("email")String email,@ModelAttribute("getUser")User user){
		user=ui.getUserById(email);
		ModelAndView m=new ModelAndView("edit-profile");
		m.addObject("edit",user);
		return m;
	}
	
	
	@RequestMapping(value="/updateProfile",method=RequestMethod.POST)
	public ModelAndView updateProfile(HttpServletRequest request,User user){
		ModelAndView m=new ModelAndView("redirect:/");
		ui.update(user);
		return m;
	}
	
	@RequestMapping("/userLogout")
    public ModelAndView userLogout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
       ModelAndView m=new ModelAndView("redirect:/");
       return m;
    }
	
	@RequestMapping(value="/forgot-password")
	public ModelAndView forgotPassword(){
		ModelAndView m=new ModelAndView("forgot-password");
		return m;
	}
	
	@RequestMapping(value="/accountRecovery")
	public ModelAndView accountRecovery(HttpServletRequest request,User user){
		String check=request.getParameter("email");
		user=ui.getUserById(check);
		ModelAndView m=new ModelAndView("account-recovery");
		m.addObject("recover",user);
		return m;
	}
	
	@RequestMapping(value="/verifyAnswer")
	public ModelAndView verifyAnswer(HttpServletRequest request,User user){
		
		String email=request.getParameter("email").trim();
		String answer1=request.getParameter("answer1").trim();
		String answer2=request.getParameter("answer2").trim();
		
		user=ui.getUserById(email);
		
		String a1=user.getAnswer1().trim();
		String a2=user.getAnswer2().trim();
		
		if(answer1.equalsIgnoreCase(a1) && answer2.equalsIgnoreCase(a2)){
			ModelAndView m=new ModelAndView("new-password");
			m.addObject("recover",user);
			return m;
		}
		else {
			ModelAndView m=new ModelAndView("redirect:/account-recovery");
			m.addObject("msg","Your answers are incorrect");
			return m;
		}
	}
	
	@RequestMapping(value="/newPassword")
	public ModelAndView newPassword(HttpServletRequest request,User user){
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");
		String confirm=request.getParameter("conf");
		user=ui.getUserById(email);
		user.setPwd(password);
		user.setConf(confirm);
		boolean res=ui.update(user);
		if(res==true){
			ModelAndView m=new ModelAndView("redirect:/user-login");
			m.addObject("pwd",user.getPwd());
			return m;
		}
		else{
			ModelAndView m=new ModelAndView("new-password");
			return m;
		}
	}
	
	@RequestMapping("/confirmLogin")
	public ModelAndView conFirmLogin(){
		ModelAndView m=new ModelAndView("confirm-login");
		return m;
	}
	
	@RequestMapping(value=("/validateProcess/{seats}"),method=RequestMethod.POST)
	public ModelAndView validateProcess(@PathVariable("seats")String seats,HttpServletRequest request,@ModelAttribute User user){
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		user=ui.getUserById(email);
		String confirm=user.getPwd();
		if(password.equals(confirm)){
			ModelAndView m=new ModelAndView("make-payment");
			BookingDetails bd=bi.getBookingDetailById(seats);
			bd.setEmail(user.getEmail());
			bi.update(bd);
			m.addObject("su",user);
			return m;
		}else{
			ModelAndView m=new ModelAndView("confirm-login");
			return m; 
		}
	}

}
