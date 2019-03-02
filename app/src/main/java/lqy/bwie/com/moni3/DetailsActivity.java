package lqy.bwie.com.moni3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import lqy.bwie.com.moni3.bean.Details;
import lqy.bwie.com.moni3.mvp.p.DetailsPresenter;
import lqy.bwie.com.moni3.mvp.v.DetailsView;

public class DetailsActivity extends AppCompatActivity implements DetailsView {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        DetailsPresenter detailsPresenter = new DetailsPresenter(this);
        detailsPresenter.getDatas(id);

    }

    @Override
    public void getDetailsDatas(Details details) {
       // webView.setWebViewClient(new WebViewClient());
        webView.loadDataWithBaseURL(null,details.getResult().getDetails(),"text/html","utf-8",null);

        ArrayList<String> strings = new ArrayList<>();
        String picture = details.getResult().getPicture();
        String[] split = picture.split(",");
        for (int i = 0; i <split.length ; i++) {
          strings.add(split[i].toString());
        }


        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load((String)path).into(imageView);
            }
        });
        banner.setImages(strings);
        banner.start();
    }
}
