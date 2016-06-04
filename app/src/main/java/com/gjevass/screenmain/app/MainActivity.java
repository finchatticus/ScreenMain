package com.gjevass.screenmain.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        Log.d(TAG, "width = " + width);
        Log.d(TAG, "height = " + height);

        //ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Bitmap bMap0 = BitmapFactory.decodeResource(getResources(), R.drawable.main_part_0);
        Bitmap bMapScaled0 = Bitmap.createScaledBitmap(bMap0, width, height, true);

        Bitmap bMap1 = BitmapFactory.decodeResource(getResources(), R.drawable.main_part_1);
        Bitmap bMapScaled1 = Bitmap.createScaledBitmap(bMap1, width, height, true);

        Bitmap bMap2 = BitmapFactory.decodeResource(getResources(), R.drawable.main_part_2);
        Bitmap bMapScaled2 = Bitmap.createScaledBitmap(bMap2, width, 202, true);

        Bitmap bMap3 = BitmapFactory.decodeResource(getResources(), R.drawable.main_part_3);
        Bitmap bMapScaled3 = Bitmap.createScaledBitmap(bMap3, width, height, true);

        Bitmap bMap4 = BitmapFactory.decodeResource(getResources(), R.drawable.main_part_4);
        Bitmap bMapScaled4 = Bitmap.createScaledBitmap(bMap4, width, height, true);

        //imageView.setImageBitmap(bMapScaled);

        List<Bitmap> bitmap = new ArrayList<Bitmap>();
        bitmap.add(bMapScaled0);
        bitmap.add(bMapScaled1);
        bitmap.add(bMapScaled2);
        bitmap.add(bMapScaled3);
        bitmap.add(bMapScaled4);

        ListView listView = (ListView) findViewById(R.id.listView);

        //-1000 dp
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT
        );
        params.setMargins(0, -1000, 0, 0); //left,top,right,bottom
        listView.setLayoutParams(params);

        listView.setAdapter(new ImageViewAdapter(this, bitmap));

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
