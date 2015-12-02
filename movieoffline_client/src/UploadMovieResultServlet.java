

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webresource.MovieResource;
import models.Movie;


@WebServlet("/show_upload_moive")
public class UploadMovieResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movie_id=request.getParameter("movie_id");
		String title=request.getParameter("movie_title");			
		Object age_rating = request.getParameter("age_rating");
		Object genre_id = request.getParameter("genre_id");
		String storyline=request.getParameter("storyline");			
		MovieResource movieResource=new MovieResource();
		int returnStatus=movieResource.addMovie(movie_id, title, Long.parseLong(genre_id.toString()), Long.parseLong(age_rating.toString()), "2015-12-1", storyline);
		if(returnStatus==200){		
			Movie movie=new Movie();
			movie.setMovie_id(movie_id);
			movie.setTitle(title);			
			movie.setGenre_id(Long.parseLong(genre_id.toString()));
			movie.setAge_rating(Long.parseLong(age_rating.toString()));
			movie.setStoryline(storyline);
			request.setAttribute("movie", movie);		
			request.getRequestDispatcher("webpages/upload_result.jsp").forward(request, response);	
		}else{
			request.getRequestDispatcher("webpages/upload_error.jsp").forward(request, response);
		}
	}

}
