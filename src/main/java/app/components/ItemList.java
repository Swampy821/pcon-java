package app;
import java.util.ArrayList;

public class ItemList {

	private ArrayList<Item> items = new ArrayList();

	public ItemList() {}


	public ArrayList getItems() {
		return items;
	}

	public void addItem( Item item ) {
		items.add( item );
	}

	public void removeItem( int index ) {
		items.remove( index );
	}

	public Item getItem( int index ) {
		return items.get( index );
	}

	public Item getById( int id ) {
		for( Item item : items ) {
			if ( item.getId() == id ) {
				return item;
			}
		}
		return null;
	}


	public int getLength() {
		return items.size();
	}
}