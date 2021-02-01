package groupId;

import org.junit.Test;
import worker.test.Hanota;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
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
}
