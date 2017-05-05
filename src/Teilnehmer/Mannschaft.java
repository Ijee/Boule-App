package Teilnehmer;

/**
 * Die Struktur zum speichern einer Mannschaft, die bei der Eingabe in
 * der HomeVisionUI eingetragen wird.
 *  
 * @author Thorsten Schulz, Alexander Röber
 *
 */
public class Mannschaft
{
    public static final Mannschaft EMPTY = new Mannschaft(-1, "Leer", "");

    private int nr;
    private String namen;
    private String vereine;

    public Mannschaft(int nr, String namen, String vereine)
    {
        this.nr = nr;
        this.namen = namen;
        this.vereine = vereine;
    }

    /**
     * Gibt die nr als int zurück
     * 
     * @return die nr
     */
    public int getNr()
    {
        return nr;
    }

    /**
     * Gibt den Namen als String zurück
     * 
     * @return der Name
     */
    public String getNamen()
    {
        return namen;
    }

    /**
     * Gibt den Verein als String zurück
     * 
     * @return der Verein
     */
    public String getVereine()
    {
        return vereine;
    }
}