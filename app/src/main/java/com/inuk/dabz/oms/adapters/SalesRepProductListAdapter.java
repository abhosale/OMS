package com.inuk.dabz.oms.adapters;

/**
 * Created by CWR.Deepak.Zambre on 6/25/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.inuk.dabz.oms.*;

import com.inuk.dabz.oms.product;

import java.util.List;

/**
 * Created by Admin on 8/26/2016.
 */
public class SalesRepProductListAdapter extends ArrayAdapter<product> {
    private Context thiscontext;
    List<product> productList;


    public SalesRepProductListAdapter(Context context, List<product> _productList) {
        super(context, R.layout.content_salesrep_product_list_item, _productList);
        this.thiscontext = context;
        this.productList = _productList;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final product products = getItem(position);

        final productViewHolder viewholder;

        if (convertView == null){

            convertView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
            convertView = vi.inflate(R.layout.content_salesrep_product_list_item, parent, false);

            viewholder = new productViewHolder();
        //    viewholder.productIcon = (ImageView) convertView.findViewById(R.id.iconProduct);
            viewholder.productTitle = (TextView) convertView.findViewById(R.id.titleProduct);
            viewholder.productDescription = (TextView) convertView.findViewById(R.id.descProduct);

            viewholder.productRate = (TextView) convertView.findViewById(R.id.rateProduct);
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

}
