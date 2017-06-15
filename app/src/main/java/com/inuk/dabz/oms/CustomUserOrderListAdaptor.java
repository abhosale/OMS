package com.inuk.dabz.oms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Home on 13/06/2017.
 */

public class CustomUserOrderListAdaptor extends BaseAdapter {

    private ArrayList<UserOrder> listData;
    private LayoutInflater layoutInflater;

    public CustomUserOrderListAdaptor(Context aContext, ArrayList<UserOrder> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_order_layout, null);
            holder = new ViewHolder();
            holder.productView = (TextView) convertView.findViewById(R.id.product);
            holder.srepView = (TextView) convertView.findViewById(R.id.srep);
            holder.qtyView = (TextView) convertView.findViewById(R.id.qty);
            holder.rateView = (TextView) convertView.findViewById(R.id.rate);
            holder.totalView = (TextView) convertView.findViewById(R.id.total);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.productView.setText(listData.get(position).getProduct());
        holder.srepView.setText("By, " + listData.get(position).getSrep());
        holder.qtyView.setText(listData.get(position).getQty());
        holder.rateView.setText(listData.get(position).getRate());
        holder.totalView.setText(listData.get(position).getTotal());
        return convertView;
    }

    static class ViewHolder {
        TextView productView;
        TextView srepView;
        TextView qtyView;
        TextView rateView;
        TextView totalView;


    }
}
