

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Member;
import webresource.MemberResource;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputEmail=request.getParameter("inputEmail");
		String inputPassword=request.getParameter("inputPassword");
		
		MemberResource memberResource=new MemberResource();
		Member member=memberResource.getMember(inputEmail,inputPassword);
		request.setAttribute("member", member);
		if(member.getUser_id()==0){//not register
			request.getRequestDispatcher("./webpages/login_error.jsp").forward(request, response);
		}else{//have already registered
			request.getSession().setAttribute("user_id", member.getUser_id());//set sesstion user_id
			request.getRequestDispatcher("./webpages/home.jsp").forward(request, response);			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
	}

}
