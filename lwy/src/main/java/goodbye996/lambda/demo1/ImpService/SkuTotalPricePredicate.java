package goodbye996.lambda.demo1.ImpService;

import goodbye996.lambda.demo1.service.SkuPredicate;
import goodbye996.lambda.demo1.sort.Sku;

/**
 * 对Sku的总价是否超出2000作为判断标准
 */
public class SkuTotalPricePredicate implements SkuPredicate {

    @Override
    public boolean test(Sku sku) {
        return sku.getTotalPrice()>2000.00;
    }
}
