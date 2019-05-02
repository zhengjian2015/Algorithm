package com.debug;

/**
 *
 * https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9216077872269292444%22%7D&n_type=0&p_from=1
 */
public class DebugTest {
    public static void main(String[] args) {
        int i = 10;
        i++;
        int j = pp(i);
        Long.valueOf(j);
        System.out.println(j);
    }

    public static int pp(int i){
        int j = 1 + (i + 2);
        return j;
    }
}
