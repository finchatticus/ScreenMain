package com.gjevass.screenmain.app.ui;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ListView;
import com.gjevass.screenmain.app.R;
import com.gjevass.screenmain.app.util.DisplayUtil;
import com.gjevass.screenmain.app.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        DisplayUtil displayUtil = new DisplayUtil(this);
        System.out.println(displayUtil.toString());

        int resources[] = { R.drawable.main_part_0,
                            R.drawable.main_part_1,
                            R.drawable.main_part_2,
                            R.drawable.main_part_3,
                            R.drawable.main_part_4 };

        List<ImageViewModel> imagesList = new ArrayList<ImageViewModel>();
        for (int i = 0; i < resources.length; i++) {
            imagesList.add(new ImageViewModel(resources[i], this));
        }
        imagesList.get(0).setMarginTop(-1000);
        imagesList.get(4).setMarginBottom(-1000);
        //imagesList.add(new ImageViewModel(resources[2],this));

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ImageViewAdapter(this, imagesList));

        /*
        ListView listView = (ListView) findViewById(R.id.listView);

        //-1000 dp
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT
        );
        params.setMargins(0, -1000, 0, 0); //left,top,right,bottom
        listView.setLayoutParams(params);

        listView.setAdapter(new ImageViewAdapter(this, bitmap));*/

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
