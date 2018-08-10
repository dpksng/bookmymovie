package com.bookmymovie.dao.impl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bookmymovie.dao.api.MoviesDao;
import com.bookmymovie.dao.entity.Movies;
import com.bookmymovie.service.HConnect;
import com.bookmymovie.service.JConnect;


@Transactional
@Repository
@Service
public class MoviesDaoImpl implements MoviesDao {
	
	@Autowired
	private HConnect con;

	public boolean insert(Movies movie) {
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.save(movie);
			t.commit();
			session.close();
			return true;
			
		} catch (Exception e) {
			
			System.out.println("Exception(ADD): " + e);
			return false;
		
		}
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Movies> getAllMovies() {
		
		List<Movies> movie= new ArrayList<Movies>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			movie=session.createCriteria(Movies.class).list();
			t.commit();
			session.close();
			return movie;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return movie;
		}
		
	}

	public boolean delete(long movieId){

		try {
			
			Statement st=JConnect.getStatement();
			st.executeUpdate("delete from movies where MOV_ID='"+movieId+"'");
			return true;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return false;
		}
		
	}

	public boolean update(Movies movie) {

		try {
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			session.update(movie);
			t.commit();
			session.close();
			return true;
			
			}catch (Exception e) {
				System.out.println("Exception(ADD): " + e);
				return false;
			}
		
	}

	public Movies getMovieById(long movieId) {
		
		Movies movie=new Movies();	
		
		try {
			Statement st=JConnect.getStatement();
			ResultSet rs=st.executeQuery("select * from movies where MOV_ID='"+movieId+"'");
			while(rs.next()){
				movie.setId(rs.getLong("MOV_ID"));
				movie.setTitle(rs.getString("MOV_TITLE"));
				movie.setDescription(rs.getString("MOV_DSC"));
				movie.setCast(rs.getString("MOV_CAST"));
				movie.setCategory(rs.getString("MOV_CAT"));
				movie.setLanguage(rs.getString("MOV_LANG"));
				movie.setDate(rs.getString("MOV_R_DTE"));
				movie.setLength(rs.getString("MOV_LEN"));
				movie.setImage(rs.getString("MOV_IMAGE"));
				movie.setStatus(rs.getString("MOV_S"));
				}
				
				return movie;
			
		}catch(Exception exception) {
			exception.printStackTrace();
			return movie;
		}
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Movies> getAllMoviesByCategory(String cat) {
		
		List<Movies> movie= new ArrayList<Movies>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			Criteria cr=session.createCriteria(Movies.class);
			cr.add(Restrictions.eq("category", cat));
			movie=cr.list();
			t.commit();
			session.close();
			return movie;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return movie;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Movies> getAllMoviesByLanguage(String lang) {
		
		List<Movies> movie= new ArrayList<Movies>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			Criteria cr=session.createCriteria(Movies.class);
			cr.add(Restrictions.eq("language", lang));
			movie=cr.list();
			t.commit();
			session.close();
			return movie;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return movie;
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Movies> getAllMoviesByStatus(String stat) {
		
		List<Movies> movie= new ArrayList<Movies>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			Criteria cr=session.createCriteria(Movies.class);
			cr.add(Restrictions.eq("status", stat));
			movie=cr.list();
			t.commit();
			session.close();
			return movie;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return movie;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Movies> getAllMoviesById(Long id) {
		
		List<Movies> movie= new ArrayList<Movies>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			@SuppressWarnings("deprecation")
			Criteria cr=session.createCriteria(Movies.class);
			cr.add(Restrictions.eq("id", id));
			movie=cr.list();
			t.commit();
			session.close();
			return movie;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return movie;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Movies> getAllMoviesByTitle(String title) {
		
		List<Movies> movie= new ArrayList<Movies>();
		
		try {
			
			Session session = con.getSession();
			Transaction t = session.beginTransaction();
			@SuppressWarnings("deprecation")
			Criteria cr=session.createCriteria(Movies.class);
			cr.add(Restrictions.eq("title", title));
			movie=cr.list();
			t.commit();
			session.close();
			return movie;
			
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return movie;
		}
		
	}

}
