package MainMenus;

public interface Command {
    void apply();
    default boolean isExit() {
        return true;
    }
}
