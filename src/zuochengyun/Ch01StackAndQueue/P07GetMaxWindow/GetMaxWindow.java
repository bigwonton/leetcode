package zuochengyun.Ch01StackAndQueue.P07GetMaxWindow;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 */
public class GetMaxWindow {
    public int[]  getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        // 存放arr的下标，队首为当前的最大值
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length-w+1];
//        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (i - w == qmax.getFirst()) {
                qmax.pollFirst();
            }
            if (i - w + 1 >= 0) {
                res[i-w+1] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,5,4,3,3,6,7};
        System.out.println(Arrays.toString(new GetMaxWindow().getMaxWindow(arr, 3)));
    }
}
