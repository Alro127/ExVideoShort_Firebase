package com.example.exvideoshort_firebase;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.exvideoshort_firebase.API.APIService;
import com.example.exvideoshort_firebase.Adapters.VideosAdapter;
import com.example.exvideoshort_firebase.Adapters.VideosFireBaseAdapter;
import com.example.exvideoshort_firebase.Models.MessageVideoModel;
import com.example.exvideoshort_firebase.Models.VideoModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Vd2 extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private VideosAdapter videosAdapter;
    private List<VideoModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        viewPager2 = findViewById(R.id.vpager);
        list = new ArrayList<>();
        getVideos();
    }

    private void getVideos() {
        APIService.serviceApi.getVideos().enqueue(new Callback<MessageVideoModel>() {
            @Override
            public void onResponse(Call<MessageVideoModel> call, Response<MessageVideoModel> response) {
                list = response.body().getResult();
                videosAdapter = new VideosAdapter(getApplicationContext(), list);
                viewPager2.setOrientation(viewPager2.ORIENTATION_VERTICAL);
                viewPager2.setAdapter(videosAdapter);
            }

            @Override
            public void onFailure(Call<MessageVideoModel> call, Throwable t) {
                Log.d("TAG", t.getMessage());
            }
        });
    }
}
