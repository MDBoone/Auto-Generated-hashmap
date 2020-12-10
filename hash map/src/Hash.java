import java.util.HashMap; 
import java.util.Scanner;

public class Hash {
	
	public static void main(String[] args) {
		hashMenu();
	}

	static void hashMenu() {
		Scanner input = new Scanner(System.in);
        HashFunctions obj = new HashFunctions();
        int user = 0;
        while(user != 6) {
        	System.out.println("1) add item to map");
        	System.out.println("2) replace item");
        	System.out.println("3) print map");
        	System.out.println("4) search map");
        	System.out.println("5) auto generate entries");
        	System.out.println("Press 6 to quit");
        	user = input.nextInt();
        	if(user == 1) {
        		obj.addEl();
        	}
        	else if(user == 2) {
        		obj.replace();
        	}
        	else if(user == 3) {
        		obj.print();
        	}
        	else if(user == 4) {
        		obj.search();
        	}
        	else if(user == 5) {
        		obj.generate();
        	}
        	else if(user > 6) {
        		System.out.println("Please enter a valid input");
        	}
        	
        }
	}

}
