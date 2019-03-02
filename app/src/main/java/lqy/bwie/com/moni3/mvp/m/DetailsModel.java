package lqy.bwie.com.moni3.mvp.m;

import lqy.bwie.com.moni3.bean.Details;
import lqy.bwie.com.moni3.http.RetrofitUtil;
import lqy.bwie.com.moni3.mvp.DetailsCallback;
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
public class DetailsModel {
    public void getDatas(String commodityId, final DetailsCallback detailsCallback){
        ShopCarService api = RetrofitUtil.getInstance().createApi(ShopCarService.class);
        Call<Details> detailsDatas = api.getDetailsDatas(commodityId);
        detailsDatas.enqueue(new Callback<Details>() {
            @Override
            public void onResponse(Call<Details> call, Response<Details> response) {
                Details body = response.body();
                detailsCallback.getDetailsDatas(body);
            }

            @Override
            public void onFailure(Call<Details> call, Throwable t) {

            }
        });
    }
}
