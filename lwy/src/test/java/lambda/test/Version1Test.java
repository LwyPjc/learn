package lambda.test;

import com.alibaba.fastjson.JSON;
import goodbye996.lambda.sort.CartService;
import goodbye996.lambda.sort.Sku;
import org.junit.Test;

import java.util.List;

public class Version1Test {

    @Test
    public void filterElectronicsSkus(){
        List<Sku> cartLists = CartService.getCartSkuList();
        List<Sku> results = CartService.filterElectronicsSkus(cartLists);

        System.out.println(JSON.toJSONString(
                results,true));

    }
}
