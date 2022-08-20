

public class T2044 {

    int[] nums;
    int maxOr;
    int cnt;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        this.maxOr = 0;
        this.cnt = 0;

        search(0, 0);
        return cnt;
    }

    void search(int index, int val) {
        if (index == nums.length) {
            if (val > maxOr) {
                maxOr = val;
                cnt = 1;
            } else if (val == maxOr) {
                cnt++;
            }
            return;
        }
        search(index + 1, val);
        search(index + 1, val | nums[index]);
    }

}
