package com.inuk.dabz.oms;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class user_product_buy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_product_buy);


        //this line shows back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        product oProduct = getIntent().getParcelableExtra("Product_OBJ");

        ImageView imgUserProductImage = (ImageView) findViewById(R.id.img_user_product_image);
        TextView tvUserProductTitle = (TextView) findViewById(R.id.tv_user_product_title);
        TextView tvUserProductRate = (TextView) findViewById(R.id.tv_user_product_rate);
        TextView tvUserProductDesc = (TextView) findViewById(R.id.tv_user_product_desc);
        Button btnAddToCart = (Button) findViewById(R.id.btn_user_add_to_cart);

        tvUserProductTitle.setText(oProduct.getProductTitle());
        tvUserProductRate.setText(oProduct.getRate_String());
        tvUserProductDesc.setText(oProduct.getProductDesc());


        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Item added to Cart!",
                        Toast.LENGTH_LONG).show();
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
}
