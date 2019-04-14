package com.example.piclabs.photoshoptroll.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@Entity
public class UrlEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "url_id")
    private int id;

    @ColumnInfo(name = "photo_url")
    private @NonNull String url;

    @ColumnInfo(name = "photo_description")
    private @Nullable String description;

    public UrlEntity(@NonNull String url, @Nullable String description) {
        this.url = url;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getUrl() {
        return url;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(@NonNull String url) {
        this.url = url;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }
}
