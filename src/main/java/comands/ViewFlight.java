package comands;


public class ViewFlight implements Command {

    @Override
    public void apply() {

    }

    @Override
    public boolean isExit() {
        return Command.super.isExit();
    }
}
