

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Genre;
import models.MovieRating;
import webresource.MovieResource;


@WebServlet("/upload")
public class UploadMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieResource movieResource=new MovieResource();		
		ArrayList<Genre> genreList=movieResource.getAllGenre();
		ArrayList<MovieRating> movieRatingList = movieResource.getAllMovieRating();
		request.setAttribute("movieRatingList", movieRatingList);
		request.setAttribute("genreList", genreList);		
		request.getRequestDispatcher("webpages/upload_movie.jsp").forward(request, response);
	}

	

}
