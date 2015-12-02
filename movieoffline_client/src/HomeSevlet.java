

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Member;
import webresource.MemberResource;


@WebServlet("/home")
public class HomeSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object user_id=request.getSession().getAttribute("user_id");
		//String user_id="1";
		MemberResource memberResource=new MemberResource();
		Member member=memberResource.getMember(user_id.toString());
		request.setAttribute("member", member);
		request.getRequestDispatcher("./webpages/home.jsp").forward(request, response);	
	}

	
}
