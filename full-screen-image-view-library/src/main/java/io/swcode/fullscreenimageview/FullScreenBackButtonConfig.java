package io.swcode.fullscreenimageview;

import android.content.Intent;

class FullScreenBackButtonConfig {
    private final Integer imageViewBackIconId;

    private FullScreenBackButtonConfig(Integer imageViewBackIconId) {
        this.imageViewBackIconId = imageViewBackIconId;
    }

    static FullScreenBackButtonConfig of(Intent intent) {
        if(intent.hasExtra(FullScreenParameter.IMAGE_FULL_SCREEN_BACK_BUTTON)) {
            return new FullScreenBackButtonConfig(intent.getIntExtra(FullScreenParameter.IMAGE_FULL_SCREEN_BACK_BUTTON, 0));
        }
        return new FullScreenBackButtonConfig(null);
    }

    int getImageViewBackIcon() {
        if(hasImageViewBackIcon()) {
            return imageViewBackIconId;
        }
        throw new NullPointerException("Back icon not set");
    }

    boolean hasImageViewBackIcon() {
        return imageViewBackIconId != null;
    }

}
