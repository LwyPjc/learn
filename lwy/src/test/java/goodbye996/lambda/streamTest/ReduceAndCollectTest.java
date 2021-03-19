package goodbye996.lambda.streamTest;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 归约与汇总操作
 */
public class ReduceAndCollectTest {

    @Test
    public void reduceTest() {
        /**
         * 订单对象
         */
        //TODO：为什么注解没有效果呢
//        @Data
//        @AllArgsConstructor
        class Order {
            //订单编号
            private Integer id;

            //商品数量
            private Integer productCount;

            //消费总金额
            private Double totalAmount;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getProductCount() {
                return productCount;
            }

            public void setProductCount(Integer productCount) {
                this.productCount = productCount;
            }

            public Double getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(Double totalAmount) {
                this.totalAmount = totalAmount;
            }

            public Order(Integer id, Integer productCount, Double totalAmount) {
                this.id = id;
                this.productCount = productCount;
                this.totalAmount = totalAmount;
            }
        }

        /**
         * 准备数据
         */
        List<Order> list = new ArrayList<>();
        list.add(new Order(1, 2, 25.12));
        list.add(new Order(2, 5, 257.23));
        list.add(new Order(3, 3, 23332.12));


        //汇总商品数量和总金额
        Order order = list.stream()
                //开启并行
                .parallel()
                .reduce(new Order(0, 0, 0.0),
                        (Order order1, Order order2) -> {
                            System.out.println("执行 计算逻辑 方法！！！");

                            int totalProducts = order1.getProductCount() + order2.getProductCount();
                            double totalAmount = order2.getTotalAmount() +
                                    order1.getTotalAmount();
                            return new Order(0, totalProducts, totalAmount);
                        }, (Order order1, Order order2) -> {
                            System.out.println("执行 计算逻辑 方法！！！");

                            int totalProducts = order1.getProductCount() + order2.getProductCount();
                            Double totalAmount = order2.getTotalAmount() +
                                    order1.getTotalAmount();
                            return new Order(0, totalProducts, totalAmount);
                        });

        System.out.println(JSON.toJSONString(order, true));
    }

    @Test
    public void collectTest() {

        class Order {
            //订单编号
            private Integer id;

            //用户账号
            private String username;
            //商品数量
            private Integer productCount;

            //消费总金额
            private Double totalAmount;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getProductCount() {
                return productCount;
            }

            public void setProductCount(Integer productCount) {
                this.productCount = productCount;
            }

            public Double getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(Double totalAmount) {
                this.totalAmount = totalAmount;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public Order(Integer id, String username, Integer productCount, Double totalAmount) {
                this.id = id;
                this.username = username;
                this.productCount = productCount;
                this.totalAmount = totalAmount;
            }
        }

        /**
         * 准备数据
         */
        List<Order> list = new ArrayList<>();
        list.add(new Order(1, "zhangsan", 2, 25.12));
        list.add(new Order(2, "zhangsan", 5, 257.23));
        list.add(new Order(3, "lisi", 3, 23332.12));

        list.stream()
                .collect(
                        () -> {
                            System.out.println("执行 初始化同期 操作！！！");
                            return new HashMap<String, Order>();
                        },
                        (HashMap<String, Order> map, Order newOrder) -> {
                            System.out.println("执行 新元素添加到容器！！！");
                            /**
                             * 如果此账号已存在，将新订单数据加上
                             */
                            if (map.containsKey(newOrder.getUsername())) {
                                Order order = map.get(newOrder.getUsername());
                                order.setProductCount(order.getProductCount() + newOrder.getProductCount());
                                order.setTotalAmount(order.getTotalAmount() + newOrder.getTotalAmount());
                            } else {
                                map.put(newOrder.getUsername(), newOrder);
                            }
                        }, (HashMap<String, Order> map1, HashMap<String, Order> map2) -> {
                            System.out.println("执行并行结果合并操作！！");
                            map2.forEach((key, value) -> {
                                //TODO:注意一定要用map1做合并，因为最后返回的collect是map1
                                map1.merge(key, value, (order1, order2) -> {
                                    return new Order(0, key, order1.getProductCount() + order2.getProductCount(),
                                            order1.getTotalAmount() + order2.getTotalAmount());
                                });
                            });
                        });


    }
}
