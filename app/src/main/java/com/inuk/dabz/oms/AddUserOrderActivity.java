package com.inuk.dabz.oms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddUserOrderActivity extends AppCompatActivity {
    private Button btnUserCancelActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_order);


        btnUserCancelActivity = (Button) findViewById(R.id.cancelOrderbtn);

        btnUserCancelActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchActivity();
            }
        });
    }
    private void launchActivity() {

        Intent intent = new Intent(this, ListUserOrderActivity.class);
        startActivity(intent);
    }
}
