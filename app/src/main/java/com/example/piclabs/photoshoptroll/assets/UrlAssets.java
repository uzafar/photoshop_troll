package com.example.piclabs.photoshoptroll.assets;

import com.example.piclabs.photoshoptroll.entity.UrlEntity;

public class UrlAssets {
    private static final int FIRST_TROLL_IMAGE_ASSET_SIZE = 230;
    private static final int SECOND_TROLL_IMAGE_ASSET_SIZE = 24;

    public static UrlEntity[] getUrlEntities() {
        UrlEntity[] urlEntities = new UrlEntity[FIRST_TROLL_IMAGE_ASSET_SIZE + SECOND_TROLL_IMAGE_ASSET_SIZE];

        for(int i = 0; i < FIRST_TROLL_IMAGE_ASSET_SIZE; i++) {
            urlEntities[i] =
                    new UrlEntity("file:///android_asset/trollImage" + String.valueOf(i) + ".webp", "");
        }

        int index = 1;
        for(int i = FIRST_TROLL_IMAGE_ASSET_SIZE; i < FIRST_TROLL_IMAGE_ASSET_SIZE + SECOND_TROLL_IMAGE_ASSET_SIZE; i++) {
            urlEntities[i] =
                    new UrlEntity("file:///android_asset/trollPT" + String.valueOf(index) + ".webp", "");
            index++;
        }
        
        return urlEntities;
    }
}