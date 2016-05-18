package app;
import java.util.ArrayList;


public class FavoriteList {

	private ArrayList<Favorite> list = new ArrayList();
	private int userId;

	public FavoriteList( int userId ) {
		this.userId = userId;
	}


	public Favorite findFavoriteById( int id ) {
		for( int i=0; i<list.size(); i++ ) {
			if ( list.get( i ).getId().equals( id ) ) {
				return list.get( i );
			}
		}
		return null;
	}

	public int getFavoriteIndexById( int id ) {
		for( int i=0; i<list.size(); i++ ) {
			if ( list.get( i ).getId().equals( id ) ) {
				return i;
			}
		}
		return null;
	}

	public void add( Favorite favorite ) {
		Favorite fav = this.findFavoriteById( favorite.getId() );
		if ( fav == null ) {
			list.add( favorite );
		}
	}

	public void remove( int id ) {
		int index = this.getFavoriteIndexById( id );
		if ( index != null ) {
			list.remove( index );
		}
	}

	public int getUserId() {
		return userId;
	}

	public ArrayList getList() {
		return list;
	}
}