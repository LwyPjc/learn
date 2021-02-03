package goodbye996.lambda.streamTest;

import com.alibaba.fastjson.JSON;
import goodbye996.lambda.demo1.sort.CartService;
import goodbye996.lambda.demo1.sort.Sku;
import goodbye996.lambda.demo1.sort.SkuCategoryEnum;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class StreamVs {
    /**
     *以Stream流的方式实现需求
     */
    @Test
    public void newCartHandle(){

        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0));
        List<String> resultSkuNameLists = CartService.getCartSkuList()
                .stream()
                //打印所有商品信息
                .peek(sku-> System.out.println(JSON.toJSONString(sku,true)))
                //过滤掉图书类商品
                .filter(sku-> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                //按商品价格排序 从大到小（默认从小到大）
                .sorted(Comparator.comparing(Sku::getSkuPrice).reversed())
                //选择前两个
                .limit(2)
                //累加商品总金额
                .peek(sku->money.set(money.get()+sku.getSkuPrice()))
                //获取商品名称
                .map(sku->sku.getSkuName())
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(resultSkuNameLists,true));
        System.out.println("商品总价："+money.get());

    }
}
