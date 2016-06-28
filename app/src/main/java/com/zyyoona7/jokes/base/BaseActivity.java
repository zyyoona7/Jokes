package com.zyyoona7.jokes.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by MatriMax on 2016/6/28.
 */

public abstract class BaseActivity extends SupportActivity {

    //管理观察者
    private CompositeSubscription mCompositeSubscription;
    //Unbinder对象，用来解绑ButterKnife
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentViewID() != 0) {
            setContentView(getContentViewID());
        }
        mUnbinder = ButterKnife.bind(this);
        initViewsAndEvents();
    }

    /**
     * 获取compositeSubscription对象
     *
     * @return
     */
    public CompositeSubscription getCompositeSubscription() {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        return this.mCompositeSubscription;
    }

    /**
     * 将观察者添加到compositeSubscription中
     *
     * @param s
     */
    public void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }

        this.mCompositeSubscription.add(s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消订阅观察者
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.unsubscribe();
        }
        if (mUnbinder != null) {
            //取消绑定ButterKnife
            mUnbinder.unbind();
        }
    }

    /**
     * init views and events here
     */
    protected abstract void initViewsAndEvents();

    /**
     * bind layout resource file
     */
    protected abstract int getContentViewID();
}
