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
import android.widget.Toast;
import com.gjevass.screenmain.app.R;

import java.util.ArrayList;
import java.util.List;

public class ImageViewAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<ImageViewModel> imageList = new ArrayList<ImageViewModel>();
    private List<Bitmap> posters = null;
    private List<Bitmap> elements = null;

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
        ImageViewModel imageViewModel = (ImageViewModel) getItem(i);

        ImageView imageViewBackground = (ImageView) view.findViewById(R.id.itemImageView);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(imageViewBackground.getLayoutParams());
        lp.setMargins(0, imageViewModel.getMarginTop(), 0, imageViewModel.getMarginBottom());
        imageViewBackground.setLayoutParams(lp);
        imageViewBackground.setImageBitmap(imageViewModel.getBitmap());

        ImageView imageView0 = (ImageView) view.findViewById(R.id.imageViewEl0);
        ImageView imageView1 = (ImageView) view.findViewById(R.id.imageViewEl1);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.imageViewEl2);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.imageViewEl3);
        ImageView imageView4 = (ImageView) view.findViewById(R.id.imageViewEl4);

        if (posters != null && elements != null) {
            if(i == 1) {
                //poster 1
                FrameLayout.LayoutParams lp0 = new FrameLayout.LayoutParams(imageView0.getLayoutParams());
                lp0.setMargins(130, 617, 0, 0);
                imageView0.setLayoutParams(lp0);
                imageView0.setRotation(3);
                imageView0.setImageBitmap(posters.get(0));

                //poster 2
                FrameLayout.LayoutParams lp3 = new FrameLayout.LayoutParams(imageView3.getLayoutParams());
                lp3.setMargins(334, 677, 0, 0);
                imageView3.setLayoutParams(lp3);
                imageView3.setRotation(-1);
                imageView3.setImageBitmap(posters.get(1));

                //poster frame
                Bitmap bitmapFrame = Bitmap.createScaledBitmap(elements.get(0), 224, 312, true);
                FrameLayout.LayoutParams lp1 = new FrameLayout.LayoutParams(imageView1.getLayoutParams());
                lp1.setMargins(124, 611, 0, 0);
                imageView1.setLayoutParams(lp1);
                imageView1.setRotation(3);
                imageView1.setImageBitmap(bitmapFrame);

                //poster frame
                FrameLayout.LayoutParams lp2 = new FrameLayout.LayoutParams(imageView2.getLayoutParams());
                lp2.setMargins(328, 671, 0, 0);
                imageView2.setLayoutParams(lp2);
                imageView2.setRotation(-1);
                imageView2.setImageBitmap(bitmapFrame);

                //sticks frame
                Bitmap bitmapSticks = Bitmap.createScaledBitmap(elements.get(1), 455, 400, true);
                FrameLayout.LayoutParams lp4 = new FrameLayout.LayoutParams(imageView4.getLayoutParams());
                lp4.setMargins(110, 595, 0, 0);
                imageView4.setLayoutParams(lp4);
                imageView4.setImageBitmap(bitmapSticks);
            }
            if(i == 3) {
                imageView4.setVisibility(View.INVISIBLE);

                //poster 1
                FrameLayout.LayoutParams lp0 = new FrameLayout.LayoutParams(imageView0.getLayoutParams());
                lp0.setMargins(84, 1100, 0, 0);
                imageView0.setLayoutParams(lp0);
                imageView0.setRotation(2);
                imageView0.setImageBitmap(posters.get(2));

                //poster 2
                FrameLayout.LayoutParams lp1 = new FrameLayout.LayoutParams(imageView1.getLayoutParams());
                lp1.setMargins(372, 1098, 0, 0);
                imageView1.setLayoutParams(lp1);
                imageView1.setRotation(2.5f);
                imageView1.setImageBitmap(posters.get(3));

                //pin
                FrameLayout.LayoutParams lp2 = new FrameLayout.LayoutParams(imageView2.getLayoutParams());
                lp2.setMargins(212, 206, 0, 0);
                imageView2.setLayoutParams(lp2);
                imageView2.setImageBitmap(elements.get(2));

                //light
                FrameLayout.LayoutParams lp3 = new FrameLayout.LayoutParams(imageView3.getLayoutParams());
                lp3.setMargins(344, 495, 0, 0);
                imageView3.setLayoutParams(lp3);
                imageView3.setImageBitmap(elements.get(3));
            }

        }

        return view;
    }

    public void setPosters(List<Bitmap> posters) {
        this.posters = posters;
    }

    public void setElements(List<Bitmap> elements) {
        this.elements = elements;
    }
}
