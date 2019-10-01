package bookinfo;

import java.sql.*;

import java.util.Scanner;


public class Bookshop {

	static Scanner sc;
	static PreparedStatement pst;
	static Connection con;
	String sid,sname;
	float ssal;
	
	public Bookshop() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		sc=new Scanner(System.in);		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adjt23","root","root");
		
		
	}
	
	
	public void insert() throws SQLException {
		
		
		System.out.println("Enter Sid :");
		sid=sc.next();
		
		System.out.println("Enter Sname :");
		sname=sc.next();
		
		System.out.println("Enter Salary :");
		ssal=sc.nextFloat();
	
	    String ins="insert into adjt values(?,?,?)";
	    
	    pst=con.prepareStatement(ins);
	    
	    pst.setString(1,sid);
	    pst.setString(2,sname);
	    pst.setFloat(3,ssal);
		
		pst.execute();
		
		System.out.println("Data inserted Sucesfully..!!");
		
	    
	}
	
public void delete() throws SQLException {
	
	System.out.println("Enter Sid :");
	sid=sc.next();
	
	
	String ins="delete from adjt where sid=?";
	
	pst=con.prepareStatement(ins);
	
	pst.setString(1, sid);
	
	pst.execute();
	
	
	System.out.println("Record Deleted..!!");
	
}	
	
public void update() throws SQLException {
		
	System.out.println("Enter Sid :");
	sid=sc.next();
	
	System.out.println("Enter Sname :");
	sname=sc.next();
	
	System.out.println("Enter Salary :");
	ssal=sc.nextFloat();
	
    String ins="update adjt set sid=?,sname=?,ssal=? where sid=?";
    
    pst=con.prepareStatement(ins);
    
    pst.setString(1,sid);
    pst.setString(2,sname);
    pst.setFloat(3,ssal);
	
    pst.setString(4,sid);
	
    pst.execute();
	
	System.out.println("Data updated Sucesfully..!!");
	
	
	
	}

public void select() throws ClassNotFoundException, SQLException {
	
	String ins="select *from adjt";
	
	pst=con.prepareStatement(ins);
	
	ResultSet rs=pst.executeQuery();
	
	while(rs.next()){
		
		System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3));
	
	  
	}
	
	
}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		int ch;
		
		Bookshop bk=new Bookshop();
		
		System.out.println("\t\t!!!Welcome to profound Database..!!!");
		
		
		System.out.println("1.Insert Data\n2.Update Data\n3.Delete Data\n4.Select Data");
		System.out.println("Enter your Choice :");
		ch=sc.nextInt();
		switch(ch) {
		
		case 1:
			bk.insert();
			bk.select();
		  break;
		
		case 2:
			bk.update();
			bk.select();
		  break;
		  
		case 3:
			bk.delete();
			bk.select();
		  break; 
		  
		case 4:
			bk.select();
		  break;
		  
		default :
			System.out.println("Invalid Choice");
			break;
			
		}

	}

}
