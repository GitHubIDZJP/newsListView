package com.android.newslistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.newslistview.adapter.NewsItemListAdapter;
import com.android.newslistview.config.ApiConfig;
import com.android.newslistview.config.httpApi.HttpApi;
import com.android.newslistview.config.httpProvider.HttpProvider;
import com.android.newslistview.view.activity.NewsDetailsActivity;
import com.android.newslistview.vo.request.news.ListNewsResVO;
import com.android.newslistview.vo.response.news.ListNewsVO;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_news)
    RecyclerView rvNews;

    private NewsItemListAdapter newsItemListAdapter;
    private ListNewsVO listNewsVO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        initView();

        ListNewsResVO resVO = new ListNewsResVO();
        resVO.setType("top");
        resVO.setKey("a1a755458cc22f129942b34904feb820");

        getNewsList(resVO);

    }

    private void initData() {
        listNewsVO = new ListNewsVO();
    }

    private void initView() {
        rvNews.setLayoutManager(new LinearLayoutManager(this));
    }


    private void initListener() {
        if (newsItemListAdapter != null) {
            newsItemListAdapter.setListener(new NewsItemListAdapter.OnItemClickListener() {
                @Override
                public void onClick(View view, int position) {
                    String detailsUrl = listNewsVO.getResult().getData().get(position).getUrl();
                    startActivity(new Intent(MainActivity.this, NewsDetailsActivity.class)
                            .putExtra("url", detailsUrl));
                }
            });
        }
    }

    private void getNewsList(ListNewsResVO resVO) {
        HttpApi httpApi = HttpProvider.http(ApiConfig.BASE_URL).create(HttpApi.class);
        httpApi.newsList(resVO.getType(), resVO.getKey())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListNewsVO>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListNewsVO resp) {
                        listNewsVO = resp;
                        newsItemListAdapter = new NewsItemListAdapter(MainActivity.this, resp);
                        rvNews.setAdapter(newsItemListAdapter);
                        initListener();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
