package com.example.userinterface;
/*
import androidx.annotation.RequiresApi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class feedActivity extends AppCompatActivity{


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.feed_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.logout:
                Intent intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    feedAdapter feeds;
    RecyclerView recyclerView ;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        getSupportActionBar().setTitle("Welcome");
        recyclerView=findViewById(R.id.recycle);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        getitem();
       // feeds.updatedNews(newsarray);
        feeds=new feedAdapter(newsarray,this);
        recyclerView.setAdapter(feeds);
    }
    ArrayList<Articles> newsarray = new ArrayList<>();
    private void getitem(){
        /*
        String url;
        url = "http://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=9e1ac8704e124f32ab6b70e9de3a56c8";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                            try {
                                JSONArray newsJsonArray = response.getJSONArray("articles");
                                newsarray.clear();
                                for (int i = 0; i < newsJsonArray.length(); i++) {
                                    JSONObject newsJsonObject = newsJsonArray.getJSONObject(i);
                                    news n = new news(newsJsonObject.getString("title"),
                                            newsJsonObject.getString("author"),
                                            newsJsonObject.getString("url"),
                                            newsJsonObject.getString("urlToImage"));
                                    newsarray.add(n);
                                }
                            } catch (JSONException e) {
                                Log.w(String.valueOf(7),"nahi hua"+e.getMessage());
                            }
                    }
                },
                (Response.ErrorListener) error -> {
                    NetworkResponse response = error.networkResponse;
                    if (error instanceof ServerError && response != null) {
                        try {
                            String res = new String(response.data,
                                    HttpHeaderParser.parseCharset(((NetworkResponse) response).headers, "utf-8"));
                            // Now you can use any deserializer to make sense of data
                            JSONObject obj = new JSONObject(res);
                        } catch (UnsupportedEncodingException | JSONException e1) {
                            // Couldn't properly decode data to string
                            e1.printStackTrace();
                        } // returned data is not JSONObject?

                    }
                }
        );
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    /}
}*/
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class feedActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    feedAdapter adapter;
    final  String API_KEY="d2df6a66321b4346b86d9e139b26100c";
    Button button;
    List<Articles> articles=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        recyclerView=(RecyclerView)findViewById(R.id.recycle);
        button=findViewById(R.id.refreshButton);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        final String country=getCountry();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveJson(country,API_KEY);
            }
        });
    }
    public  void retrieveJson(String country,String apiKey)
    {
        Call<Headlines> call=ApiClient.getInstance().getApi().getHeadlines(country,apiKey);
        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                if (response.isSuccessful() && response.body().getArticles()!=null){
                    articles.clear();
                    articles=response.body().getArticles();

                    adapter =new feedAdapter( articles,feedActivity.this);
                    adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {
                Log.e("ye lo"," ab to gaye "+t.getMessage());
                Toast.makeText(feedActivity.this,"There is An Error",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public String getCountry()
    {
        Locale locale=Locale.getDefault();
        String country=locale.getCountry();
        return country.toLowerCase();
    }
}
