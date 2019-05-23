package breakely.cs.b;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

class OpenCommercial {

    /**
     * Prompts the user for the name X of a company (a single string), opens
     * the Web site corresponding to www.X.com, and prints the first five lines
     * of the Web page in reverse order.
     *
     * @param arg is not used.
     * @throws Exception thrown if there are any problems parsing the
     *                   user's input or opening the connection.
     */
    public static void main(String[] arg) throws Exception {

        BufferedReader keyboard;
        String inputLine;

        keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please enter the name of a company (without spaces): ");
        System.out.flush();        /* Make sure the line is printed immediately. */
        inputLine = keyboard.readLine();

        /* Replace this comment with your solution.  */
        //System.out.println(inputLine);
        String web = "http://www." + inputLine + ".com";
        URL u = new URL(web);
        InputStream ins = u.openStream();
        InputStreamReader isr = new InputStreamReader(ins);
        BufferedReader whitehouse = new BufferedReader(isr);
        int n = 0;
        String[] readLines = new String[5];
        while (n <= 4) {
            readLines[n] = whitehouse.readLine();
            n++;
        }
        for (int i = 4; i >= 0; i--) {
            System.out.println(readLines[i]);
        }
    }
}