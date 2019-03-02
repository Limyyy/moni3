package lqy.bwie.com.moni3.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lqy.bwie.com.moni3.R;

/**
 * author lim
 * email:lim@123.com
 * date 2019/3/2
 * desc:
 */
public class ShowFragment extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_show, container, false);
        return inflate;
    }
}
