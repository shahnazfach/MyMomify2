package com.shahnazfachri.mymomify.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.shahnazfachri.mymomify.R;
import com.shahnazfachri.mymomify.Adapters.MovieAdapter;
import com.shahnazfachri.mymomify.databinding.ActivityMovieBinding;
import com.shahnazfachri.mymomify.Models.Item;
import com.shahnazfachri.mymomify.Models.Videos;
import com.shahnazfachri.mymomify.Presenter.YoutubePresenter;
import com.shahnazfachri.mymomify.utils.DBHelper;
import com.shahnazfachri.mymomify.view.ListViewHolder;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MovieActivity extends AppCompatActivity implements Observer {

    String OBJECT = "OBJECT";
    String CHANNELID = "UCYn4qXEQzqghWyLl6j2DaqQ";
    ActivityMovieBinding binding;
    YoutubePresenter youtubePresenter;
    DBHelper simpleDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie);

        simpleDB = new DBHelper(this);
        youtubePresenter = new YoutubePresenter(this);
        youtubePresenter.addObserver(this);
        youtubePresenter.getVideos(CHANNELID);

        setToolbar();
        setCacheData();
    }

    void setCacheData(){
        Videos videos = simpleDB.getObject(OBJECT, Videos.class);
        if (videos != null){
            setListVideos(videos.getItems());
        }
    }

    void setToolbar(){
        setSupportActionBar(binding.toolbar);
    }

    void setListVideos(List<Item> items){
        binding.progressbar.setVisibility(View.GONE);
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        MovieAdapter<Item, ListViewHolder> adapter;

        adapter = new MovieAdapter<Item, ListViewHolder>(R.layout.list_video, ListViewHolder.class, Item.class, items) {
            @Override
            public void bindView(ListViewHolder holder, Item model, int position) {
                holder.onBind(MovieActivity.this, model);
            }
        };

        binding.list.setLayoutManager(manager);
        binding.list.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        youtubePresenter.deleteObserver(this);
        super.onDestroy();
    }

    @Override
    public void update(Observable observable, Object o) {

        if (o == null){
            Toast.makeText(this, "Koneksi gagal!", Toast.LENGTH_LONG).show();
            return;
        }

        Videos videos = (Videos) o;
        simpleDB.putObject(OBJECT, videos);
        setListVideos(videos.getItems());
    }
}