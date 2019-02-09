package zuochengyun.Ch01StackAndQueue.P10MaxMin;

import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组数量
 * 要求：
 *      时间复杂度为O(N)
 */
public class P10MaxMin {
    public int getNum(int[]  arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // qmin和qmax分别维护从[i,j]之间的最小值和最大值的下标
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int res = 0; //存放符合条件的子数组个数
        int i = 0;
        int j = 0;
        for (i = 0; i < arr.length; i ++) {
            for (j = 0; j < arr.length; j++) {
                // 维护qmin
                while (!qmin.isEmpty() && arr[j] < arr[qmin.peekLast()]) {
                    qmin.pollLast();
                }
                qmin.addLast(arr[j]);

                // 维护qmax
                while (!qmax.isEmpty() && arr[j] > arr[qmax.peekLast()]) {
                    qmax.pollLast();
                }
                qmax.addLast(arr[j]);

                //检查此时是否符合条件
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                    break;
                }
            }

            //计算在以位置i开头的子数组中，符合条件的有多少个
            res += (j - i);

            //i往后移一个位置，同时，修正qmin和qmax
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
        }

        return res;
    }
}
