package com.crycetruly.onboard;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Elia on 12/4/2017.
 */

public class SliderAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater inflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }
    private int [] slideImages={
      R.drawable.one,R.drawable.two,R.drawable.three
    };
    private String [] headings={
            "EAT","CODE","SLEEP"
    };

    private String [] descriptions={
            "  Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem velit ex minus molestias, nisi rem tenetur at reiciendis, natus aut earum ipsum molestiae repudiandae illum quasi aspernatur magnam eligendi! Earum?","  Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem velit ex minus molestias, nisi rem tenetur at reiciendis, natus aut earum ipsum molestiae repudiandae illum quasi aspernatur magnam eligendi! Earum?","  Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolorem velit ex minus molestias, nisi rem tenetur at reiciendis, natus aut earum ipsum molestiae repudiandae illum quasi aspernatur magnam eligendi! Earum?"
    };

    @Override
    public int getCount() {
        return slideImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v=inflater.inflate(R.layout.slide_layout,container,false);


        TextView heading=v.findViewById(R.id.top);
        TextView bottom=v.findViewById(R.id.bottom);
        ImageView imageView=v.findViewById(R.id.pic);

        imageView.setImageResource(slideImages[position]);
        heading.setText(headings[position]);
        bottom.setText(descriptions[position]);

        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
