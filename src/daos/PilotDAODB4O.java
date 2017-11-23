package daos;

import contexts.Db4oContext;
import entities.Pilot;

public class PilotDAODB4O
{
    private static Db4oContext DBContext;
    
    public PilotDAODB4O()
    {
        DBContext = Db4oContext.Instance();
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
            Pilot p = new Pilot(String.format("Db4o %d", id), id, id);
            DBContext.store(p);
        }
        
        System.out.println(Integer.toString(qt).concat(" pilotos adicionados!"));
    }
}