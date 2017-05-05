package Home;

import java.io.InputStream;
import java.util.regex.*;

import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.event.*;

/**
 * Diese Klasse wird von HomeVision benutzt, um die Eintr�ge der
 * TeilnehmerAuflistung besser zu handhaben.
 * 
 * @author Thorsten Schulz, Alexander R�ber
 *
 */
public class TeilnehmerAuflistungsEintrag
{
    private int nr;
    private Label nrLabel;
    private TextField namenField;
    private TextField vereinField;
    private Button loeschenButton;
    
    private static final Pattern INPUT_PATTERN = Pattern.compile("[a-zA-Z]+");

    public TeilnehmerAuflistungsEintrag(EventHandler<Event> handler, int nr)
    {
        this.nr = nr;
        nrLabel = new Label();
        setNr(nr);
        InputStream loeschenStream = getClass().getResourceAsStream("/rsc/loeschenButton.png");
        Image loeschenImage = new Image(loeschenStream, 20, 20, true, true );
        loeschenButton = new Button("", new ImageView(loeschenImage));
        namenField = new TextField();
        namenField.setPromptText("Max Mustermann, Erika Mustermann...");
        vereinField = new TextField();
        vereinField.setPromptText("Verein 1, Verein 2...");

        loeschenButton.addEventHandler(ActionEvent.ACTION, handler);
        loeschenButton.setFocusTraversable(false);
        
        namenField.addEventHandler(KeyEvent.KEY_RELEASED, handler);
        namenField.addEventHandler(KeyEvent.KEY_TYPED, handler);
        vereinField.addEventHandler(KeyEvent.KEY_RELEASED, handler);
        vereinField.addEventHandler(KeyEvent.KEY_TYPED, handler);
        //TODO: REGEX f�r die beiden TextFields der HomeVisionUI:
//        namenField.focusedProperty().addListener(new ChangeListener<Boolean>()
//        {
//
//            @Override
//            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldP, Boolean newP)
//            {
//                if(newP)
//                {
//
//                }
//            }
//            
//        });
    }
    
    /**
     * Gibt die Nummer zur�ck.
     * 
     * @return die Nummer
     */
    public int getNr()
    {
        return nr;
    }
    
    /**
     * Setzt die Nummer.
     * 
     * @param nr die Nummer
     */
    public void setNr(int nr)
    {
        this.nr = nr;
        nrLabel.setText((nr+1)+".");
    }
    
    /**
     * Gibt das nrLabel zur�ck.
     * 
     * @return das nrLabel
     */
    public Label getNrLabel()
    {
    	return nrLabel;
    }
    
    /**
     * Gibt das namenField zur�ck.
     * 
     * @return das namenField
     */
    public TextField getNameField()
    {
        return namenField;
    }
    
    /**
     * Gibt das vereinField zur�ck.
     * 
     * @return das vereinField
     */
    public TextField getVereinField()
    {
        return vereinField;
    }
    
    /**
     * Gibt den L�schenButton zur�ck.
     * 
     * @return der L�schenButton
     */
    public Button getLoeschenButton()
    {
    	return loeschenButton;
    }
}
