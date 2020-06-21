package learn.java8.streamLambdaDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;
import tools.PrintStreamUtil;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 交易实体模型
 */
@Data
@AllArgsConstructor
class Trade {
    // 下单价格
    private BigDecimal price;
    // 下单时间
    private LocalDateTime time;
    // 下单量
    private Integer count;
    // 下单类型：机构 / 个人
    private String type;
}

/**
 * 排序功能
 */
public class CaseSort {

    /**
     * 一段时间内的交易申请
     */
    List<Trade> trades;

    @Before
    public void init() {
        trades = new ArrayList<>();

        trades.add(new Trade(new BigDecimal(100),
                // 在当前时间的基础上添加 1 秒
                LocalDateTime.now().plusSeconds(1),
                500, "机构"));
        trades.add(new Trade(new BigDecimal(101),
                LocalDateTime.now().plusSeconds(2),
                1, "个人"));
        trades.add(new Trade(new BigDecimal(101),
                LocalDateTime.now().plusSeconds(1),
                1, "个人"));
        trades.add(new Trade(new BigDecimal(100),
                LocalDateTime.now().plusSeconds(1),
                500, "个人"));
        trades.add(new Trade(new BigDecimal(100),
                LocalDateTime.now().plusSeconds(0),
                2, "个人"));
        trades.add(new Trade(new BigDecimal(100),
                LocalDateTime.now().plusSeconds(0),
                100, "机构"));
    }

    /**
     * 排序
     */
    @Test
    public void sortTest() {
        trades.stream()
                .sorted(Comparator.comparing(
                        Trade::getCount
                        // 翻转排序
                        , Comparator.reverseOrder())
                        .thenComparing(Trade::getTime)
                        // 自定义排序 机构排在前面
                        .thenComparing(
                                Trade::getType,
                                (type1, type2) -> {
                                    if (type1.equals("机构") && "个人".equals(type2)) {
                                        return -1;
                                    } else if ("个人".equals(type1) && "机构".equals(type2)) {
                                        return 1;
                                    } else {
                                        return 0;
                                    }
                                }
                        )
                ).forEach(PrintStreamUtil::printObject);


    }
}
