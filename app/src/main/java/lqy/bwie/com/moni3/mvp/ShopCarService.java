package lqy.bwie.com.moni3.mvp;

import lqy.bwie.com.moni3.bean.Details;
import lqy.bwie.com.moni3.bean.ShopCar;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author lim
 * email:lim@123.com
 * date 2019/3/2
 * desc:
 */
public interface ShopCarService {
    @GET("commodity/v1/commodityList")
    Call<ShopCar> getShopCarDatas();

    @GET("commodity/v1/findCommodityDetailsById")
    Call<Details> getDetailsDatas(@Query("commodityId") String commodityId);

}
