package Main;

import java.io.InputStream;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.event.*;



/**
 * Die UI-Klasse der MainApp.
 * 
 * @author Thorsten Schulz, Alexander Röber
 *
 */
public class MainAppUI
{
    private final int MENU_WIDTH = 100;

    private Master master;
    private EventHandler<ActionEvent> handler;

    private BorderPane rootPane;
    private BorderPane testPane;
    private Pane menuPane;
    private Pane contentPane;
    
    private Scene scene;
    private ProgressBar progressBar;
    private ToggleButton homeButton;
    private ToggleButton spielButton;
    private ToggleButton teilnehmerButton;
    private ToggleButton vorlagenButton;
    private ToggleButton einstellungsButton;
    private ToggleButton beendenButton;

    /**
     * Initialisiert die Scene.
     */
    public MainAppUI(Master m, EventHandler<ActionEvent> handler)
    {
        master = m;
        this.handler = handler;
        
        menuPane = new VBox();
        progressBar = new ProgressBar();
        
        testPane = new BorderPane(null, progressBar, null, null, null);
        
        rootPane = new BorderPane(testPane, null, null, null, menuPane);
        progressBar.prefWidthProperty().bind(testPane.widthProperty());
        
        rootPane.getStyleClass().add("rootPane");

        initMenu(); 

        scene = new Scene(rootPane, 1000, 600);
    }

    /**
     * Gibt die Scene zurück, falls diese initialisiert ist.
     * 
     * @return die Scene oder null, falls nicht initialisiert.
     */
    public Scene getScene()
    {
        return scene;
    }

    /**
     * Setzt den Content-Teil des Fensters.
     * 
     * @param pane
     *            der neue Content.
     */
    public void setContent(Pane pane)
    {
        contentPane = pane;
        testPane.setCenter(contentPane);
    }

    /**
     * Initialisiert das Menü.
     */
    private void initMenu()
    {
        //Menubuttons mit Icons 36x36
        ToggleGroup t = new ToggleGroup();
        
        //Richtige Auswahl der toggleproperty auf den ToggleButtons (immer eine Auswahl)
        t.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle,
                    Toggle toggle_neu)
            {
                if(toggle_neu == null)
                {
                    toggle.setSelected(true);
                }
                
            }
            
        });
        InputStream homeStream = getClass().getResourceAsStream("/rsc/HomeMenuHome.png");
        Image homeImage = new Image(homeStream, 36, 36, true, true );
        homeButton = new ToggleButton("Home", new ImageView(homeImage));
        homeButton.setContentDisplay(ContentDisplay.TOP);
        
        InputStream spielStream = getClass().getResourceAsStream("/rsc/HomeMenuSpiel.png");
        Image spielImage = new Image(spielStream, 36, 36, true, true );
        spielButton = new ToggleButton("Spiel", new ImageView(spielImage));
        spielButton.setContentDisplay(ContentDisplay.TOP);
        
        InputStream teilnehmerStream = getClass().getResourceAsStream("/rsc/HomeMenuTeilnehmer.png");
        Image teilnehmerImage = new Image(teilnehmerStream, 36, 36, true, true );
        teilnehmerButton = new ToggleButton("Teilnehmer", new ImageView(teilnehmerImage));
        teilnehmerButton.setContentDisplay(ContentDisplay.TOP);
        
        InputStream vorlagenStream = getClass().getResourceAsStream("/rsc/HomeMenuVorlagen.png");
        Image vorlagenImage = new Image(vorlagenStream, 36, 36, true, true );
        vorlagenButton = new ToggleButton("Vorlagen", new ImageView(vorlagenImage));
        vorlagenButton.setContentDisplay(ContentDisplay.TOP);
        
        InputStream einstellungenStream = getClass().getResourceAsStream("/rsc/HomeMenuEinstellungen.png");
        Image einstellungenImage = new Image(einstellungenStream, 36, 36, true, true );
        einstellungsButton = new ToggleButton("Einstellungen", new ImageView(einstellungenImage));
        einstellungsButton.setContentDisplay(ContentDisplay.TOP);
        
        InputStream beendenStream = getClass().getResourceAsStream("/rsc/HomeMenuBeenden.png");
        Image beendenImage = new Image(beendenStream, 36, 36, true, true );
        beendenButton = new ToggleButton("Beenden", new ImageView(beendenImage));
        beendenButton.setContentDisplay(ContentDisplay.TOP);

        homeButton.setToggleGroup(t);
        homeButton.setSelected(true);
        spielButton.setToggleGroup(t);
        teilnehmerButton.setToggleGroup(t);
        vorlagenButton.setToggleGroup(t);
        einstellungsButton.setToggleGroup(t);
        //TODO: Einstellungsansicht
        einstellungsButton.setDisable(true);
        beendenButton.setToggleGroup(t);

        //UI: Buttons hinzufügen, handler, traversable
        menuPane.getChildren().addAll(homeButton, spielButton,
                teilnehmerButton, vorlagenButton, einstellungsButton, beendenButton);
        menuPane.setMaxHeight(Double.MAX_VALUE);
        for (Node n : menuPane.getChildren())
        {
            if (n instanceof ButtonBase)
            {
                ButtonBase b = (ButtonBase) n;
                b.setFocusTraversable(false);
                b.setPrefWidth(MENU_WIDTH);
                b.setOnAction(handler);
                b.setMaxHeight(Double.MAX_VALUE);
                b.getStyleClass().add("menu-eintrag");
            }
        }
        
        //Sorgt dafür, dass "Spiel" und "Teilnehmer" nur benutzbar sind, wenn die Teilnehmer in der HomeVision eingetragen wurden. 
        spielButton.disableProperty().bind(master.getFertig().not());
        teilnehmerButton.disableProperty().bind(master.getFertig().not());
        menuPane.getStyleClass().add("menu");
    }
    
    /**
     * Gibt die rootPane zurück.
     * 
     * @return die rootPane
     */
    public BorderPane getRootPane()
    {
    	return testPane;
    }
    
    /**
     * Gibt den homeButton zurück.
     * 
     * @return der homeButton
     */
    public EventTarget getHomeTarget()
    {
        return homeButton;
    }

    /**
     * Gibt den spielButton zurück.
     * 
     * @return der spielButton
     */
    public EventTarget getSpielTarget()
    {
        return spielButton;
    }

    /**
     * Gibt den teilnehmerButton zurück.
     * 
     * @return der teilnehmerButton
     */
    public EventTarget getTeilnehmerTarget()
    {
        return teilnehmerButton;
    }
    
    /**
     * gibt den vorlagenButton zurück.
     * 
     * @return der vorlagenButton
     */
    public EventTarget getVorlagenTarget()
    {
        return vorlagenButton;
    }

    /**
     * Gibt den einstellungsButton zurück.
     * 
     * @return der einstellungsButton
     */
    public EventTarget getEinstellungsTarget()
    {
        return einstellungsButton;
    }
    
    /**
     * Gibt den beendenButton zurück.
     * 
     * @return der beendenButton
     */
    public EventTarget getBeendenTarget()
    {
        return beendenButton;
    }
}
