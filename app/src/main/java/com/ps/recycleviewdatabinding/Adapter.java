package com.ps.recycleviewdatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ps.recycleviewdatabinding.databinding.ActivityRowBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * RecycleView Adapter
 * Created by k-kamiya on 2018/02/19.
 */
public class Adapter extends RecyclerView.Adapter {

    private List<Model> mModels;

    /**
     * コンストラクタ
     */
    public Adapter() {
        mModels = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // DataBindingクラスの作成
        ActivityRowBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.activity_row,
                parent,
                false);

        // RootViewを取得
        View rootView = binding.getRoot();

        // RootViewのTagにDataBindingを設定
        rootView.setTag(binding);

        // RecycleViewのインスタンス生成、Abstractだたから{}が必要。。。
        // 気になるようだったら、別クラスへ！
        return new RecyclerView.ViewHolder(rootView) {};
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // ViewHolderのitemViewからonCreateViewHolderで設定したDataBindingClassを取得
        ActivityRowBinding binding = (ActivityRowBinding) holder.itemView.getTag();
        // ModelとViewのBind
        binding.setModel(getItem(position));
    }

    @Override
    public int getItemCount() {
        return mModels.size();
    }

    public void setModels(List<Model> models) {
        mModels = models;
    }

    public List<Model> getModels() {
        return mModels;
    }

    public Model getItem(int position){
        return mModels.get(position);
    }
}
