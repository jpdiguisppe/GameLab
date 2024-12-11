public class Closet extends Item {
	public Closet(String name2, String desc2) {
		super(name2, desc2);
	}
	public void open() {
		if(Game.getInventory("combination")==null) {
			Game.print("The closet is locked and you dont have the combination");
		}
		else {
			Game.print("Using the combination, you open the closet and find the Alfred inside! Naturally, you pick Alfred up to escape.");
			Item alfred = new Item("alfred", "The manisons butler");
			Game.inventory.add(alfred);
		}
			
		
	}
}
