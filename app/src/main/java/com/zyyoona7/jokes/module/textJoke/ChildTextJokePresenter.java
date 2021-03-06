package com.zyyoona7.jokes.module.textJoke;

import com.zyyoona7.jokes.model.TextJokeModel;
import com.zyyoona7.jokes.model.bean.TextJoke;
import com.zyyoona7.jokes.utils.RxManager;
import com.zyyoona7.jokes.utils.TimeUtils;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by zyyoona7 on 2016/6/29.
 */

public class ChildTextJokePresenter implements ChildTextJokeContract.Presenter {
    private static final int NEWEST = 1;
    private static final int DAY = 2;
    private static final int WEEK = 3;
    private static final int MONTH = 4;


    private ChildTextJokeContract.View mView;
    private RxManager mRxManager = new RxManager();
    private TextJokeModel mModel;

    private boolean isRefresh = false;

    private boolean isFirstIn = true;

    private int currentPage = 1;

    public ChildTextJokePresenter() {
        this.mModel = new TextJokeModel();
    }

    @Override
    public void refresh(int type) {
        isRefresh = true;
        currentPage = 1;
        switch (type) {
            case NEWEST:
                //最新
                getNewestTextJoke(currentPage);
                break;
            case DAY:
                //一天前
                getTextJokeByTime(currentPage, TimeUtils.getTodayZero());
                break;
            case WEEK:
                //一周前
                getTextJokeByTime(currentPage, TimeUtils.getWeekZero());
                break;
            case MONTH:
                //一个月前
                getTextJokeByTime(currentPage, TimeUtils.getMonthZero());
        }
    }

    @Override
    public void loadMore(int type) {
        isRefresh = false;
        currentPage++;
        switch (type) {
            case NEWEST:
                //最新
                getNewestTextJoke(currentPage);
                break;
            case DAY:
                //一天前
                getTextJokeByTime(currentPage, TimeUtils.getTodayZero());
                break;
            case WEEK:
                //一周前
                getTextJokeByTime(currentPage, TimeUtils.getWeekZero());
                break;
            case MONTH:
                //一个月前
                getTextJokeByTime(currentPage, TimeUtils.getMonthZero());
        }
    }

    @Override
    public void attachView(ChildTextJokeContract.View view) {
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
     * 获取最新的TextJoke
     * @param page
     */
    public void getNewestTextJoke(int page) {
        if (isFirstIn) {
            mView.ShowLoading(true, "数据加载中...");
        }
        Subscription subscription = mModel.getNewestTextJoke(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<TextJoke>>() {
                    @Override
                    public void call(List<TextJoke> textJokes) {
                        if (isFirstIn) {
                            mView.ShowLoading(false, "");
                            isFirstIn = false;
                        }
                        if (textJokes != null) {
                            if (isRefresh) {
                                mView.refreshData(textJokes);
                            } else {
                                mView.loadMoreData(textJokes);
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
     * 按时间获取textJoke
     * @param page
     * @param time
     */
    public void getTextJokeByTime(int page, String time) {
        if (isFirstIn) {
            mView.ShowLoading(true, "数据加载中...");
        }
        Subscription subscription = mModel.getTextJokeByTime(page, time)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<TextJoke>>() {
                    @Override
                    public void call(List<TextJoke> textJokes) {
                        if (isFirstIn) {
                            mView.ShowLoading(false, "");
                            isFirstIn = false;
                        }
                        if (textJokes != null) {
                            if (isRefresh) {
                                mView.refreshData(textJokes);
                            } else {
                                mView.loadMoreData(textJokes);
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
}
