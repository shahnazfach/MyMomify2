package com.shahnazfachri.mymomify.view;

import android.app.Activity;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shahnazfachri.mymomify.R;
import com.shahnazfachri.mymomify.databinding.ListVideoBinding;
import com.shahnazfachri.mymomify.Models.Item;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class ListViewHolder extends RecyclerView.ViewHolder {

    private ListVideoBinding binding;

    public ListViewHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public void onBind(final Activity activity, final Item model) {

        Glide.with(activity).asBitmap()
                .load(model.getSnippet().getThumbnails().getDefault().getUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .dontAnimate()
                .into(binding.imgThumbnail);

        binding.txtTitle.setText(model.getSnippet().getTitle());
        binding.txtDescription.setText(model.getSnippet().getDescription());
        binding.btnWatch.setOnClickListener(view -> activity.startActivity(YouTubeStandalonePlayer.createVideoIntent(activity,
                "AIzaSyD-7R_0Em9W0O3n0lXo1hhiDq6keMSOgTY", model.getId().getVideoId())));

    }
}
