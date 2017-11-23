package daos;

import contexts.PostgreContext;
import entities.Pilot;

public class PilotDAOPostgre
{
	private static PostgreContext DBContext;
    
    public PilotDAOPostgre()
    {
        DBContext = PostgreContext.Instance();
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
            Pilot p = new Pilot(String.format("PostgreSQL %d", id), id, id);
            DBContext.store(p);
        }
        
        System.out.println(Integer.toString(qt).concat(" pilotos adicionados!"));
    }
}