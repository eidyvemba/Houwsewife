package com.msmasters.housewife;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MenuSemanaViewHolder>{
    List<MenuSemana> menu;

    RecyclerViewAdapter(List<MenuSemana> menu)
    {
        this.menu = menu;
    }

    public static class MenuSemanaViewHolder extends RecyclerView.ViewHolder
    {
        CardView card;
        TextView menu_almoco, menu_almoco_desc, menu_jantar, menu_jantar_desc, menu_extra, menu_extra_desc;
        ImageView image;

        MenuSemanaViewHolder(View itemView)
        {
            super(itemView);
            card = (CardView)itemView.findViewById(R.id.cardView);
            menu_almoco = (TextView) itemView.findViewById(R.id.txt_desc_almoco);
            menu_almoco_desc = (TextView) itemView.findViewById(R.id.txt_desc_almoco_desc);
            menu_jantar = (TextView) itemView.findViewById(R.id.txt_desc_jantar);
            menu_jantar_desc = (TextView) itemView.findViewById(R.id.txt_desc_jantar_desc);
            menu_extra = (TextView) itemView.findViewById(R.id.txt_desc_extra);
            menu_extra_desc = (TextView) itemView.findViewById(R.id.txt_desc_extra_desc);

            image = (ImageView) itemView.findViewById(R.id.logo);
        }

    }

    @Override
    public MenuSemanaViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        MenuSemanaViewHolder mvh = new MenuSemanaViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MenuSemanaViewHolder holder, int pos)
    {
        holder.menu_almoco.setText("Almoço :");
        holder.menu_almoco_desc.setText(menu.get(pos).almoco);
        holder.menu_jantar.setText("Jantar : ");
        holder.menu_jantar_desc.setText(menu.get(pos).jantar);
        holder.menu_extra.setText("Extra :");
        holder.menu_extra_desc.setText(menu.get(pos).extra);

        holder.image.setImageResource(menu.get(pos).logoId);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView rv)
    {
        super.onAttachedToRecyclerView(rv);
    }

    @Override
    public int getItemCount()
    {
        return menu.size();
    }
}
