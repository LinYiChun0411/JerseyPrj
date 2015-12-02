/**
 * 
 */
package moviesoffline;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import dto.Genre;
import dto.Movie;
import dto.MovieRating;
import dto.WatchList;
import model.MovieManager;


@Path("/movies")
public class MovieService {
	@GET
	@Path("/list")
	@Produces("application/json")
	public String getAllMovieData() {
		String listMovieData = null;
		Gson gson = new Gson();
		ArrayList<Movie> listMovie = new ArrayList<Movie>();
		MovieManager movieManager = new MovieManager();		
		listMovie = movieManager.getAllMovie();
		listMovieData = gson.toJson(listMovie);		
		return listMovieData;
	}
	
	
	@GET
	@Path("/genre")
	@Produces("application/json")
	public String getAllGenreData() {
		String listGenreData = null;
		Gson gson = new Gson();
		ArrayList<Genre> genreMovie = new ArrayList<Genre>();
		MovieManager movieManager = new MovieManager();		
		genreMovie = movieManager.getAllGenre();
		listGenreData = gson.toJson(genreMovie);		
		return listGenreData;
	}
	@GET
	@Path("/movie_rating")
	@Produces("application/json")
	public String getAllMovieRatingData() {
		String movieRatingString = null;
		Gson gson = new Gson();
		ArrayList<MovieRating> movieRatingList = new ArrayList<MovieRating>();
		MovieManager movieManager = new MovieManager();		
		movieRatingList = movieManager.getAllMovieRating();
		movieRatingString = gson.toJson(movieRatingList);		
		return movieRatingString;
	}
	
	@GET
	@Path("/watchlist")
	@Produces("application/json")
	public String getAllWatchList() {
		String watchlistString = null;
		Gson gson = new Gson();
		ArrayList<WatchList> listWatchlist = new ArrayList<WatchList>();
		MovieManager movieManager = new MovieManager();		
		listWatchlist = movieManager.getAllWatchList();
		watchlistString = gson.toJson(listWatchlist);		
		return watchlistString;
	}
	
	@GET
	@Path("/watchlist/{user_id}")
	@Produces("application/json")
	public String getWatchList(@PathParam("user_id") Long user_id) {
		String watchlistString = null;
		Gson gson = new Gson();
		ArrayList<WatchList> listWatchlist = new ArrayList<WatchList>();
		MovieManager movieManager = new MovieManager();		
		listWatchlist = movieManager.getWatchList(user_id);
		watchlistString = gson.toJson(listWatchlist);		
		return watchlistString;
	}
	
	
	@GET
	@Path("/searchMovie/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMovie(@PathParam("id") String id) {			
		Movie movie = new Movie();
		MovieManager movieManager =new MovieManager();
		movie=movieManager.getMovie(id);
		Gson gson = new Gson();
		return gson.toJson(movie);
	}
	
	@GET
	@Path("/searchMovies/{id}/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMovies(@PathParam("id") String id,@PathParam("title") String title) {			
		ArrayList<Movie> listMovie = new ArrayList<Movie>();		
		MovieManager movieManager =new MovieManager();		
		listMovie=movieManager.getMovies(id, title);
		Gson gson = new Gson();
		return gson.toJson(listMovie);
	}
	
	@GET
	@Path("/searchMovies/{genre_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMovies(@PathParam("genre_id") Long genre_id) {			
		ArrayList<Movie> listMovie = new ArrayList<Movie>();		
		MovieManager movieManager =new MovieManager();		
		listMovie=movieManager.getMovies(genre_id);
		Gson gson = new Gson();
		return gson.toJson(listMovie);
	}
	
	@GET
	@Path("/addMovie/{movie_id}/{title}/{genre_id}/{age_rating}/{releaseDate}/{storyline}")
	@Produces(MediaType.TEXT_PLAIN)
	public int addMovie1(
			 @PathParam("movie_id") String movie_id
			,@PathParam("title") String title
			,@PathParam("genre_id") Long genre_id
			,@PathParam("age_rating") Long age_rating
			,@PathParam("releaseDate") String releaseDate
			,@PathParam("storyline") String storyline
			) {			
		
		MovieManager movieManager =new MovieManager();
		
		Movie movie=new Movie();
		movie.setMovie_id(movie_id);
		movie.setTitle(title);
		movie.setGenre_id(genre_id);
		movie.setAge_rating(age_rating);
		movie.setReleaseDate(releaseDate);
		movie.setStoryline(storyline);
		
		return movieManager.createMovie(movie);
	}
	
	@POST
	@Path("/addMovie")
	@Produces(MediaType.TEXT_PLAIN)
	public Response addMovie(
			 @FormParam("movie_id") String movie_id
			,@FormParam("title") String title
			,@FormParam("genre_id") Long genre_id
			,@FormParam("age_rating") Long age_rating
			,@FormParam("releaseDate") String releaseDate
			,@FormParam("storyline") String storyline
			) {			
		
		MovieManager movieManager =new MovieManager();
	
		Movie movie=new Movie();
		movie.setMovie_id(movie_id);
		movie.setTitle(title);
		movie.setGenre_id(genre_id);
		movie.setAge_rating(age_rating);
		movie.setReleaseDate(releaseDate);
		movie.setStoryline(storyline);
		movieManager.createMovie(movie);
		
		return Response.status(200).build();
	}
	
	  @Path("/addwatchlist")
	  @POST
	  public Response addwatchlist(@FormParam("user_id") Long user_id,
	      @FormParam("movie_id") String movie_id,
	      @FormParam("status") String status,
	      @FormParam("modifiedDate") String modifiedDate,
	      @Context HttpServletResponse servletResponse) throws IOException {
		  
		  WatchList watchList=new WatchList();
		  watchList.setUser_Id(user_id);
		  watchList.setMovie_id(movie_id);
		  watchList.setStatus(status);
		  watchList.setModifiedDate(modifiedDate);
		  new MovieManager().addWatchList(watchList);		 
		  return Response.status(200)
					.entity("addwatchlist is called, user_id : " +user_id + ", movie_id : " + movie_id)
					.build();
	  }
	
	
	
	
}
