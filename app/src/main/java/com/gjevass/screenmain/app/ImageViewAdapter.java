package com.gjevass.screenmain.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ImageViewAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<Bitmap> imageViewList = new ArrayList<Bitmap>();

    public ImageViewAdapter(Context context,List<Bitmap> imageViewList) {
        this.context = context;
        this.imageViewList = imageViewList;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageViewList.size();
    }

    @Override
    public Object getItem(int i) {
        return imageViewList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = layoutInflater.inflate(R.layout.item, null);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.itemImageView);
        Bitmap bitmap = (Bitmap) getItem(i);
        imageView.setImageBitmap(bitmap);
        return rowView;
    }
}
