package leetcode;

/**
 * 反转单词
 *
 */
public class Solution557 {
    /**
     * 我思路是以空格隔开 然后再反转再合并
     *
     * 别人的思路是 遇到空格就反转前面的字符串
     */
    public String reverseWords1(String s) {
        String[] all = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < all.length; i++) {
            if (i == all.length - 1)
                res.append(reverseWord(all[i]));
            else
                res.append(reverseWord(all[i]) + " ");
        }
        return res.toString();
    }

    public String reverseWord(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        String s2 = "abc";
        String s3 = new StringBuilder(s2).reverse().toString();
        System.out.println(s3);
    }
}
