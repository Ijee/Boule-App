/**
 * 
 */
package Vorlagen;


import Main.*;

import java.util.*;
import java.io.InputStream;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;

/**
 * Diese Klasse stellt einen Eintrag für die VorlagenVision dar.
 *                  --> Vorerst nicht in Benutzung <-- 
 * 
 * @author Thorsten Schulz, Alexander Röber
 */
public class VorlagenEintrag
{
    private VBox container;
    private Button button;
    private Label beschreibungLabel;
    
    
    public VorlagenEintrag(Vorlage vorlage)
    {   
        container = new VBox();
        button = new Button();
        
        InputStream stream = getClass().getResourceAsStream("" + vorlage.getPfad());
        Image image = new Image(stream);
        
        beschreibungLabel = new Label(vorlage.getName());
        button.setGraphic(new ImageView(image));
//        poulephaseButton.addEventHandler(ActionEvent.ACTION, handler);
        
        container.getChildren().addAll(button, beschreibungLabel);
        container.getStyleClass().add("vorlagenHBox");

    }
}
