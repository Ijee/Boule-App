package Teilnehmer;

import Main.*;

/**
 * Diese Vision-Klasse ist für das initialisieren der Teilnehmerliste zuständig.
 * 
 * @author Thorsten Schulz, Alexander Röber
 *
 */
public class TeilnehmerVision extends Vision
{
    MannschaftService mannschaftService;
    TeilnehmerVisionUI ui;

    public TeilnehmerVision(Master m)
    {
        super(m);
    }

    /**
     * Setzt den mannschaftService.
     * 
     * @param mannschaftService der mannschaftService
     */
    public void setMannschaftService(MannschaftService mannschaftService)
    {
        this.mannschaftService = mannschaftService;
    }

    /**
     * Die Initialisierungsmethode dieser Vision-Klasse.
     */
    @Override
    public void init()
    {
        if(mannschaftService != null)
        {
            ui = new TeilnehmerVisionUI(mannschaftService);

            pane = ui.getPane();
            isInit = true;
        }
    }
}
