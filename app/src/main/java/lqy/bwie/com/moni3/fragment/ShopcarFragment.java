package lqy.bwie.com.moni3.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import lqy.bwie.com.moni3.R;
import lqy.bwie.com.moni3.adapter.MyShopCarAdapter;
import lqy.bwie.com.moni3.bean.ShopCar;
import lqy.bwie.com.moni3.mvp.p.ShopCarPresenter;
import lqy.bwie.com.moni3.mvp.v.ShopCarView;

/**
 * author lim
 * email:lim@123.com
 * date 2019/3/2
 * desc:
 */
public class ShopcarFragment extends android.support.v4.app.Fragment implements ShopCarView{
    @BindView(R.id.recyclerView_shopcar)
    RecyclerView recyclerViewShopcar;
    @BindView(R.id.ck_all_shopcar)
    CheckBox ckAllShopcar;
    @BindView(R.id.tv_price_sum_shopcar)
    TextView tvPriceSumShopcar;
    @BindView(R.id.tv_settlement_shopccar)
    TextView tvSettlementShopccar;
    Unbinder unbinder;
    private List<ShopCar.ResultBean.MlssBean.CommodityListBeanXX> mCommodityList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_shopcar, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ShopCarPresenter shopCarPresenter = new ShopCarPresenter(this);
        shopCarPresenter.getDatas();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.ck_all_shopcar, R.id.tv_settlement_shopccar})
    public void onClick(View view) {
        switch (view.getId()) {
            //全选
            case R.id.ck_all_shopcar:
                if(ckAllShopcar.isChecked()){
                    for (int i = 0; i <mCommodityList.size() ; i++) {
                        ShopCar.ResultBean.MlssBean.CommodityListBeanXX commodityListBeanXX = mCommodityList.get(i);
                        if(!commodityListBeanXX.isChecked()){
                            commodityListBeanXX.setChecked(true);
                        }
                    }
                }
                break;
            //去结算
            case R.id.tv_settlement_shopccar:
                break;
        }
    }

    @Override
    public void onGetShopCarDatas(ShopCar shopCar) {
        mCommodityList = shopCar.getResult().getMlss().getCommodityList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewShopcar.setLayoutManager(linearLayoutManager);
        MyShopCarAdapter myShopCarAdapter = new MyShopCarAdapter(shopCar,getActivity());
        recyclerViewShopcar.setAdapter(myShopCarAdapter);
    }
}
