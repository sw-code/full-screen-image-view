# full-screen-image-view-library
This is a library to help developer faster on view an image full screen which has some gesture like double tap to zoom, span, zoom in/out, move.
Fork of [tntkhang/full-screen-image-view](https://github.com/tntkhang/full-screen-image-view),
migrated to AndroidX and Jetpack.

![FullScreenImageViewGIF](FullScreenImageViewGIF.gif)

[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-full--screen--image--view-green.svg?style=flat )]( https://android-arsenal.com/details/1/7986 )
# Setup
1. Add to build.gradle in app level
```
implementation 'com.github.tntkhang:full-screen-image-view-library:1.1.0'
```

2. Call open a FullScreenImageViewActivity and sent some appropriate data.
```
Intent fullImageIntent = new Intent(MainActivity.this, FullScreenImageViewActivity.class);
// uriString is an ArrayList<String> of URI of all images
fullImageIntent.putExtra(FullScreenParameter.URI_LIST_DATA, uriString);
// pos is the position of image will be showned when open
fullImageIntent.putExtra(FullScreenParameter.IMAGE_FULL_SCREEN_CURRENT_POS, pos);
// toolbar back navigation icon
fullImageIntent.putExtra(FullScreenParameter.IMAGE_FULL_SCREEN_BACK_BUTTON, R.drawable.ic_back_button);
startActivity(fullImageIntent);
```