package zuochengyun.Ch01StackAndQueue.P06ClassicHanoi;

/**
 * 经典汉诺塔问题
 */
public class P06ClassicHanoi {
    private static int count = 0;

    public static int getCount() {
        return count;
    }

    private static void move(int n, String from, String to) {
        System.out.println("第"+(++count)+"次，将第"+n+"层圆盘，从"+from+"移到"+to);
    }

    public static void hanoi(int n, String left, String mid, String right) {
        if (n == 1) {
            move(1, left, right);
        } else {
            hanoi(n - 1, left, right, mid);
            move(n, left, right);
            hanoi(n - 1, mid, left, right);
        }
    }

    public static void main(String[] args) {
        P06ClassicHanoi hanoi = new P06ClassicHanoi();
        hanoi.hanoi(3, "A", "B", "C");
        System.out.println(hanoi.getCount());

    }
}
