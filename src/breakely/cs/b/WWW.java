/**
 * 伯克利分校cs61B
 */
package breakely.cs.b;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class WWW {
    public static void main(String[] args) throws Exception{
        URL u = new URL("http://www.baidu.com/");
        InputStream ins = u.openStream();
        InputStreamReader isr = new InputStreamReader(ins);
        BufferedReader whitehouse = new BufferedReader(isr);
        System.out.println(whitehouse.readLine());

    }
}
