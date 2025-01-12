package Dao;

import java.sql.SQLException;
import java.util.List;

import Pojo.Candidate;

public interface ICandidateDao {
  public List<Candidate> getAllCandidate() throws SQLException;
  public Candidate getCandidateById(int id) throws SQLException;
  public void updateVotingStatus(int id) throws SQLException;
}
