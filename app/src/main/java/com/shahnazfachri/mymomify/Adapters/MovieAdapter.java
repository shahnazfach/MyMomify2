package com.shahnazfachri.mymomify.Adapters;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class MovieAdapter<TipeData, ViewHolder extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<ViewHolder> {

    private int mLayout;
    Class<ViewHolder> mViewHolderClass;
    Class<TipeData> mModelClass;
    List<TipeData> mData;

    public MovieAdapter(int mLayout, Class<ViewHolder> mViewHolderClass, Class<TipeData> mModelClass, List<TipeData> mData) {
        this.mLayout = mLayout;
        this.mViewHolderClass = mViewHolderClass;
        this.mModelClass = mModelClass;
        this.mData = mData;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup view = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(mLayout, parent, false);

        try {
            Constructor<ViewHolder> constructor = mViewHolderClass.getConstructor(View.class);
            return constructor.newInstance(view);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TipeData model = getItem(position);
        bindView(holder, model, position);
    }

    public abstract void bindView(ViewHolder holder, TipeData model, int position);

    private TipeData getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}


