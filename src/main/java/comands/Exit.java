package comands;

public class Exit implements Command {
    @Override
    public void apply() {}

    @Override
    public boolean isExit() {
        return false;
    }
}
