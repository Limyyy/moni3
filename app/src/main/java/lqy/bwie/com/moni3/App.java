package lqy.bwie.com.moni3;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * author lim
 * email:lim@123.com
 * date 2019/3/2
 * desc:
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
