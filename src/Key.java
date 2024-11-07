public class Key extends Item{
	public Key(String name3, String desc3) {
		super(name3, desc3);
	}
	public void use() {
		Rooms basement = Game.currentRoom.getExit('d');
		if((basement != null) && basement.getName().equals("basement")) {
			basement.setLock(false);
			Game.print("Door has been unlocked");
		}
		else {
			Game.print("There is no door to unlock");
		}
	}
}
