/**
 * 
 */
package Vorlagen;

/**
 * TODO: Noch nicht in Benutzung
 * 
 * @author Thorsten Schulz, Alexander R�ber
 */
public class Vorlage
{
    int id;
    String name;
    String pfad;
    
    public Vorlage(int id, String name, String pfad)
    {
        this.id = id;
        this.name = name;
        this.pfad = pfad;
    }
    
    /**
     * Gibt die ID zur�ck
     * 
     * @return die id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Gibt den Namen zur�ck.
     * 
     * @return der name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gibt den Pfad zur�ck
     * 
     * @return der Pfad
     */
    public String getPfad()
    {
        return pfad;
    }
}
