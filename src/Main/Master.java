package Main;

import javafx.beans.property.*;

public interface Master
{
    ReadOnlyBooleanProperty getFertig();
    void notifyFertig();
}
