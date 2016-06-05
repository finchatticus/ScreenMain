package com.gjevass.screenmain.app.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.gjevass.screenmain.app.R;

import java.util.ArrayList;
import java.util.List;

public class ImageViewAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<ImageViewModel> imageList = new ArrayList<ImageViewModel>();
    private List<Bitmap> posters = null;

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
        if(view == null) {
            view = layoutInflater.inflate(R.layout.item, viewGroup, false);
        }
        //View rowView = layoutInflater.inflate(R.layout.item, null);
        ImageViewModel imageViewModel = (ImageViewModel) getItem(i);

        ImageView imageView = (ImageView) view.findViewById(R.id.itemImageView);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(imageView.getLayoutParams());
        lp.setMargins(0,imageViewModel.getMarginTop(),0,imageViewModel.getMarginBottom());
        imageView.setLayoutParams(lp);

        imageView.setImageBitmap(imageViewModel.getBitmap());


        if (posters != null) {
            if(i == 1) {

                ImageView imageViewEl0 = (ImageView) view.findViewById(R.id.imageViewEl0);
                FrameLayout.LayoutParams lp1 = new FrameLayout.LayoutParams(imageView.getLayoutParams());
                lp1.setMargins(130,617,0,0);
                imageViewEl0.setLayoutParams(lp1);
                imageViewEl0.setRotation(3);
                imageViewEl0.setImageBitmap(posters.get(0));

                ImageView imageViewEl1 = (ImageView) view.findViewById(R.id.imageViewEl1);
                FrameLayout.LayoutParams lp2 = new FrameLayout.LayoutParams(imageView.getLayoutParams());
                lp2.setMargins(334,677,0,0);
                imageViewEl1.setLayoutParams(lp2);
                imageViewEl1.setRotation(-1);
                imageViewEl1.setImageBitmap(posters.get(1));
            }
            if(i == 3) {
                ImageView imageViewEl2 = (ImageView) view.findViewById(R.id.imageViewEl2);
                FrameLayout.LayoutParams lp3 = new FrameLayout.LayoutParams(imageView.getLayoutParams());
                lp3.setMargins(84,1100,0,0);
                imageViewEl2.setLayoutParams(lp3);
                imageViewEl2.setRotation(2);
                imageViewEl2.setImageBitmap(posters.get(2));

                ImageView imageViewEl3 = (ImageView) view.findViewById(R.id.imageViewEl3);
                FrameLayout.LayoutParams lp4 = new FrameLayout.LayoutParams(imageView.getLayoutParams());
                lp4.setMargins(372,1098,0,0);
                imageViewEl3.setLayoutParams(lp4);
                imageViewEl3.setRotation(2.5f);
                imageViewEl3.setImageBitmap(posters.get(3));
            }
        }

        return view;
    }

    public void setPosters(List<Bitmap> posters) {
        this.posters = posters;
    }
}
