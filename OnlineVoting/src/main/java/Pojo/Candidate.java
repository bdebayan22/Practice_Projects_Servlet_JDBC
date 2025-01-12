package Pojo;

public class Candidate {
/**
 * id int AUTO_INCREMENT,
name varchar(255) NOT NULL,
political_party_name varchar(255) NOT NULL,
vote_count int,
 */
	private int id;
	private String name;
	private String political_party_name;
	private int vote_count;
	public Candidate(int id, String name, String political_party_name, int vote_count) {
		super();
		this.id=id;
		this.name = name;
		this.political_party_name = political_party_name;
		this.vote_count = vote_count;
	}
	public Candidate() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPolitical_party_name() {
		return political_party_name;
	}
	public void setPolitical_party_name(String political_party_name) {
		this.political_party_name = political_party_name;
	}
	public int getVote_count() {
		return vote_count;
	}
	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", political_party_name=" + political_party_name
				+ ", vote_count=" + vote_count + "]";
	}
	
	
}
