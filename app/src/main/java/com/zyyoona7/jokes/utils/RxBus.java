package com.zyyoona7.jokes.utils;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by zyyoona7 on 2016/6/28.
 */

public class RxBus {

    private static volatile RxBus mRxBus;
    //主题
    private final Subject<Object,Object> bus;

    private RxBus() {
        //SerializedSubject强制顺序发射数据
        //PublishSubject 只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者
        bus=new SerializedSubject<>(PublishSubject.create());
    }

    /**
     * 单例获取
     * @return
     */
    public static RxBus getDefault(){
        if(mRxBus==null){
            synchronized (RxBus.class){
                if(mRxBus==null){
                    mRxBus=new RxBus();
                }
            }
        }
        return mRxBus;
    }

    /**
     * 提供了一个新的事件
     * @param o
     */
    public void post(Object o){
        bus.onNext(o);
    }

   /**
     * 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
     * @param eventType
     * @param <T>
     * @return
     */
    public <T> Observable<T> toObservable(Class<T> eventType){
        return bus.ofType(eventType);
    }
}
