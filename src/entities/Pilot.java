package entities;

public class Pilot extends BaseEntity
{    
    private String name;
    private int points;  
    
    public Pilot(String name, int points, int id)
    {
        super.setId(id);
        this.name = name;
        this.points = points;
    }
        
    public int getPoints()
    {
        return points;
    }
    
    public void addPoints(int points)
    {
        this.points += points;
    }
    
    public String getName()
    {
        return name;
    }
    
//    @Override
//    protected String identifier()
//    {
//        return String.format("%s / %d", this.name, this.points);
//    }
    
//    public String toString()
//    {
//        return name + " / " + points;
//    }
}