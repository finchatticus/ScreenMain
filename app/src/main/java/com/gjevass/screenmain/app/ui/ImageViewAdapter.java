package com.gjevass.screenmain.app.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.gjevass.screenmain.app.R;

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

        imageView.setImageBitmap(imageViewModel.getBitmap());
        return rowView;
    }
}
