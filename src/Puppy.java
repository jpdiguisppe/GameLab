public class Puppy extends NPC {
	private int count = 1;
	public Puppy() {
		super("puppy", "A hideous puppy wags his tail.");
	}
	public void talk() {
		if (count == 1) {
			say("Hi! I'm an adorable puppy!");
			String[] options = {
				"Yes you are! Who's a good boy?",
				"Ew, no. You're actually kinda hideous."
			};
			getResponse(options);
		}
		else if (count == 2) {
			say("Hey! Wanna play fetch? Say yes! Say yes!");
			String[] options = {
				"Yes! I love fetch!",
				"No. I am a horrible person and don't like playing with puppies."
			};
			getResponse(options);
		}
		else if (count == 3) {
			say("Yip!");
			Game.print("(The puppy wags its tail.)");
			count++;
		}
		else {
			Game.print("The Puppy no longer wants to interact");
			count++;
		}
	}
	public void response(int option) {
		if(count == 1) {
			switch(option) {
			case 1:
				say("I am! I'm a good boy!");
				break;
	
			case 2:
				say("I am adorable! Why are you so mean?");
				Game.print("The puppy bites you. You deserve it.");	
				break;
			}
		}
		if (count == 2) {
			switch(option) {
			case 1:
				say("Yay! Fetch");
				Game.print("(The puppy runs off and returns with a ball. The player receives the ball.)");
				break;
	
			case 2:
				say("You're a bad person! I don't like you!");
				Game.print("(The puppy runs away and doesn't come back.)");
				break;
			}
		}	
		count++;
	}
}