package executors;

import daos.PilotDAODB4O;

public class Db4oExecutor extends BaseExecutor
{
    public static void execDB4O(int qt)
    {
        PilotDAODB4O dao = new PilotDAODB4O();
        
        try
        {
            dao.startContext();
            
            startTime();
            
            dao.store(qt);
        }
        finally
        {
            endTime();
            
            dao.closeContext();
        }
    }
}