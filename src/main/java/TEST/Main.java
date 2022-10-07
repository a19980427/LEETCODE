package TEST;

/**
 * @author qihang
 * @create 2022-09-13 下午  07:55
 */
//public class Main {
//
//    private long maxNum = Long.MIN_VALUE;
//    private boolean[] visited;
//    private int n;
//    private long[] arr;
//    private long[] temp;
//
//    private void init(int n, long[] arr) {
//        this.n = n;
//        this.arr = arr;
//        this.temp = new long[3];
//        visited = new boolean[n];
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        long[] arr = new long[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextLong();
//        }
//        if (n == 1) {
//            System.out.println(arr[0]);
//        }
//        if (n == 2) {
//            String v1 = String.valueOf(arr[0]) + arr[1];
//            String v2 = String.valueOf(arr[1]) + arr[0];
//
//            Long l1 = Long.parseLong(v1);
//            Long l2 = Long.parseLong(v2);
//            System.out.println(l1 > l2 ? l1 : l2);
//        }
//
//        Main main = new Main();
//        main.init(n, arr);
//        main.solution(0);
//        System.out.println(main.maxNum);
//    }
//
//    public void solution(int index) {
//        if (index == 3) {
//            String strValue = Arrays.stream(temp).boxed().map(String::valueOf).collect(Collectors.joining());
//            long longValue = Long.parseLong(strValue);
//            if (longValue > maxNum) {
//                maxNum = longValue;
//            }
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                temp[index] = arr[i];
//                solution(index + 1);
//                visited[i] = false;
//            }
//        }
//    }
//}


public class Main {
    static char[] x = {'a', 'b', 'c'};
    static char[] y = {'x', 'y', 'z'};

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((x[i] == 'a' && y[j] == 'x') || (x[i] == 'a' && y[j] == 'y')) {
                    continue;
                } else if ((x[i] == 'c' && y[j] == 'x') || (x[i] == 'c' && y[j] == 'z')) {
                    continue;
                } else if ((x[i] == 'b' && y[j] == 'y') || (x[i] == 'b' && y[j] == 'z')) {
                    continue;
                } else {
                    System.out.println(x[i] + " VS " + y[j]);
                }
            }
        }

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int rem = 0, y = 0;
        int quo = x;
        while (quo != 0) {
            rem = quo % 10;
            y = y * 10 + rem;
            quo = quo / 10;
        }
        return y == x;
    }
}