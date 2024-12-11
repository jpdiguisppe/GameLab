public class World {

	// Builds the game world.
	// Returns the room the player starts in.
	public static Rooms buildWorld() {
			Rooms foyer = new Rooms("foyer");
			Rooms study = new Rooms("study");
			Rooms kitchen = new Rooms("kitchen");
			Rooms bathroom = new Rooms("bathroom");
			Rooms secondfloor = new Rooms("secondfloor");
			Rooms bedroom = new Rooms("bedroom");
			Rooms basement = new Rooms("basement");
			Item note = new Item("note","This is a halfwritten note, abandoned.");
			Item batarang = new Item("batarang", "This is a batarang");
			Item suit = new Item("suit", "This is a black costume with a bat emblem on the chest");
			Item cape = new Item("cape", "This is a heavy black cape");
			Item milk = new Item("milk", "Just milk lol");
			Item key = new Key("key", "This is the key to the locked room");
			Combination combination = new Combination("combination", "This is the combination to the safe.");
			AudioRecorder audiorecorder = new AudioRecorder("audiorecorder", "This is a device with a store message.");
			TransportGate transportgate = new TransportGate("transportgate", "This will transport you back to the foyer.");
			Closet closet = new Closet("closet", "This is a closet, perhaps something is inside.");
			Joker joker = new Joker();
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
			study.addItem("note",note);
			kitchen.addItem("batarang",batarang);
			kitchen.addItem("cape",cape);
			kitchen.addItem("milk",milk); 
			bedroom.addItem("suit",suit);
			bedroom.addItem("combination", combination);
			bathroom.addItem("key", key);
			basement.setLock(true);
			foyer.addItem("audiorecorder", audiorecorder);
			foyer.addNPC("joker", joker);
			basement.addItem("closet", closet);
			secondfloor.addItem("transportgate", transportgate);
			return foyer;
	}

}
