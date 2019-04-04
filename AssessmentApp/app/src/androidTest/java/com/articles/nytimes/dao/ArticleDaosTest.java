package com.articles.nytimes.dao;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.articles.nytimes.database.AppDataBase;
import com.articles.nytimes.database.ArticleEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;


@RunWith(AndroidJUnit4.class)
public class ArticleDaosTest {

    private AppDataBase articleDatabase;

    @Before
    public void init(){
        articleDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), AppDataBase.class).build();
    }

    @After
    public void uninit(){
        articleDatabase.close();
    }
    @Test
    public void testLoadPopularArticles(){
        List<ArticleEntity> articleEntities = new ArrayList<>();
        ArticleEntity entity = new ArticleEntity();
        entity.setId(1000);
        entity.setTitle("test");
        entity.setAuthors("test");
        entity.setPublishedDate("test");
        entity.setUrl("test");
        articleEntities.add(entity);
        articleDatabase.articleDao().saveArticles(articleEntities);
        List<ArticleEntity> articlesList =  articleDatabase.articleDao().loadArticles();
        MutableLiveData<List<ArticleEntity>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(articlesList);
        assertNotNull(articlesList);
    }

}
