public class Safe extends Item {
	public Safe(String name2, String desc2) {
		super(name2, desc2);
	}
	public void open() {
		if(Game.getInventory("combination")==null) {
			Game.print("The safe is locked and you dont have the combination");
		}
		else {
			Game.print("Using the combination, you open the safe and find the diamond inside! Naturally, you pocket the diamond.");
			Item diamond = new Item("diamond", "A shiny diamond.");
			Game.inventory.add(diamond);
		}
			
		
	}
}
