package com.zyyoona7.jokes.model;

import com.zyyoona7.jokes.base.Constants;
import com.zyyoona7.jokes.model.bean.Result;
import com.zyyoona7.jokes.model.bean.TextJoke;
import com.zyyoona7.jokes.model.service.JokeService;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by User on 2016/6/29.
 */

public class TextJokeModel {

    public TextJokeModel() {

    }

    /**
     * 获取最新的TextJoke
     *
     * @param page
     * @return
     */
    public Observable<List<TextJoke>> getNewestTextJoke(int page) {
        return JokeService.getJokesApi().getNewstTextJoke(Constants.APPKEY, page, 20)
                .map(new Func1<Result<List<TextJoke>>, List<TextJoke>>() {
                    @Override
                    public List<TextJoke> call(Result<List<TextJoke>> listResult) {
                        return listResult.getResult().getData();
                    }
                })
                .subscribeOn(Schedulers.io());
    }

    /**
     * 获取time之前的TextJoke
     *
     * @param page
     * @param time 一天前，一周前，一个月前
     * @return
     */
    public Observable<List<TextJoke>> getTextJokeByTime(int page, String time) {
        return JokeService.getJokesApi().getTextJokeByTime(Constants.APPKEY, page, 20, Constants.DESC, time)
                .map(new Func1<Result<List<TextJoke>>, List<TextJoke>>() {
                    @Override
                    public List<TextJoke> call(Result<List<TextJoke>> listResult) {
                        return listResult.getResult().getData();
                    }
                })
                .subscribeOn(Schedulers.io());
    }
}
