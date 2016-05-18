package app;

import java.util.ArrayList;


public class UserAuth {
	private String auth;
	private UserStore usr;
	public UserAuth( String username, String password ) {
		this.usr = UserStore.getInstance();
		this.auth = usr.authUser( username, password );
	}


	public String getAuth() {
		return auth;
	}
}