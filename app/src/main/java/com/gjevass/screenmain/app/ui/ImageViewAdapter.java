package com.gjevass.screenmain.app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.gjevass.screenmain.app.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImageViewAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<ImageViewModel> imageList = new ArrayList<ImageViewModel>();

    public ImageViewAdapter(Context context, List<ImageViewModel> imageList) {
        this.context = context;
        this.imageList = imageList;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public Object getItem(int i) {
        return imageList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = layoutInflater.inflate(R.layout.item, null);
        ImageViewModel imageViewModel = (ImageViewModel) getItem(i);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.itemImageView);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(imageView.getLayoutParams());
        lp.setMargins(0,imageViewModel.getMarginTop(),0,imageViewModel.getMarginBottom());
        imageView.setLayoutParams(lp);

        //imageView.setMaxHeight(imageViewModel.getImageHeight());
        //imageView.setMaxHeight(imageViewModel.getImageWidth());


        Log.d("1", "max height " + imageView.getMaxHeight());
        Log.d("1", "max width "  + imageView.getMaxWidth());
        imageView.setImageBitmap(imageViewModel.getBitmap());
        return rowView;
    }
}
