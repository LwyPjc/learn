package learn.algorithm;

import org.junit.Test;

/**
 * 20个人排成一圈，1到20号。
 * 从第13个人说1，说到3的人离开
 * 问: 19号 是第几个离开的？
 */
@SuppressWarnings("all")
public class Count {
    public static void main(String[] args) {
        int[] a = new int[20];
        for (int i = 0; i < 20; i++) {
            a[i] = i + 1;
        }
        int sum = 0;
        int cnt = 0;
        int index = 12;
        Integer element = 0;
        while (element != 19) {
            if (cnt == 2) {
                if (a[index] == -1) {
                    index++;
                    continue;
                }
                if (a[index] == 19) {
                    sum++;
                    break;
                } else {
                    sum++;
                    element = a[index];
                    a[index] = -1;
                    cnt = 0;
                    System.out.println("弹出" + element);
                }
            } else {
                if (a[index] != -1) {
                    cnt++;
                    index++;
                } else {
                    index++;
                }
                if (index == 20) {
                    index = 0;
                }
            }
        }
        System.out.println("19号玩家是第" + sum + "个出局的");
    }

    /**
     * 优化一下
     */
    @Test
    public void resolveMethodTwo() {
        int[] a = new int[20];
        for (int i = 0; i < 20; i++) {
            a[i] = i + 1;
        }
        int sum = 0;
        int cnt = 1; // todo 为什么等于1
        int index = 12; // 待测下标
        int element = 0;
        while (element != 19) {
            if (a[index] != -1) {
                if (cnt == 3) {
                    element = a[index];
                    a[index] = -1;
                    System.out.println("弹出" + element);
                    cnt = 1;
                    continue;
                }
                // 如果cnt!=3
                cnt++;
            }
            index = addIndex(index);
        }
    }

    /**
     * index 加一的情况
     */
    private int addIndex(int index) {
        index++;
        if (index == 20) {
            index = 0;
        }
        return index;
    }

}
