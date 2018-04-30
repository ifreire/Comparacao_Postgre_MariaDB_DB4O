package main;

import executors.Db4oExecutor;
//import executors.MariaDBExecutor;
//import executors.PostgreExecutor;

public class Main
{
    public static void main(String[] args)
    {
    	System.out.println("");
        System.out.println("DB4O:");
        execDB4O(50000);
        
        //System.out.println("");
        //System.out.println("PostgreSQL:");
        //execPostgre(10000);
        
        //System.out.println("");
        //System.out.println("MariaDB:");
        //execMariaDB(10000);
    }
    
    private static void execDB4O(int qt)
    {
        Db4oExecutor.execDB4O(qt);
    }
    
//    private static void execPostgre(int qt)
//    {
//        PostgreExecutor.execPostgre(qt);
//    }
//    
//    private static void execMariaDB(int qt)
//    {
//    	MariaDBExecutor.execMariaDB(qt);
//    }
}