package table;

import comands.Command;
import comands.UnexpectedCommand;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<MenuItem> list = new ArrayList<>();

    public void add(String label, Command command) {
        list.add(new MenuItem(list.size(), label, command));
    }

    public Command listen() {
        list.forEach(item -> Console.TellHim(item.toString()));
        String answer = Console.askHim("Введіть номер пункта меню");
        Command cmd;
        try {
            int item = Integer.parseInt(answer);
            cmd = list.get(item).command();
        } catch (Exception e) {
            cmd = new UnexpectedCommand();
        }
        return cmd;
    }
}
