package executors;

import daos.PilotDAOPostgre;

public class PostgreExecutor extends BaseExecutor
{
	public static void execPostgre(int qt)
    {
		PilotDAOPostgre dao = new PilotDAOPostgre();
		
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