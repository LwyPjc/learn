package groupId;

import com.alibaba.fastjson.JSON;
import goodbye996.lambda.demo1.sort.CartService;
import goodbye996.lambda.demo1.sort.Sku;
import org.junit.Test;
import worker.test.Hanota;

import java.util.*;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous com.springsecurity.application.controller.Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void listTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.remove(2));
    }

    @Test
    public void hanota() {
        Hanota hanota = new Hanota();
        List<Integer> listA = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listA.add(i);
        }
        List<Integer> listB = new ArrayList<>();
        List<Integer> listC = new ArrayList<>();

        hanota.hanota(listA, listB, listC);
        System.out.println("次数： " + hanota.getCount());
        System.out.println(listC.toString());
    }

    @Test
    public void test() {
        if (2000 > (int) 2000.01) {
            System.out.println("2000.00>2000");
        } else if (2000 == (int) 2000.01) {
            System.out.println("2000.00=2000");
        } else {
            System.out.println("2000.00<2000");
        }
    }

    @Test
    public void compareTest() {
        List<Sku> cartLists = CartService.getCartSkuList();
        Collections.sort(cartLists, new Comparator<Sku>() {
            @Override
            public int compare(Sku o1, Sku o2) {
                return o1.getSkuPrice().compareTo(o2.getSkuPrice());
            }
        });

        System.out.println(JSON.toJSONString(cartLists, true));
    }

    @Test
    public void randomTest() {
        Random r = new Random(23);
        //设置上限为100,下限为0，为了防止除数为0，做+1操作
        int i = r.nextInt(100) + 1;
        int j = r.nextInt(100) + 1;
        float f = r.nextFloat();
        System.out.println("i = " + i + ", j = " + j + ",f = " + f);
    }

    int n = 10;

    @Test
    public void breakTest() {

        receive(n);
    }

    public void receive(int i) {
        if (i > 0) {
            if (i == 8) {
                return;
            }
            receive(--i);
            System.out.println("i = " + i);
        }
    }

    @Test
    public void arrayTest() {
        final int[] arr = {1, 2};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 2;
        }
        for (int a : arr) {
            System.out.println(a);
        }
    }

    @Test
    public void array() {
        int[] arr = new int[10];
        System.out.println(arr.length);
    }


    public boolean isValid(String s) {
        Queue<Character> queue = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{')
                queue.offer(chars[i]);
            else if (chars[i] == ')' && queue.poll() == '(')
                queue.remove();
            else if (chars[i] == ']' && queue.peek() == '[')
                queue.remove();
            else if (chars[i] == '}' && queue.peek() == '{')
                queue.remove();
        }
        if (queue.size() == 0)
            return true;
        return false;
    }

    @Test
    public void testBrace() {
        String s = "([)]";
        System.out.println(testString(s));
    }

    /**
     * leetcode 20题 有效括号
     * @param str
     * @return
     */
    public boolean testString(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            if (c=='('||c=='['||c=='{')
                stack.push(c);
            else if (stack.isEmpty()){
                return false;
            }else {
                char top = stack.pop();
                if (c==')'&&top!='(')
                    return false;
                if (c==']'&&top!='[')
                    return false;
                if (c=='}' && top!='}')
                    return false;
            }
        }
        return stack.isEmpty();

    }
}
