public class Item {
	private String name;
	private String description;
	public Item(String n, String d) {
		name = n;
		description = d;
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String d) {
		description = d;
	}
	public String toString() {
		return name;
	}
}