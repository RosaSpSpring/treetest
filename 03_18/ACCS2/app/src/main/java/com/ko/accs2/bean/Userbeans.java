package com.ko.accs2.bean;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class Userbeans {
	public int id;
	public String username;
	public String password;

	public Userbeans() {

	}

	public Userbeans(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Userbeans{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
	}
}
