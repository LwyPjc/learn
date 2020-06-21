package learn.java8.stream;

import learn.java8.lambda.cart.CartService;
import learn.java8.lambda.cart.Sku;
import org.junit.Before;
import org.junit.Test;
import tools.PrintStreamUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 流的中间
 * filter: 过滤掉不符合断言的元素
 * flatMap: 返回的是Stream<R>
 * peek 中间操作，流中元素不被改变
 * distinct 有状态操作
 * skip 有状态
 * limit 有状态
 */
public class DStreamOperator {

    private List<Sku> skuList;

    @Before
    public void init() {
        skuList = CartService.getCartSkuList();
    }

    /**
     * 将对象转为流
     */
    @Test
    public void flatMapTest() {
        skuList.stream()
                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(PrintStreamUtil::printObject);
    }

    @Test
    /**
     * 一个元素先经过中间操作 再经过forEach，才会下一轮
     */
    public void testPeekAndForEach() {
        skuList.stream()
                .map(sku -> {
                    sku.setSkuName(sku.getSkuName() + " map");
                    return sku;
                })
                .peek(sku -> System.out.println("经过peek " + sku.getSkuName()))
                .forEach(sku -> System.out.println("经过forEach " + sku.getSkuName()));
    }

    /**
     * 无状态操作后执行有状态操作
     * sorted 有状态的操作，所有元素到这边要先做一个汇总才往后走。
     */
    @Test
    public void testPeekSort() {
        skuList.stream()
                .peek(sku -> System.out.println("peek " + sku.getSkuName() + sku.getTotalPrice()))
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .forEach(sku -> System.out.println("forEach " + sku.getSkuName() + sku.getTotalPrice()));
    }

    /**
     * 去重
     * 查看有哪些分类
     */
    @Test
    public void testDistinct() {
        skuList.stream()
                .map(sku -> sku.getSkuCategory())
                .distinct()
                .forEach(PrintStreamUtil::printObject);
    }

    @Test
    /**
     * skip limit 做分页
     */
    public void test() {
        // 页数
        AtomicReference<Integer> page = new AtomicReference<>(1);
        AtomicReference<Integer> eachSize = new AtomicReference<>(3);
        skuList.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(page.get() * eachSize.get())
                .limit(eachSize.get())
                .forEach(PrintStreamUtil::printObject);
    }

}
