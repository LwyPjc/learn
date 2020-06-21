package learn.java8.lambda.cart;

import org.junit.Test;
import tools.PrintStreamUtil;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CartBusiService {

    /**
     * 过滤信息
     * 找出购物车所有的电子产品
     */
    @Test
    public void filterElectronicsSkus() {
        List<Sku> result = null;
        List<Sku> cartSkuList = CartService.getCartSkuList();
        result = cartSkuList.stream().filter(v -> SkuCategoryEnum.ELECTRONICS.equals(v.getSkuCategory())).collect(Collectors.toList());
        PrintStreamUtil.printObject(result);
        return;
    }

    /**
     * 根据传入参数查找
     * 类型 或 价格
     */
    @Test
    public void filterElectronicsSkusByParam() {
        Random random = new Random();
        // 价格
        double price = 2000.00;
        // 传入类型
        SkuCategoryEnum skuCategoryEnum = SkuCategoryEnum.ELECTRONICS;
        // true 类型 false 总价
        boolean flag = random.nextBoolean();

        List<Sku> cartSkuList = CartService.getCartSkuList();
        Stream<Sku> skuStream = cartSkuList.stream().filter(v -> skuCategoryEnum.equals(v.getSkuCategory()));
        PrintStreamUtil.printObject(skuStream);
    }

    @Test
    public void testFilterSkus(){
        // 匿名类测试
        List<Sku> skus = filterSkusByPredicate(new SkuPredicate() {
            @Override
            public boolean test(Sku sku) {
                return sku.getSkuPrice() > 1000;
            }
        });
        PrintStreamUtil.printObject(skus);
        System.out.println("=================");
        // lambda 代码
        List<Sku> skus1 = filterSkusByPredicate(sku -> sku.getSkuPrice() > 1000);
        PrintStreamUtil.printObject(skus1);

    }
    /**
     * 策略模式 传入算法
     */
    public List<Sku> filterSkusByPredicate(SkuPredicate skuPredicate) {
        List<Sku> result = null;
        Stream<Sku> skuStream = CartService.getCartSkuList().stream().filter(skuPredicate::test);
        return skuStream.collect(Collectors.toList());
    }
}
