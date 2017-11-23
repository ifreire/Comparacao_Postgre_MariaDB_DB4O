package entities;

import java.util.Random;

class BaseEntity
{
    private int id;
    private int idEntity;
    private static int actualId = 0;
    
    public BaseEntity()
    {
        this.id = 0;
        this.idEntity = newId();
    }
    
    private static int newId()
    {
        actualId = (new Random().nextInt(Integer.MAX_VALUE) % Integer.MAX_VALUE) + 1;
        return -actualId;
    }
    
    public int getId()
    {
        int result = 0;
        
        if (id == 0)
            result = idEntity;
        else
            result = id;
        
        return result;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int IdEntity()
    {
        return idEntity;
    }
    
    public boolean isNew()
    {
        return this.id == 0;
    }
    
//    protected String identifier()
//    {
//        return null;
//    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        
        if (!(obj instanceof BaseEntity))
            return false;
        
        if (!obj.getClass().equals(this.getClass()))
            return false;
        
        if (this != obj)
            return false;
        
        if (this.id != ((BaseEntity)obj).id)
            return false;
        
        return true;
    }

    @Override
    public int hashCode()
    {
        return (this.getClass().getName() + ":" + Integer.toString(this.id)).hashCode();
    }

//    @Override
//    public String toString()
//    {
//        return String.format("[ %s ] - [ Id: %d ] - [ %s ]", this.getClass().getSimpleName(), this.id, identifier());
//    }
}