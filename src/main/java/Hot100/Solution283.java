package Hot100;

/**
 * @author qihang
 * @create 2022-09-15 下午  09:15
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int nZeroIndex = 0;
        while (nZeroIndex < nums.length) {
            if (nums[nZeroIndex] != 0) {
                nZeroIndex++;
            } else {
                break;
            }
        }
        int index = nZeroIndex + 1;
        while (index < nums.length) {
            if (nums[index] != 0) {
                nums[nZeroIndex++] = nums[index];
            }
            index++;
        }
        for (int i = nZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        new Solution283().moveZeroes(arr);
    }
}
