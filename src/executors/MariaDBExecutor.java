package executors;

import daos.PilotDAOMariaDB;

public class MariaDBExecutor extends BaseExecutor
{
	public static void execMariaDB(int qt)
    {
		PilotDAOMariaDB dao = new PilotDAOMariaDB();
		
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