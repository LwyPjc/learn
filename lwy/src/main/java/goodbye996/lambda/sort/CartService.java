package goodbye996.lambda.sort;

import goodbye996.lambda.service.SkuPredicate;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车服务类
 */
public class CartService {

    //加入到购物车中
    private static List<Sku> cartSkuList = new ArrayList<Sku>() {
        {
            add(new Sku(654032, "无人机",
                    4999.00, 1, 4999.00,
                    SkuCategoryEnum.ELECTRONICS));
            add(new Sku(642934, "短袖",
                    409.00, 3, 1227.00,
                    SkuCategoryEnum.CLOTHING));

            add(new Sku(67589, "跑步机",
                    2699.00, 1, 2699.00,
                    SkuCategoryEnum.SPORTS));
            add(new Sku(644564, "Java编程思想",
                    79.80, 1, 79.80,
                    SkuCategoryEnum.BOOKS));
        }
    };

    /**
     * 获取商品信息列表
     *
     * @return
     */
    public static List<Sku> getCartSkuList() {
        return cartSkuList;
    }

    /**
     * Version 1.0.0
     * 找出购物车中所有电子产品
     *
     * @param cartSkuList
     * @return
     */
    public static List<Sku> filterElectronicsSkus(List<Sku> cartSkuList) {

        List<Sku> result = new ArrayList<>();

        for (Sku sku : cartSkuList) {
            if (sku.getSkuCategory().equals
                    (SkuCategoryEnum.ELECTRONICS)) {
                result.add(sku);
            }
        }
        return result;
    }

    /**
     * Version 2.0.0
     * 支持通过商品类型或者商品总价查找
     *
     * @param cartSkuList
     * @param categoryEnum
     * @param totalPrice
     * @param categoryOrPrice  true:根据商品类型，false:根据商品总价
     * @return
     */
    public static List<Sku> filterCart(List<Sku> cartSkuList, SkuCategoryEnum categoryEnum,
                                       Double totalPrice, boolean categoryOrPrice) {

        List<Sku> result = new ArrayList<>();
        for (Sku sku : cartSkuList) {
            if (
                    categoryOrPrice && categoryEnum.equals(sku.getSkuCategory())
                            || !categoryOrPrice && sku.getTotalPrice() > totalPrice){
                result.add(sku);
            }
        }
        return result;
    }

    /**
     * Version 3.0.0
     * 根据不同的Sku判断标准，对Sku列表进行过滤
     * @param cartSkuList
     * @param predicate - 不停的Sku判断标准策略
     * @return
     */
    public static List<Sku> filterCart(
            List<Sku> cartSkuList, SkuPredicate predicate){
        List<Sku> result = new ArrayList<>();
        for (Sku sku:cartSkuList){
            //根据不同的Sku判断标准策略，对Sku进行判断
            if (predicate.test(sku)){
                result.add(sku);
            }
        }
        return result;
    }


}

