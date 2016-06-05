package com.gjevass.screenmain.app.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import com.gjevass.screenmain.app.R;
import com.gjevass.screenmain.app.json.JSONParser;
import com.gjevass.screenmain.app.util.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ImageViewAdapter imageViewAdapter;

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

        imageViewAdapter = new ImageViewAdapter(this, imagesList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(imageViewAdapter);

        PosterTask posterTask = new PosterTask();
        posterTask.execute();
    }

    private class PosterTask extends AsyncTask<Void, Void, List<Bitmap>> {
        private JSONParser jsonParser;
        private String TAG = PosterTask.class.getSimpleName();

        @Override
        protected List<Bitmap> doInBackground(Void... voids) {
            Log.v(TAG, "doInBackground");
            jsonParser = new JSONParser(getApplicationContext());
            return jsonParser.getPosters();
        }

        @Override
        protected void onPostExecute(List<Bitmap> posters) {
            super.onPostExecute(posters);
            imageViewAdapter.setPosters(posters);
            imageViewAdapter.notifyDataSetChanged();
            Log.v(TAG, "onPostExecute");
        }
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
