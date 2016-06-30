package com.zyyoona7.jokes.module.imageJoke;

import com.zyyoona7.jokes.model.ImageJokeModel;
import com.zyyoona7.jokes.model.bean.ImageJoke;
import com.zyyoona7.jokes.utils.RxManager;
import com.zyyoona7.jokes.utils.TimeUtils;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by zyyoona7 on 2016/6/30.
 */

public class ChildImageJokePresenter implements ChildImageJokeContract.Presenter {

    private ChildImageJokeContract.View mView;

    private ImageJokeModel mModel;

    private RxManager mRxManager;

    //是否第一次加载
    private boolean isFirst = true;

    //是否是下拉刷新操作
    private boolean isRefresh = false;

    //当前页
    private int currentPage = 1;

    public ChildImageJokePresenter() {
        mModel = new ImageJokeModel();
        mRxManager = new RxManager();
    }

    @Override
    public void refresh(int type) {
        isRefresh = true;
        currentPage = 1;
        switch (type) {
            case 1:
                //最新
                getNewestImagJoke(currentPage);
                break;
            case 2:
                //一天前
                getImageJokeByTime(currentPage, TimeUtils.getTodayZero());
                break;
            case 3:
                //一周前
                getImageJokeByTime(currentPage, TimeUtils.getWeekZero());
                break;
            case 4:
                //一个月前
                getImageJokeByTime(currentPage, TimeUtils.getMonthZero());
                break;
        }
    }

    @Override
    public void loadMore(int type) {
        isRefresh = false;
        currentPage++;
        switch (type) {
            case 1:
                //最新
                getNewestImagJoke(currentPage);
                break;
            case 2:
                //一天前
                getImageJokeByTime(currentPage, TimeUtils.getTodayZero());
                break;
            case 3:
                //一周前
                getImageJokeByTime(currentPage, TimeUtils.getWeekZero());
                break;
            case 4:
                //一个月前
                getImageJokeByTime(currentPage, TimeUtils.getMonthZero());
                break;
        }
    }

    @Override
    public void attachView(ChildImageJokeContract.View view) {
        this.mView = view;
    }

    @Override
    public void destroyView() {
        mRxManager.unSubscibe();
    }

    @Override
    public void addSubscription(Subscription subscription) {
        mRxManager.addSubscription(subscription);
    }


    /**
     * 获取最新的ImageJoke
     *
     * @param page
     */
    public void getNewestImagJoke(int page) {
        if (isFirst) {
            mView.ShowLoading(true, "数据加载中...");
        }
        Subscription subscription = mModel.getNewestImageJoke(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<ImageJoke>>() {
                    @Override
                    public void call(List<ImageJoke> imageJokes) {
                        if (isFirst) {
                            mView.ShowLoading(false, "");
                            isFirst = false;
                        }
                        if (imageJokes != null) {
                            if (isRefresh) {
                                mView.refreshData(imageJokes);
                            } else {
                                mView.loadMoreData(imageJokes);
                            }
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.ShowError(true, "请求出错！");
                    }
                });
        mRxManager.addSubscription(subscription);
    }

    /**
     * 按时间获取ImageJoke
     *
     * @param page
     * @param time
     */
    public void getImageJokeByTime(int page, String time) {
        if (isFirst) {
            mView.ShowLoading(true, "数据加载中...");
        }
        Subscription subscription = mModel.getImageJokeByTime(page, time)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<ImageJoke>>() {
                    @Override
                    public void call(List<ImageJoke> imageJokes) {
                        if (isFirst) {
                            mView.ShowLoading(false, "");
                            isFirst = false;
                        }
                        if (imageJokes != null) {
                            if (isRefresh) {
                                mView.refreshData(imageJokes);
                            } else {
                                mView.loadMoreData(imageJokes);
                            }
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.ShowError(false, "请求出错！");
                    }
                });

        mRxManager.addSubscription(subscription);
    }
}
