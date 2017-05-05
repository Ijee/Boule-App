package Main;

import javafx.scene.layout.*;

/**
 * Dieses interface wird von allen Klassen implementiert, die als ContentPane im
 * Hauptfenster angezeigt werden.
 * 
 * @author Thorsten Schulz, Alexander Röber
 *
 */
public abstract class Vision
{
    protected Pane pane;
    protected boolean isInit;
    protected Master master;
    
    public Vision(Master m)
    {
        master = m;
    }

    /**
     * Diese Methode soll das Initialisieren implementieren und muss aufgerufen
     * worden sein, bevor die Klasse weiter benutzt werden kann. Die Variablen
     * isInit und pane sollten am Ende korrek gesetzt sein.
     */
    public abstract void init();

    /**
     * Wenn die implementierte Klasse initialisiert worden ist, gibt diese
     * Methode ein Pane zurück, das die graphischen Elemente enthält.
     * 
     * @return das Pane zum anzeigen
     */
    public Pane getPane()
    {
        if(!isInit)
        {
            throw new NotInitializedException(this.getClass().getSimpleName()+" is not initialized");
        }
        return pane;
    }
    
    public boolean isInit()
    {
        return isInit;
    }
}
