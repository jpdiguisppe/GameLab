public class Closet extends Item{
	public Closet(String name6, String desc6) {
		super(name6, desc6);
	}
	public void open() {
		Game.print("You have found Alfred, now hurry and escape!");
		Item alfred = new Item("alfred", "The housekeeper of the mansion.");
		Game.inventory.add(alfred);
	}

}
