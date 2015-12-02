

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.WatchList;
import webresource.MovieResource;

@WebServlet("/watchlist")
public class WatchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object  user_id=request.getSession().getAttribute("user_id");
		MovieResource movieResource=new MovieResource();
		ArrayList<WatchList> watchList=movieResource.getWatchList(Long.parseLong(user_id.toString()));
		request.setAttribute("watchList", watchList);
		request.getRequestDispatcher("/webpages/watchlist.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
