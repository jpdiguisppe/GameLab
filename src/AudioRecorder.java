public class AudioRecorder extends Item{
	public AudioRecorder(String name4, String desc4) {
		super(name4, desc4);
	}
	public void use() {
		Game.print("Robin, if you find this, you are running out of time. The manisons failsafe will be activating \nshortly, and you dont want to be there when it does. Alfred isnt responding, he must have been \ntrapped under the rubble from the recent attack. Find him and escape. Quickly!");
	}
}
