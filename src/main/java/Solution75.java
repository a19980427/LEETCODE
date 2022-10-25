/**
 * @author qihang
 * @create 2022-10-25 下午  05:43
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        int[] countMap = new int[3];
        for (int num : nums) {
            countMap[num]++;
        }
        int index = 0;

        for (int i = 0; i < countMap.length; i++) {
            int j = index;
            while (j < index + countMap[i]) {
                nums[j++] = i;
            }
            index = j;
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 0, 2, 1, 1, 0};
        new Solution75().sortColors(a);
    }
}
