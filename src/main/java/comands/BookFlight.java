package comands;


public class BookFlight implements Command {
    @Override
    public void apply() {

    }

    @Override
    public boolean isExit() {
        return Command.super.isExit();
    }
}
