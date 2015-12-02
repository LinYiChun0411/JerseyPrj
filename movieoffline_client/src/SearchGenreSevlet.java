

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Movie;
import webresource.MovieResource;

@WebServlet("/search_genre")
public class SearchGenreSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String genre_id=request.getParameter("genre_id").toString();
		
		MovieResource movie_resource=new MovieResource();
		
		ArrayList<Movie> movielist=movie_resource.getMovies(Long.parseLong(genre_id));						
		request.setAttribute("movielist", movielist);
		
		request.getRequestDispatcher("webpages/search_result.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);
	}

}
