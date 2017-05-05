package Main;

public class NotInitializedException extends RuntimeException
{
    static final long serialVersionUID = "Habrrr".hashCode();
    
    public NotInitializedException(String s)
    {
        super(s);
    }
}
