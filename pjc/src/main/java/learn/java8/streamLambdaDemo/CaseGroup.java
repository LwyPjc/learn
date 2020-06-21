package learn.java8.streamLambdaDemo;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;
import tools.PrintStreamUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
class Order {
    /**
     * 订单编号
     */
    private Integer orderId;
    /**
     * 账户编号
     */
    private String accountId;
}

/**
 * 案例 分组
 */
public class CaseGroup {

    /**
     * 传进账号列表 返回订单列表
     * 模拟数据库查询
     *
     * @param accountIds
     * @return
     */
    public List<Order> selectFromDB(List<String> accountIds) {
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            orderList.add(
                    new Order(i,
                            accountIds.get(i % accountIds.size())));
        }
        return orderList;
    }

    /**
     * 接口
     * accountIds
     */
    public List<Order> queryOrderByAccountIds(List<String> accountIds) {
        List<Order> orders = selectFromDB(accountIds);
        return orders;
    }

    /**
     * 分组
     */
    @Test
    public void groupBy(){
        List<String> stringList = Arrays.asList("pan", "lin", "liu","chen");
        List<Order> orders = queryOrderByAccountIds(stringList);
        // 未分组
        orders.forEach(PrintStreamUtil::printObject);

        // 使用Optional 判空
        Map<String, List<Order>> collect = Optional.ofNullable(orders)
                // 如果不为空
                .map(Collection::stream)
                // 如果为空 默认的流
                .orElseGet(Stream::empty)
                .collect(Collectors.groupingBy(order -> order.getAccountId()));
        PrintStreamUtil.printObject(collect);

    }


}
