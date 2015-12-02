package model;

import java.util.ArrayList;

import configuration.DbConfig;
import dao.GenreDAO;
import dao.MovieDAO;
import dao.MovieRatingDAO;
import dao.WatchlistDAO;
import dto.Genre;
import dto.Movie;
import dto.MovieRating;
import dto.WatchList;

public class MovieManager {
	public ArrayList<Movie> getAllMovie() {
		ArrayList<Movie> listMovie = new ArrayList<Movie>();
		DbConfig dbLink;
		try {
			dbLink = new DbConfig();			
			MovieDAO movieAccessObject = new MovieDAO();
			listMovie = movieAccessObject.getAllMovie(dbLink);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMovie;
	}
	public int createMovie(Movie moive){
		DbConfig dbLink;
		Movie tempmovie=moive;
		int returnValue=-1000;
		try {
			dbLink = new DbConfig();			
			MovieDAO movieAccessObject = new MovieDAO();			
			returnValue = movieAccessObject.createMovie(dbLink,tempmovie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
		
	}
	
	public int addWatchList(WatchList watchList){
		DbConfig dbLink;
		WatchList watchlist=watchList;
		int returnValue=-1000;
		try {
			dbLink = new DbConfig();			
			WatchlistDAO movieAccessObject = new WatchlistDAO();			
			returnValue = movieAccessObject.addWatchList(dbLink, watchlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
		
	}
	
	
	
	public Movie getMovie(String id) {	
		DbConfig dbLink;
		Movie movie=null;
		try {
			dbLink = new DbConfig();			
			MovieDAO movieAccessObject = new MovieDAO();
			movie = movieAccessObject.getMovie(dbLink, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movie;
	}
	
	public ArrayList<Movie> getMovies(String id,String title) {	
		DbConfig dbLink;
		ArrayList<Movie> listMovie = new ArrayList<Movie>();
		try {
			dbLink = new DbConfig();			
			MovieDAO movieAccessObject = new MovieDAO();
			listMovie = movieAccessObject.getMovies(dbLink, id, title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMovie;
	}
	public ArrayList<Movie> getMovies(Long  genre_id) {	
		DbConfig dbLink;
		ArrayList<Movie> listMovie = new ArrayList<Movie>();
		try {
			dbLink = new DbConfig();			
			MovieDAO movieAccessObject = new MovieDAO();
			listMovie = movieAccessObject.getMovies(dbLink,genre_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMovie;
	}
	
	
	public ArrayList<Genre> getAllGenre() {
		ArrayList<Genre> listGenre = new ArrayList<Genre>();
		DbConfig dbLink;
		try {
			dbLink = new DbConfig();			
			GenreDAO genreAccessObject = new GenreDAO();
			listGenre = genreAccessObject.getAllGenre(dbLink);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listGenre;
	}
	public ArrayList<WatchList> getAllWatchList() {
		ArrayList<WatchList> listWatchList = new ArrayList<WatchList>();
		DbConfig dbLink;
		try {
			dbLink = new DbConfig();			
			WatchlistDAO watchListAccessObject = new WatchlistDAO();
			listWatchList = watchListAccessObject.getAllWatchList(dbLink);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listWatchList;
	}
	public ArrayList<WatchList> getWatchList(Long user_id) {
		ArrayList<WatchList> listWatchList = new ArrayList<WatchList>();
		DbConfig dbLink;
		try {
			dbLink = new DbConfig();			
			WatchlistDAO watchListAccessObject = new WatchlistDAO();
			listWatchList = watchListAccessObject.getWatchList(dbLink, user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listWatchList;
	}
	
	public ArrayList<MovieRating> getAllMovieRating() {
		ArrayList<MovieRating> listMovieRating = new ArrayList<MovieRating>();
		DbConfig dbLink;
		try {
			dbLink = new DbConfig();			
			MovieRatingDAO movieRatingAccessObject = new MovieRatingDAO();
			listMovieRating = movieRatingAccessObject.getAllMovieRating(dbLink);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMovieRating;
	}


	

}
