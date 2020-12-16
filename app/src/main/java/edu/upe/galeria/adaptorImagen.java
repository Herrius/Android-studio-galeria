package edu.upe.galeria;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class adaptorImagen extends BaseAdapter {
    private List<Integer> miniaturas;
    private Context context;

    public adaptorImagen(List<Integer> miniaturas, Context context) {
        this.miniaturas = miniaturas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return miniaturas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return miniaturas.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=(ImageView) convertView;
        if(imageView ==null){
            imageView=new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(250,350));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        imageView.setImageResource(miniaturas.get(position));

        return imageView;
    }
}
