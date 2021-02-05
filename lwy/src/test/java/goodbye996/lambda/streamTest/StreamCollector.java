package goodbye996.lambda.streamTest;

import com.alibaba.fastjson.JSON;
import goodbye996.lambda.demo1.sort.CartService;
import goodbye996.lambda.demo1.sort.Sku;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 常见预定义收集器使用
 */
public class StreamCollector {

    List<Sku> cartLists = null;

    @Before
    public void getCartLists() {
        cartLists = CartService.getCartSkuList();
    }

    /**
     * 集合收集器
     */
    @Test
    public void toList() {
        List<Sku> skus = cartLists.stream()
                .filter(sku -> sku.getSkuPrice() > 100)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(skus, true));
    }

    /**
     * 分组
     */
    @Test
    public void group() {
        //Map<分组条件，结果集合>
        Map<Object, List<Sku>> map = cartLists.stream()
                .collect(Collectors.groupingBy(Sku::getSkuCategory));

        System.out.println(JSON.toJSONString(map, true));
    }

    /**
     * 分区
     */
    @Test
    public void partition() {
        Map<Boolean, List<Sku>> partition = cartLists.stream()
                .collect(Collectors.partitioningBy(sku -> sku.getSkuPrice() > 100));
        System.out.println(JSON.toJSONString(partition,true));

    }


}
