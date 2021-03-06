package la.xiong.androidquick.demo.architecture.mvp.activity_dagger;

import android.os.Bundle;
import android.widget.TextView;

import la.xiong.androidquick.demo.R;
import la.xiong.androidquick.demo.base.mvp_dagger2.BaseTActivity;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class MVPDaggerActivity extends BaseTActivity<MVPDaggerPresenter> implements MVPDaggerContract.View{

    private TextView mContent;
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_architecture_mvp_activity;
    }

    @Override
    protected void initInjector() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        mContent = findViewById(R.id.tv_activity_mvp);
        mContent.setText("this is MVPActivity");
        mPresenter.initData();
    }

    @Override
    public void refreshView(final String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mContent.setText(result);
            }
        });
    }

}
