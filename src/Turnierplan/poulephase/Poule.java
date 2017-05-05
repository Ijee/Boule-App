package Turnierplan.poulephase;

import Teilnehmer.Mannschaft;

/**
 * Die Klasse, welche Mannschaften in einen Poule zusammenf�sst (4 Mannschaften befinden sich in einem Poule).
 * 
 * @author Thorsten Schulz, ALexander R�ber
 */
public class Poule
{
    private int nr;

    private Mannschaft mannschaft1;
    private Mannschaft mannschaft2;
    private Mannschaft mannschaft3;
    private Mannschaft mannschaft4;
    
    public Poule(int nr, Mannschaft m1, Mannschaft m2, Mannschaft m3, Mannschaft m4)
    {
        this.nr = nr;
        mannschaft1 = m1;
        mannschaft2 = m2;
        mannschaft3 = m3;
        mannschaft4 = m4;
    }

    /**
     * Gibt die Nummer des Poules zur�ck.
     * 
     * @return die nr
     */
    public int getNr()
    {
        return nr;
    }

    /**
     * Gibt die erste Mannschaft zur�ck
     * 
     * @return die mannschaft1
     */
    public Mannschaft getMannschaft1()
    {
        return mannschaft1;
    }
    
    /**
     * Gibt die zweite Mannschaft zur�ck
     * 
     * @return die mannschaft2
     */
    public Mannschaft getMannschaft2()
    {
        return mannschaft2;
    }

    /**
     * Gibt die dritte Mannschaft zur�ck
     * 
     * @return die mannschaft3
     */
    public Mannschaft getMannschaft3()
    {
        return mannschaft3;
    }

    /**
     * Gibt die vierte Mannschaft zur�ck
     * 
     * @return die mannschaft4
     */
    public Mannschaft getMannschaft4()
    {
        return mannschaft4;
    }
}
