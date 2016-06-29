package com.zyyoona7.jokes.base;

/**
 * Created by zyyoona7 on 2016/6/28.
 */

public interface BaseView {

    /**
     * 切换loading页面
     * @param toggle true 切换 false 还原
     * @param msg
     */
    void ShowLoading(boolean toggle, String msg);

    /**
     * 切换无数据页面
     *
     * @param toggle true 切换 false 还原
     * @param msg
     */
    void ShowEmpty(boolean toggle, String msg);

    /**
     * 切换错误页面
     *
     * @param toggle true 切换 false 还原
     * @param msg
     */
    void ShowError(boolean toggle, String msg);

    /**
     * 显示通知
     * @param msg
     */
    void toast(String msg);

}
