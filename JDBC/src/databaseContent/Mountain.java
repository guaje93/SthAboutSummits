package databaseContent;

public class Mountain {
	private int id;
	private String name;
	private String range;
	private int height;
	private String sciezka;

	public String getSciezka() {
		return sciezka;
	}

	public void setSciezka(String sciezka) {
		this.sciezka = sciezka;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	String text;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mountain() {
	}

	public Mountain(int id, String name, String range, int height, String sciezka, String text) {
		this.id = id;
		this.name = name;
		this.range = range;
		this.height = height;
		this.text = text;
		this.sciezka = sciezka;

	}

	@Override
	public String toString() {
		return "[" + id + "] - " + name + " " + range + " - " + height + " " + sciezka + text;
	}
}