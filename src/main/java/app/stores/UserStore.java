package app;

import java.util.ArrayList;

class UserStore {
	private static UserStore instance = new UserStore();
	private Integer idCount;
	private ArrayList<User> store = new ArrayList();


	private UserStore() {
		this.idCount = 0;
	}

	public static UserStore getInstance() {
		return instance;
	}

	public ArrayList getUsers() {
		return store;
	}

	public void removeUser( int index ) {
		store.remove( index );
	}

	public boolean addUser( User user ) {
		User usr = this.getUserByUsername( user.getUsername() );
		if( usr == null ) {
			user.setId( this.getNewId() );
			store.add( user );
			return true;
		} else {
			return false;
		}
	}

	public User getUser( int index ) {
		return store.get( index );
	}

	public int count() {
		return store.size();
	}

	public User getUserByUsername( String name ) {
		for( int i=0; i<this.count(); i++ ) {
			if( this.getUser( i ).getUsername().equals( name ) ) {
				return this.getUser( i );
			}
		}
		return null;
	}

	public User getUserByToken( String token ) {
		for( int i=0; i<this.count(); i++ ) {
			if( this.getUser( i ).getToken().equals( token ) ) {
				return this.getUser( i );
			}
		}
		return null;
	}


	public String authUser( String name, String password ) {
		User user = this.getUserByUsername( name );
		if ( user == null ) {
			return null;
		} else {
			return user.authenticate( name, password );
		}
	}

	private Integer getNewId() {
		this.idCount = new Integer( this.idCount + 1 );
		return this.idCount;
	}

	public User authByToken( String token ) {
		return this.getUserByToken( token );
	}

}