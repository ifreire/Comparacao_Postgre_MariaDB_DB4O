package daos;

import contexts.MariaDBContext;
import entities.Pilot;

public class PilotDAOMariaDB
{
	private static MariaDBContext DBContext;
    
    public PilotDAOMariaDB()
    {
        DBContext = MariaDBContext.Instance();
    }
    
    public void startContext()
    {
        DBContext.startContext();
    }
    
    public void closeContext()
    {
        DBContext.closeContext();
    }
    
    public void store(int qt)
    {
        int id = 0;
        
        for (int i = 0; i < qt; i++)
        {
            id++;
            Pilot p = new Pilot(String.format("MariaDB %d", id), id, id);
            DBContext.store(p);
        }
        
        System.out.println(Integer.toString(qt).concat(" pilotos adicionados!"));
    }
    
}