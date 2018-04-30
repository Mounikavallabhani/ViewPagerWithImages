package com.example.welcome.viewpagerwithimages;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Welcome on 4/30/2018.
 */

public class MyCustomPagerAdapter extends PagerAdapter {
    Context context;
    int images[];
    String mThumbIdsTxt[];
    LayoutInflater layoutInflater;



    public MyCustomPagerAdapter(Context context, int[] images, String[] mThumbIdsTxt) {
        this.context = context;
        this.images = images;
        this.mThumbIdsTxt=mThumbIdsTxt;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        TextView textView = (TextView) itemView.findViewById(R.id.texvt);
        textView.setText(mThumbIdsTxt[position]);
        imageView.setImageResource(images[position]);

        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        Intent intent= new Intent(context,Main2Activity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        Intent it= new Intent(context,Main2Activity.class);
                        context.startActivity(it);
                        break;
                    case 2:
                        Intent it1= new Intent(context,Main2Activity.class);
                        context.startActivity(it1);
                        break;
                    case 3:
                        Intent it2= new Intent(context,Main2Activity.class);
                        context.startActivity(it2);
                        break;




                }

//                Toast.makeText(context, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show();

            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}
