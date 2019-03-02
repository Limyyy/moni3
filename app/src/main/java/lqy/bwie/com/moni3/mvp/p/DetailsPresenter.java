package lqy.bwie.com.moni3.mvp.p;

import lqy.bwie.com.moni3.DetailsActivity;
import lqy.bwie.com.moni3.bean.Details;
import lqy.bwie.com.moni3.mvp.DetailsCallback;
import lqy.bwie.com.moni3.mvp.m.DetailsModel;
import lqy.bwie.com.moni3.mvp.v.DetailsView;

/**
 * author lim
 * email:lim@123.com
 * date 2019/3/2
 * desc:
 */
public class DetailsPresenter {
    private DetailsModel mDetailsModel;
    private DetailsView mDetailsView;

    public DetailsPresenter(DetailsView detailsView) {
        mDetailsView = detailsView;
        mDetailsModel = new DetailsModel();
    }
    public void getDatas(String commodityId){
        mDetailsModel.getDatas(commodityId, new DetailsCallback() {
            @Override
            public void getDetailsDatas(Details details) {
                mDetailsView.getDetailsDatas(details);
            }
        });
    }

}
