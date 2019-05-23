package breakely.cs.b;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Nuke2 {
    public static void main(String[] args) throws Exception{
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println(keyboard.readLine());
        String str = "";
        str = keyboard.readLine();
        while (str.length() <= 2) {
            System.out.println("your string fewer than two characters");
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            str = keyboard.readLine();
             //会读到下一行
        }
        char[] chars = str.toCharArray();
        StringBuilder sbu = new StringBuilder(str);
        System.out.println(sbu.deleteCharAt(2).toString());
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            if (i == 2)
                res+="";
            else
                res += chars[i];
        }
        System.out.println(res);
    }
}
