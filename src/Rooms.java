import java.util.HashMap;

public class Rooms {
	
		private HashMap<String, Item> item = new HashMap<String, Item>();
	
		private String description;
		private Rooms north;
		private Rooms east;
		private Rooms south;
		private Rooms west;
		private Rooms up;
		private Rooms down;
		private boolean lock;
		private String name;
		public String getName() {
			return name;
		}
		public void setName(String k) {
			name = k;
		}
			
		public boolean getLock() {
			return lock;
		}
		public void setLock(boolean lock) {
			this.lock = lock;
		}
		public Rooms(String d, String n) {
			description = d;
			name = n;
		}
		public Item getItem(String i) {
			return item.get(i);
		}
		public void addItem(String s, Item i) {
			item.put(s, i);
		}
		public void removeItem(String s) {
			item.remove(s);
		}
		public Rooms getExit(char exit) {
			if(exit == 'e') {
				return east;
			}
			else if(exit == 'n') {
				return north;
			}
			else if(exit=='s') {
				return south;
			}
			else if(exit=='w') {
				return west;
			}
			else if(exit=='u') {
				return up;
			}
			else if(exit=='d') {
				return down;
			}
			else {
				return null;
			} 
		}
		public void addExit(Rooms r, char d) {
			if(d == 'e') {
				east = r;
			}
			else if(d == 'n') {
				north = r;
			}
			else if(d=='s') {
				south = r;
			}
			else if(d=='w') {
				west = r;
			}
			else if(d=='u') {
				up = r;
			}
			else if(d=='d') {
				down = r;
			}
		}
		public String toString() {
			return description;
		}
}
