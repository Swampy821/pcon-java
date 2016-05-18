package app;

import java.util.ArrayList;

class TodoStore {
	private static TodoStore instance = new TodoStore();

	private ItemList store = new ItemList();


	private TodoStore() {}

	public static TodoStore getInstance() {
		return instance;
	}

	public ArrayList getItems() {
		return store.getItems();
	}

	public void removeItem( int index ) {
		store.removeItem( index );
	}

	public void addItem( Item item ) {
		store.addItem( item );
	}

	public Item getItem( int index ) {
		return store.getItem( index );
	}

	public int getLength() {
		return store.getLength();
	}

}