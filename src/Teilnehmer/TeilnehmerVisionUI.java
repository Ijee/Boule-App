package Teilnehmer;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Die UI-Klasse für die TeilnehmerVision.
 * 
 * @author Thorsten Schulz, Alexander Röber
 *
 */
public class TeilnehmerVisionUI
{
    private Pane content;

    private MannschaftService mannschaftService;

    private ReadOnlyListProperty<Mannschaft> tableList;

    private TextField suchFeld;

    private TableView<Mannschaft> tableView;
    private TableColumn<Mannschaft, Integer> nrColumn;
    private TableColumn<Mannschaft, String> namenColumn;
    private TableColumn<Mannschaft, String> vereinColumn;

    public TeilnehmerVisionUI(MannschaftService mannschaftService)
    {
        content = new VBox();
        content.getStyleClass().add("content");

        this.mannschaftService = mannschaftService;

        suchFeld = new TextField();
        suchFeld.setFocusTraversable(false);
        suchFeld.setPromptText("Suchen...");
        suchFeld.getStyleClass().add("suchfeld");
        suchFeld.textProperty().addListener(new InvalidationListener()
        {

            @Override
            public void invalidated(Observable o)
            {
                String text = suchFeld.textProperty().get().toLowerCase();
                if(suchFeld.textProperty().get().isEmpty())
                {
                    tableView.setItems(tableList);
                }
                else
                {
                    List<Mannschaft> list = tableList
                            .stream()
                            .filter(m -> m.getNamen().toLowerCase().contains(text)
                                    || m.getVereine().toLowerCase().contains(text)
                                    || String.valueOf(m.getNr()+1).equals(text))
                            .collect(Collectors.toList());
                    tableView.setItems(FXCollections.observableList(list));
                    tableView.setPlaceholder(new Label("Keine Übereinstimmungen mit " +suchFeld.textProperty().get() + " gefunden."));
                }
            }

        });

        tableView = new TableView<Mannschaft>();

        content.getChildren().addAll(suchFeld, tableView);

        tableList = mannschaftService.getList();

        tableView.setItems(tableList);
        tableView.prefWidthProperty().bind(content.widthProperty());
        tableView.prefHeightProperty().bind(content.heightProperty().subtract(20));

        nrColumn = new TableColumn<Mannschaft, Integer>("Nr.");
        nrColumn.setCellValueFactory(s -> getNewNrCell(s));
        nrColumn.setMinWidth(40);
        nrColumn.getStyleClass().add("table-column-alignment");
        nrColumn.prefWidthProperty().bind(tableView.widthProperty().divide(10));

        namenColumn = new TableColumn<Mannschaft, String>("Namen:");
        namenColumn.setCellValueFactory(s -> getNewNamenCell(s));
        namenColumn.prefWidthProperty().bind(tableView.widthProperty().divide(3));

        vereinColumn = new TableColumn<Mannschaft, String>("Verein/e:");
        vereinColumn.setCellValueFactory(s -> getNewVereinCell(s));
        vereinColumn.prefWidthProperty().bind(namenColumn.widthProperty());

        tableView.getColumns().setAll(nrColumn, namenColumn, vereinColumn);
    }

    /**
     * 
     * 
     * @param cdf
     * @return
     */
    private ObservableValue<Integer> getNewNrCell(
            TableColumn.CellDataFeatures<Mannschaft, Integer> cdf)
    {
        SimpleObjectProperty<Integer> op = new SimpleObjectProperty<Integer>();
        int i = cdf.getValue().getNr() + 1;
        op.set(i);
        return op;
    }

    /**
     * 
     * 
     * @param cdf
     * @return
     */
    private ObservableValue<String> getNewNamenCell(
            TableColumn.CellDataFeatures<Mannschaft, String> cdf)
    {
        SimpleObjectProperty<String> op = new SimpleObjectProperty<String>();
        String s = cdf.getValue().getNamen();
        op.set(s);
        return op;
    }

    /**
     * 
     * 
     * @param cdf
     * @return
     */
    private ObservableValue<String> getNewVereinCell(
            TableColumn.CellDataFeatures<Mannschaft, String> cdf)
    {
        SimpleObjectProperty<String> op = new SimpleObjectProperty<String>();
        String s = cdf.getValue().getVereine();
        op.set(s);
        return op;
    }

    public Pane getPane()
    {
        return content;
    }
}
