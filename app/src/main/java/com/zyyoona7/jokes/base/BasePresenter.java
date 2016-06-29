package com.zyyoona7.jokes.base;

import rx.Subscription;

/**
 * Created by zyyoona7 on 2016/6/28.
 */

public interface BasePresenter<T extends BaseView> {

    /**
     * 注入View，使之能够与View相互响应
     *
     * @param view
     */
    void attachView(T view);

    /**
     * 释放资源
     */
    void destroyView();

    /**
     * 在Presenter中管理观察者，需借助RxManager
     *
     * @param subscription
     */
    void addSubscription(Subscription subscription);
}
