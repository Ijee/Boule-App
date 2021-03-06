package Home;

import Main.*;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.input.*;

/**
 * Die Vision-Klasse f�r das initialisieren des Turniers zust�ndig.
 * 
 * @author Thorsten Schulz, Alexander R�ber
 *
 */
public class HomeVision extends Vision implements EventHandler<Event>
{
    private HomeVisionUI ui;

    public HomeVision(Master m)
    {
        super(m);
    }

    @Override
    /**
     * Initialisiert die HomeVisionUI.
     */
    public void init()
    {
        ui = new HomeVisionUI(master, this);

        pane = ui.getPane();
        isInit = true;
    }

    @Override
    /**
     * Der handler f�r alle UI-Aktionen der HomeVisionUI.
     */
    public void handle(Event e)
    {
        if(e.getSource() instanceof TextField && e instanceof KeyEvent)
        {
            KeyEvent k = (KeyEvent) e;
            TextField t = (TextField) e.getSource();
            ObservableList<TeilnehmerAuflistungsEintrag> liste = ui.getEintragsListe();

            if(liste.size() > 0
                    && (liste.get(liste.size() - 1).getNameField() == t || liste.get(
                            liste.size() - 1).getVereinField() == t))
            {
                if(k.getEventType() == KeyEvent.KEY_TYPED
                        && k.getCharacter().matches("\\p{Alnum}")
                        && t.getText().length() == 0)
                {
                    ui.addNewListLine();
                    ui.updateTeilnehmer(t);
                }
            }
            else if(liste.size() > 1
                    && (liste.get(liste.size() - 2).getNameField() == t || liste.get(
                            liste.size() - 2).getVereinField() == t))
            {
                if(k.getCode() == KeyCode.BACK_SPACE && t.getText().isEmpty())
                {
                    ui.deleteLastListLine();
                    ui.updateTeilnehmer(t);
                }
            }
        }
        else if(e.getSource() instanceof Button)
        {
            Button b = (Button) e.getSource();
            if(b == ui.getLadenButton())
            {
                ladeDummyListe();
            }
            else if(b == ui.getEditButon())
            {
                // TODO:MainApp sagen, dass bearbeitet werden soll
            }
            else if(b == ui.getFertigButton())
            {
                master.notifyFertig();
            }
            else
            // L�schenbutton
            {
                ui.deleteListLine(b);
                ui.updateTeilnehmer();
            }
        }
    }
    
    /**
     * Gibt die EintragsListe zur�ck zur�ck.
     * 
     * @return die EintragsListe
     */
    public ObservableList<TeilnehmerAuflistungsEintrag> getEintragsListe()
    {
        return ui.getEintragsListe();
    }
    
    /**
     * L�dt eine Dummy Liste in die TableView der HomeVisionUI, sp�ter wird diese 
     * Funktionalit�t mit einer richtigen versehen.
     */
    private void ladeDummyListe()
    {
        for(int i=0;i<=42;i++)
        {
            ui.addNewListLine(getDummy(i), "");
        }
        ui.updateTeilnehmer(ui.getEintragsListe().get(ui.getEintragsListe().size()-1).getNameField());
    }
    
    /**
     * Enth�lt eine "Liste" verschiedener Namen und gibt den jeweils angefragten zur�ck.
     * 
     * @param i der Parameter zur R�ckgabe des einzutragenden Namens
     * @return der Name
     */
    private String getDummy(int i)
    {
        switch(i)
        {
            case 0: return "Alex";
            case 1: return "Alexander";
            case 2: return "Thorsten";
            case 3: return "Toasted";
            case 4: return "Thorstyleinchen";
            case 5: return "Alexander R�ber";
            case 6: return "Thorsten Schulz";
            case 7: return "R�ber";
            case 8: return "Schulz";
            case 9: return "Hallo";
            case 10: return "Ich";
            case 11: return "Bin";
            case 12: return "Werauchimmer";
            case 13: return "Lalelu";
            case 14: return "Hustenbonbon";
            case 15: return "Kater";
            case 16: return "Meier";
            case 17: return "Alfred";
            case 18: return "Meierhoff";
            case 19: return "Tsuno";
            case 20: return "Tsiana";
            case 21: return "Ijee";
            case 22: return "Home";
            case 23: return "Main";
            case 24: return "Teilnehmer";
            case 25: return "Horacius";
            case 26: return "Turnierplan";
            case 27: return "Vorlagen";
            case 28: return "Beenden";
            case 29: return "Poule";
            case 30: return "Uebersicht";
            case 31: return "Phase";
            case 32: return "Menu";
            case 33: return "Spiel";
            case 34: return "Einstellungen";
            case 35: return "Fertig";
            case 36: return "Bearbeiten";
            case 37: return "Icon";
            case 38: return "Loeschen";
            case 39: return "Preview";
            case 40: return "Karte";
            case 41: return "DarkBlade";
            case 42: return "Trevor";
            default: return "nichts";
        }
    }
}
