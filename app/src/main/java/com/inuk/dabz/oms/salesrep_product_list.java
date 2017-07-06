package com.inuk.dabz.oms;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.inuk.dabz.oms.adapters.SalesRepProductListAdapter;

import java.util.ArrayList;
import java.util.List;

public class salesrep_product_list extends AppCompatActivity {
    private Context thisContext;
    List products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salesrep_product_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Set Screen Title
        this.setTitle("Product List");
        // populate data into product list

        products = new ArrayList();

        for(int i=1;i<100;i++) {
            products.add(new product(i, "Test Product-"+Integer.toString(i), "This is a Test Product - " +Integer.toString(i) + " Which is a test product Which is a test product Which is a test product", "Units", 45.99, 0,0));
        }
        final ListView lvProducts = (ListView)findViewById(R.id.list_products);
        SalesRepProductListAdapter CustomSalesRepProductAdapter = new SalesRepProductListAdapter(this,products);
        lvProducts.setAdapter(CustomSalesRepProductAdapter);

        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                thisContext = view.getContext();
                product oProduct = (product) lvProducts.getItemAtPosition(position);
                Log.d("Context - ",view.getContext().toString());
                Intent i = new Intent(view.getContext(),product_master.class);
                //i.putExtra("TITLE", oProduct.getProductTitle());
                Log.d("PASSED TITLE-",oProduct.getProductTitle());

                i.putExtra("TITLE",oProduct);
                thisContext.startActivity(i);
            }
        });
    }

}
