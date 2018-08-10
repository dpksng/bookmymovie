package com.bookmymovie.controllers;

import java.util.List;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookmymovie.dao.entity.Feedbacks;
import com.bookmymovie.dao.entity.Movies;
import com.bookmymovie.dao.impl.FeedbacksDaoImpl;
import com.bookmymovie.dao.impl.MoviesDaoImpl;
import com.bookmymovie.service.DateTime;

@Controller

public class HomeController{
	
	@Autowired
	MoviesDaoImpl mi;
	
	@Autowired
	FeedbacksDaoImpl fi;
	
	@Autowired
	private DateTime dt;
		
	@RequestMapping(value={"/","/index"})
	public ModelAndView getHomePage(Map<String, Object> model){
		ModelAndView m=new ModelAndView("index");
		List<Movies> list1=mi.getAllMoviesByStatus("Released");
		List<Movies> list2=mi.getAllMoviesByStatus("Upcoming");
		List<Movies> list=mi.getAllMovies();
		model.put("list",list);
		model.put("list1",list1);
		model.put("list2",list2);
		return m;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView getAboutPage(){
		ModelAndView m=new ModelAndView("about");
		return m;
	}
	
	@RequestMapping(value="/terms")
	public ModelAndView getTermsPage(){
		ModelAndView m=new ModelAndView("terms");
		return m;
	}
	
	@RequestMapping(value="/privacy-policy")
	public ModelAndView getPolicyPage(){
		ModelAndView m=new ModelAndView("privacy-policy");
		return m;
	}
	
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public ModelAndView getContactPage(@ModelAttribute("feed")Feedbacks feed){
		ModelAndView m=new ModelAndView("contact");
		return m;
	}
	
	@RequestMapping(value="/sendMessage",method=RequestMethod.POST)
	public ModelAndView sendMessage(Feedbacks feed){
		feed.setDate(dt.date());
		fi.insert(feed);
		ModelAndView m=new ModelAndView("redirect:/contact");
		m.addObject("msg","Message Sent");
		return m;
	}
	
	@RequestMapping(value="/feedback",method=RequestMethod.GET)
	public ModelAndView getFeedbackPage(@ModelAttribute("feed")Feedbacks feed){
		ModelAndView m=new ModelAndView("feedback");
		return m;
	}
	
	@RequestMapping(value="/sendFeedback",method=RequestMethod.POST)
	public ModelAndView sendFeedback(Feedbacks feed){
		feed.setDate(dt.date());
		fi.insert(feed);
		ModelAndView m=new ModelAndView("redirect:/feedback");
		m.addObject("msg","Feedback Sent");
		return m;
	}
	
	@RequestMapping(value="/searchMovieCategory/{cat}")
	public ModelAndView searchMovieCategory(@PathVariable("cat")String cat,Movies movie,Map<String, Object> model){
		List<Movies> list=mi.getAllMoviesByCategory(cat);
		ModelAndView m=new ModelAndView("search-movies");
		model.put("list",list);
		m.addObject("show",cat);
		return m;
	}
	
	@RequestMapping(value="/searchMovieLanguage/{lang}")
	public ModelAndView searchMovieLanguage(@PathVariable("lang")String lang,Movies movie,Map<String, Object> model){
		List<Movies> list=mi.getAllMoviesByLanguage(lang);
		ModelAndView m=new ModelAndView("search-movies");
		model.put("list",list);
		m.addObject("show",lang);
		return m;
	}
	
}
