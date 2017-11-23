package contexts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import entities.Pilot;

public class PostgreContext extends BaseContext
{
	private static PostgreContext instance;
	private static String urlPostgresql  = "jdbc:postgresql://localhost:5432/ubuntu";
	private static String userPostgresql = "ubuntu";
	private static String passPostgresql = "";
	private static Connection conPostgresql;
	
	public static PostgreContext Instance()
    {
        if (instance == null)
            instance = new PostgreContext();
        
        return instance;
    }
    
    private PostgreContext() { }
    
    public void startContext()
    {
    	try
    	{
    		conPostgresql = (Connection) DriverManager.getConnection(urlPostgresql, userPostgresql, passPostgresql);
    		System.out.println("Conexão PostgreSQL realizada com sucesso.");
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
    		if (!conPostgresql.isClosed()) conPostgresql.close();
    		System.out.println("Conexão PostgreSQL finalizada com sucesso.");
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
            Statement stmt = (Statement)conPostgresql.createStatement();
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