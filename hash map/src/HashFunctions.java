import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class HashFunctions {
	
	String name;
	int key =1;
	static HashMap<Integer, String> map = new HashMap<>(20000);
	static Weapons wep = new Weapons();
	static Scanner input = new Scanner(System.in);

	
	public HashFunctions() {
	}

	public int key(String name) {
		int key = Integer.parseInt(name) % 5;
		System.out.println(key);
		return key;
	}
	
	public void addEl() {
		System.out.println("Please enter the name you would like to add");
		String name = input.next();
		if(!(map.containsKey(key))) {
			map.put(key, name);
		}
		else {
			while(map.containsKey(key)) {
				key++;
			}
			map.put(key, name);
		}
		
	}
	
	public void addEl(String name) {
		String s = name;
		String t = "";
		for (int i = 0; i < s.length(); ++i) {
		    char ch = s.charAt(i);
		    int n = (int)ch - (int)'a' + 1;
		    t += String.valueOf(n);
		}
		int key = Integer.parseInt(t);
		key = key % 20000;
		if(!(map.containsKey(key))) {
			map.put(key, name);
		}
		else {
			int count = 0;
			while(map.containsKey(key) || count > 1000) {
				key = key * 2;
				key++;
				count++;
				if(count >= 1000) {
					key = 0;
					while(map.containsKey(key)) {
						key++;
					}
				}
			}
			map.put(key, name);
		}
		
	}
	
	public String randomString() {
		 
		String generatedString;
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 4;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    generatedString = buffer.toString();
	    return generatedString;
	}
	
	public void generate() {
		int hund = 0;
		while(hund < 200) {
			addEl(randomString());
			hund++;
		}
	}
	
	public void search() {
		System.out.println("please enter the name you would like to search for");
		String name = input.next();
		if(map.containsValue(name)) {
			int i =0;
			while(i > 20000) {
				if(map.get(i).equalsIgnoreCase(name)) {
					break;
				}
				i++;
			}
			System.out.println(name + " is in the map at key " + i);
		}
		else if(!(map.containsValue(name))){
			System.out.println("The name " + name + " is not in the map");
		}
	}
	
	public void replace() {
		System.out.println("What is the key vale of the element you would like to replace");
		int key = input.nextInt();
		System.out.println("What name would you like to replace it with");
		String name = input.next();
		map.replace(key, name);
	}
	
	public void print() {
		System.out.println("The number of entries: " + map.size());
		for(int i = 0; i < 20000; i++) {
			if(map.containsKey(i)) {
				System.out.println("Value: " + map.get(i) + "' at key " + i);
			}
		}
	}
	

}
