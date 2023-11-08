package table;

import MainMenus.Command;

public class MenuItem {
    private final int id;
    private final String label;
    private final Command command;

    public MenuItem(int id, String label, Command command) {
        this.id = id;
       this.label = label;
       this.command = command;
    }

    public Command command() {
        return command;
     }

    @Override
    public String toString() {
        return String.format("%s - %s", id, label);
    }
}
