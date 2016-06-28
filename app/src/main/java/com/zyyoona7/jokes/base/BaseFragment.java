package com.zyyoona7.jokes.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zyyoona7 on 2016/6/28.
 */

public abstract class BaseFragment extends SupportFragment {

    //管理观察者
    private CompositeSubscription mCompositeSubscription;
    //Unbinder对象，用来解绑ButterKnife
    private Unbinder mUnbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getContentViewID() != 0) {
            return inflater.inflate(getContentViewID(), null);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder=ButterKnife.bind(this,view);
        initViewAndEvents(view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //取消订阅观察者
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.unsubscribe();
        }
        if(mUnbinder!=null){
            //取消绑定ButterKnife
            mUnbinder.unbind();
        }
    }

    /**
     * override this method to return content view id of the fragment
     * @return
     */
    protected abstract int getContentViewID();

    /**
     * override this method to do operation in the fragment
     * 设置监听器
     * @param view
     */
    protected abstract void initViewAndEvents(View view);
}
