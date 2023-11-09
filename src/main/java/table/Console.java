package table;

import java.util.Scanner;

public class Console {
    private static final Scanner in = new Scanner(System.in);

    public static String readLine() {
        return in.nextLine();
    }

    public static void TellHim(String string){
        System.out.println(string);
    }

    public static String askHim(String str){
        System.out.printf("%s: ", str);
        return in.nextLine();
    }

}
