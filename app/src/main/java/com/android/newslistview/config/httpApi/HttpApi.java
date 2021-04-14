package com.android.newslistview.config.httpApi;


import com.android.newslistview.vo.response.news.ListNewsVO;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface HttpApi {
    @POST("toutiao/index")
    Observable<ListNewsVO> newsList(@Query("type") String type, @Query("key") String key);
}
