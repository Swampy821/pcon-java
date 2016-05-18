package app;


public class GetUser {
	private User user;
	private String status;

	public GetUser( User user) {
		this.user = user;
		if ( user == null ) {
			this.status = "UnAuthenticated";
		} else {
			this.status = "Success!";
		}
	}


	public User getUser() {
		return user;
	}

	public String getStatus() {
		return status;
	}
}