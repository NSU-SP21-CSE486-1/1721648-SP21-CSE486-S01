package com.example.studentdatabase;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button getStartbutton, changeLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);
        // change actionbar title ,if you don not chnage it will be according to my systems default language
        ActionBar actionbar= getSupportActionBar();
        actionbar.setTitle(getResources().getString(R.string.app_name));


        StudentRepository studentRepository= new StudentRepository(getApplicationContext());
        getStartbutton=findViewById(R.id.get_start_btn);
        changeLang=findViewById(R.id.language);
        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show alertdialog
                showChangeLanguageDialog();
                

            }
        });


        getStartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Profile.class);
                startActivity(intent);

            }
        });
    }

    private void showChangeLanguageDialog() {
        final  String[] listItems={"English","বাংলা"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Choose Language...");
        mBuilder.setSingleChoiceItems(listItems,-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0){
                    //english
                    setLocale("en");
                            recreate();

                }
                else if(i==1){
                    //bangla
                    setLocale("bn-rBD");
                    recreate();

                }
                dialogInterface.dismiss();

            }

        });

          AlertDialog mDialog=mBuilder.create();
          mDialog.show();
    }

    private void setLocale(String lang ) {
        Locale locale=new Locale(lang);
        locale.setDefault(locale);
        Configuration config= new Configuration();
        config.locale= locale;
        getBaseContext().getResources().updateConfiguration(config ,getBaseContext().getResources().getDisplayMetrics());
        //save data to shared preferences
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_lang", lang);
        
        editor.apply();
    }
    //load language saved in shared preference
    public void  loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language=prefs.getString("My_lang","");
        setLocale(language);
    }
}