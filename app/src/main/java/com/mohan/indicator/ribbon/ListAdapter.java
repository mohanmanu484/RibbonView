package com.mohan.indicator.ribbon;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mohan.indicator.tagview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by mohang on 9/11/17.
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Item> items;

    public ListAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_single_item,parent,false);

        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((Binder)holder).bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder implements Binder{

        ImageView imageView;
        TextView name;
        RibbonView ribbonView;


         public ItemHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.itemName);
            ribbonView=itemView.findViewById(R.id.ribbonView);
        }

        @Override
        public void bind(Item item) {

             try {
                 Picasso.with(imageView.getContext()).load(item.getImage()).into(imageView);
             }catch (Exception e){

             }
             name.setText(item.getName());
             ribbonView.setText(item.getRibbonText());

        }
    }

    interface Binder{
        void bind(Item item);
    }
}
