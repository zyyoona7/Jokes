package com.zyyoona7.jokes.module.textJoke;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zyyoona7.jokes.R;
import com.zyyoona7.jokes.adapter.TextJokeRvAdapter;
import com.zyyoona7.jokes.base.BaseLazyFragment;
import com.zyyoona7.jokes.base.Constants;
import com.zyyoona7.jokes.model.bean.TextJoke;

import java.util.List;

import butterknife.BindView;

/**
 * Created by zyyoona7 on 2016/6/29.
 */

public class ChildTextJokeFragment extends BaseLazyFragment implements ChildTextJokeContract.View, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    private int mType = 1;

    @BindView(R.id.srl_child_text_joke)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.rv_child_text_joke)
    RecyclerView mRvTextJoke;

    private TextJokeRvAdapter mAdapter;

    private ChildTextJokeContract.Presenter mPresenter;

    public static ChildTextJokeFragment newInstance(int type) {
        ChildTextJokeFragment fragment = new ChildTextJokeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mType = getArguments().getInt("type");
        }
        mPresenter = new ChildTextJokePresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.destroyView();
    }

    @Override
    protected void onFirstUserVisible() {
        mPresenter.refresh(mType);
    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected View getLoadingTargetView() {
        return mSwipeRefreshLayout;
    }

    @Override
    protected void initViewsAndEvents(View view) {
        mRvTextJoke.setHasFixedSize(true);
        mRvTextJoke.setLayoutManager(new LinearLayoutManager(_mActivity, LinearLayoutManager.VERTICAL, false));
        mAdapter = new TextJokeRvAdapter();
        mRvTextJoke.setAdapter(mAdapter);
        mAdapter.setOnLoadMoreListener(this);
        mAdapter.openLoadMore(Constants.PAGE_SIZE, true);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_child_text_joke;
    }

    @Override
    public void onRefresh() {
        mPresenter.refresh(mType);
    }

    @Override
    public void refreshData(List<TextJoke> data) {
        mSwipeRefreshLayout.setRefreshing(false);
        mAdapter.setNewData(data);
    }

    @Override
    public void loadMoreData(List<TextJoke> data) {
        if (data.size() > 0) {
            mAdapter.notifyDataChangedAfterLoadMore(data, true);
        } else {
            mAdapter.notifyDataChangedAfterLoadMore(false);
        }
    }

    @Override
    public void ShowLoading(boolean toggle, String msg) {
        toggleShowLoading(toggle, msg);
    }

    @Override
    public void ShowEmpty(boolean toggle, String msg) {
        toggleShowEmpty(toggle, msg, null);
    }

    @Override
    public void ShowError(boolean toggle, String msg) {
        toggleShowError(toggle, msg, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //retry
            }
        });
    }

    @Override
    public void toast(String msg) {
        showToast(msg);
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.loadMore(mType);
    }
}
