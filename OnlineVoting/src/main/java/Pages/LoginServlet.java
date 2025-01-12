package Pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDaoImp;
import Pojo.VotingUser;
import Utils.DBUtils;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDaoImp user;
	
	public LoginServlet()
	{
		
	}
	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		try {
			ServletConfig config=getServletConfig();
			System.out.println("In init of login servlet--"+config);
			//System.out.println("DB_URL-----------"+config.getInitParameter("db_url"));
			DBUtils.openConnection(config.getInitParameter("db_url"), config.getInitParameter("username"), config.getInitParameter("password"));
		   user=new UserDaoImp();
		}
		catch(Exception e)
		{
			throw new ServletException("error in init of "+getClass(), e);
		}
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			String voter_id=request.getParameter("id");
			String password=request.getParameter("pass");
			System.out.println("Voter_id=="+voter_id+"  Passowrd=="+password);
			
			
		    VotingUser user1=user.getVotingUser(voter_id, password);
			if(user1==null)
			{
				pw.print("<h5>Invalid Login <a href='login.html'>Retry</a></h5>");
			}
			else
			{
				if(!user1.getStatus())
				{
				pw.print("Successful login...");
				HttpSession session=request.getSession();
				//add user details under request scope
				session.setAttribute("userDetails", user1);
				RequestDispatcher rd=request.getRequestDispatcher("Voting");
				//forward the client
				rd.forward(request, response);
				System.out.println("Control exec came back to login");
				}
				else
				{
					pw.print("User Already Voted, Thank You.....");
				
				}
				  
			}
		}catch(Exception e)
		{
			throw new ServletException("Error in doPost of "+getClass(), e);
		}
	}

}
