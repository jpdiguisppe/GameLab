public class World {
	// Builds the game world.
	// Returns the room the player starts in.
	public static Rooms buildWorld() {
			Rooms foyer = new Rooms("You are in the foyer.");
			Rooms study = new Rooms("You are in the study.");
			Rooms kitchen = new Rooms("You are in the kitchen.");
			Rooms bathroom = new Rooms("You are in the bathroom.");
			Rooms secondfloor = new Rooms("You are on the second floor.");
			Rooms bedroom = new Rooms("You are in the bedroom.");
			Rooms basement = new Rooms("You are in the basement.");
			Item keycard = new Item("keycard","This is the keycard");
			Item batarang = new Item("batarang", "This is a batarang");
			Item suit = new Item("suit", "This is a black costume with a bat emblem on the chest");
			Item cape = new Item("cape", "This is a heavy black cape");
			Item milk = new Item("milk", "Just milk lol");
			foyer.addExit(study, 'e');
			study.addExit(foyer, 'w');
			foyer.addExit(kitchen, 'w');
			kitchen.addExit(foyer,  'e');
			foyer.addExit(bathroom, 'n');
			bathroom.addExit(foyer,  's');
			foyer.addExit(secondfloor, 'u');
			secondfloor.addExit(foyer, 'd');
			secondfloor.addExit(bedroom, 'n');
			bedroom.addExit(secondfloor,  's');
			study.addExit(basement, 'd');
			basement.addExit(study,  'u');
			study.addItem("keycard",keycard);
			kitchen.addItem("batarang",batarang);
			kitchen.addItem("cape",cape);
			kitchen.addItem("milk",milk); 
			bedroom.addItem("suit",suit);
			return foyer;
	}

}
