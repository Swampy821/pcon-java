package app;
import java.util.ArrayList;


public class Todo {
	private final TodoStore store;

	public Todo() {
		this.store = TodoStore.getInstance();
	}

	public ArrayList getItems() {
		return store.getItems();
	}

	public void addItem( String content ) {
		store.addItem( new Item( content, store.getLength() ) );
	}

	public void removeItem( int index ) {
		store.removeItem( index );
	}

}