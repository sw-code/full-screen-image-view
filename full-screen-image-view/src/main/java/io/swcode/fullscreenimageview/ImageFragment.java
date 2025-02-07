package io.swcode.fullscreenimageview;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;


public class ImageFragment extends Fragment {
    private Uri uri;
    private static final String EXTRA_URI = "EXTRA_URI";

    public static ImageFragment newInstance(Uri uri) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_URI, uri.toString());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getArguments() != null) {
            String path = getArguments().getString(EXTRA_URI);
            uri = Uri.parse(path);
        }
        View view = inflater.inflate(R.layout.full_image_item, container, false);

        if (view instanceof TouchImageView) {
            Picasso.get()
                    .load(uri)
                    .placeholder(R.drawable.loading)
                    .into((TouchImageView)view);
        }

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        FullScreenImageViewActivity activity = (FullScreenImageViewActivity) getActivity();

        if(activity != null && activity.getBackButtonConfig().hasImageViewBackIcon()&& activity.getSupportActionBar() != null) {
            ActionBar actionBar = activity.getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setTitle(null);
            actionBar.setHomeAsUpIndicator(activity.getBackButtonConfig().getImageViewBackIcon());
        }
    }
}
