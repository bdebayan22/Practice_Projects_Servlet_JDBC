package Pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CandidateDaoImpl;
import Dao.UserDaoImp;
import Pojo.Candidate;
import Pojo.VotingUser;

/**
 * Servlet implementation class Status
 */
@WebServlet("/Status")
public class Status extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HttpSession session; 
    CandidateDaoImpl candidate;
    UserDaoImp userDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Status() {
        super();
        // TODO Auto-generated constructor stub
    }
     
    
	@Override
	public void init() throws ServletException {
		try {
			candidate=new CandidateDaoImpl();
			userDao=new UserDaoImp();
		} catch (Exception e) {
			throw new ServletException("Error in Status init method "+getClass(),e);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			VotingUser user=(VotingUser)request.getSession().getAttribute("userDetails");
			String[] paramValues = request.getParameterValues("candidate");
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				Candidate candidateDetails=candidate.getCandidateById(Integer.parseInt(paramValue));
				candidate.updateVotingStatus(Integer.parseInt(paramValue));
				userDao.updateStatusOfVotingUser(user.getId());
				pw.print("Hello thanks for voting Candidate="+candidateDetails.getName()+"  of Party="+candidateDetails.getPolitical_party_name());
				pw.print("<h5><a href='login.html'>Logout</a></h5>");
			}
			
		}
		catch(Exception e)
		{
			throw new ServletException("Error in doPost of Status servlet"+getClass(),e);
		}
	}


	@Override
	public void destroy() {
		
	}
  
}
