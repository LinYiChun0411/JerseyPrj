

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Genre;
import models.Movie;
import webresource.MovieResource;

@WebServlet("/search_result")
public class SearchQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieKey=request.getParameter("searchInput").toString();
		//String movieKey="tt1001";
		MovieResource movie_resource=new MovieResource();
		ArrayList<Genre> genrelist=movie_resource.getAllGenre();
		ArrayList<Movie> movielist=movie_resource.getMovies(movieKey,movieKey);						
		request.setAttribute("movielist", movielist);
		request.setAttribute("genrelist", genrelist);
		request.getRequestDispatcher("webpages/search_result.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);
	}

}
