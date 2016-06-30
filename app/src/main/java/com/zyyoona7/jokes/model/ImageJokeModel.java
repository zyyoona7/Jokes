package com.zyyoona7.jokes.model;

import com.zyyoona7.jokes.base.Constants;
import com.zyyoona7.jokes.model.bean.ImageJoke;
import com.zyyoona7.jokes.model.bean.Result;
import com.zyyoona7.jokes.model.service.JokeService;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by zyyoona7 on 2016/6/30.
 */

public class ImageJokeModel {

    public ImageJokeModel() {
    }

    /**
     * 获取最新的ImageJoke
     *
     * @param page
     * @return
     */
    public Observable<List<ImageJoke>> getNewestImageJoke(int page) {
        return JokeService.getJokesApi().getNewestImageJoke(Constants.APP_KEY, page, Constants.PAGE_SIZE)
                .map(new Func1<Result<List<ImageJoke>>, List<ImageJoke>>() {
                    @Override
                    public List<ImageJoke> call(Result<List<ImageJoke>> listResult) {
                        return listResult.getResult().getData();
                    }
                })
                .subscribeOn(Schedulers.io());
    }

    /**
     * 按时间获取ImageJoke
     *
     * @param page
     * @param time
     * @return
     */
    public Observable<List<ImageJoke>> getImageJokeByTime(int page, String time) {
        return JokeService.getJokesApi().getImageJokeByTime(Constants.APP_KEY, page, Constants.PAGE_SIZE, Constants.DESC, time)
                .map(new Func1<Result<List<ImageJoke>>, List<ImageJoke>>() {
                    @Override
                    public List<ImageJoke> call(Result<List<ImageJoke>> listResult) {
                        return listResult.getResult().getData();
                    }
                })
                .subscribeOn(Schedulers.io());
    }
}
