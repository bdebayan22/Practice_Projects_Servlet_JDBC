package Pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CandidateDaoImpl;
import Pojo.Candidate;
import Pojo.VotingUser;

/**
 * Servlet implementation class Voting
 */
@WebServlet("/Voting")
public class Voting extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CandidateDaoImpl candidate;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		try {
			candidate=new CandidateDaoImpl();
		} catch (Exception e) {
			throw new ServletException("error in init of "+getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("Hello login successfull...");
			VotingUser user=(VotingUser)request.getSession().getAttribute("userDetails");
			if(user.getStatus()==false)
			{
				pw.print("<form action=\"Status\" method=\"post\"");
				List<Candidate> candidates= candidate.getAllCandidate();
				for(Candidate c:candidates)
				{
					pw.print("<label><input type='radio' name='candidate' value='"+c.getId()+"'>'"+c.getName()+"---"+c.getPolitical_party_name()+"'<label><br>");
				}
				pw.print("<button type='submit'>Vote</button>");
			}
		}
		catch(Exception e)
		{
			throw new ServletException("error in doPost of voting class ---"+getClass(),e);
		}
	}

}
