package com.gjevass.screenmain.app.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.Display;
import com.gjevass.screenmain.app.util.DisplayUtil;
import com.gjevass.screenmain.app.util.ImageUtil;

public class ImageViewModel {
    private int imageWidth;
    private int imageHeight;
    private int marginTop;
    private int marginBottom;
    private int resourceId;
    private Bitmap bitmap;

    public ImageViewModel(int resourceId, Context context) {
        this.resourceId = resourceId;
        ImageUtil imageUtil = new ImageUtil(resourceId, context);
        DisplayUtil displayUtil = new DisplayUtil(context);
        this.imageWidth = displayUtil.getWidth();
        this.imageHeight = displayUtil.getHeight();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
        this.bitmap = Bitmap.createScaledBitmap(bitmap, displayUtil.getWidth(), imageUtil.getRealHeight(), true);
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(int marginTop) {
        this.marginTop = marginTop;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
    }
}
