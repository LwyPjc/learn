package goodbye996.lambda.cases;

import java.util.ArrayList;
import java.util.List;

public class CaseFour {
    class Order {
        /**
         * 订单编号
         */
        private Integer orderId;
        /**
         * 账户编号
         */
        private String account;


        public Order(Integer orderId, String account) {
            this.orderId = orderId;
            this.account = account;
        }
    }

    /**
     * 模拟数据库查询
     * @param accountIds
     * @return
     */
    public List<Order> selectFromDB(List<String> accountIds) {
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            orderList.add(
                    new Order(i, accountIds.get(i % accountIds.size())));
        }
        return orderList;
    }
}
