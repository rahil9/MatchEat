package com.example.matcheat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matcheat.adapter.MyListViewAdapter;
import com.example.matcheat.adapter.MyRecyclerAdapter;
import com.example.matcheat.model.Recommendation;
import com.example.matcheat.model.RecommendationItem;
import com.example.matcheat.network.Retrofit2Client;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

//    MyRecyclerAdapter adapter;
    MyListViewAdapter adapter;
    ListView listView;
    List<RecommendationItem> list = new ArrayList<>();
    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        progressBar = findViewById(R.id.progress_bar);

//        adapter = new MyRecyclerAdapter(this, list);
        adapter = new MyListViewAdapter(this, list);
        listView = findViewById(R.id.listView);
//        listView.setHasFixedSize(true);
//        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(adapter);

        TextView cuisine = findViewById(R.id.cuisine);
        TextView rating = findViewById(R.id.rating);

        String c = getIntent().getStringExtra("cuisineInput");
        String r = getIntent().getStringExtra("ratingInput");

        cuisine.setText(c);
        rating.setText(r);

        // TODO: 16-10-2024 show loading dialog
        progressBar.setVisibility(View.VISIBLE);
        Retrofit2Client.getInstance().getApiService().getRecommendation(c, r).enqueue(new Callback<Recommendation>() {
            @Override
            public void onResponse(@NonNull Call<Recommendation> call, @NonNull Response<Recommendation> response) {
                // TODO: 16-10-2024 hide loading dialog
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    list.clear();
                    list.addAll(response.body().recommendations);
                    adapter = new MyListViewAdapter(MainActivity2.this, list);
                    listView.setAdapter(adapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            RecommendationItem item = adapter.getItem(i);
                            Toast.makeText(MainActivity2.this, item.getName(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                            intent.putExtra("restaurantName", item.getName());
                            intent.putExtra("restaurantLocation", item.getLocation());
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onFailure(@NonNull Call<Recommendation> call, @NonNull Throwable t) {
                // TODO: 16-10-2024 hide loading dialog
                progressBar.setVisibility(View.GONE);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}