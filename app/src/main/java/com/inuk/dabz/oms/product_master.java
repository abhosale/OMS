package com.inuk.dabz.oms;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class product_master extends AppCompatActivity {

    //product oProduct = new product();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_master);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.TRANSPARENT);
        setSupportActionBar(toolbar);

        //this line shows back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        //String ScreenTitle = extras.getString("TITLE");
        //oProduct = (product) extras.getParcelable("TITLE");
        product oProduct = getIntent().getParcelableExtra("TITLE");

        this.setTitle(oProduct.getProductTitle());

        ImageView imgProductImage = (ImageView)findViewById(R.id.image_product_master);
        TextView tvProductID = (TextView) findViewById(R.id.productID);
        EditText etProductTitle = (EditText) findViewById(R.id.productTitle);
        EditText etProductDesc = (EditText) findViewById(R.id.productDesc);
        EditText etProductUOM = (EditText) findViewById(R.id.productUOM);
        EditText etProductRate = (EditText) findViewById(R.id.productRate);

        tvProductID.setText(Integer.toString(oProduct.productId));
        etProductTitle.setText(oProduct.productTitle);
        etProductDesc.setText(oProduct.productDesc);
        etProductUOM.setText(oProduct.unitOfMeasure);
        etProductRate.setText(Double.toString(oProduct.getRate()));

        imgProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent_ShowProductImage = new Intent(view.getContext(),product_images.class);
                view.getContext().startActivity(intent_ShowProductImage);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


}
