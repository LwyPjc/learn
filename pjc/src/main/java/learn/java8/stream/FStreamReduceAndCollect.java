package learn.java8.stream;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;
import tools.PrintStreamUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * 订单对象
 */
@AllArgsConstructor
@Getter
@Setter
class Order {
    private Integer id;

    private Integer productCount;

    private Double totalAmount;
}

/**
 * 订单Collect对象
 */
@AllArgsConstructor
@Getter
@Setter
class OrderCollect {
    private Integer id;

    private Integer productCount;

    private Double totalAmount;

    private String account;
}

/**
 * 规约与汇总操作
 */
public class FStreamReduceAndCollect {

    ArrayList<Order> orderArrayList = new ArrayList<Order>() {
        {
            add(new Order(1, 2, 25.32));
            add(new Order(2, 5, 345.77));
            add(new Order(3, 6, 876.55));
        }
    };

    ArrayList<OrderCollect> orderCollectArrayList = new ArrayList<OrderCollect>() {
        {
            add(new OrderCollect(1, 2, 25.32, "pan"));
            add(new OrderCollect(2, 5, 345.77, "pan"));
            add(new OrderCollect(3, 6, 876.55, "pan"));
            add(new OrderCollect(4, 5, 276.55, "lin"));
            add(new OrderCollect(5, 7, 6676.55, "lin"));
            add(new OrderCollect(6, 2, 8796.55, "lin"));

        }
    };

    @Test
    /**
     *
     * reduce 三参数
     * 计算总价
     */
    public void reduceTest() {
        Order reduce = orderArrayList.stream()
                // 并行处理 才会执行reduce的第三个参数
                .parallel()
                .reduce(
                        // 初始化值
                        new Order(0, 0, 0.0),
                        // 流中两个元素的计算逻辑
                        (o1, o2) -> {
                            System.out.println("执行 逻辑计算");
                            int productAcount = o1.getProductCount() + o2.getProductCount();
                            double total = o1.getTotalAmount() + o2.getTotalAmount();
                            return new Order(0, productAcount, total);
                        },
                        // 并行情况下多个结果如何合并,非并行情况下下面的不会执行
                        (o1, o2) -> {
                            System.out.println("执行并行计算");
                            int productAcount = o1.getProductCount() + o2.getProductCount();
                            double total = o1.getTotalAmount() + o2.getTotalAmount();
                            return new Order(0, productAcount, total);
                        }
                );
        PrintStreamUtil.printObject(reduce);
    }

    @Test
    /**
     * 按用户计算平均商品价格--返回map
     * Map<账号，订单（数量，price）>
     * collect 汇总操作
     *     <R> R collect(
     *     Supplier<R> supplier, 初始化结果集
     *     BiConsumer<R, ? super T> accumulator, 添加元素到结果容器逻辑
     *     BiConsumer<R, R> combiner 并行执行时多个结果容器的合并方式
     *     );
     */
    public void testCollect() {
        HashMap<String, OrderCollect> collect = orderCollectArrayList.stream()
                .parallel()
                .collect(
                        () -> {
                            // 并行时下面的那行会做多次，多个map做合并
                            System.out.println("初始化容器操作");
                            return new HashMap<String, OrderCollect>();
                        },
                        /**
                         * 新元素的account 是否加和
                         */
                        (HashMap<String, OrderCollect> map, OrderCollect newOrderCollect) -> {
                            System.out.println("添加元素操作");
                            String account = newOrderCollect.getAccount();
                            if (map.containsKey(account)) {
                                OrderCollect orderCollect = map.get(account);
                                orderCollect.setProductCount(orderCollect.getProductCount() + newOrderCollect.getProductCount());
                                orderCollect.setTotalAmount(orderCollect.getTotalAmount() + newOrderCollect.getTotalAmount());
                            } else {
                                // 如果不存在
                                map.put(account, newOrderCollect);
                            }
                        },
                        // 如果并行了，两个集合如何做合并
                        (HashMap<String, OrderCollect> map1, HashMap<String, OrderCollect> map2) -> {
                            map1.forEach((key, value) -> {
                                        System.out.println("合并操作");
                                        // TODO: 一定要用 第一个参数 做 merge,返回的是第一个参数，来与之后的map做合并
                                        // 如果两个key一样，如何计算 合并
                                        map2.merge(key, value, (orderCollect1, orderCollect2) -> {
                                            return new OrderCollect(0, orderCollect1.getProductCount() + orderCollect2.getProductCount(), orderCollect1.getTotalAmount() + orderCollect2.getTotalAmount(), key);
                                        });
                                    }
                            );
                        }
                );
        PrintStreamUtil.printObject(collect);
    }


    @Test
    /**
     * Collector 接口
     * <R, A> R collect(Collector<? super T, A, R> collector);
     *
     */
    public void collectorTest(){
        orderCollectArrayList.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
