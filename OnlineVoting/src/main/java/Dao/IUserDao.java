package Dao;

import java.sql.SQLException;

import Pojo.VotingUser;

public interface IUserDao {

	VotingUser getVotingUser(String voter_id,String passowrd) throws SQLException;
	void updateStatusOfVotingUser(int id) throws SQLException;
}
