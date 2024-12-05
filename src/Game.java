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
			System.out.println("File not found!!!");
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
			System.out.println("File "+saveload+" not found.");
		} catch (IOException ex) {
			System.out.println("Bummers, man");
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
			System.out.println("File "+saveload+" not found.");
			System.exit(0);
		} catch (IOException ex) {
			System.out.println("Bummers, man");
		} catch (ClassNotFoundException ex) {
			System.out.println("Not an object.");
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
		System.out.println(obj.toString());
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
					System.out.println("You cant go that way.");
				}
				else if(nextRoom.getLock() == true) {
					System.out.println("Room is Locked.");
				}
				else
					currentRoom = nextRoom;
					Game.print(currentRoom);
				break;
			case "take":
				System.out.println("You are trying to take the " + words[1]+".");
				Item i = currentRoom.getItem(words[1]);
				if(i == null) {
					System.out.println("No item found.");
				}
				else {
					currentRoom.addItem(null, null);
					inventory.add(i);
					System.out.println("You now posses " + i.getName());
				}
				break;
			case "look":
				if(currentRoom.getItem(words[1])!=null) {
					System.out.println(currentRoom.getItem(words[1]).getDescription());
				}
				else { 
					boolean found = false;
					for(Item l : inventory) {
						if(l.getName().equals(words[1])) {
							System.out.println(l.getDescription());
							found = true;
							break;
						}
					}
					if(found==false) {
						System.out.println("This item is not in this room or inventory.");
					}
				}
				break;
			case "use":
				if(currentRoom.getItem(words[1])!=null) {
					currentRoom.getItem(words[1]).use();
				}
				else {
					if(getInventory(words[1]) == null) {
						System.out.println("There is no such item.");
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
						System.out.println("There is no such item.");
					}
					else {
						getInventory(words[1]).open();
					}
				}
				break;
			case "i":
				if(inventory.size()==0) {
					System.out.println("You have nothing in your inventory.");
					break;
				}
				else {
					System.out.println("You are carrying: ");
					for(Item item : inventory) {
						System.out.println(item.getName());
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
				System.out.println("Thanks for walking through my game!");
				break;
			default:
				System.out.println("I dont know what that means. ");
				break;
			}
	}
	
		/*Rooms currentRooms = World.buildWorld();
		System.out.println(currentRooms);
		System.out.println("\nNow we'll move east!");
		currentRooms = currentRooms.getExitnull('e');
		System.out.println(currentRooms);
		System.out.println("\nNow we'll move down!");
		currentRooms = currentRooms.getExit('d');
		System.out.println(currentRooms);
		System.out.println("\nNow we'll move up!");
		currentRooms = currentRooms.getExit('u');
		System.out.println(currentRooms);
		System.out.println("\nNow we'll move west!");
		currentRooms = currentRooms.getExit('w');
		System.out.println(currentRooms);
		System.out.println("\nNow we'll move west!");
		currentRooms = currentRooms.getExit('w');
		System.out.println(currentRooms);
		System.out.println("\nNow we'll move east!");
		currentRooms = currentRooms.getExit('e');
		System.out.println(currentRooms);
		System.out.println("\nNow we'll move north!");
		currentRooms = currentRooms.getExit('n');
		System.out.println(currentRooms);
		System.out.println("\nNow we'll move south!");
		currentRooms = currentRooms.getExit('s');
		System.out.println(currentRooms);
		System.out.println("\nNow we'll move up!");
		currentRooms = currentRooms.getExit('u');
		System.out.println(currentRooms);
		System.out.println("\nNow we'll move north!");
		currentRooms = currentRooms.getExit('n');
		System.out.println(currentRooms);
		System.out.println("\nNow we'll move south!");
		currentRooms = currentRooms.getExit('s');
		System.out.println(currentRooms);
		System.out.println("\nNow we'll move down!");
		currentRooms = currentRooms.getExit('d');
		System.out.println(currentRooms);
		*/
}