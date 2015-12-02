

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webresource.MovieResource;


@WebServlet("/addwatchlist")
public class AddWatchList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String movie_id=request.getParameter("movie_id");
		Long user_id=Long.parseLong(request.getSession().getAttribute("user_id").toString());
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();		
		
		MovieResource movieResource=new MovieResource();		
		if(200==movieResource.addWatchlist(user_id, movie_id, "watch list", dateFormat.format(date))){			
			request.getRequestDispatcher("/webpages/addwatchlist_ok.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/webpages/addwatchlist_error.jsp").forward(request, response);
		}
	}
	


}
