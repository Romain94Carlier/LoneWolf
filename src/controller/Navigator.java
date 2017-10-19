package controller;
import java.util.Random;

import javax.faces.bean.*;

@ManagedBean
public class Navigator {
	
	private static String firstName = "";
	private static String lastName = "";

	private String[] resultPages =
		{ 
				"a"
//				, 
//				"b"
//				, 
//				"c"
		};
	
	public String choosePage() {
		return "a";//(resultPages[new Random().nextInt(3)]);
	}
	
	public String choiceInA() {
		String[] choice = {"b", "defeat" };
		return(choice[new Random().nextInt(2)]);
	}
	
	public String choiceInB() {
		String[] choice = {"c", "defeat" };
		return(choice[new Random().nextInt(2)]);
	}
	
	public String choiceInC() {
		String[] choice = {"victory", "defeat" };
		return(choice[new Random().nextInt(2)]);
	}
	
	public String enterName() {
		System.out.println(firstName+" @@@@@ "+lastName);
		if(firstName.equals("") || lastName.equals(""))
			return "incomplete";
		return "validname";
	}
	
	public String nameService() {
		return "namePrompt";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		System.out.println("Set first name "+firstName);
		firstName = name;
		System.out.println("First name "+firstName);
	}

	public String getLastName() {
		System.out.println("First name "+lastName);
		return lastName;
	}

	public void setLastName(String name) {
		lastName = name;
	}
	
}
