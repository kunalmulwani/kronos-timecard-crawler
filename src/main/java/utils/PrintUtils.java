package utils;

import model.enums.Colors;

/**
 * Created by kunal on 26/11/17.
 */
public class PrintUtils {
    public static void print(String msg, Colors color){
        if (color == Colors.RED)
            System.out.print((char)27 + "[31;m"+msg);
        else if(color == Colors.YELLOW)
            System.out.print((char)27 + "[33;m"+msg);
        else
            System.out.print(msg);
        //Used to clear the formating
        System.out.print((char)27 + "[0;m");
    }
}
