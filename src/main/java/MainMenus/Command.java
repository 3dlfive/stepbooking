package MainMenus;

import java.io.FileNotFoundException;

public interface Command {
    void apply() ;
    default boolean isExit() {
        return true;
    }
}
