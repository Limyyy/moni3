package lqy.bwie.com.moni3.mvp.p;

import lqy.bwie.com.moni3.bean.ShopCar;
import lqy.bwie.com.moni3.mvp.ShopCarCallback;
import lqy.bwie.com.moni3.mvp.m.ShopCarModel;
import lqy.bwie.com.moni3.mvp.v.ShopCarView;

/**
 * author lim
 * email:lim@123.com
 * date 2019/3/2
 * desc:
 */
public class ShopCarPresenter {
    private ShopCarModel mShopCarModel;
    private ShopCarView mShopCarView;

    public ShopCarPresenter(ShopCarView shopCarView) {
        mShopCarView = shopCarView;
        mShopCarModel = new ShopCarModel();
    }

    public void getDatas(){
        mShopCarModel.getDatas(new ShopCarCallback() {
            @Override
            public void onGetShopCarDatas(ShopCar shopCar) {
                mShopCarView.onGetShopCarDatas(shopCar);
            }
        });
    }
}
