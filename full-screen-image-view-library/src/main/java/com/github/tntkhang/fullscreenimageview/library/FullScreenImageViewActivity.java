package com.github.tntkhang.fullscreenimageview.library;

import android.os.Bundle;
import android.support.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class FullScreenImageViewActivity extends AppCompatActivity {

    private FullScreenBackButtonConfig backButtonConfig;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_touch_image_view);

        backButtonConfig = FullScreenBackButtonConfig.of(getIntent());
        if(backButtonConfig.hasImageViewBackIcon()) {
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }

        ViewPager2 viewPager = findViewById(R.id.view_pager);

        ArrayList<String> imagePaths = getIntent().getStringArrayListExtra(FullScreenParameter.URI_LIST_DATA);

        int currentPos = getIntent().getIntExtra(FullScreenParameter.IMAGE_FULL_SCREEN_CURRENT_POS, 0);

        FragmentManager manager = getSupportFragmentManager();
        PagerAdapter adapter = new PagerAdapter(manager, imagePaths, getLifecycle());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(currentPos);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public FullScreenBackButtonConfig getBackButtonConfig() {
        return backButtonConfig;
    }
}
