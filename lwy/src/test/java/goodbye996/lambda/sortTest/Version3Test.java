package goodbye996.lambda.sortTest;

import com.alibaba.fastjson.JSON;
import goodbye996.lambda.demo1.ImpService.SkuTotalPricePredicate;
import goodbye996.lambda.demo1.sort.CartService;
import goodbye996.lambda.demo1.sort.Sku;
import org.junit.Test;

import java.util.List;

public class Version3Test {
    @Test
    public void filterTest() {
        List<Sku> cartLists = CartService.getCartSkuList();
        //过滤商品总价大于2000
        List<Sku> result = CartService.filterCart(cartLists,new SkuTotalPricePredicate());

        System.out.println(JSON.toJSONString(result,true));
    }
}
