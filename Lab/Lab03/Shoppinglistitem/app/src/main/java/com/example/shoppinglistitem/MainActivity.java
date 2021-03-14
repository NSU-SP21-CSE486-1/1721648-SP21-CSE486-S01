package com.example.shoppinglistitem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;

    private TextView item_1;
    private TextView item_2;
    private TextView item_3;
    private TextView item_4;
    private TextView item_5;
    private TextView item_6;
    private TextView item_7;
    private TextView item_8;
    private TextView item_9;
    private TextView item_10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item_1 = findViewById(R.id.txtItemOne);
        item_2 = findViewById(R.id.txtItemTwo);
        item_3 = findViewById(R.id.txtItemThree);
        item_4 = findViewById(R.id.txtItemFour);
        item_5 = findViewById(R.id.txtItemFive);
        item_6 = findViewById(R.id.txtItemSix);
        item_7 = findViewById(R.id.txtItemSeven);
        item_8 = findViewById(R.id.txtItemEight);
        item_9 = findViewById(R.id.txtItemNine);
        item_10 = findViewById(R.id.txtItemTen);

    }
    public void openItems(View view) {
        Log.d(LOG_TAG, "Button Clicked by user");

        Intent intent = new Intent(this, activity_second.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }
    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =  data.getStringExtra(activity_second.EXTRA_REPLY);
                if(item_1.getText()=="")
                    item_1.setText(reply);
                else if(item_2.getText()=="")
                    item_2.setText(reply);
                else if(item_3.getText()=="")
                    item_3.setText(reply);
                else if(item_4.getText()=="")
                    item_4.setText(reply);
                else if(item_5.getText()=="")
                    item_5.setText(reply);
                else if(item_6.getText()=="")
                    item_6.setText(reply);
                else if(item_7.getText()=="")
                    item_7.setText(reply);
                else if(item_8.getText()=="")
                    item_8.setText(reply);
                else if(item_9.getText()=="")
                    item_9.setText(reply);
                else if(item_10.getText()=="")
                    item_10.setText(reply);
            }
        }
    }

}