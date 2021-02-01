package lambda.test;

import com.alibaba.fastjson.JSON;
import goodbye996.lambda.service.SkuPredicate;
import goodbye996.lambda.sort.CartService;
import goodbye996.lambda.sort.Sku;
import org.junit.Test;

import java.util.List;

/**
 * 通过匿名内部类实现条件过滤
 */
public class Version4Test {
    @Test
    public void filterTest() {
        List<Sku> cartLists = CartService.getCartSkuList();
        //过滤商品总价大于2000
        List<Sku> result = CartService.filterCart(cartLists, new SkuPredicate() {
            @Override
            public boolean test(Sku sku) {
                return sku.getTotalPrice()>1000;
            }
        });

        System.out.println(JSON.toJSONString(result,true));
    }

    /**
     * lambda表达式
     */
    @Test
    public void filterTest5() {
        List<Sku> cartLists = CartService.getCartSkuList();
        //过滤商品总价大于2000
        List<Sku> result = CartService.filterCart(cartLists, (Sku sku)->sku.getTotalPrice()>1000);

        System.out.println(JSON.toJSONString(result,true));
    }
}
