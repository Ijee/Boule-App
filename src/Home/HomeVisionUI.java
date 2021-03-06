package Home;

import Main.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.collections.ObservableList;
import javafx.beans.value.*;
import javafx.beans.property.*;
import javafx.geometry.Insets;

/**
 * Die UI-Klasse der HomeVision.
 * 
 * @author Thorsten Schulz, Alexander R�ber
 *
 */
public class HomeVisionUI
{
    private Master master;
    private EventHandler<Event> handler;
    private Pane content;

    private TableView<TeilnehmerAuflistungsEintrag> tableView;
    private ObservableList<TeilnehmerAuflistungsEintrag> tableList;

    private TableColumn<TeilnehmerAuflistungsEintrag, Label> nrColumn;
    private TableColumn<TeilnehmerAuflistungsEintrag, TextField> namenColumn;
    private TableColumn<TeilnehmerAuflistungsEintrag, TextField> vereinColumn;
    private TableColumn<TeilnehmerAuflistungsEintrag, Button> buttonColumn;

    private Label anzahlField;
    private Button ladenButton;
    private Button editButton;
    private Button fertigButton;
    final Tooltip buttonTooltip;

    public HomeVisionUI(Master m, EventHandler<Event> handler)
    {
        master = m;
        this.handler = handler;

        // Unterteilung der HomeVisionUI
        content = new VBox();
        content.getStyleClass().add("content");
        Pane infoPane = new VBox();
        infoPane.getStyleClass().add("infoPane");
        Pane infoPaneOben = new HBox();
        Pane infoPaneUnten = new HBox();
        infoPane.getChildren().addAll(infoPaneOben, infoPaneUnten);
        tableView = new TableView<TeilnehmerAuflistungsEintrag>();
        tableView.getStyleClass().add("tableView");
        content.getChildren().addAll(infoPane, tableView);

        // UI: Turniername
        VBox nameBox = new VBox();
        Label nameLabel = new Label("Turniername:");
        TextField nameField = new TextField();
        nameBox.setMargin(nameField, new Insets(0, 5, 0, 0));
        nameBox.getChildren().addAll(nameLabel, nameField);

        // UI: Spielart-ComboBox Auswahl
        VBox spielartBox = new VBox();
        Label spielartLabel = new Label("Spielart:");
        ArrayList<String> list = new ArrayList<String>();
        list.add("ABCD-Turnier");
        ComboBox<String> spielartComboBox = new ComboBox<String>(
                FXCollections.observableArrayList(list));
        spielartComboBox.setFocusTraversable(false);
        spielartComboBox.getSelectionModel().select("ABCD-Turnier");
        spielartBox.getChildren().addAll(spielartLabel, spielartComboBox);

        // UI: Teilnehmeranzahl
        VBox anzahlBox = new VBox();
        Label anzahlLabel = new Label("Teilnehmeranzahl:");
        anzahlField = new Label();
        anzahlField.setText("0");
        anzahlBox.getChildren().addAll(anzahlLabel, anzahlField);
        anzahlBox.setAlignment(Pos.TOP_CENTER);
        HBox.setHgrow(anzahlBox, Priority.ALWAYS);

        // UI: Datumsanzeige
        VBox datumBox = new VBox();
        // TODO: Sonst JSR-130 (Reminder)
        GregorianCalendar kalender = new GregorianCalendar();
        kalender.setTime(new Date());
        int jahr = kalender.get(Calendar.YEAR);
        int monat = (kalender.get(Calendar.MONTH) + 1);
        int datum = kalender.get(Calendar.DATE);
        Label datumLabel = new Label(datum + "." + (monat) + "." + jahr);
        datumBox.getChildren().add(datumLabel);
        datumBox.setAlignment(Pos.TOP_RIGHT);
        HBox.setHgrow(datumBox, Priority.SOMETIMES);

        infoPaneOben.getChildren().addAll(nameBox, spielartBox, anzahlBox, datumBox);

        // UI: Ortangabe
        VBox ortBox = new VBox();
        Label ortLabel = new Label("Austragungsort:");
        TextField ortField = new TextField();
        ortBox.getChildren().addAll(ortLabel, ortField);

        // UI: Laden / Bearbeiten / Fertig
        HBox buttonBox = new HBox();
        ladenButton = new Button("Laden");
        buttonBox.setMargin(ladenButton, new Insets(0, 5, 0, 0));
        ladenButton.setFocusTraversable(false);
        ladenButton.addEventFilter(ActionEvent.ACTION, handler);
        editButton = new Button("Bearbeiten");
        buttonBox.setMargin(editButton, new Insets(0, 5, 0, 0));
        editButton.setFocusTraversable(false);
        editButton.addEventHandler(ActionEvent.ACTION, handler);
        editButton.disableProperty().bind(master.getFertig().not());
        fertigButton = new Button("Fertig");
        fertigButton.setFocusTraversable(false);
        fertigButton.addEventHandler(ActionEvent.ACTION, handler);
        fertigButton.disableProperty().bind(master.getFertig());
        buttonBox.getChildren().addAll(ladenButton, editButton, fertigButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        HBox.setHgrow(buttonBox, Priority.SOMETIMES);

        infoPaneUnten.getChildren().addAll(ortBox, buttonBox);

        // UI: Teilnehmer eingeben
        tableList = FXCollections.observableArrayList();
        tableView.setEditable(false);
        tableView.setFocusTraversable(false);
        tableView.setItems(tableList);
        tableView.prefWidthProperty().bind(content.widthProperty());
        tableView.prefHeightProperty().bind(
                content.heightProperty().subtract(infoPane.getHeight()));
        
        // UI: Tabellennummer und Tooltip
        Label nrLabel = new Label("Nr.");
        nrColumn = new TableColumn<TeilnehmerAuflistungsEintrag, Label>();
        Tooltip nrTooltip = new Tooltip();
        nrTooltip.setText(
                "Die Nummer, mit welcher die Mannschaften identifiziert werden.\n");
        nrLabel.setTooltip(nrTooltip);
        nrColumn.setGraphic(nrLabel);
        nrColumn.setCellValueFactory(s -> getNewNrCell(s));
        nrColumn.setMinWidth(40);
        nrColumn.getStyleClass().add("table-column-alignment");
        nrColumn.setSortable(false);
        nrColumn.prefWidthProperty().bind(
                tableView.widthProperty().divide(10).subtract(17));

        // UI: Tabellenname und Tooltip
        Label namenLabel = new Label("Namen");
        namenColumn = new TableColumn<TeilnehmerAuflistungsEintrag, TextField>();
        Tooltip namenTooltip = new Tooltip();
        namenTooltip.setText(
                "Hier werden die Namen der Teilnehmer eingetragen. "
                + "\nDie Reihenfolge ist dabei unerheblich.\n");
        namenLabel.setTooltip(namenTooltip);
        namenColumn.setGraphic(namenLabel);
        namenColumn.setCellValueFactory(s -> getNewNamenCell(s));
        namenColumn.setSortable(false);
        namenColumn.prefWidthProperty().bind(
                tableView.widthProperty().multiply(0.45D).subtract(17));

        // UI: Tabellenverein und Tooltip
        Label vereinLabel = new Label("Verein/e");
        vereinColumn = new TableColumn<TeilnehmerAuflistungsEintrag, TextField>();
        Tooltip vereinTooltip = new Tooltip();
        vereinTooltip.setText(
                "Hier werden die zugeh�rigen Vereinnamen eingetragen.\n");
        vereinLabel.setTooltip(vereinTooltip);
        vereinColumn.setGraphic(vereinLabel);
        vereinColumn.setCellValueFactory(s -> getNewVereinCell(s));
        vereinColumn.setSortable(false);
        vereinColumn.prefWidthProperty().bind(
                tableView.widthProperty().multiply(0.45D).subtract(17));

        // UI: Tabellenbutton und Tooltip
        buttonTooltip = new Tooltip();
        buttonTooltip.setText(
                "L�scht die dazugeh�rige Zeile mit allen eingetragenen Namen und Vereinen.\n");
        buttonColumn = new TableColumn<TeilnehmerAuflistungsEintrag, Button>();
        buttonColumn.setCellValueFactory(s -> getNewButtonCell(s));
        buttonColumn.setSortable(false);
        buttonColumn.setMinWidth(48);
        tableView.getColumns().setAll(nrColumn, namenColumn, vereinColumn, buttonColumn);
        
        tableList.add(new TeilnehmerAuflistungsEintrag(handler, tableList.size()));
    }

    /**
     * 
     * 
     * @param cdf 
     * @return die simpleObjectProperty
     */
    private ObservableValue<Label> getNewNrCell(
            TableColumn.CellDataFeatures<TeilnehmerAuflistungsEintrag, Label> cdf)
    {
        SimpleObjectProperty<Label> op = new SimpleObjectProperty<Label>();
        Label l = cdf.getValue().getNrLabel();
        op.set(l);
        return op;
    }
    
    /**
     * 
     * 
     * @param cdf
     * @return die simpleObjectProperty
     */
    private ObservableValue<TextField> getNewNamenCell(
            TableColumn.CellDataFeatures<TeilnehmerAuflistungsEintrag, TextField> cdf)
    {
        SimpleObjectProperty<TextField> op = new SimpleObjectProperty<TextField>();
        TextField l = cdf.getValue().getNameField();
        op.set(l);
        return op;
    }
    
    /**
     * 
     * 
     * @param cdf
     * @return die simpleObjectProperty
     */
    private ObservableValue<TextField> getNewVereinCell(
            TableColumn.CellDataFeatures<TeilnehmerAuflistungsEintrag, TextField> cdf)
    {
        SimpleObjectProperty<TextField> op = new SimpleObjectProperty<TextField>();
        TextField l = cdf.getValue().getVereinField();
        op.set(l);
        return op;
    }
    
    /**
     * 
     * 
     * @param cdf
     * @return die simpleObjectProperty
     */
    private ObservableValue<Button> getNewButtonCell(
            TableColumn.CellDataFeatures<TeilnehmerAuflistungsEintrag, Button> cdf)
    {
        SimpleObjectProperty<Button> op = new SimpleObjectProperty<Button>();
        Button l = cdf.getValue().getLoeschenButton();
        l.setTooltip(buttonTooltip);
        op.set(l);
        return op;
    }

    /**
     * F�gt eine neue Zeile hinzu, scrollt zur neu hinzugef�gten
     * Zeile.
     */
    public void addNewListLine()
    {
        tableList.add(new TeilnehmerAuflistungsEintrag(handler, tableList.size()));
        tableView.scrollTo(tableList.size() - 1);

        // tableView.getSelectionModel().select(tableList.size()-2);
        // tableView.getFocusModel().focus(tableList.size()-2, namenColumn);
    }
    
    /**
     * F�gt eine neue Zeile hinzu, scrollt zur neu hinzugef�gten
     * Zeile.
     * 
     * @param name der Name
     * @param verein der Verein
     */
    public void addNewListLine(String name, String verein)
    {
        tableList.add(0, new TeilnehmerAuflistungsEintrag(handler, tableList.size()));
        TeilnehmerAuflistungsEintrag e = tableList.get(0);
        e.getNameField().setText(name);
        e.getVereinField().setText(verein);
        tableView.scrollTo(tableList.size() - 1);
    }

    /**
     * Entfernt die letzte Liste in der tableList.
     */
    public void deleteLastListLine()
    {
        if(tableList.size() > 1)
        {
            tableList.remove(tableList.size() - 1);
        }
    }
    
    /**
     * L�scht die gew�nschte Zeile in der TableView �ber einen Button.
     * 
     * @param der zu �bergebene Button
     */
    public void deleteListLine(Button b)
    {
        if(tableList.size() > 1)
        {
            int index = tableList.size();
            for(TeilnehmerAuflistungsEintrag tae : tableList)
            {
                if(tae.getLoeschenButton() == b)
                {
                    index = tableList.indexOf(tae);
                    break;
                }
            }

            tableList.remove(index);

            for(int i = index; i < tableList.size(); i++)
            {
                tableList.get(i).setNr(i);
            }
        }
    }

    /**
     * Aktualisiert die UI. Sollte nach �nderungen aufgerufen werden.
     */
    public void updateTeilnehmer()
    {
        updateTeilnehmer(null);
    }

    /**
     * Aktualisiert die UI und setzt danach den Fokus auf das �bergegebene
     * TextField.
     * 
     * @param textfield t
     */
    public void updateTeilnehmer(TextField t)
    {
        anzahlField.setText((tableList.size() - 1) + "");

        Node n = tableView.lookup(".scroll-bar");
        if(n instanceof ScrollBar)
        {
            Platform.runLater(new Runnable()
            {
                @Override
                public void run()
                {
                    if(t != null)
                    {
                        while(!t.isFocused())
                        {
                            t.requestFocus();
                            t.selectEnd();
                        }
                    }
                    if(((ScrollBar) n).isVisible())
                    {
                        nrColumn.prefWidthProperty().bind(
                                tableView.widthProperty().divide(10).subtract(25));
                        namenColumn.prefWidthProperty().bind(
                                tableView.widthProperty().multiply(0.45D).subtract(25));
                        vereinColumn.prefWidthProperty().bind(
                                tableView.widthProperty().multiply(0.45D).subtract(25));
                    }
                    else
                    {
                        nrColumn.prefWidthProperty().bind(
                                tableView.widthProperty().divide(10).subtract(17));
                        namenColumn.prefWidthProperty().bind(
                                tableView.widthProperty().multiply(0.45D).subtract(17));
                        vereinColumn.prefWidthProperty().bind(
                                tableView.widthProperty().multiply(0.45D).subtract(17));
                    }
                    Platform.runLater(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            if(t != null)
                            {
                                while(!t.isFocused())
                                {
                                    t.requestFocus();
                                    t.selectEnd();
                                }
                            }
                        }
                    });
                }
            });
        }
    }

    /**
     * Gibt die Eintragsliste zur�ck.
     * 
     * @return die eintragsListe
     */
    public ObservableList<TeilnehmerAuflistungsEintrag> getEintragsListe()
    {
        return tableList;
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
     * Gibt den Lade-Button zur�ck.
     * 
     * @return der ladenButton
     */
    public Button getLadenButton()
    {
        return ladenButton;
    }

    /**
     * Gibt den Edit-Button zur�ck.
     * 
     * @return der editButton
     */
    public Button getEditButon()
    {
        return editButton;
    }

    /**
     * Gibt den Fertig-Button zur�ck.
     * 
     * @return der fertigButton
     */
    public Button getFertigButton()
    {
        return fertigButton;
    }
}
