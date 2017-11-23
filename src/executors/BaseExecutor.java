package executors;

import java.time.Instant;

public class BaseExecutor
{
    protected static void startTime()
    {
        now();
    }
    
    protected static void endTime()
    {
        now();
    }
    
    protected static void now()
    {
        System.out.println(Instant.now());
    }
}