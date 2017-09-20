package perso.simen.coursework.utilities;

public class Utilities {



public boolean isValidEmailAddress(String email) {
	String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
	java.util.regex.Matcher m = p.matcher(email);
	return m.matches();
}


public static void main(String args[]){
	String emailVal = "test@test.co.uk";
	Utilities utilities = new Utilities();
	System.out.println(utilities.isValidEmailAddress(emailVal));
}

}