package redditClone;
import java.util.*;

/**
 * This is the singleton class that keeps track of all the users
 * @author vishweshmashru
 *
 */
public class Database {
	private static Database system = null;
	private ArrayList<User> db = new ArrayList<>();
	
	private Database() {
	}
	
	public static Database getSystem() {
		if(system == null) {
			system = new Database();
		}
		return system;
	}
	
	public void addUser(User u) {
		db.add(u);
	}
	
	public void removeUser(User u) {
		db.remove(u);
	}
	
	public void sortByTime() {
	    Collections.sort(db, new Comparator<User>() {
	        public int compare(User u1, User u2) {
	            return Long.compare(u1.timestamp, u2.timestamp);
	        }
	    });
	}
	
	public void sortByKarma() {
	    Collections.sort(db, new Comparator<User>() {
	    	public int compare(User u1, User u2) {
	            return Long.compare(u1.totalKarma, u2.totalKarma);
	        }
	    });
	}
}
