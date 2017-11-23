package contexts;

import entities.Pilot;

public class BaseContext
{
    public static void printPilot(Pilot pilot)
    {
        System.out.println(pilot.getName() + ": " + pilot.getPoints() + " pontos.");
    }
}