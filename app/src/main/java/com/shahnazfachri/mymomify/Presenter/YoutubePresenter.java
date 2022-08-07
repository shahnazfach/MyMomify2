package com.shahnazfachri.mymomify.Presenter;

import android.content.Context;

import androidx.annotation.NonNull;

import com.shahnazfachri.mymomify.R;
import com.shahnazfachri.mymomify.Models.Videos;
import com.shahnazfachri.mymomify.service.ApiInterface;
import com.shahnazfachri.mymomify.service.ApiService;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YoutubePresenter extends Observable {

    ApiInterface apiInterface;
    String YOUTUBE_KEY;
    Context context;

    public YoutubePresenter(Context context){
        this.context = context;
        YOUTUBE_KEY = "AIzaSyD-7R_0Em9W0O3n0lXo1hhiDq6keMSOgTY";
        apiInterface = ApiService.getClient().create(ApiInterface.class);
    }

    public void getVideos(String channelID){
        Map<String, String> params = new HashMap<>();
        params.put("key", YOUTUBE_KEY);
        params.put("part","snippet,id");
        params.put("order","date");
        params.put("maxResults", "50");
        params.put("channelId", channelID);

        Call<Videos> videosCall = apiInterface.getVideos(params);
        videosCall.enqueue(new Callback<Videos>() {
            @Override
            public void onResponse(@NonNull Call<Videos> call, @NonNull Response<Videos> response) {
                Videos videos = response.body();
                notifyToObservers(videos);
            }

            @Override
            public void onFailure(@NonNull Call<Videos> call, @NonNull Throwable t) {
                notifyToObservers(null);
            }
        });
    }

    private void notifyToObservers(Videos videos){
        setChanged();
        notifyObservers(videos);
    }
}