package contexts;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import entities.Pilot;

public class Db4oContext extends BaseContext
{
    private static Db4oContext instance;
    final static String DB4OFILENAME = "db/mtc.db4o";
    static ObjectContainer DB;
    
    
    
    public static Db4oContext Instance()
    {
        if (instance == null)
            instance = new Db4oContext();
        
        return instance;
    }
    
    private Db4oContext() { }
    
    public void startContext()
    {
        if (DB == null)
            DB = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
    }
    
    public void closeContext()
    {
        if (DB != null)
            DB.close();
    }
    
    public void store(Pilot p)
    {
        DB.store(p);
    }
}