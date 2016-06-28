package com.zyyoona7.jokes.base;

/**
 * Created by zyyoona7 on 2016/6/28.
 */

public interface BaseView<T extends BasePresenter> {

    /**
     * 绑定presenter
     * @param presenter
     */
    void setPresenter(T presenter);

    /**
     * 显示加载进度条
     * @param msg
     */
    void showProgress(String msg);

    /**
     * 显示无数据页面
     * @param msg
     */
    void showEmpty(String msg);

    /**
     * 显示错误页面
     * @param msg
     */
    void showError(String msg);

    /**
     * 显示正常内容
     */
    void showContent();


}
