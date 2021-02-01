package lambda.test;

import com.alibaba.fastjson.JSON;
import goodbye996.lambda.sort.CartService;
import goodbye996.lambda.sort.Sku;
import org.junit.Test;

import java.util.List;

public class Version2Test {

    @Test
    public void filterTest() {
        List<Sku> cartLists = CartService.getCartSkuList();
        List<Sku> result = CartService.filterCart(cartLists, null, 2000.00, false);

        System.out.println(JSON.toJSONString(result,true));
    }
}
