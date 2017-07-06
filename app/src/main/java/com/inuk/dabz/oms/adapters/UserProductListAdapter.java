package com.inuk.dabz.oms.adapters;

/**
 * Created by CWR.Deepak.Zambre on 6/25/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.inuk.dabz.oms.R;
import com.inuk.dabz.oms.product;
import com.inuk.dabz.oms.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 8/26/2016.
 */
public class UserProductListAdapter extends ArrayAdapter<product> implements Filterable{
    private Context thiscontext;
    List<product> productList;
    List<product> filter_product_list;
    Filter filter;

    public UserProductListAdapter(Context context, List<product> _productList) {
        super(context, R.layout.activity_user_product_list_item, _productList);
        this.thiscontext = context;
        this.productList = _productList;
        this.filter_product_list = new ArrayList<product>(_productList);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final product products = getItem(position);

        final productViewHolder viewholder;

        if (convertView == null){

            convertView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
            convertView = vi.inflate(R.layout.activity_user_product_list_item, parent, false);

            viewholder = new productViewHolder();
        //    viewholder.productIcon = (ImageView) convertView.findViewById(R.id.iconProduct);
            viewholder.productTitle = (TextView) convertView.findViewById(R.id.tv_title_product);
            viewholder.productDescription = (TextView) convertView.findViewById(R.id.tv_desc_product);
            viewholder.productRate = (TextView) convertView.findViewById(R.id.tv_rate_product);
 //           viewholder.productAvailability = (TextView) convertView.findViewById(R.id.availabilityProduct);


        //

        convertView.setTag(viewholder);
    }
        else
    {
        viewholder = (productViewHolder) convertView.getTag();
    }


        viewholder.populate(products);


    //return super.getView(position, convertView, parent);
        return convertView;

}

static class productViewHolder{

    public ImageView productIcon;
    public TextView productTitle;
    public TextView productDescription;
    public TextView productRate;
    public TextView productAvailability;

    void populate(product products) {

        productTitle.setText(products.getProductTitle());
        productDescription.setText(products.getProductDesc());
        productRate.setText(products.getRate_String());
    }
}

    @NonNull
    @Override
    public Filter getFilter() {
        if (filter == null)
            filter = new productFilter();

        return filter;
    }

    private class productFilter extends Filter
    {
        @Override
        protected FilterResults performFiltering(CharSequence constraint)
        {
            FilterResults results = new FilterResults();
            String prefix = constraint.toString().toLowerCase();

            if (prefix == null || prefix.length() == 0)
            {
                ArrayList<product> list = new ArrayList<product>(productList);
                results.values = list;
                results.count = list.size();
            }
            else
            {
                final ArrayList<product> list = new ArrayList<product>(productList);
                final ArrayList<product> nlist = new ArrayList<product>();
                int count = list.size();

                for (int i=0; i<count; i++)
                {
                    final product p = list.get(i);
                    final String value = p.getProductTitle().toLowerCase();

                    if (value.startsWith(prefix))
                    {
                        nlist.add(p);
                    }
                }
                results.values = nlist;
                results.count = nlist.size();
            }
            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filter_product_list = (ArrayList<product>)results.values;

            clear();
            int count = filter_product_list.size();
            for (int i=0; i<count; i++)
            {
                product p = (product)filter_product_list.get(i);
                add(p);
            }
        }
    }
}
