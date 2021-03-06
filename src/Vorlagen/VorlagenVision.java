package Vorlagen;

import java.awt.Desktop;

import Main.*;

import java.util.ArrayList;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;

import javax.management.RuntimeErrorException;

import javafx.event.*;
import javafx.scene.control.*;

/**
 * Diese Vision-Klasse ist f�r das initialisieren der Vorlagen zust�ndig.
 * 
 * @author Thorsten Schulz, Alexander R�ber
 *
 */
public class VorlagenVision extends Vision implements EventHandler<Event>
{
    ArrayList<VorlagenEintrag> vorlagenList;
    private VorlagenVisionUI ui;

    public VorlagenVision(Master m)
    {
        super(m);
        vorlagenList = new ArrayList<VorlagenEintrag>();
    }

    @Override
    public void init()
    {
        ui = new VorlagenVisionUI(master, this);

        pane = ui.getPane();
        isInit = true;

    }

    /**
     * Der handler der VorlagenVisionUI
     */
    @Override
    public void handle(Event e)
    {
        if(e.getSource() instanceof Button)
        {
            Button b = (Button) e.getSource();
            if(b == ui.getPoulephaseButton())
            {
               
                if(Desktop.isDesktopSupported())
                {
                    try
                    {
                        File file = new File(URI.create(getClass().getResource("/rsc/Poulephase_Karte.pdf").toString()));
                        Desktop.getDesktop().open(file);
                    }
                    catch(IOException err)
                    {
                       //TODO: IOException Dialog
                    }
                }
            }
        }

    }
    
    /**
     * TODO: Baut die Liste der Vorlagen dynamisch zusammen.
     * 
     * @return die VorlagenEintragsListe
     */
    private ArrayList<VorlagenEintrag> buildVorlagenList()
    {
        ArrayList<VorlagenEintrag> vorlagenEintragList = new ArrayList<VorlagenEintrag>();
        //TODO: Gehe alle Dateien des PDF Verzeichnis durch, speichere g�ltige Dateienpfade
        //      und f�ge diese nach Turniername(Alphabetisch) sortiert der Vorlagenliste hinzu.
        File verzeichnis = new File("");
        File[] matches = verzeichnis.listFiles(new FilenameFilter() {
            public boolean accept(File verzeichnis, String name)
            {
                return name.startsWith("Poule") && name.endsWith(".pdf");
            }
        });
        
        //nope
        Vorlage poulephaseKarte = new Vorlage(0, "Poulephase-Karte", "/rsc/poulekarte_preview.png");
        return vorlagenEintragList;
    }
}
