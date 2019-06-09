package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 力扣
 * 484题目
 * 第一次 思路 超出时间限制
 */
public class Solution484 {
    public List<Integer> findDisappearedNumbersOne(int[] nums) {
        Set<Integer> b = new HashSet<>();
        for (int num : nums) {
            b.add(num);
        }
        List<Integer> l = new ArrayList<>(b);
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!l.contains(i))
                res.add(i);
        }
        return res;
    }

    /**
     * 好的思路
     * 创建一个输入数组长度的数组，填充0，然后遍历输入数组
     *
     * 把输入数组的每一项的值作为创建数组的下标
     *
     * 然后遍历创建数组，其中值为0的就是没有的元素，把其下标值+1填充到返回数组中：
     * @param args
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(0);
        }
        for(int i=0;i<nums.length;i++) {
            list.set(nums[i]-1,1);
        }
        for (int i = 0; i < nums.length; i++) {
          if(list.get(i) == 0)
              res.add(i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2,2,3,1,3,1};
        List<Integer> ret = new Solution484().findDisappearedNumbers(a);
        System.out.println(ret);
    }

}
