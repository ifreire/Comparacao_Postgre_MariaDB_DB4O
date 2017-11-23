package contexts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Pilot;

public class MariaDBContext extends BaseContext
{
	private static MariaDBContext instance;
	private static String urlMariaDB  = "jdbc:mysql://127.0.0.1:3306/ubuntu";
	private static String userMariaDB = "ubuntu";
	private static String passMariaDB = "";
	private static Connection conMariaDB;
	
	public static MariaDBContext Instance()
    {
        if (instance == null)
            instance = new MariaDBContext();
        
        return instance;
    }
	
	private MariaDBContext() { }
	
	public void startContext()
    {
    	try
    	{
    		conMariaDB = (Connection) DriverManager.getConnection(urlMariaDB, userMariaDB, passMariaDB);
    		System.out.println("Conexão MariaDB realizada com sucesso.");
    	}
    	catch (SQLException e)
    	{
    		System.err.print(e.getMessage());
    	}
    }
    
    public void closeContext()
    {
    	try
    	{
    		if (!conMariaDB.isClosed()) conMariaDB.close();
    		System.out.println("Conexão MariaDB finalizada com sucesso.");
    	}
    	catch (SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public void store(Pilot p)
    {
        try
        {
            Statement stmt = (Statement)conMariaDB.createStatement();
            stmt.
            execute(String.
            		format("INSERT INTO PILOTS(NAME, POINTS) VALUES ('%s', %d)",
            				p.getName(),
            				p.getPoints()));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
