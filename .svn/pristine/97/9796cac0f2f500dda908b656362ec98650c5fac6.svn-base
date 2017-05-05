package Turnierplan;

import javafx.beans.property.*;
import javafx.event.*;
import Main.Master;
import Main.Vision;
import Teilnehmer.MannschaftService;
import Turnierplan.poulephase.PoulephaseVision;
import Turnierplan.uebersicht.UebersichtVision;

/**
 * Diese Vision-Klasse organisiert das ABCD-Turnier.
 * 
 * @author Thorsten Schulz, Alexander Röber
 *
 */
public class TurnierplanVision extends Vision implements TurnierMaster,
        EventHandler<ActionEvent>
{
    private TurnierplanVisionUI ui;
    private SimpleBooleanProperty isFertig;

    private UebersichtVision uebersicht;
    private PoulephaseVision poulephase;
    private TurnierphaseVision turnierA;
    private TurnierphaseVision turnierB;
    private TurnierphaseVision turnierC;
    private TurnierphaseVision turnierD;

    private MannschaftService mannschaftService;

    public TurnierplanVision(Master m)
    {
        super(m);

        isFertig = new SimpleBooleanProperty(false);
        
        uebersicht = new UebersichtVision(this);
        poulephase = new PoulephaseVision(this);
        turnierA = new TurnierphaseVision(this);
        turnierB = new TurnierphaseVision(this);
        turnierC = new TurnierphaseVision(this);
        turnierD = new TurnierphaseVision(this);
    }

    public void setMannschaftService(MannschaftService service)
    {
        mannschaftService = service;
    }

    /**
     * Die Initialisierungsmethode dieser Vision-Klasse.
     */
    @Override
    public void init()
    {
        if(mannschaftService != null)
        {
            ui = new TurnierplanVisionUI(this, this);
            pane = ui.getPane();

            poulephase.setMannschaftService(mannschaftService);
            poulephase.init();
            ui.setContent(poulephase.getPane());

            isInit = true;
        }
    }

    /**
     * Gibt isFertig zurück.
     */
    @Override
    public ReadOnlyBooleanProperty getFertig()
    {
        return isFertig;
    }

    @Override
    public void notifyFertig()
    {

    }

    /**
     * Der handler dieser Vision-Klasse.
     */
    @Override
    public void handle(ActionEvent e)
    {
        if(e.getSource() == ui.getUeberblickButton())
        {
            ui.setContent(uebersicht.getPane());
        }
        if(e.getSource() == ui.getPouleButton())
        {
            ui.setContent(poulephase.getPane());
        }
        if(e.getSource() == ui.getTurnierAButton())
        {
            if(!turnierA.isInit())
            {
                turnierA.init();
            }
            ui.setContent(turnierA.getPane());
        }
        if(e.getSource() == ui.getTurnierBButton())
        {
            if(!turnierB.isInit())
            {
                turnierB.init();
            }
            ui.setContent(turnierB.getPane());
        }
        if(e.getSource() == ui.getTurnierCButton())
        {
            if(!turnierC.isInit())
            {
                turnierC.init();
            }
            ui.setContent(turnierC.getPane());
        }
        if(e.getSource() == ui.getTurnierDButton())
        {
            if(!turnierD.isInit())
            {
                turnierD.init();
            }
            ui.setContent(turnierD.getPane());
        }
    }

}
