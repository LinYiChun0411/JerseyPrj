/**
 * 
 */
package dto;

/**
 * @author Alexander
 *
 */
public class Member {
	private long user_id;
	private String username;
	private String password;
	private String first_name, last_name;
	private String gender;
	private String email;
	
	public Member() {
		super();
		user_id = 0;
		username = "";
		password = "";
		first_name = "";
		last_name = "";
		gender = "";
	}

	public long getUser_id() { 
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
