package perso.simen.coursework.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;



import perso.simen.coursework.utilities.Validator;




public class Main {
	
	//static Validator Valid;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		
		
//		if (Valid == null){
//			Valid = new Validator();
//		}
		
		System.out.println("====== Customer Management =======\n\n");
		Scanner scanner = new Scanner(System.in);
		showInputForm(scanner);
	}

public static void showInputForm(Scanner scanner) throws ClassNotFoundException, SQLException, ParseException{
	
	//Connection connection = null;
	
	System.out.println("=======Select your Option=======\n");
	System.out.println("====== 1- Add a new Customer =======");
	System.out.println("====== 2- Edit a Customer Details =======");
	System.out.println("====== 3- Delete a Customer =======");
	System.out.println("====== 4- See all the Customers  =======");
	
	
	int choice = scanner.nextInt();
	
	if(choice == 1){
	
		try{
			//SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12345");
			
			Statement mystmt = connection.createStatement();	
			int id;
			
			System.out.println("=======Please fill the form of the new user=======\n");
			do{
			System.out.println("Enter the id of the new customer : ");
			 //= scanner.nextInt();
			int j2=4,i2=1;
			while(!scanner.hasNextInt() && i2<j2){
			    System.out.println("\n Invalid id !");
			    scanner.next();
			}
			id = scanner.nextInt();
			}while (id <=0);
			
//			if(i2==j2){
//				System.out.println("Sorry you did too many incorrect attempts.. !");
//				System.out.println("\nDo you want to continue y/n");
//				String wantToContinue = scanner.next();
//				
//				if (wantToContinue.equalsIgnoreCase("y")){
//					showInputForm(scanner);
//				}else
//				System.out.println("Thanks, see ya later. ");
//				return;
//			}
			
			
			System.out.println("\n Firstname : ");
			String firstname = scanner.next();
			int j=4,i=1;
			while(!firstname.matches("[a-zA-Z_]+") && i<j){
			    System.out.println("\n Invalid First Name !");
			    System.out.println("\n Firstname : ");
				firstname = scanner.next();
				i++;
			}
			if(i==j){
				System.out.println("Sorry you did too many incorrect attempts.. !");
				System.out.println("\nDo you want to continue y/n");
				String wantToContinue = scanner.next();
				
				if (wantToContinue.equalsIgnoreCase("y")){
					showInputForm(scanner);
				}else
				System.out.println("Thanks, see ya later. ");
				return;
			}
			
			scanner.nextLine();
			
			System.out.println("\n Name : ");
			String name = scanner.next();
			int k=4,l=1;
			while(!name.matches("[a-zA-Z_]+") && l<k){
			    System.out.println("\n Invalid Name !");
			    System.out.println("\n Name : ");
				name = scanner.next();
				l++;
			}
			if(l==k){
				System.out.println("Sorry you did too many incorrect attempts.. !");
				System.out.println("\nDo you want to continue y/n");
				String wantToContinue = scanner.next();
				
				if (wantToContinue.equalsIgnoreCase("y")){
					showInputForm(scanner);
				}else
				System.out.println("Thanks, see ya later. ");
				return;
			}
			
			scanner.nextLine();
			
			System.out.println("Email : ");
			String email = scanner.next();
			int k1=4,l1=1;
			while(!Validator.getValid().isValidEmailAddress(email) && l1<k1){
				System.out.println("Email Format invalid !");
				System.out.println("\n Email : ");
				email = scanner.next();
				l1++;
			}
			if(l1==k1){
				System.out.println("Sorry you did too many incorrect attempts..  !");
				System.out.println("\nDo you want to continue y/n");
				String wantToContinue = scanner.next();
				
				if (wantToContinue.equalsIgnoreCase("y")){
					showInputForm(scanner);
				}else
				System.out.println("Thanks, see ya later. ");
				return;
				
			
			}
			
			scanner.nextLine();
			
			
			System.out.println("Date of Birth (dd/mm/yyyy): ");
			String dob = scanner.next();
			int j1=4,i1=1;
			while(!Validator.getValid().validate(dob) && i1<j1){
				System.out.println("Date Format invalid !");
				System.out.println("\n Date of Birth (dd/mm/yyyy): ");
				dob = scanner.next();
				i1++;
			}
			if(i1==j1){
				System.out.println("Sorry you did too many incorrect attempts.. Good Bye !");
				System.out.println("\nDo you want to continue y/n");
				String wantToContinue = scanner.next();
				
				if (wantToContinue.equalsIgnoreCase("y")){
					showInputForm(scanner);
				}else
				System.out.println("Thanks, see ya later. ");
				return;
			}
			
			mystmt.executeUpdate("insert into Customer value('"+id+"','"+firstname+"','"+name+"','"+dob+"','"+email+"')");
			
			//System.out.println("Date of Birth (dd/mm/yyyy): ");
			//String dob = scanner.next();
//			int re =getDOBInput(scanner, mystmt, id, firstname, name, email);
//			if(re!=1){
//				
//				System.out.println("\n Do you want to try again ? y/n");
//				String wantToTryAgain = scanner.next();
//				if (wantToTryAgain.equalsIgnoreCase("y")){
//					showInputForm(scanner);
//				}
//			   }
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		System.out.println("\n The insertion has been successful !\n\n");
		System.out.println("Do you want to continue y/n");
		String wantToContinue = scanner.next();
		
		if (wantToContinue.equalsIgnoreCase("y")){
			showInputForm(scanner);
		}else{
			System.out.println("Thanks, see ya later.");
		}
		
	}
		
	if(choice == 2){
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12345");
			Statement mystmt = connection.createStatement();	
			
			System.out.println("=======UPDATE User Details=======\n");
			
			
			System.out.println("Enter the id of the customer you want to update: ");
			 //= scanner.nextInt();
			int id1;
			do{
			int j2=4,i2=1;
			while(!scanner.hasNextInt() && i2<j2){
			    System.out.println("\n Invalid id !");
			    scanner.next();
			}
			id1 = scanner.nextInt();
			}while (id1 <=0);
			
			
			System.out.println("\n Firstname : ");
			String firstname1 = scanner.next();
			int j=4,i=1;
			while(!firstname1.matches("[a-zA-Z_]+") && i<j){
			    System.out.println("\n Invalid First Name !");
			    System.out.println("\n Firstname : ");
				firstname1 = scanner.next();
				i++;
			}
			if(i==j){
				System.out.println("Sorry you did too many incorrect attempts.. !");
				System.out.println("\nDo you want to continue y/n");
				String wantToContinue = scanner.next();
				
				if (wantToContinue.equalsIgnoreCase("y")){
					showInputForm(scanner);
				}else
				System.out.println("Thanks, see ya later. ");
				return;
			}
			
			scanner.nextLine();
			
			System.out.println("\n Name : ");
			String name1 = scanner.next();
			int k=4,l=1;
			while(!name1.matches("[a-zA-Z_]+") && l<k){
			    System.out.println("\n Invalid Name !");
			    System.out.println("\n Name : ");
				name1 = scanner.next();
				l++;
			}
			if(l==k){
				System.out.println("Sorry you did too many incorrect attempts.. !");
				System.out.println("\nDo you want to continue y/n");
				String wantToContinue = scanner.next();
				
				if (wantToContinue.equalsIgnoreCase("y")){
					showInputForm(scanner);
				}else
				System.out.println("Thanks, see ya later. ");
				return;
			}
			
			scanner.nextLine();
			
			System.out.println("Email : ");
			String email1 = scanner.next();
			int k1=4,l1=1;
			while(!Validator.getValid().isValidEmailAddress(email1) && l1<k1){
				System.out.println("Email Format invalid !");
				System.out.println("\n Email : ");
				email1 = scanner.next();
				l1++;
			}
			if(l1==k1){
				System.out.println("Sorry you did too many incorrect attempts..  !");
				System.out.println("\nDo you want to continue y/n");
				String wantToContinue = scanner.next();
				
				if (wantToContinue.equalsIgnoreCase("y")){
					showInputForm(scanner);
				}else
				System.out.println("Thanks, see ya later. ");
				return;
				
			
			}
			
			scanner.nextLine();
			
			
			System.out.println("Date of Birth (dd/mm/yyyy): ");
			String dob1 = scanner.next();
			int j1=4,i1=1;
			while(!Validator.getValid().validate(dob1) && i1<j1){
				System.out.println("Date Format invalid !");
				System.out.println("\n Date of Birth (dd/mm/yyyy): ");
				dob1 = scanner.next();
				i1++;
			}
			if(i1==j1){
				System.out.println("Sorry you did too many incorrect attempts.. Good Bye !");
				System.out.println("\nDo you want to continue y/n");
				String wantToContinue = scanner.next();
				
				if (wantToContinue.equalsIgnoreCase("y")){
					showInputForm(scanner);
				}else
				System.out.println("Thanks, see ya later. ");
				return;
			}
				
			
			ResultSet rs = mystmt.executeQuery("select * from Customer"); 
			while(rs.next()){ 
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t");
			}
			
			String query = "update Customer set firstname='"+firstname1+"',name='"+name1+"',dob='"+dob1+"',email='"+email1+"' where customer_id="+id1;
			
			//System.out.println("UPDATE QUERY: "+query);
			mystmt.executeUpdate(query);
			System.out.println("update complete successfully");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Do you want to continue y/n");
		String wantToContinue = scanner.next();
		
		if (wantToContinue.equalsIgnoreCase("y")){
			showInputForm(scanner);
		}else{
			System.out.println("Thanks, see ya later.");
		}
		
	}
	
	
if(choice == 3){
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12345");
			Statement mystmt = connection.createStatement();	
			
			ResultSet rs = mystmt.executeQuery("select * from Customer"); 
			while(rs.next()){ 
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t");
			}
			
			System.out.println("=======DELETE User=======\n");
			System.out.println("Enter the id of the customer you want to delete: ");
			int id1 = scanner.nextInt();

			mystmt.executeUpdate("delete from Customer where customer_id="+id1+"");
			System.out.println("delete complete successfully");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Do you want to continue y/n");
		String wantToContinue = scanner.next();
		
		if (wantToContinue.equalsIgnoreCase("y")){
			showInputForm(scanner);
		}else{
			System.out.println("Thanks, see ya later.");
		}
		
	}
		
if(choice == 4){
	
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12345");
		Statement mystmt = connection.createStatement();	
		
		System.out.println("=======List Customers=======\n");
		ResultSet rs = mystmt.executeQuery("select * from Customer"); 
		while(rs.next()){ 
			System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t");
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	System.out.println("Do you want to continue y/n");
	String wantToContinue = scanner.next();
	
	if (wantToContinue.equalsIgnoreCase("y")){
		showInputForm(scanner);
	}else{
		System.out.println("Thanks, see ya later.");
	}
	
}
	}


	public boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
	
//	private static int getDOBInput(Scanner scanner, Statement mystmt, int id, String firstname, String name, String email){
//		String dob = scanner.nextLine();
//		if(Valid.validate(dob)){
//		   try {
//			   mystmt.executeUpdate("insert into Customer value('"+id+"','"+firstname+"','"+name+"','"+dob+"','"+email+"')");
//			int result = 1;
//			return result;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		}else{
//			System.out.println("The date format is not appropriate !");
//			
//			try {
//				showInputForm(scanner);
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
//		return 0;
//	}

//	private static int getEmailInput(Scanner scanner, Statement mystmt, int id, String firstname, String dob, String name) throws SQLException{
//		String email = scanner.nextLine();
//	
//		if(Valid.isValidEmailAddress(email)){
//		   
//			   mystmt.executeUpdate("insert into Customer value('"+id+"','"+firstname+"','"+name+"','"+dob+"','"+email+"')");
//			int result = 1;
//			return result;
//		}else System.out.println("The email format is not valid !");
//		return 0;
//	}
	
}


