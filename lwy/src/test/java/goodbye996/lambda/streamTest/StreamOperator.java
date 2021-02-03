package goodbye996.lambda.streamTest;

import com.alibaba.fastjson.JSON;
import goodbye996.lambda.demo1.sort.CartService;
import goodbye996.lambda.demo1.sort.Sku;
import goodbye996.lambda.demo1.sort.SkuCategoryEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamOperator {

    List<Sku> skuList = null;

    @Before
    public void init() {
        skuList = CartService.getCartSkuList();
    }

    /**
     * filter返回boolean
     * 过滤掉不符合断言判断的数据
     */
    @Test
    public void filterTest() {
        skuList.stream()
                .filter(sku -> sku.getSkuCategory().equals(SkuCategoryEnum.BOOKS))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * 输出String类型集合
     * map：将一种元素转换为另一种元素
     */
    @Test
    public void mapTest() {
        skuList.stream()
                .map(sku -> sku.getSkuName())
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * flatMap使用，将一个对象转换为流
     */
    @Test
    public void flatMapTest() {
        skuList.stream()
                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * peek()操作与foreach类似，都是对流中所有元素进行操作，
     * 但是peek是中间操作无状态的，操作完后还可以继续使用六操作，foreach是终端操作，操作完后则不能再进行流操作
     */
    @Test
    public void peek() {
        skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    @Test
    public void sort() {
        skuList.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .sorted(Comparator.comparing(Sku::getSkuPrice))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * 去重
     */
    @Test
    public void distinctTest() {
        skuList.stream()
                .map(sku -> sku.getSkuCategory())
                .distinct()
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * 跳过指定条数
     */
    @Test
    public void skipTest() {
        skuList.stream()
                .sorted(Comparator.comparing(Sku::getSkuPrice))
                //跳过前三条
                .skip(1 * 3)
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));

    }

    /**
     * 选取指定的前几条数据
     */
    @Test
    public void limitTest() {
        skuList.stream()
                .sorted(Comparator.comparing(Sku::getSkuPrice))
                //只取前几条数据
                .limit(3)
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));

    }

    /**
     * allMatch 终端操作，短路操作（当遇到不满足条件时，就返回后面的元素不会再操作）
     * 所有元素都匹配才返回true
     */
    @Test
    public void allMatch() {
        boolean match = skuList.stream()
                .allMatch(sku -> sku.getSkuPrice() > 100);

        System.out.println(match);
    }

    /**
     * anyMatch:只要有一个满足的就立刻返回
     */
    @Test
    public void anyMatch() {
        boolean match = skuList.stream()
                .anyMatch(sku -> sku.getSkuPrice() > 100);

        System.out.println(match);
    }

    /**
     * 没有元素匹配 返回true  （短路操作）
     */
    @Test
    public void noneMatch() {
        boolean match = skuList.stream()
                .noneMatch(sku -> sku.getSkuPrice() > 10_000);

        System.out.println(match);
    }

    /**
     * 找到第一个元素 返回，没有就返回空
     */
    @Test
    public void findFirst() {
        Optional<Sku> optional = skuList.stream()
                .findFirst();

        System.out.println(JSON.toJSONString(optional.get(),true));
    }

    /**
     * 找到任意一个即返回，没有就返回空
     * 与findFirst区别：再串行上两者没有区别，但是在并行上findAny会选取任意一个，每次返回的值可能不相同
     * findFirst在并行中也是选择第一个
     */
    @Test
    public void findAny() {
        Optional<Sku> optional = skuList.stream()
                .findAny();

        System.out.println(JSON.toJSONString(optional.get(),true));
    }

    @Test
    public void mapToDouble(){
//        skuList.stream()
//                .map(Sku::getTotalPrice)
//                .forEach(item-> System.out.println(item+"\n"));
    }
}
