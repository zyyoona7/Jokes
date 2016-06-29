package com.zyyoona7.jokes.module.textJoke;

import com.zyyoona7.jokes.base.BasePresenter;
import com.zyyoona7.jokes.base.BaseView;
import com.zyyoona7.jokes.model.bean.TextJoke;

import java.util.List;

/**
 * Created by zyyoona7 on 2016/6/29.
 */

public interface ChildTextJokeContract {

    interface View extends BaseView {
        /**
         * 刷新数据
         *
         * @param data
         */
        void refreshData(List<TextJoke> data);

        /**
         * 添加更多的数据
         *
         * @param data
         */
        void loadMoreData(List<TextJoke> data);


    }

    interface Presenter extends BasePresenter<View> {
        /**
         * 刷新操作调用
         */
        void refresh(int type);

        /**
         * 加载更多操作调用
         */
        void loadMore(int type);
    }
}
