package webresource;

import java.net.URI;
import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import models.Genre;
import models.Movie;
import models.MovieRating;
import models.WatchList;

import org.glassfish.jersey.client.ClientConfig;

import com.google.gson.Gson;

public class MovieResource {
	WebTarget targetWebservice;
	WebTarget webPath;
	public MovieResource() {	
		URI uri=UriBuilder.fromUri("http://localhost:8080/moviesoffline").build();
		ClientConfig config=new ClientConfig();
		Client client=ClientBuilder.newClient(config);
		targetWebservice=client.target(uri);
		webPath=targetWebservice.path("rest/movies");
	}
	
	public int addWatchlist(Long user_id,String movie_id,String status,String modifiedDate){
		//Create a Todo
	    Form form =new Form();
	    form.param("user_id",String.valueOf(user_id));
	    form.param("movie_id",movie_id);
	    form.param("status",status);
	    form.param("modifiedDate",modifiedDate);
	    Response response =webPath.path("addwatchlist").request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),Response.class);	    
	    return response.getStatus();
	   
		
	}
	public int addMovie(String movie_id,String title,Long genre_id,Long age_rating,String releaseDate,String storyline){
		Form form =new Form();	    
	    form.param("movie_id",movie_id);
	    form.param("title",title);
	    form.param("genre_id",String.valueOf(genre_id));
	    form.param("age_rating",String.valueOf(age_rating));
	    form.param("releaseDate",releaseDate);
	    form.param("storyline",storyline);
	    
		Response response =webPath.path("addMovie").request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),Response.class);	    
	    return response.getStatus();
	}
	
	public int addMovie2(String movie_id,String title,Long genre_id,Long age_rating,String releaseDate,String storyline){
		String returnValue=webPath.path("addMovie")
				.path(movie_id)
				.path(title)
				.path(String.valueOf(genre_id) )
				.path(String.valueOf(age_rating))
				.path(releaseDate)
				.path(storyline)
				.request().accept(MediaType.TEXT_PLAIN_TYPE).get(String.class);
		return Integer.parseInt(returnValue);
	}	
	
	public ArrayList<Movie> getAllMovie(){
		ArrayList<Movie> movieList=new ArrayList<Movie>();
		String jsonString=webPath.path("list").request().accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		Gson gson=new Gson();
		Movie[] movieArray= gson.fromJson(jsonString, Movie[].class);				
		
		for(int i=0;i<movieArray.length;i++){
			movieList.add(movieArray[i]);						
		}
		
		return movieList;

	}
	public ArrayList<Genre> getAllGenre(){
		ArrayList<Genre> genreList=new ArrayList<Genre>();
		String jsonString=webPath.path("genre").request().accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		Gson gson=new Gson();
		Genre[] genreArray= gson.fromJson(jsonString, Genre[].class);				
		
		for(int i=0;i<genreArray.length;i++){
			genreList.add(genreArray[i]);						
		}
		
		return genreList;

	}
	public ArrayList<MovieRating> getAllMovieRating(){
		ArrayList<MovieRating> movieRatingList=new ArrayList<MovieRating>();
		String jsonString=webPath.path("movie_rating")
				.request().accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		Gson gson=new Gson();
		MovieRating[] movieRatingArray= gson.fromJson(jsonString, MovieRating[].class);				
		
		for(int i=0;i<movieRatingArray.length;i++){
			movieRatingList.add(movieRatingArray[i]);						
		}
		
		return movieRatingList;

	}
	public ArrayList<WatchList> getAllWatchList(){
		ArrayList<WatchList> movieWatchList=new ArrayList<WatchList>();
		String jsonString=webPath.path("watchlist")
				.request().accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		Gson gson=new Gson();
		WatchList[] watchListArray= gson.fromJson(jsonString, WatchList[].class);				
		
		for(int i=0;i<watchListArray.length;i++){
			movieWatchList.add(watchListArray[i]);						
		}		
		return movieWatchList;

	}
	public ArrayList<WatchList> getWatchList(Long user_id){
		ArrayList<WatchList> movieWatchList=new ArrayList<WatchList>();
		String jsonString=webPath.path("watchlist").path(String.valueOf(user_id))
				.request().accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		Gson gson=new Gson();
		WatchList[] watchListArray= gson.fromJson(jsonString, WatchList[].class);				
		
		for(int i=0;i<watchListArray.length;i++){
			movieWatchList.add(watchListArray[i]);						
		}		
		return movieWatchList;

	}
	
	
	public ArrayList<Movie> getMovies(String id,String title){
		ArrayList<Movie> movieList=new ArrayList<Movie>();
		String jsonString=webPath.path("searchMovies").path(id).path(title).request().accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		Gson gson=new Gson();
		Movie[] movieArray= gson.fromJson(jsonString, Movie[].class);				
		
		for(int i=0;i<movieArray.length;i++){
			movieList.add(movieArray[i]);						
		}
		
		return movieList;

	}
	public ArrayList<Movie> getMovies(Long genre_id){
		ArrayList<Movie> movieList=new ArrayList<Movie>();
		String jsonString=webPath.path("searchMovies").path(String.valueOf(genre_id))
				.request().accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		Gson gson=new Gson();
		Movie[] movieArray= gson.fromJson(jsonString, Movie[].class);				
		
		for(int i=0;i<movieArray.length;i++){
			movieList.add(movieArray[i]);						
		}
		
		return movieList;

	}
	
	
}
