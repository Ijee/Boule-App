/**
 * 
 */
package Turnierplan.uebersicht;

import javafx.event.Event;
import javafx.event.EventHandler;
import Main.Master;
import Main.Vision;

/**
 * Die Vision-Klasse der Uebersichts-Ansicht.
 * 
 * @author Thorsten Schulz, Alexander Röber
 */
public class UebersichtVision extends Vision implements EventHandler<Event>
{
    private UebersichtVisionUI ui;

    /**
     * @param m
     */
    public UebersichtVision(Master m)
    {
        super(m);
    }
    
    /* 
     * Die Initialisierungsmethode dieser Vision-Klasse.
     */
    @Override
    public void init()
    {
       ui = new UebersichtVisionUI(master, this);
       
       pane = ui.getPane();
       isInit = true;
        
    }
    /* 
     * der handler, der sich um die Uebersicht-Ansicht kümmert.
     */
    @Override
    public void handle(Event arg0)
    {
        // TODO Auto-generated method stub
        
    }



}
