package Turnierplan.poulephase;

import Main.Master;
import Main.Vision;
import Teilnehmer.Mannschaft;
import Teilnehmer.MannschaftService;

import java.util.ArrayList;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;

/**
 * Diese Vision-Klasse ist für den ersten Teil des ABCD-Turniers verantwortlich (Poule).
 * 
 * @author Thorsten Schulz, Alexander Röber
 *
 */
public class PoulephaseVision extends Vision implements EventHandler<Event>
{
    private ArrayList<Poule> pouleList;
    private PoulephaseVisionUI ui;

    private MannschaftService mannschaftService;

    public PoulephaseVision(Master m)
    {
        super(m);
        pouleList = new ArrayList<Poule>();
    }

    public void setMannschaftService(MannschaftService service)
    {
        mannschaftService = service;
    }

    @Override
    public void init()
    {
        ArrayList<PouleEintrag> list = buildPouleList();

        ui = new PoulephaseVisionUI(list, this);

        pane = ui.getPane();
        isInit = true;
    }

    @Override
    public void handle(Event e)
    {
        EventType t = e.getEventType();
        if(t == ActionEvent.ACTION)
        {
            
        }
    }

    /**
     * Baut eine Liste an PouleListEinträgen zusammen und gibt diese zurück.
     * Gleichzeitig, um doppelte Arbeit zu sparen, füllt diese Methode die
     * PouleList. Dabei achtet es darauf, die unpassende Anzahl an Mannschaften
     * mit leeren Mannschaften auszugleichen.
     * 
     * @return die Liste mit PouleListEinträgen
     */
    private ArrayList<PouleEintrag> buildPouleList()
    {
        ArrayList<PouleEintrag> eintragList = new ArrayList<PouleEintrag>();
        int rest = mannschaftService.getList().getSize() % 4;

        for(int i = 0; i < rest; i++)
        {
            Mannschaft m1 = mannschaftService.getList().get(i * 3);
            Mannschaft m2 = mannschaftService.getList().get(i * 3 + 1);
            Mannschaft m3 = mannschaftService.getList().get(i * 3 + 2);
            Poule p = new Poule(i, m1, m2, m3, Mannschaft.EMPTY);
            pouleList.add(p);

            PouleEintrag pe = new PouleEintrag(p);
            eintragList.add(pe);
        }

        for(int i = 0; i < (mannschaftService.getList().getSize() - rest * 3) / 4; i++)
        {
            Mannschaft m1 = mannschaftService.getList().get(rest * 3 + i * 4);
            Mannschaft m2 = mannschaftService.getList().get(rest * 3 + i * 4 + 1);
            Mannschaft m3 = mannschaftService.getList().get(rest * 3 + i * 4 + 2);
            Mannschaft m4 = mannschaftService.getList().get(rest * 3 + i * 4 + 3);
            Poule p = new Poule(i + rest, m1, m2, m3, m4);
            pouleList.add(p);

            PouleEintrag pe = new PouleEintrag(p);
            eintragList.add(pe);
        }

        return eintragList;
    }
}
