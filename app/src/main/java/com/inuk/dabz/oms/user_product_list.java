package com.inuk.dabz.oms;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.inuk.dabz.oms.adapters.SalesRepProductListAdapter;
import com.inuk.dabz.oms.adapters.UserProductListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class user_product_list extends AppCompatActivity {
    private Context thisContext;
    List products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_product_list);


        // populate data into product list

        products = new ArrayList();

        for(int i=1;i<100;i++) {
            products.add(new product(i, RandomProductName(), "This is a Test Product - " +Integer.toString(i) + " Which is a test product ", "Units", 45.99, 0,0));
        }
        final ListView lvProducts = (ListView)findViewById(R.id.lv_user_product_list);
        final UserProductListAdapter CustomUserProductAdapter = new UserProductListAdapter(this,products);
        lvProducts.setAdapter(CustomUserProductAdapter);

        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                thisContext = view.getContext();
                product oProduct = (product) lvProducts.getItemAtPosition(position);

                Intent i = new Intent(view.getContext(),user_product_buy.class);
                i.putExtra("Product_OBJ",oProduct);
                thisContext.startActivity(i);
            }
        });

        EditText etUserProductSearch = (EditText) findViewById(R.id.et_user_product_search);

        etUserProductSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                CustomUserProductAdapter.getFilter().filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_user_cart) {
            Intent i = new Intent(this,user_product_buy.class);
            this.startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String RandomProductName (){
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return  sb.toString();
    }
}
