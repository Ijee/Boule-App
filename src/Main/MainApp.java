package Main;

import java.util.ArrayList;

import javafx.scene.input.MouseEvent;
import Home.HomeVision;
import javafx.application.Platform;
import Home.TeilnehmerAuflistungsEintrag;
import Teilnehmer.Mannschaft;
import Teilnehmer.MannschaftService;
import Teilnehmer.TeilnehmerVision;
import Turnierplan.TurnierplanVision;
import Vorlagen.VorlagenVision;
import javafx.application.Application;
import javafx.scene.image.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.beans.property.*;
import javafx.collections.*;

/**
 * PTP 15
 * Diese Klasse dient zum einen als Hauptklasse unseres Projekts und zum anderen
 * als EventHandler f�r die Men�steuerung.
 * 
 * @author Thorsten Schulz, Alexander R�ber
 */
public class MainApp extends Application implements EventHandler<ActionEvent>, Master
{
    private MainAppUI ui;
    
//    private double xOffset = 0;
//    private double yOffset = 0;
    
    private SimpleBooleanProperty isFertig;

    private HomeVision homeVision;
    private TurnierplanVision turnierplanVision;
    private TeilnehmerVision teilnehmerVision;
    private VorlagenVision vorlagenVision;

    private MannschaftService mannschaftService;

    public static void main(String[] args)
    {
        launch(args);
    }

    public MainApp()
    {
        isFertig = new SimpleBooleanProperty(false);

        ui = new MainAppUI(this, this);

        homeVision = new HomeVision(this);
        turnierplanVision = new TurnierplanVision(this);
        teilnehmerVision = new TeilnehmerVision(this);
        vorlagenVision = new VorlagenVision(this);
    }

    /**
     * Die start-Methode zur Ausf�hrung der JavaFX-Applikation.
     */
    public void start(Stage primaryStage)
    {
        //Titel der Applikation, setzen der Szene, Icon setzen
        primaryStage.setTitle("P�tanque");
        primaryStage.centerOnScreen();
        primaryStage.setScene(ui.getScene());
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/rsc/Icon.png")));
        
//        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        //F�gt die CSS Datei des Projekts der Scene hinzu
        ui.getScene().getStylesheets().add("rsc/stylesheet.css");
        //TODO: Entscheiden, ob keine Decoration genutzt werden soll, nachfolgender Code
        //      sorgt daf�r, dass sich das Fenster (die Panes) verschieben l�sst.
        
//        //Macht das Programm ohne decorations bewegbar
//        ui.getScene().setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                xOffset = event.getSceneX();
//                yOffset = event.getSceneY();
//            }
//        });
//        ui.getScene().setOnMouseDragged(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                primaryStage.setX(event.getScreenX() - xOffset);
//                primaryStage.setY(event.getScreenY() - yOffset);
//            }
//        });
        primaryStage.show();

        homeVision.init();
        ui.setContent(homeVision.getPane());
    }

    @Override
    /**
     * Der handler zur Auswahl der UI-Ansicht.
     */
    public void handle(ActionEvent e)
    {
        if(e.getTarget() == ui.getHomeTarget())
        {
            ui.getRootPane().setCenter(homeVision.getPane());
        }
        else if(e.getTarget() == ui.getSpielTarget() && isFertig.get())
        {
            if(!turnierplanVision.isInit())
            {
                turnierplanVision.init();
            }
            ui.getRootPane().setCenter(turnierplanVision.getPane());
        }
        else if(e.getTarget() == ui.getTeilnehmerTarget() && isFertig.get())
        {
            if(!teilnehmerVision.isInit())
            {
                teilnehmerVision.init();
            }
            ui.getRootPane().setCenter(teilnehmerVision.getPane());
        }
        else if(e.getTarget() == ui.getVorlagenTarget())
        {
            if(!vorlagenVision.isInit())
            {
                vorlagenVision.init();
            }
            ui.getRootPane().setCenter(vorlagenVision.getPane());
        }
        else if(e.getTarget() == ui.getEinstellungsTarget())
        {
            //TODO: Einstellungen
        }
        else if(e.getTarget() == ui.getBeendenTarget())
        {
                
                Platform.exit();
        }
    }

    /**
     * Gibt die SimpleBooleanProperty isFertig zur�ck.
     */
    @Override
    public ReadOnlyBooleanProperty getFertig()
    {
        return isFertig;
    }

    /**
     * 
     */
    @Override
    public void notifyFertig()
    {
        ObservableList<TeilnehmerAuflistungsEintrag> list = homeVision.getEintragsListe();
        ArrayList<Mannschaft> mList = new ArrayList<Mannschaft>();
        for(int i = 0; i < list.size() - 1; i++)
        {
            TeilnehmerAuflistungsEintrag tae = list.get(i);
            mList.add(new Mannschaft(tae.getNr(), tae.getNameField().getText(), tae
                    .getVereinField().getText()));
        }
        mannschaftService = new MannschaftService(mList);
        teilnehmerVision.setMannschaftService(mannschaftService);
        turnierplanVision.setMannschaftService(mannschaftService);
        isFertig.set(true);
    }
}