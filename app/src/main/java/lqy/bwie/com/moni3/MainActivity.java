package lqy.bwie.com.moni3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lqy.bwie.com.moni3.fragment.OrderFragment;
import lqy.bwie.com.moni3.fragment.ShopcarFragment;
import lqy.bwie.com.moni3.fragment.ShowFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tv_show)
    TextView tvShow;
    @BindView(R.id.tv_circle)
    TextView tvCircle;
    @BindView(R.id.tv_shopcar)
    TextView tvShopcar;
    @BindView(R.id.tv_order)
    TextView tvOrder;
    @BindView(R.id.tv_mine)
    TextView tvMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ShowFragment());
        fragments.add(new ShowFragment());
        fragments.add(new ShopcarFragment());
        fragments.add(new OrderFragment());
        fragments.add(new ShowFragment());

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

    }

    @OnClick({R.id.tv_show, R.id.tv_circle, R.id.tv_shopcar, R.id.tv_order, R.id.tv_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_show:
                vp.setCurrentItem(0);
                break;
            case R.id.tv_circle:
                vp.setCurrentItem(1);
                break;
            case R.id.tv_shopcar:
                vp.setCurrentItem(2);
                break;
            case R.id.tv_order:
                vp.setCurrentItem(3);
                break;
            case R.id.tv_mine:
                vp.setCurrentItem(4);
                break;
        }
    }
}
