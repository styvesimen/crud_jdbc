package perso.simen.coursework.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import perso.simen.coursework.utilities.DateValid;



public class Main {
	
	static DateValid dateValid;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		if (dateValid == null){
			dateValid = new DateValid();
		}
		
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
			SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12345");
			
			Statement mystmt = connection.createStatement();	
			
			System.out.println("=======Please fill the form of the new user=======\n");
			System.out.println("Enter the id of the new customer : ");
			int id = scanner.nextInt();
			System.out.println("Firstname : ");
			String firstname = scanner.next();
			System.out.println("Name : ");
			String name = scanner.next();
			
			System.out.println("Email : ");
			String email = scanner.next();
			
			scanner.nextLine();
			
			System.out.println("Date of Birth (dd/mm/yyyy): ");
			String dob = scanner.nextLine();
			if(dateValid.validate(dob)){
			   mystmt.executeUpdate("insert into Customer value('"+id+"','"+firstname+"','"+name+"','"+dob+"','"+email+"')");
			}else{
				System.out.println("The date format is not appropriate !");
				showInputForm(scanner);
			}
			
			
			System.out.println("insert complete successfully");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
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
			int id1 = scanner.nextInt();
			System.out.println("Firstname : ");
			String firstname1 = scanner.next();
			System.out.println("Name : ");
			String name1 = scanner.next();
			System.out.println("Date of Birth : ");
			String dob1 = scanner.next();
			System.out.println("Email : ");
			String email1 = scanner.next();
				


			ResultSet rs = mystmt.executeQuery("select * from Customer"); 
			while(rs.next()){ 
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t");
			}
			
			String query = "update Customer set firstname='"+firstname1+"',name='"+name1+"',dob='"+dob1+"',email='"+email1+"' where customer_id="+id1;
			
			System.out.println("UPDATE QUERY: "+query);
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

	
}


