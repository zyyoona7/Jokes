package com.zyyoona7.jokes.utils;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zyyoona7 on 2016/6/29.
 *
 * 管理RxJava相关代码的生命周期处理
 */

public class RxManager {

    // 管理订阅者者
    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    public RxManager() {

    }

    /**
     * 添加订阅者
     *
     * @param subscription
     */
    public void addSubscription(Subscription subscription) {
        if (mCompositeSubscription == null || mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    /**
     * 取消订阅观察者
     */
    public void unSubscibe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }
}
