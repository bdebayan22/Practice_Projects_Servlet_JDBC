package Pojo;

public class VotingUser {
 
	/**
	 * id int AUTO_INCREMENT,
name varchar(255) NOT NULL,
voter_id varchar(255) NOT NULL ,
password varchar(255) NOT NULL,
role varchar(255) NOT NULL,
mybool boolean not null default false,
	 */
	private int id;
	private String name;
	private String voter_id;
	private String password;
	private String role;
	private boolean status;
	public VotingUser(String name, String voter_id, String password, String role) {
		super();
		this.name = name;
		this.voter_id = voter_id;
		this.password = password;
		this.role = role;
	}
	
	
	
	public VotingUser(int id, String name, String voter_id, String password, String role, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.voter_id = voter_id;
		this.password = password;
		this.role = role;
		this.status = status;
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
	public String getVoter_id() {
		return voter_id;
	}
	public void setVoter_id(String voter_id) {
		this.voter_id = voter_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "VotingUser [id=" + id + ", name=" + name + ", voter_id=" + voter_id + ", password=" + password
				+ ", role=" + role + ", status=" + status + "]";
	}
	
}
