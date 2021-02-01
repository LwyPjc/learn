package goodbye996.lambda.ImpService;

import goodbye996.lambda.service.SkuPredicate;
import goodbye996.lambda.sort.Sku;
import goodbye996.lambda.sort.SkuCategoryEnum;

/**
 * 对Sku的商品类型为图书类的判断标准
 */
public class SkuBooksCategoryPredicate implements SkuPredicate {

    @Override
    public boolean test(Sku sku) {
        return sku.getSkuCategory().equals(SkuCategoryEnum.BOOKS);
    }
}
