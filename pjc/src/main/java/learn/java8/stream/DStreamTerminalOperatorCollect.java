package learn.java8.stream;

import learn.java8.lambda.cart.CartService;
import learn.java8.lambda.cart.Sku;
import org.junit.Before;
import org.junit.Test;
import tools.PrintStreamUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 收集器
 * collect
 */
public class DStreamTerminalOperatorCollect {

    private List<Sku> skuList;

    @Before
    public void init() {
        skuList = CartService.getCartSkuList();
    }

    /**
     * toLlist
     * Collector<? super T, A, R> collector
     */
    public void toList() {
        List<Sku> collect = skuList.stream().limit(10).collect(Collectors.toList());

    }

    /**
     * 分组 group
     * key 条件 value 元素的集合
     */
    @Test
    public void groupTest() {
        Map<Enum, List<Sku>> collect = skuList.stream()
                .collect(Collectors.groupingBy(sku -> sku.getSkuCategory()));
        PrintStreamUtil.printObject(collect);

        Map<Boolean, List<Sku>> collect1 = skuList.stream()
                .collect(Collectors.groupingBy(sku -> sku.getTotalPrice() > 100));

    }

    @Test
    /**
     * 分区 谓词 true false 分组的一个特例
     * Predicate<? super T> predicate
     * Map<Boolean, List<Sku>>
     */
    public void partition() {
        Map<Boolean, List<Sku>> collect = skuList.stream()
                .collect(Collectors.partitioningBy(sku -> sku.getTotalPrice() > 100));
        PrintStreamUtil.printObject(collect);
    }

}
