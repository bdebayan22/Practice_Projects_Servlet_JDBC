package Pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CandidateDaoImpl;
import Dao.UserDaoImp;
import Pojo.Candidate;

/**
 * Servlet implementation class AdminPage
 */
@WebServlet("/AdminPage")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidateDaoImpl candidate;
	
	
	public void init() throws ServletException {
		try {
			candidate=new CandidateDaoImpl();
		} catch (Exception e) {
			throw new ServletException("Error in AdminPage init method "+getClass(),e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter pw=response.getWriter())
		{
			Candidate topVotedCandidate=candidate.getTopVotedCandidate();
			pw.print("Top Voted Candidate is---"+topVotedCandidate.getName()+" total votes----"+topVotedCandidate.getVote_count());
		}
		catch(Exception e)
		{
			throw new ServletException("Error in AdminPage doPost Method  "+getClass(), e);
		}
	}

}
