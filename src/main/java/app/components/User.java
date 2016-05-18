package app;

import java.util.Base64;


public class User {
	private String username;
	private String password;
	private String name;
	private Integer id;
	private String auth;

	public User( String username, String password ) {
		this.username = username;
		this.password = password;
		this.auth = new String(  Base64.getEncoder().encodeToString( Long.toString( System.currentTimeMillis() / 1000L ).getBytes() ) );
	}

	public String getUsername() {
		return username;
	}

	public Integer getId() {
		return id;
	}

	public void setId( Integer newId ) {
		id = newId;
	}

	public String getName() {
		return name;
	}
	public void setName( String name ) {
		this.name = name;
	}

	public String getToken() {
		return this.auth;
	}

	public String authenticate( String uname, String pass ) {
		if( username.equals( uname ) && password.equals( pass ) ) {
			return this.auth;
		} else {
			return null;
		}
	}

	public boolean authed( String authToken ) {
		if ( authToken.equals( auth ) ) {
			return true;
		} else {
			return false;
		}
	}

}