package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Pojo.Candidate;
import Utils.DBUtils;

public class CandidateDaoImpl implements ICandidateDao {
    private Connection con;
    private PreparedStatement pst,pst1,pst2;
	public CandidateDaoImpl() throws SQLException {
		con=DBUtils.getConnection();
		pst=con.prepareStatement("select * from candidatelist");
		pst1=con.prepareStatement("select * from candidatelist where id=?");
		pst2=con.prepareStatement("update candidatelist set vote_count=vote_count+1 where id=?");
	}
	
	@Override
	public List<Candidate> getAllCandidate() throws SQLException {
		List<Candidate> candidates=new ArrayList<Candidate>();
		try(ResultSet rst=pst.executeQuery())
		{
			while(rst.next())
			{
				/**
				 * private int id;
	private String name;
	private String political_party_name;
	private int vote_count;
				 */
				candidates.add(new Candidate(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4)));
			}
		}
		return candidates;
	}

	@Override
	public Candidate getCandidateById(int id) throws SQLException {
		Candidate candidate=null;
		pst1.setInt(1, id);
		try(ResultSet rst=pst1.executeQuery())
		{
			if(rst.next())
			{
				candidate=new Candidate(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4));
			}
		}
		return candidate;
	}

	@Override
	public void updateVotingStatus(int id) throws SQLException {
		int status;
		pst2.setInt(1, id);
		status=pst2.executeUpdate();
		if(status==1)
			System.out.println("Status updated...");
		else
			System.out.println("Faild to update status...");
		
	}
	
	

}
