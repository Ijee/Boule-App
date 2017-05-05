package Teilnehmer;

import Main.*;

/**
 * Diese Vision-Klasse ist f�r das initialisieren der Teilnehmerliste zust�ndig.
 * 
 * @author Thorsten Schulz, Alexander R�ber
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
