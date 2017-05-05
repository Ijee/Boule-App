package Turnierplan.poulephase;

import java.util.ArrayList;

import javafx.event.*;
import javafx.collections.*;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;


/**
 * Die UI-Klasse der PoulephaseVision.
 * 
 * @author Thorsten Schulz, Alexander Röber
 */
public class PoulephaseVisionUI 
{
    ObservableList<PouleEintrag> list;
    Pane content;

    /**
     * 
     * @param arrayList
     * @param handler
     */
    public PoulephaseVisionUI(ArrayList<PouleEintrag> arrayList,
            EventHandler<Event> handler)
    {
        content = new Pane();
        ScrollPane scr = new ScrollPane();
        Accordion acc = new Accordion();

        list = FXCollections.observableArrayList(arrayList);
        
        Tooltip tooltip = new Tooltip();
        tooltip.setText("Mit Bild hoch und Bild runter lassen sich die Poule-Einträge durchgehen.\n");
        
        for(int i = 0; i<list.size();i++)
        {
            acc.getPanes().add(list.get(i));
            list.get(i).setTooltip(tooltip);
        }
//        acc.getPanes().addAll(list);
        acc.prefWidthProperty().bind(scr.widthProperty());
        scr.setContent(acc);
        for(Node n : scr.lookupAll(".scroll-bar"))
        {
            if(n instanceof ScrollBar)
            {
                ((ScrollBar)n).setUnitIncrement(15);
                ((ScrollBar)n).setBlockIncrement(15);
            }
        }
        scr.setVbarPolicy(ScrollBarPolicy.NEVER);
        scr.setHbarPolicy(ScrollBarPolicy.NEVER);
        scr.prefHeightProperty().bind(content.heightProperty());
        scr.prefWidthProperty().bind(content.widthProperty());
        content.getChildren().add(scr);
    }

    /**
     * Gibt die contentpane zurück.
     * 
     * @return die pane
     */
    public Pane getPane()
    {
        return content;
    }
}
