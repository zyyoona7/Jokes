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
    void toggleShowLoading(boolean toggle, String msg);

    /**
     * 切换无数据页面
     *
     * @param toggle true 切换 false 还原
     * @param msg
     */
    void toggleShowEmpty(boolean toggle, String msg);

    /**
     * 切换错误页面
     *
     * @param toggle true 切换 false 还原
     * @param msg
     */
    void toggleShowError(boolean toggle, String msg);

    /**
     * 显示通知
     * @param msg
     */
    void showToast(String msg);

}
