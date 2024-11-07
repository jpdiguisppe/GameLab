import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	
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
		}
	
	public static void main(String[] args) {
		runGame();
	}
	public static void runGame() {
		Scanner input = new Scanner(System.in);
		
		String command; //players command
		do {
			System.out.println(currentRoom);
			System.out.print("Where do you want to go? ");
			command = input.nextLine();
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
				else if(currentRoom.getItem(words[1])==null) {
					for(Item y : inventory) {
						if(y.getName().equals(words[1])) {
							System.out.println(y.getDescription());
							break;
						}
					System.out.println("Item is not in current room or inventory.");
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
			case "x":
				System.out.println("Thanks for walking through my game!");
				break;
			default:
				System.out.println("I dont know what that means. ");
				break;
			}
			
		}while(!command.equals("x"));
		
		
		input.close();
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