package com.bookmymovie.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bookmymovie.dao.entity.Admin;
import com.bookmymovie.dao.entity.BookingDetails;
import com.bookmymovie.dao.entity.Cinemas;
import com.bookmymovie.dao.entity.Combos;
import com.bookmymovie.dao.entity.Feedbacks;
import com.bookmymovie.dao.entity.Movies;
import com.bookmymovie.dao.entity.Roles;
import com.bookmymovie.dao.entity.User;
import com.bookmymovie.dao.impl.AdminDaoImpl;
import com.bookmymovie.dao.impl.BookingDetailsDaoImpl;
import com.bookmymovie.dao.impl.CinemasDaoImpl;
import com.bookmymovie.dao.impl.CombosDaoImpl;
import com.bookmymovie.dao.impl.FeedbacksDaoImpl;
import com.bookmymovie.dao.impl.MoviesDaoImpl;
import com.bookmymovie.dao.impl.RolesDaoImpl;
import com.bookmymovie.dao.impl.UserDaoImpl;
import com.bookmymovie.service.DateTime;

@Controller
@SessionAttributes(value = {"ad","profile"})
public class AdminController {
	
		@Autowired
		private MoviesDaoImpl mi;
		
		@Autowired
		private RolesDaoImpl ri;
		
		@Autowired
		private FeedbacksDaoImpl fi;
		
		@Autowired
		private DateTime dt;
		
		@Autowired
		private CombosDaoImpl cmi;
		
		@Autowired
		private CinemasDaoImpl ci;
		
		@Autowired
		private UserDaoImpl ui;
		
		@Autowired
		private AdminDaoImpl ai;
		
		@Autowired
		private BookingDetailsDaoImpl bi;
		
		@RequestMapping(value="/admin-login")
		public String getAdminLogin(){
			return "admin-login";
		}
		
		@RequestMapping(value=("/admin"),method=RequestMethod.GET)
		@ResponseBody
		public ModelAndView getAdminDashboard(Principal principal,Admin admin){
			ModelAndView m=new ModelAndView("admin");
			admin=ai.getAdminById(principal.getName());
			if(admin.getGender().equals("female")){
				m.addObject("profile","profile-female");
			
			}
			else if(admin.getGender().equals("male")){
				m.addObject("profile","profile-male");
				
			}
			else{
				m.addObject("profile","profile");
			}
			
			m.addObject("ad",admin.getName());
			return m;
		}
		
		@RequestMapping(value=("/admin/manage-movies"),method=RequestMethod.GET)
		public ModelAndView getManageMovies(@ModelAttribute("movie")Movies movie,Map<String, Object> model){
			List<Movies> list=mi.getAllMovies();
			List<String> l= new ArrayList<String>();
			l.add("Language");
			l.add("Hindi");
			l.add("English");
			l.add("Punjabi");
			l.add("Telugu");
			List<String> s= new ArrayList<String>();
			s.add("Status");
			s.add("Released");
			s.add("Upcoming");
			List<String> c= new ArrayList<String>();
			c.add("Category");
			c.add("Action");
			c.add("Adventure");
			c.add("Comedy");
			c.add("Crime");
			c.add("Drama");
			c.add("Fantasy");
			c.add("History");
			c.add("Horror");
			c.add("Romance");
			c.add("Science Fiction");
			model.put("category",c);
			model.put("language",l);
			model.put("status",s);
			model.put("list",list);
			ModelAndView m=new ModelAndView("manage-movies");
			return m;
		}
		
		@RequestMapping(value=("/admin/registerMovie"),method=RequestMethod.POST)
		public ModelAndView registerMovie(Movies movie){
			boolean res=mi.insert(movie);
			ModelAndView m=new ModelAndView("redirect:/admin/manage-movies");
			if(res==true){
				m.addObject("msg","added");
			}else {
				m.addObject("msg","Cannot add movie re-submit");
			}
			return m;
		}
		
		@RequestMapping(value=("/admin/updateMovie"),method=RequestMethod.POST)  
	    public ModelAndView updateMovie(Movies mov){
	        mi.update(mov); 
	        return new ModelAndView("redirect:/admin/manage-movies");  
	    }
		
		@RequestMapping(value=("/admin/deleteMovie/{id}"),method=RequestMethod.GET)  
		public ModelAndView deleteMovie(@PathVariable("id") long id){
		    mi.delete(id); 
		    return new ModelAndView("redirect:/admin/manage-movies");  
		}

		
		@RequestMapping("/admin/manage-cinemas")
		public ModelAndView getManageCinemas(@ModelAttribute("cinema") Cinemas cinema,Map<String, Object> model){
			List<Cinemas> list=ci.getAllCinemas();
			List<String> l= new ArrayList<String>();
			l.add("PVR");
			l.add("Cinepolis");
			l.add("DT Cinemas");
			l.add("Fun Cinemas");
			l.add("Satyam Cineplexes");
			l.add("M2K");
			l.add("Movietime");
			model.put("list",list);
			model.put("name",l);
			ModelAndView m=new ModelAndView("manage-cinemas");
			return m;
		}
		
		@RequestMapping(value="/admin/registerCinema",method=RequestMethod.POST)
		public ModelAndView registerCinema(Cinemas cinema){
			cinema.setDate(dt.date());
			ci.insert(cinema);
			ModelAndView m=new ModelAndView("redirect:/admin/manage-cinemas");
			return m;
		}
		
		@RequestMapping(value=("/admin/updateCinema"),method=RequestMethod.POST)  
	    public ModelAndView updateCinema(Cinemas cinema){
	        ci.update(cinema); 
	        return new ModelAndView("redirect:/admin/manage-cinemas");  
	    }
		
		@RequestMapping(value=("/admin/deleteCinema/{id}"),method=RequestMethod.GET)  
		public ModelAndView deleteCinema(@PathVariable("id") long id){
		    ci.delete(id);
		    return new ModelAndView("redirect:/admin/manage-cinemas");  
		}
		
		@RequestMapping("/admin/manage-combos")
		public ModelAndView getManageCombos(@ModelAttribute("combo")Combos combo,Map<String, Object> model){
			List<Combos> list=cmi.getAllCombos();
			model.put("list",list);
			ModelAndView m=new ModelAndView("manage-combos");
			return m;
		}
		
		@RequestMapping(value="/admin/addCombo",method=RequestMethod.POST)
		public ModelAndView addCombo(Combos combo){
			cmi.insert(combo);
			ModelAndView m=new ModelAndView("redirect:/admin/manage-combos");
			return m;
		}
		
		@RequestMapping(value=("/admin/updateCombo"),method=RequestMethod.POST)  
	    public ModelAndView updateCombo(Combos combo){
	        cmi.update(combo); 
	        return new ModelAndView("redirect:/admin/manage-combos");  
	    }
		
		@RequestMapping(value=("/admin/deleteCombo/{id}"),method=RequestMethod.GET)  
		public ModelAndView deleteCombo(@PathVariable("id") long id){
		    cmi.delete(id);
		    return new ModelAndView("redirect:/admin/manage-combos");
		}
		
		@RequestMapping("/admin/manage-feedbacks")
		public ModelAndView getManageFeedbacks(Map<String, Object> model){
			List<Feedbacks> list=fi.getAllFeedbacks();
			model.put("list",list);
			ModelAndView m=new ModelAndView("manage-feedbacks");
			return m;
		}
		
		@RequestMapping(value=("/admin/deleteFeedback/{id}"),method=RequestMethod.GET)  
		public ModelAndView deleteFeedback(@PathVariable("id") long id){
		    fi.delete(id);
		    return new ModelAndView("redirect:/admin/manage-feedbacks");  
		 }
		
		@RequestMapping("/admin/manage-bookings")
		public String getManageReports(BookingDetails bd,Map<String, Object> model){
			List<BookingDetails> list=bi.getAllBookingDetails();
			model.put("list",list);
			return "manage-bookings";
		}
		
		@RequestMapping(value=("/admin/deleteBooking/{id}"),method=RequestMethod.GET)  
		public ModelAndView deleteBooking(@PathVariable("id") long id){
		    bi.delete(id);
		    return new ModelAndView("redirect:/admin/manage-bookings");  
		 }
		
		
		@RequestMapping("/admin/manage-users")
		public ModelAndView getManageUsers(@ModelAttribute("user")User user,Map<String, Object> model){
			List<User> list=ui.getAllUser();
			model.put("list",list);
			ModelAndView m=new ModelAndView("manage-users");
			return m;
		}
		
		@RequestMapping(value=("/admin/updateUser"),method=RequestMethod.POST)  
	    public ModelAndView updateUser(User user){
	        ui.update(user); 
	        return new ModelAndView("redirect:/admin/manage-users");  
	    }
		
		@RequestMapping(value=("/admin/deleteUser/{id}"),method=RequestMethod.GET)  
		public ModelAndView deleteUser(@PathVariable("id") long id){
		    ui.delete(id);
		    return new ModelAndView("redirect:/admin/manage-users");
		}
		
		@RequestMapping("/logout")
		public ModelAndView getLogout(){
			ModelAndView m=new ModelAndView("/admin");
			return m;
		}
		
		@RequestMapping("/logFail")
		public ModelAndView getLogFail(){
			ModelAndView m=new ModelAndView("/admin");
			return m;
		}
	
		@RequestMapping(value="/admin/add",method=RequestMethod.GET)
		public ModelAndView addAdmin(@ModelAttribute("admin")Admin admin){
			ModelAndView m=new ModelAndView("admin-registration");
			return m;
		}
		
		@RequestMapping(value="/admin/registerAdmin")
		public ModelAndView registerAdmin(Admin admin){
			boolean res=ai.insert(admin);
			Roles role=new Roles();
			role.setEmail(admin.getId());
			role.setRole("ROLE_ADMIN");
			if(res==true){
				ri.insert(role);
			}
			ModelAndView m=new ModelAndView("redirect:/admin/add");
			return m;
		}
		
		@RequestMapping(value="/admin/upload",method=RequestMethod.POST)
		public ModelAndView upload(@RequestParam("file")CommonsMultipartFile file,@RequestParam String selection,HttpSession session,HttpServletRequest request){
		
			String path=session.getServletContext().getRealPath("/resources/img/movies/");
			
			//String fileName=file.getOriginalFilename();
			
			Long id=Long.parseLong(selection);
			Movies movie=mi.getMovieById(id);
			movie.setImage(selection);
			String fileName=selection;
						
			System.out.println(path);	
			
			try{
				File f = new File(path+fileName+".jpg");
				if(f.exists()){
					boolean res=f.delete();
					if(res){
						System.out.println("Deleted");
					}
					byte img[]=file.getBytes();
					BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(path+fileName+".jpg"));
					out.write(img);
					out.flush();
					out.close();
					mi.update(movie);
				}
				else{
					byte img[]=file.getBytes();
					BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(path+fileName+".jpg"));
					out.write(img);
					out.flush();
					out.close();
					mi.update(movie);
				}

			}catch(Exception e){
				e.printStackTrace();
			}
			ModelAndView m=new ModelAndView("redirect:/admin/manage-movies");
			return m;
			
		}
		
		@RequestMapping(value="/admin/uploadSlide",method=RequestMethod.POST)
		public ModelAndView uploadSlide(@RequestParam("file")CommonsMultipartFile file,@RequestParam String selection,HttpSession session,HttpServletRequest request){
		
			String path=session.getServletContext().getRealPath("/resources/img/slider/");
			
			//String fileName=file.getOriginalFilename();
			
			String fileName=selection;
						
			System.out.println(path);	
			
			try{
				File f = new File(path+fileName+".jpg");
				if(f.exists()){
					boolean res=f.delete();
					if(res){
						System.out.println("Deleted");
					}
					byte img[]=file.getBytes();
					BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(path+fileName+".jpg"));
					out.write(img);
					out.flush();
					out.close();
				}
				else{
					byte img[]=file.getBytes();
					BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(path+fileName+".jpg"));
					out.write(img);
					out.flush();
					out.close();
				}

			}catch(Exception e){
				e.printStackTrace();
			}
			ModelAndView m=new ModelAndView("redirect:/admin/manage-movies");
			return m;
			
		}
			   	
}
