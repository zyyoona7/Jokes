package com.zyyoona7.jokes.utils;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by zyyoona7 on 2016/6/29.
 */

public class ImageLoader {

    private ImageLoader() {

    }

    /**
     * 加载url的图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    /**
     * 加载drawable的图片
     *
     * @param context
     * @param resId
     * @param imageView
     */
    public static void loadImage(Context context, @DrawableRes int resId, ImageView imageView) {
        Glide.with(context)
                .load(resId)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    /**
     * 加载url图片并带有占位图
     *
     * @param context
     * @param url
     * @param placeholder 默认图片
     * @param imageView
     */
    public static void loadImage(Context context, String url, @DrawableRes int placeholder, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    /**
     * 加载url图片并带有占位图和error图
     *
     * @param context
     * @param url
     * @param placeholder
     * @param error
     * @param imageView
     */
    public static void loadImage(Context context, String url, @DrawableRes int placeholder, @DrawableRes int error, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(placeholder)
                .error(error)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    /**
     * 加载url图片并转换成圆角图片
     *
     * @param context
     * @param url
     * @param corners
     * @param imageView
     */
    public static void loadRoundImage(Context context, String url, int corners, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .bitmapTransform(new RoundedCornersTransformation(context, corners, 0))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    /**
     * 加载url图片并转换成圆形图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadCircleImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .bitmapTransform(new CropCircleTransformation(context))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    /**
     * 加载url图片并转换成正方形图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadSquareImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .bitmapTransform(new CropSquareTransformation(context))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
}
