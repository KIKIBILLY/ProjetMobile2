package com.example.user.projetmobile;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by User on 27/03/2017.
 */

public class customSwip extends PagerAdapter {
    private int [] imageResources = new int[6] ;
    private Context ctx;
    private LayoutInflater layoutInflater;

    public customSwip(Context c, int [] images) {
        ctx=c;
        for (int i = 0 ; i < images.length;i++){
            imageResources[i]= images[i];
        }
    }

    @Override
    public int getCount() {

        return imageResources.length-1;
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=layoutInflater.inflate(R.layout.activity_custom_swip,container,false);
        ImageView imageView=(ImageView) itemView.findViewById(R.id.swip_image_view);
        imageView.setImageResource(imageResources[position+1]);

        container.addView(itemView);
        return itemView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return  (view==object);
    }

}
