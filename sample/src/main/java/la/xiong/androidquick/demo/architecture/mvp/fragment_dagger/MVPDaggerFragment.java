package la.xiong.androidquick.demo.architecture.mvp.fragment_dagger;

import android.os.Bundle;
import android.widget.TextView;

import la.xiong.androidquick.demo.R;
import la.xiong.androidquick.demo.base.mvp_dagger2.BaseTFragment;

/**
 * @author  ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class MVPDaggerFragment extends BaseTFragment<MVPDaggerPresenter> implements MVPDaggerContract.View{

    private TextView mContent;

    @Override
    protected void initInjector() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_architecture_mvp_fragment;
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        mContent = getActivity().findViewById(R.id.tv_fragment_mvp);
        mContent.setText("this is MVPDaggerFragment");
        mPresenter.initData("hello");
    }

    @Override
    public void refreshView(final String result) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mContent.setText(result);
            }
        });
    }

}
