package comands;


public class MyFlights implements Command {

    @Override
    public void apply() {

    }

    @Override
    public boolean isExit() {
        return Command.super.isExit();
    }
}
