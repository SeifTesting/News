package com.example.seifeldenehab.news;

import android.provider.ContactsContract;

import com.example.seifeldenehab.news.Json.DataSet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {


    @GET("v2/top-headlines?sources=bbc-news&apiKey=c594ee24630f46d9a2e79c4f1a75262b")
        Call<DataSet> getData();


}
