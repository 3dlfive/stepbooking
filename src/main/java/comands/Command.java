package comands;

public interface Command {
    void apply();
    default boolean isExit() {
        return true;
    }
}
