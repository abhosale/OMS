package com.inuk.dabz.oms;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListUserOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ArrayList image_details = getListData();
        final ListView lv1 = (ListView) findViewById(R.id.custom_order_list);
        lv1.setAdapter(new CustomUserOrderListAdaptor(this, image_details));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                UserOrder newsData = (UserOrder) o;
                Toast.makeText(ListUserOrderActivity.this, "Selected :" + " " + newsData, Toast.LENGTH_LONG).show();
            }
            });

        FloatingActionButton orderAdd = (FloatingActionButton) findViewById(R.id.orderAdd);
        orderAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                launchActivity();
            }

        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        }

    private void launchActivity() {

        Intent intent = new Intent(this, AddUserOrderActivity.class);
        startActivity(intent);
    }

    private ArrayList getListData() {

        ArrayList<UserOrder> results = new ArrayList<UserOrder>();
        UserOrder userOrderData = new UserOrder();
        userOrderData.setProduct("Democracy");
        userOrderData.setSrep("Pankaj Gupta");
        userOrderData.setQty("26");
        userOrderData.setRate("50.3");
        userOrderData.setTotal(" 2013 13:35");
        results.add(userOrderData);
        UserOrder userOrderData1 = new UserOrder();
        userOrderData1.setProduct("Democracy");
        userOrderData1.setSrep("Abhay Bhosale");
        userOrderData1.setQty("26");
        userOrderData1.setRate("50.3");
        userOrderData1.setTotal(" 2013 13:35");
        results.add(userOrderData1);
        UserOrder userOrderData2 = new UserOrder();
        userOrderData2.setProduct("Democracy");
        userOrderData2.setSrep("Deepak Zambre");
        userOrderData2.setQty("26");
        userOrderData2.setRate("50.3");
        userOrderData2.setTotal(" 2013 13:35");
        results.add(userOrderData2);
        UserOrder userOrderData3 = new UserOrder();
        userOrderData3.setProduct("Democracy");
        userOrderData3.setSrep("Shailesh Admane");
        userOrderData3.setQty("26");
        userOrderData3.setRate("50.3");
        userOrderData3.setTotal(" 2013 13:35");
        results.add(userOrderData3);
        UserOrder userOrderData4 = new UserOrder();
        userOrderData4.setProduct("Democracy");
        userOrderData4.setSrep("Atul Bhosale");
        userOrderData4.setQty("26");
        userOrderData4.setRate("50.3");
        userOrderData4.setTotal(" 2013 13:35");
        results.add(userOrderData4);
        UserOrder userOrderData5 = new UserOrder();
        userOrderData5.setProduct("Democracy");
        userOrderData5.setSrep("Kishore Mane");
        userOrderData5.setQty("26");
        userOrderData5.setRate("50.3");
        userOrderData5.setTotal(" 2013 13:35");
        results.add(userOrderData5);
        UserOrder userOrderData6 = new UserOrder();
        userOrderData6.setProduct("Democracy");
        userOrderData6.setSrep("Pankaj Gupta");
        userOrderData6.setQty("26");
        userOrderData6.setRate("50.3");
        userOrderData6.setTotal(" 2013 13:35");
        results.add(userOrderData6);
        UserOrder userOrderData7 = new UserOrder();
        userOrderData7.setProduct("Democracy");
        userOrderData7.setSrep("Pankaj Gupta");
        userOrderData7.setQty("26");
        userOrderData7.setRate("50.3");
        userOrderData7.setTotal(" 2013 13:35");
        results.add(userOrderData7);
        UserOrder userOrderData8 = new UserOrder();
        userOrderData8.setProduct("Democracy");
        userOrderData8.setSrep("Pankaj Gupta");
        userOrderData8.setQty("26");
        userOrderData8.setRate("50.3");
        userOrderData8.setTotal(" 2013 13:35");
        results.add(userOrderData8);
        UserOrder userOrderData9 = new UserOrder();
        userOrderData9.setProduct("Democracy");
        userOrderData9.setSrep("Pankaj Gupta");
        userOrderData9.setQty("26");
        userOrderData9.setRate("50.3");
        userOrderData9.setTotal(" 2013 13:35");
        results.add(userOrderData9);
        UserOrder userOrderDataq = new UserOrder();
        userOrderDataq.setProduct("Democracy");
        userOrderDataq.setSrep("Pankaj Gupta");
        userOrderDataq.setQty("26");
        userOrderDataq.setRate("50.3");
        userOrderDataq.setTotal(" 2013 13:35");
        results.add(userOrderDataq);
        UserOrder userOrderDataw = new UserOrder();
        userOrderDataw.setProduct("Democracy");
        userOrderDataw.setSrep("Pankaj Gupta");
        userOrderDataw.setQty("26");
        userOrderDataw.setRate("50.3");
        userOrderDataw.setTotal(" 2013 13:35");
        results.add(userOrderDataw);
        UserOrder userOrderDatae = new UserOrder();
        userOrderDatae.setProduct("Democracy");
        userOrderDatae.setSrep("Pankaj Gupta");
        userOrderDatae.setQty("26");
        userOrderDatae.setRate("50.3");
        userOrderDatae.setTotal(" 2013 13:35");
        results.add(userOrderDatae);
        UserOrder userOrderDatar = new UserOrder();
        userOrderDatar.setProduct("Democracy");
        userOrderDatar.setSrep("Pankaj Gupta");
        userOrderDatar.setQty("26");
        userOrderDatar.setRate("50.3");
        userOrderDatar.setTotal(" 2013 13:35");
        results.add(userOrderDatar);
        // Add some more dummy data for testing
        return results;
    }
}
