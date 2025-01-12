package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import Pojo.VotingUser;
import Utils.DBUtils;

public class UserDaoImp implements IUserDao {
  private Connection con;
  private PreparedStatement pst,pst1;
  
  public UserDaoImp() throws SQLException {
	// TODO Auto-generated constructor stub
	  System.out.println("In userDaoImpl default const...");
	  con=DBUtils.getConnection();
	  pst=con.prepareStatement(" select * from voting_user where voter_id=? and password=?");
	  pst1=con.prepareStatement("update voting_user set status=1 where id=?");
}
  
	@Override
	public VotingUser getVotingUser(String voter_id, String passowrd) throws SQLException {
		
		System.out.println("inside getvotingUser  "+voter_id+" passowrd"+passowrd);
		pst.setString(1, voter_id);
		pst.setString(2, passowrd);
		System.out.println(pst.toString());
		VotingUser user=null;
		try(ResultSet rst=pst.executeQuery())
		{
			if(rst.next())
			{
				user=new VotingUser(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getBoolean(6));
			}
		}
		return user;
	}
	
	
	public String closeResources() throws SQLException
	{
		if(con!=null)
			con.close();
		if(pst!=null)
			pst.close();
		return "All Resources Closed...";
	}

	@Override
	public void updateStatusOfVotingUser(int id) throws SQLException {
		pst1.setInt(1, id);
		int status=pst1.executeUpdate();
		if(status==1)
		  System.out.println("Voting status of user updated...");
		else
			System.out.println("failed to update voting status of user...");
		
	}
}
