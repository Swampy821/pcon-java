package app;


class Item {
	private String content;
	private int id;
	public Item( String newContent, int id ) {
		this.content = newContent;
		this.id = id;
	}
	public String getContent() {
		return content;
	}

	public int getId() {
		return id;
	}
}