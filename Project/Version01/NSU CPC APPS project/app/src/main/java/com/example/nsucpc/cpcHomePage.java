package com.example.nsucpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class cpcHomePage extends AppCompatActivity {
    ImageButton addPost,cpcViewAllPost,cpcHomeAppliedCan,cpcLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpc_home_page);
        cpcLogOut = (ImageButton)findViewById(R.id.cpcLogOutButton);
        cpcViewAllPost = (ImageButton)findViewById(R.id.cpcHomeViewJobButton);

        addPost = (ImageButton)findViewById(R.id.addPostButton);
        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PostJobActivity.class);
                startActivity(intent);

            }
        });
        cpcViewAllPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PostJobActivity.class);
                startActivity(intent);
            }
        });



    }
}