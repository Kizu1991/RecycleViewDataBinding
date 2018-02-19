package com.ps.recycleviewdatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.ps.recycleviewdatabinding.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Adapter adapter = new Adapter();
        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));
        binding.recycleView.setAdapter(adapter);

        // 追加ボタン押下
        binding.add.setOnClickListener((v -> {
            // Model作成、わかりやすいようにPosition設定
            Model model = new Model();
            model.setTitle(
                    String.format(
                            Locale.getDefault(),
                            "タイトル = %d",
                            adapter.getItemCount() + 1)
            );

            model.setDescription(
                    String.format(
                            Locale.getDefault(),
                            "詳細 = %d",
                            adapter.getItemCount() + 1)
            );
            // Adapterに追加
            adapter.getModels().add(model);
            adapter.notifyDataSetChanged();
        }));
    }
}
