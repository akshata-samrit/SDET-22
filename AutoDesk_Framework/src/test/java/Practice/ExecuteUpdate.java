package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdate 
{
	@Test
	public void executeQuery() throws Throwable
	{
		Connection con=null;
		try
		{
			//Step 1 : Register the database
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			//Step 2 : Establish Connection with database
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");

			
			
			//Step 3 : Issue Create Statement
			Statement stat = con.createStatement();
			
			//Step 4 : Execute the Query
			int result = stat.executeUpdate("insert into customer values('5','Jenny','Strange','Canada');");
	//		int del = stat.executeUpdate("delete into customer values('2','Keerthana','HS','Sydney');");
	
			
			
			if(result==1)
			{
				System.out.println("Customer is created successfully");
			}
			else
			{
				System.out.println("Query Failed");
			}
		}
		catch(Exception e)
		{
			System.out.println("exception "+e);
			throw e;
			
		}
		
//		To avoid data leakage we use try catch finally block
		finally
		{
			if (con!=null) {
			con.close();
			}
		}
	}

}
