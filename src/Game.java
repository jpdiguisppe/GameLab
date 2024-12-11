import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Game {
	
	public static void main(String[] args) {
		setMap();
		ui = new Interface();
		print(currentRoom);
	}
	
	private static Interface ui; 
			
	public static Scanner input = new Scanner(System.in);
	
	public static HashMap<String, String> roomfile = new HashMap<String, String>();
	
	public static void setMap() {
		try {
			Scanner input = new Scanner(new File("TextFile"));
			while(input.hasNextLine()) {
				String line = input.nextLine();
				String line2 = input.nextLine();
				if(input.hasNextLine()) {
					String k = input.nextLine();
				}
				roomfile.put(line, line2);
			}
			input.close();
		} catch (FileNotFoundException e) {
			Game.print("File not found!!!");
		}
	}
	
	public static HashMap<String, Rooms> roomMap = new HashMap<String, Rooms>();

	public static void saveGame(String saveload) {
		File s = new File(saveload);
		try {
			FileOutputStream fos = new FileOutputStream(s);
			ObjectOutputStream stream = new ObjectOutputStream(fos);
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(roomMap);
			stream.close();
		} catch (FileNotFoundException e) {
			Game.print("File "+saveload+" not found.");
		} catch (IOException ex) {
			Game.print("Bummers, man");
		}
	}
	
	public static void loadList(String saveload) {
		File s = new File(saveload);
		try {
			FileInputStream fos = new FileInputStream(s);
			ObjectInputStream stream = new ObjectInputStream(fos);
			inventory = (ArrayList) stream.readObject();
			roomMap = (HashMap) stream.readObject();
			currentRoom = (Rooms) stream.readObject();
			stream.close();
		} catch (FileNotFoundException e) {
			Game.print("File "+saveload+" not found.");
			System.exit(0);
		} catch (IOException ex) {
			Game.print("Bummers, man");
		} catch (ClassNotFoundException ex) {
			Game.print("Not an object.");
		}
	}
	
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	
	public static Rooms currentRoom = World.buildWorld();
	
	public static Item getInventory(String a) {
		for(Item c : inventory) {
			if(c.toString().equals(a)) {
				return(c);
			}
		}
		return null;
	}
	
	public static void print(Object obj) {
		ui.textarea.append(obj.toString()+"\n");
		}
	
	public static void processCommand(String command) {
		
			String[] words = command.split(" ");
			
			switch(words[0]) {
			case "e":
			case "w":
			case "n":
			case "s":
			case "u":
			case "d":
				Rooms nextRoom = currentRoom.getExit(command.charAt(0));
				if(nextRoom == null) {
					Game.print("You cant go that way.");
				}
				else if(nextRoom.getLock() == true) {
					Game.print("Room is Locked.");
				}
				else
					currentRoom = nextRoom;
					Game.print(currentRoom);
				break;
			case "take":
				Game.print("You are trying to take the " + words[1]+".");
				Item i = currentRoom.getItem(words[1]);
				if(i == null) {
					Game.print("No item found.");
				}
				else {
					currentRoom.addItem(null, null);
					inventory.add(i);
					Game.print("You now posses " + i.getName() + ". " + i.getDescription());
				}
				break;
			case "look":
				if(currentRoom.getItem(words[1])!=null) {
					Game.print(currentRoom.getItem(words[1]).getDescription());
				}
				else { 
					boolean found = false;
					for(Item l : inventory) {
						if(l.getName().equals(words[1])) {
							Game.print(l.getDescription());
							found = true;
							break;
						}
					}
					if(found==false) {
						Game.print("This item is not in this room or inventory.");
					}
				}
				break;
			case "use":
				if(currentRoom.getItem(words[1])!=null) {
					currentRoom.getItem(words[1]).use();
				}
				else {
					if(getInventory(words[1]) == null) {
						Game.print("There is no such item.");
					}
					else {
						getInventory(words[1]).use();
					}
				}
				break;
			case "open":
				if(currentRoom.getItem(words[1])!=null) {
					currentRoom.getItem(words[1]).open();
				}
				else {
					if(getInventory(words[1]) == null) {
						Game.print("There is no such item.");
					}
					else {
						getInventory(words[1]).open();
					}
				}
				break;
			case "i":
				if(inventory.size()==0) {
					Game.print("You have nothing in your inventory.");
					break;
				}
				else {
					Game.print("You are carrying: ");
					for(Item item : inventory) {
						Game.print(item.getName());
					}
					break;
				}
			case "save":
				saveGame(words[1]);
				break;
			case "load":
				loadList(words[1]);
				break;
			case "talk":
				currentRoom.getNPC(words[1]).talk();
				break;
			case "x":
				Game.print("Thanks for walking through my game!");
				break;
			default:
				Game.print("I dont know what that means. ");
				break;
			}
	}
	
		/*Rooms currentRooms = World.buildWorld();
		Game.print(currentRooms);
		Game.print("\nNow we'll move east!");
		currentRooms = currentRooms.getExitnull('e');
		Game.print(currentRooms);
		Game.print("\nNow we'll move down!");
		currentRooms = currentRooms.getExit('d');
		Game.print(currentRooms);
		Game.print("\nNow we'll move up!");
		currentRooms = currentRooms.getExit('u');
		Game.print(currentRooms);
		Game.print("\nNow we'll move west!");
		currentRooms = currentRooms.getExit('w');
		Game.print(currentRooms);
		Game.print("\nNow we'll move west!");
		currentRooms = currentRooms.getExit('w');
		Game.print(currentRooms);
		Game.print("\nNow we'll move east!");
		currentRooms = currentRooms.getExit('e');
		Game.print(currentRooms);
		Game.print("\nNow we'll move north!");
		currentRooms = currentRooms.getExit('n');
		Game.print(currentRooms);
		Game.print("\nNow we'll move south!");
		currentRooms = currentRooms.getExit('s');
		Game.print(currentRooms);
		Game.print("\nNow we'll move up!");
		currentRooms = currentRooms.getExit('u');
		Game.print(currentRooms);
		Game.print("\nNow we'll move north!");
		currentRooms = currentRooms.getExit('n');
		Game.print(currentRooms);
		Game.print("\nNow we'll move south!");
		currentRooms = currentRooms.getExit('s');
		Game.print(currentRooms);
		Game.print("\nNow we'll move down!");
		currentRooms = currentRooms.getExit('d');
		Game.print(currentRooms);
		*/
}