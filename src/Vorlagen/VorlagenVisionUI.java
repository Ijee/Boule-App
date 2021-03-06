package Vorlagen;

import java.io.InputStream;

import Main.*;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;

/**
 * Die UI-Klasse der VorlagenVision
 * 
 * @author Thorsten Schulz, Alexander R�ber 
 *
 */
public class VorlagenVisionUI
{
    private Master master;
    private EventHandler<Event> handler;
    private TilePane content;
    
    private VBox container;
    private Button poulephaseButton;
    private Label poulephaseBeschreibungLabel;
    
    public VorlagenVisionUI(Master m, EventHandler<Event> handler)
    {
        master = m;
        this.handler = handler;
        
        content = new TilePane();
        content.setHgap(5);
        content.setVgap(5);
        content.getStyleClass().add("content");
        
        container = new VBox();
        poulephaseButton = new Button();
        

        InputStream stream = getClass().getResourceAsStream("/rsc/poulekarte_preview.png");
        Image image = new Image(stream);
        
        poulephaseBeschreibungLabel = new Label("Poulephase Karte");
        poulephaseButton.setGraphic(new ImageView(image));
        poulephaseButton.addEventHandler(ActionEvent.ACTION, handler);
        
        container.getChildren().addAll(poulephaseButton,poulephaseBeschreibungLabel);
        container.getStyleClass().add("vorlagenHBox");
        
        content.getChildren().addAll(container);
    }
    
    /**
     * Gibt die contentpane zur�ck.
     * 
     * @return die contentpane
     */
    public Pane getPane()
    {
        return content;
    }
    
    /**
     * Gibt den poulephaseButton zur�ck.
     * 
     * @return der poulephaseButton
     */
    public Button getPoulephaseButton()
    {
        return poulephaseButton;
    }
}
