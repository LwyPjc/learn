package learn.java8.stream;

import learn.java8.lambda.cart.CartService;
import learn.java8.lambda.cart.Sku;
import org.junit.Before;
import org.junit.Test;
import tools.PrintStreamUtil;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * 流终端操作
 *
 * allMatch 所有都满足断言返回true 短路，后面的元素不再处理一下
 * anyMatch 只要有一个满足断言就返回true 短路 ....
 * noneMatch 都不满足断言返回true 短路
 *
 * 并行时，findAny可能随机返回一个
 * findFirst 短路 Optional<T>
 * findAny 短路
 *
 * max 非短路
 * min
 * count 个数
 */
public class DStreamTerminalOperator {


    private List<Sku> skuList;

    @Before
    public void init() {
        skuList = CartService.getCartSkuList();
    }

    @Test
    /**
     * 空 empty
     */
    public void findFirstTest(){
        Optional<Sku> first = skuList.stream()
                .findFirst();
        PrintStreamUtil.printObject(first);
    }

    @Test
    /**
     * max
     * min
     */
    public void maxTest(){
        OptionalDouble max = skuList.stream()
                .mapToDouble(Sku::getTotalPrice)
                .max();
        PrintStreamUtil.printObject(max);
    }

}
