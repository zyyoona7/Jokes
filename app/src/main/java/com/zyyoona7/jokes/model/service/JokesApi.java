package com.zyyoona7.jokes.model.service;

import com.zyyoona7.jokes.model.bean.ImageJoke;
import com.zyyoona7.jokes.model.bean.Rand;
import com.zyyoona7.jokes.model.bean.RandomImageJoke;
import com.zyyoona7.jokes.model.bean.RandomTextJoke;
import com.zyyoona7.jokes.model.bean.Result;
import com.zyyoona7.jokes.model.bean.TextJoke;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zyyoona7 on 2016/6/29.
 */

public interface JokesApi {

    /**
     * 获取最新的文本笑话
     *
     * @param appKey
     * @param page
     * @param pagesize
     * @return
     */
    @GET("content/text.from")
    Observable<Result<List<TextJoke>>> getNewstTextJoke(@Query("key") String appKey,
                                                        @Query("page") int page,
                                                        @Query("pagesize") int pagesize);

    /**
     * 按时间获取文本笑话
     *
     * @param appKey
     * @param page
     * @param pagesize
     * @param sort
     * @param time
     * @return
     */
    @GET("content/list.from")
    Observable<Result<List<TextJoke>>> getTextJokeByTime(@Query("key") String appKey,
                                                         @Query("page") int page,
                                                         @Query("pagesize") int pagesize,
                                                         @Query("sort") String sort,
                                                         @Query("time") String time);

    /**
     * 获取最新趣图笑话
     *
     * @param appKey
     * @param page
     * @param pageSize
     * @return
     */
    @GET("img/text.from")
    Observable<Result<List<ImageJoke>>> getNewestImageJoke(@Query("key") String appKey,
                                                           @Query("page") int page,
                                                           @Query("pagesize") int pageSize);

    /**
     * 按时间获取趣图笑话
     *
     * @param appKey
     * @param page
     * @param pagesize
     * @param sort
     * @param time
     * @return
     */
    @GET("img/list.from")
    Observable<Result<List<ImageJoke>>> getImageJokeByTime(@Query("key") String appKey,
                                                           @Query("page") int page,
                                                           @Query("pagesize") int pagesize,
                                                           @Query("sort") String sort,
                                                           @Query("time") String time);

    /**
     * 获取随机文本笑话
     *
     * @param appKey
     * @return
     */
    @GET("randJoke.php")
    Observable<Rand<List<RandomTextJoke>>> getRandomTextJoke(@Query("key") String appKey);


    /**
     * 获取随机趣图
     *
     * @param appKey
     * @param type   pic
     * @return
     */
    @GET("randJoke.php")
    Observable<Rand<List<RandomImageJoke>>> getRandomImageJoke(@Query("key") String appKey,
                                                               @Query("type") String type);
}
