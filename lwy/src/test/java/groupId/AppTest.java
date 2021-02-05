package groupId;

import com.alibaba.fastjson.JSON;
import goodbye996.lambda.demo1.sort.CartService;
import goodbye996.lambda.demo1.sort.Sku;
import org.junit.Test;
import worker.test.Hanota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous com.springsecurity.application.controller.Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void listTest(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.remove(2));
    }

    @Test
    public void hanota(){
        Hanota hanota = new Hanota();
        List<Integer> listA = new ArrayList<>();
        for (int i = 0; i<10;i++){
            listA.add(i);
        }
        List<Integer> listB = new ArrayList<>();
        List<Integer> listC = new ArrayList<>();

        hanota.hanota(listA,listB,listC);
        System.out.println("次数： "+hanota.getCount());
        System.out.println(listC.toString());
    }

    @Test
    public void test(){
        if (2000>(int)2000.01){
            System.out.println("2000.00>2000");
        }else if (2000==(int)2000.01){
            System.out.println("2000.00=2000");
        }else{
            System.out.println("2000.00<2000");
        }
    }

    @Test
    public void compareTest(){
        List<Sku> cartLists = CartService.getCartSkuList();
        Collections.sort(cartLists, new Comparator<Sku>() {
            @Override
            public int compare(Sku o1, Sku o2) {
                return o1.getSkuPrice().compareTo(o2.getSkuPrice());
            }
        });

        System.out.println(JSON.toJSONString(cartLists,true));
    }
}
