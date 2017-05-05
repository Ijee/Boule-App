package Turnierplan.poulephase;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;

/**
 * Der PouleEintrag, welcher später vorgefertigt in das Accordion der PoulePhase
 * Vision eingefügt wird.
 * 
 * @author Thorsten Schulz, ALexander Röber
 */
public class PouleEintrag extends TitledPane
{
    private GridPane content;

    private Poule p;

    private Label spiel1M1Label;
    private Label spiel1M2Label;
    private Label spiel2M1Label;
    private Label spiel2M2Label;
    private Label spiel3M1Label;
    private Label spiel3M2Label;
    private Label spiel4M1Label;
    private Label spiel4M2Label;

    private TextField spiel1M1Field;
    private TextField spiel1M2Field;
    private TextField spiel2M1Field;
    private TextField spiel2M2Field;
    private TextField spiel3M1Field;
    private TextField spiel3M2Field;
    private TextField spiel4M1Field;
    private TextField spiel4M2Field;

    public PouleEintrag(Poule p)
    {
        super();
        setText("Poule " + (p.getNr() + 1));
        this.p = p;

        content = new GridPane();
        content.setHgap(10);
        content.setVgap(5);
        buildContent();

        setContent(content);
        this.getStyleClass().add("poule-eintrag");
    }

    /**
     * Baut den geforderten Inhalt mit Aussehen, Position, etc.
     */
    private void buildContent()
    {
        Label spielLabel1 = new Label("Spiel 1");
        spielLabel1.getStyleClass().add("poulephase-spielLabel");
        spiel1M1Label = new Label((p.getMannschaft1().getNr() + 1) + "");
        spiel1M1Field = new TextField();
        spiel1M1Field.getStyleClass().add("poulephase-textField");
        Label doppelPunkt1 = new Label(":");
        spiel1M2Field = new TextField();
        spiel1M2Field.getStyleClass().add("poulephase-textField");
        spiel1M2Label = new Label((p.getMannschaft2().getNr() + 1) + "");

        Label spielLabel2 = new Label("Spiel 2");
        spielLabel2.getStyleClass().add("poulephase-spielLabel");
        spiel2M1Label = new Label((p.getMannschaft3().getNr() + 1) + "");
        spiel2M1Field = new TextField();
        spiel2M1Field.getStyleClass().add("poulephase-textField");
        Label doppelPunkt2 = new Label(":");
        spiel2M2Field = new TextField();
        spiel2M2Field.getStyleClass().add("poulephase-textField");
        spiel2M2Label = new Label((p.getMannschaft4().getNr() + 1) + "");

        Label spielLabel3 = new Label("Spiel 3");
        spielLabel3.getStyleClass().add("poulephase-spielLabel");
        spiel3M1Label = new Label("Gewinner Spiel 1");
        spiel3M1Field = new TextField();
        spiel3M1Field.getStyleClass().add("poulephase-textField");
        Label doppelPunkt3 = new Label(":");
        spiel3M2Field = new TextField();
        spiel3M2Field.getStyleClass().add("poulephase-textField");
        spiel3M2Label = new Label("Gewinner Spiel 2");

        Label spielLabel4 = new Label("Spiel 4");
        spielLabel4.getStyleClass().add("poulephase-spielLabel");
        spiel4M1Label = new Label("Verlierer Spiel 1");
        spiel4M1Field = new TextField();
        spiel4M1Field.getStyleClass().add("poulephase-textField");
        Label doppelPunkt4 = new Label(":");
        spiel4M2Field = new TextField();
        spiel4M2Field.getStyleClass().add("poulephase-textField");
        spiel4M2Label = new Label("Verlierer Spiel 2");

        content.add(spielLabel1, 0, 0);
        content.add(spiel1M1Label, 0, 1);
        content.setHalignment(spiel1M1Label, HPos.RIGHT);
        content.add(spiel1M1Field, 1, 1);
        content.add(doppelPunkt1, 2, 1);
        content.add(spiel1M2Field, 3, 1);
        content.add(spiel1M2Label, 4, 1);

        content.add(spielLabel2, 6, 0);
        content.add(spiel2M1Label, 6, 1);
        content.setHalignment(spiel2M1Label, HPos.RIGHT);
        content.add(spiel2M1Field, 7, 1);
        content.add(doppelPunkt2, 8, 1);
        content.add(spiel2M2Field, 9, 1);
        content.add(spiel2M2Label, 10, 1);

        content.add(spielLabel3, 0, 6);
        content.add(spiel3M1Label, 0, 7);
        content.setHalignment(spiel3M1Label, HPos.RIGHT);
        content.add(spiel3M1Field, 1, 7);
        content.add(doppelPunkt3, 2, 7);
        content.add(spiel3M2Field, 3, 7);
        content.add(spiel3M2Label, 4, 7);

        content.add(spielLabel4, 6, 6);
        content.add(spiel4M1Label, 6, 7);
        content.setHalignment(spiel4M1Label, HPos.RIGHT);
        content.add(spiel4M1Field, 7, 7);
        content.add(doppelPunkt4, 8, 7);
        content.add(spiel4M2Field, 9, 7);
        content.add(spiel4M2Label, 10, 7);
    }

    /**
     * Wird später das Icon des einzelnen Eintrags von x auf ein Häckchen
     * setzen, wenn die Punktzahl korrekt eingetragen wurde
     */
    public void erledigt()
    {
        // erledigtLabel.setText("U+0041");
    }
}
