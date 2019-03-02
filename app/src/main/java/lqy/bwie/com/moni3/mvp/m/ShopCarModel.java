package lqy.bwie.com.moni3.mvp.m;

import lqy.bwie.com.moni3.bean.ShopCar;
import lqy.bwie.com.moni3.http.RetrofitUtil;
import lqy.bwie.com.moni3.mvp.ShopCarCallback;
import lqy.bwie.com.moni3.mvp.ShopCarService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * author lim
 * email:lim@123.com
 * date 2019/3/2
 * desc:
 */
public class ShopCarModel {

    public void getDatas(final ShopCarCallback shopCarCallback){
        ShopCarService shopCarService = RetrofitUtil.getInstance().createApi(ShopCarService.class);
        Call<ShopCar> shopCarDatas = shopCarService.getShopCarDatas();
        shopCarDatas.enqueue(new Callback<ShopCar>() {
            @Override
            public void onResponse(Call<ShopCar> call, Response<ShopCar> response) {
                ShopCar body = response.body();
                shopCarCallback.onGetShopCarDatas(body);
            }

            @Override
            public void onFailure(Call<ShopCar> call, Throwable t) {

            }
        });
    }
}
