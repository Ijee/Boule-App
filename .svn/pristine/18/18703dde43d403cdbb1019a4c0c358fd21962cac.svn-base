package Turnierplan;


import javax.swing.JTable.PrintMode;

import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;

/**
 * Die UI-Klasse der TurnierplanVision.
 * 
 * @author Thorsten Schulz, Alexander Röber
 */
public class TurnierplanVisionUI
{
    private BorderPane content;
    private Button ueberblickButton;
    private Button pouleButton;
    private Button turnierAButton;
    private Button turnierBButton;
    private Button turnierCButton;
    private Button turnierDButton;
    
    public TurnierplanVisionUI(TurnierMaster master, EventHandler<ActionEvent> handler)
    {
        HBox buttonbar = new HBox();
        content = new BorderPane(null, buttonbar, null, null, null);
        buttonbar.prefWidthProperty().bind(content.widthProperty());
        content.getStyleClass().add("content");
        
        ueberblickButton = new Button("Überblick");
        pouleButton = new Button("Poulephase");
        turnierAButton = new Button("Turnier A");
        turnierBButton = new Button("Turnier B");
        turnierCButton = new Button("Turnier C");
        turnierDButton = new Button("Turnier D");
        buttonbar.getChildren().addAll(ueberblickButton, pouleButton, turnierAButton, turnierBButton, turnierCButton, turnierDButton);
        
        for(Node n : buttonbar.getChildren())
        {
            if(n instanceof Button)
            {
                Button b = (Button)n;
                b.setFocusTraversable(false);
                b.addEventHandler(ActionEvent.ACTION, handler);
                if(b != pouleButton)
                {
                    b.disableProperty().bind(master.getFertig().not());
                }
            }
        }
    }
    
    /**
     * Gibt die contentpane zurück.
     * 
     * @return die contentpane
     */
    public Pane getPane()
    {
        return content;
    }
    
    /**
     * setzt die geforderte Ansicht der Turnierplan-Ansicht.
     * 
     * @param p die Pane
     */
    public void setContent(Pane p)
    {
        content.setCenter(p);
    }
    
    /**
     * Gibt den ueberblickButton zurück.
     * 
     * @return der ueberblickButton
     */
    public Button getUeberblickButton()
    {
        return ueberblickButton;
    }
    
    /**
     * Gibt den pouleButton zurück.
     * 
     * @return der pouleButton
     */
    public Button getPouleButton()
    {
        return pouleButton;
    }
    
    /**
     * Gibt den turnierAButton zurück.
     * 
     * @return der turnierAButton
     */
    public Button getTurnierAButton()
    {
        return turnierAButton;
    }
    
    /**
     * Gibt den turnierBButton zurück.
     * 
     * @return der turnierBButton
     */
    public Button getTurnierBButton()
    {
        return turnierBButton;
    }
    
    /**
     * Gibt den turnierCButton zurück.
     * 
     * @return der turnierCButton
     */
    public Button getTurnierCButton()
    {
        return turnierCButton;
    }
    
    /**
     * Gibt den turnierDButton zurück.
     * 
     * @return der turnierDButton
     */
    public Button getTurnierDButton()
    {
        return turnierDButton;
    }
}
