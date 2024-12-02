public class Joker extends NPC{
	private int count = 1;
	public Joker() {
		super("Joker", "A famous comin book villain appears in the flesh.");
	}
	public void talk() {
		if(count == 1) {
			say("Hello there friend, looking for someone...");
			String[] options = {
				"I dont have time for this Joker, scram.",
				"Joker, what do you know."
			};
			getResponse(options);
		}
		else if(count == 2) {
			say("Back so soon!");
			String[] options = {
				"Tell me everything!",
				"Should I deal with you first..."
			};
			getResponse(options);
		}
		else if(count == 3) {
			say("It seems like its my time to leave!");
			Game.print("(Joker runs away cackling.)");
			count++;			
		}
		else {
			Game.print("You can no longer interact with the Joker");
			count++;
		}
	}
	public void response(int option) {
		if(count == 1) {
			switch(option) {
			case 1:
				say("If you insist, hahahahaha, ill just wait here patiently...");
				break;
		
			case 2:
				say("I would lisen to that audiorecorder if I were you!");
				break;
			}
		}
		else if(count == 2) {
			switch(option) {
			case 1:
				say("Im afraid you know as much as I do hahahahaha.");
				Game.print("(The joker does a happy dance.)");
				break;
		
			case 2:
				say("That wont do you much good, now will it. Tik-Tok.");
				break;
			}
		}
		count++;
	}
}