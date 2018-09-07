/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.boning.tinnews.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.boning.tinnews.retrofit.response.News;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface NewsDao {

    @Insert
    void insertNews(News news);

    @Query("SELECT * FROM news")
    Flowable<List<News>> getAll();

    @Query("DELETE FROM news")
    void deleteAllNews();


}

