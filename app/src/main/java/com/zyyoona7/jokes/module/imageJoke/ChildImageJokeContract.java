package com.zyyoona7.jokes.module.imageJoke;

import com.zyyoona7.jokes.base.BasePresenter;
import com.zyyoona7.jokes.base.BaseView;
import com.zyyoona7.jokes.model.bean.ImageJoke;

import java.util.List;

/**
 * Created by zyyoona7 on 2016/6/30.
 */

public interface ChildImageJokeContract {

    interface View extends BaseView {
        /**
         * 下拉刷新更新rv
         *
         * @param data
         */
        void refreshData(List<ImageJoke> data);

        /**
         * 加载更多更新rv
         *
         * @param data
         */
        void loadMoreData(List<ImageJoke> data);
    }

    interface Presenter extends BasePresenter<View> {

        /**
         * 下拉刷新操作
         *
         * @param type
         */
        void refresh(int type);

        /**
         * 加载更多操作
         *
         * @param type
         */
        void loadMore(int type);
    }
}
