package comands;


import table.Console;

public class UnexpectedCommand implements Command {
    @Override
    public void apply() {
        Console.TellHim("Ви ввели неіснуючу команду, спробуйте ще раз.");
    }
}
