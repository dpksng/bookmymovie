package com.bookmymovie.controllers;

import java.util.ArrayList;

import java.util.Iterator;
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
import org.springframework.web.servlet.ModelAndView;

import com.bookmymovie.dao.entity.BookingDetails;
import com.bookmymovie.dao.entity.Cinemas;
import com.bookmymovie.dao.entity.Combos;
import com.bookmymovie.dao.entity.Movies;
import com.bookmymovie.dao.entity.Seats;
import com.bookmymovie.dao.entity.ShowTimings;
import com.bookmymovie.dao.impl.BookingDetailsDaoImpl;
import com.bookmymovie.dao.impl.CinemasDaoImpl;
import com.bookmymovie.dao.impl.CombosDaoImpl;
import com.bookmymovie.dao.impl.MoviesDaoImpl;
import com.bookmymovie.dao.impl.SeatsDaoImpl;
import com.bookmymovie.dao.impl.ShowTimingsDaoImpl;
import com.bookmymovie.dao.impl.UserDaoImpl;
import com.bookmymovie.service.DateTime;

@Controller
@SessionAttributes(value = {"ms", "cs","ss","seats","price","count","cns","total","book"})
public class BookingController {

	@Autowired
	CinemasDaoImpl ci;
	
	@Autowired
	UserDaoImpl ui;
	
	@Autowired
	MoviesDaoImpl mi;
	
	@Autowired
	SeatsDaoImpl si;
	
	@Autowired
	ShowTimingsDaoImpl ti;
	
	@Autowired
	CombosDaoImpl cdi;
	
	@Autowired
	DateTime dt; 
	
	@Autowired
	BookingDetailsDaoImpl bi;
	
	@RequestMapping(value="/selectCinema/{id}",method=RequestMethod.GET)
	public ModelAndView chooseCinema(@PathVariable("id")long id,Movies movie,Map<String, Object> model){
		ModelAndView m=new ModelAndView("select-cinema");
		movie=mi.getMovieById(id);
		List<Cinemas> list=ci.getAllCinemas();
		model.put("list",list);
		m.addObject("ms",movie);
		return m;
	}
	
	@RequestMapping(value="/selectSeats/{time}/{cinema}/{location}",method=RequestMethod.GET)
	public ModelAndView chooseSeats(@PathVariable("time")String time,@PathVariable("cinema")String cinema,@PathVariable("location")String location,@ModelAttribute Movies movie,Map<String, Object> model,ShowTimings show){
		String cn="";
		cn=cinema+" - "+location;
		ModelAndView m=new ModelAndView("select-seats");
		show.setTime(time);
		ti.insert(show);
		List<Seats> list=si.getAllSeats();
		
		String current=dt.time();
		model.put("list",list);
		m.addObject("ss",show);
		m.addObject("cns",cn);
		m.addObject("current",current);
		return m;
	}
	
	@RequestMapping(value="/bookingDetails/{amount}")
	public ModelAndView bookingDetails(@PathVariable("amount")long price,HttpServletRequest request){
		String date=dt.shortDate();
		ModelAndView m=new ModelAndView("booking-details");
			if(request.getParameter("combo")!=null){
			String comboId=request.getParameter("combo");
			long id=Long.parseLong(comboId);
			Combos cmb=cdi.getComboById(id);
			String amt=cmb.getAmount();
			long total=Long.parseLong(amt);
			total=total+price;
			m.addObject("cmb",cmb.getTitle());
			m.addObject("total",total);
		}
		else{
			m.addObject("cmb","None");
			m.addObject("total",price);
		}
		m.addObject("sd",date);
		return m;
	}
	
	@RequestMapping(value="/selectCombos",method=RequestMethod.GET)
	public ModelAndView selectCombos(HttpServletRequest request,Map<String, Object> model){
		String st[];
		st= request.getParameterValues("seat");
		List<String> list=new ArrayList<String>();
		long count=st.length;
		for(int i=0;i<count;i++){
			list.add(st[i]);
		}
		String seats="";
		Iterator<String> itr=list.iterator();  
		  while(itr.hasNext()){  
			  seats=seats+itr.next()+", ";
		  } 
		long total=count*150;
		List<Combos> l=cdi.getAllCombos();
		model.put("list",l);
		ModelAndView m=new ModelAndView("select-combos");
		m.addObject("price",total);
		m.addObject("seats",seats);
		m.addObject("count",count);
		return m;
	}
	
	@RequestMapping("/makePayment/{id}/{cinema}/{seats}/{total}/{sdate}/{stime}/{combo}/{count}/{session:.+}")
	public ModelAndView makePayment(BookingDetails book,@PathVariable("id")long id,@PathVariable("cinema")String cinema,@PathVariable("seats")String seats,@PathVariable("total")long total,@PathVariable("sdate")String sdate,@PathVariable("stime")String stime,@PathVariable("combo")String combo,@PathVariable("count")long count,@PathVariable("session")String session){
		Movies movie=mi.getMovieById(id);
		book.setMovie(movie.getTitle());
		String amt=""+total;
		book.setAmount(amt);
		book.setCinema(cinema);
		book.setCombo(combo);
		String cnt=""+count;
		book.setCount(cnt);
		book.setShowDate(sdate);
		book.setShowTime(stime);
		book.setDate(dt.date());
		book.setTime(dt.time());
		book.setSeats(seats);
		book.setStatus("Done");
		
		if(session.equals(movie.getTitle())){
			ModelAndView m=new ModelAndView("confirm-login");
			bi.insert(book);
			m.addObject("book",book);
			return m;
		}
		else{
			
			book.setEmail(session);
			bi.insert(book);
			ModelAndView m=new ModelAndView("make-payment");
			m.addObject("book",book);
			return m;
		}
	}
	
	@RequestMapping("/getTicket")
	public ModelAndView getTicket(){
		
		ModelAndView m=new ModelAndView("getTicket");
		return m;
	}
	
	@RequestMapping("/bookingHistory/{email:.+}")
	public ModelAndView getBookingHistory(@PathVariable("email")String email,Map<String, Object> model){
		List<BookingDetails> list=bi.getAllBookingByUser(email);
		model.put("history",list);
		ModelAndView m=new ModelAndView("booking-history");
		return m;
	}
	
}
