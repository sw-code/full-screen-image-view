package io.swcode.fullscreenimageview;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentStateAdapter {

    private List<Uri> imagesUri = new ArrayList<>();

    PagerAdapter(FragmentManager fragmentManager, List<String> images, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        for (String image : images) {
            this.imagesUri.add(Uri.parse(image));
        }
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Uri item = imagesUri.get(position);
        return ImageFragment.newInstance(item);
    }

    @Override
    public int getItemCount() {
        return imagesUri.size();
    }
}
