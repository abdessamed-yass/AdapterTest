package com.example.yassineabdessamad.test;


/**
 * Created by yessine on 26-02-18.
 */


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.yassineabdessamad.test.data.RowData;
import com.squareup.picasso.Picasso;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.viewholders.FlexibleViewHolder;


public class DataItem extends AbstractFlexibleItem<DataItem.ItemHolder> {

    private RowData data;

    public DataItem(RowData data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object inObject) {
        if (inObject instanceof DataItem) {
            DataItem inItem = (DataItem) inObject;
            return true;
        }
        return false;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.my_item;
    }

    @Override
    public ItemHolder createViewHolder(View view, FlexibleAdapter adapter) {
        return new ItemHolder(view, adapter);
    }

    @Override
    public void unbindViewHolder(FlexibleAdapter adapter, final ItemHolder holder, int position) {

    }

    @Override
    public void bindViewHolder(final FlexibleAdapter adapter, final ItemHolder holder, int position, List payloads) {
        final Context context = holder.getContentView().getContext();
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        Picasso.with(context).load(data.getUrlPicture()).resize(width, 400).placeholder(R.mipmap.place)
                .into(holder.image);
        holder.name.setText("" + data.getName());
        holder.description.setText("" + data.getDescription());

        holder.details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "" + data.getName(), Toast.LENGTH_LONG).show();
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareIntent(holder);
            }
        });
    }

    public void shareIntent(final ItemHolder holder) {
        Context context = holder.getContentView().getContext();
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        holder.image.buildDrawingCache();
        Bitmap bm = holder.image.getDrawingCache();
        shareIntent.putExtra(Intent.EXTRA_TEXT, "" + data.getName() + ":" + data.getDescription());
        String url = MediaStore.Images.Media.insertImage(context.getContentResolver(), bm, "title", "description");
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(url));
        shareIntent.setType("image/*");
        context.startActivity(Intent.createChooser(shareIntent, context.getResources().getText(R.string.share)));

    }

    public class ItemHolder extends FlexibleViewHolder {
        private ImageView image;
        private TextView name;
        private TextView description;
        private TextView share;
        private TextView details;
        private LinearLayout layout;

        public ItemHolder(View v, FlexibleAdapter adapter) {
            super(v, adapter);
            image = (ImageView) v.findViewById(R.id.imageView);
            name = (TextView) v.findViewById(R.id.name);
            description = (TextView) v.findViewById(R.id.desc);
            share = (TextView) v.findViewById(R.id.share);
            details = (TextView) v.findViewById(R.id.details);

        }
    }


}