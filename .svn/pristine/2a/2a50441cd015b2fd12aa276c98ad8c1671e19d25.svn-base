package Teilnehmer;

import java.util.*;

import javafx.collections.*;
import javafx.beans.property.*;

/**
 * Der Service, welches die Mannschaft verwaltet.
 * 
 * @author Thorsten Schulz, Alexander Röber
 *
 */
public class MannschaftService
{
    private ReadOnlyListProperty<Mannschaft> list;
    
    public MannschaftService(List<Mannschaft> list)
    {
        this.list = new SimpleListProperty<Mannschaft>(FXCollections.observableArrayList(list));
    }
    
    
    /**
     * Gibt die Liste von Mannschaften zurück.
     * 
     * @return die Mannschaftsliste
     */
    public ReadOnlyListProperty<Mannschaft> getList()
    {
        return list;
    }
}
