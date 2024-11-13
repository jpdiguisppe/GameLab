public class TransportGate extends Item{
	public TransportGate(String name5, String desc5) {
		super(name5, desc5);
	}
	public void use() {
		if(Game.getInventory("alfred")==null) {
			Game.print("This requires minimun two passengers to operate, try again when the requirements are met.");
		}
		else {
			Game.print("Brace yourself, this will feel a little funny. NNNRRRRRRMMMMMMMMMMMM! \nNow get out of the house!");
			Game.currentRoom = Game.currentRoom.getExit('u').getExit('w'); //trying to make current room the foyer
			
		}
		
	}
}
