package MainMenus;


public class CancelBooking implements Command {

    @Override
    public void apply() {

    }

    @Override
    public boolean isExit() {
        return Command.super.isExit();
    }
}
