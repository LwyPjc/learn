package learn.java8.stream;

import com.alibaba.fastjson.JSON;
import learn.java8.lambda.cart.CartService;
import learn.java8.lambda.cart.Sku;
import learn.java8.lambda.cart.SkuCategoryEnum;
import org.junit.Test;
import tools.PrintStreamUtil;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 购物车都有什么商品
 * 图书类都可以
 * 其余商品只买两件最贵的 总价排序
 * 只需要前两件商品的名称和总价
 */
public class CStreamVsLoop {

    @Test
    public void testSort() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        sort(cartSkuList);
    }

    public void sort(List<Sku> skuList) {

        /**
         * 从大到小排噢
         */
        skuList.sort(new Comparator<Sku>() {
            /**
             *  返回为负数 o1 < o2
             * @param o1
             * @param o2
             * @return
             */
            @Override
            public int compare(Sku o1, Sku o2) {
                if (o1.getTotalPrice() > o2.getTotalPrice()) {
                    return -1;
                } else if (o1.getTotalPrice() < o2.getTotalPrice()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        PrintStreamUtil.printObject(skuList);
    }

    @Test
    public void newCartHandle() {
        // 可以在lambda表达式中使用的变量
        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0d));


        List<String> collect = CartService.getCartSkuList()
                .stream()
                .peek(sku -> System.out.println(JSON.toJSONString(sku, true)))
                .filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                .limit(2)
                // top2 总价
                .peek(sku -> money.set(money.get() + sku.getTotalPrice()))
                // top2 名称
                .map(sku -> sku.getSkuName())
                .collect(Collectors.toList());
        System.out.println(money.get());
        PrintStreamUtil.printObject(collect);
    }

}
