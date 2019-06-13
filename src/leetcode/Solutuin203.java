package leetcode;

/***
 * 203題  核心思想是把數組的索引對應字母
 */
public class Solutuin203 {
    public static void main(String[] args) {
        String s = "aavvnnccz";
        System.out.println(new Solutuin203().firstUniqChar(s));
        System.out.println(s.charAt(0) - 'a');
    }

    public int firstUniqChar(String s) {
        int[] req = new int[26];
        for (int i = 0; i < s.length(); i++)
            req[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (req[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
