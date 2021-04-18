package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class viewActivity extends AppCompatActivity {
    private static RecyclerView.Adapter adapter ;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView ;
    ArrayList<Student> studentArrayList,studentArrayList_search;
    EditText search_id;
    CustomAdapter customAdapter;
    Button btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        recyclerView=findViewById(R.id.my_recycle_view);
        recyclerView.setHasFixedSize(true);
        layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        search_id=(EditText)findViewById(R.id.search_id);

        search_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            String text=s.toString();
            filetr(text);


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        new LoadDataTask().execute();



    }
    class LoadDataTask extends AsyncTask<Void,Void,Void>

    {
        StudentRepository studentRepository ;
        List<Student> studentList;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            studentRepository=new StudentRepository(getApplicationContext());
        }

        @Override
        protected Void doInBackground(Void... voids) {
            studentList=studentRepository.getAllStudents();
            studentArrayList=new ArrayList<>();
            studentArrayList_search=new ArrayList<>();

            for (int i = 0;i<studentList.size(); i++)
            {
                studentArrayList.add(studentList.get(i));
                studentArrayList_search.add(studentList.get(i));
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
             customAdapter=new CustomAdapter(studentArrayList,viewActivity.this);
            recyclerView.setAdapter(customAdapter);
        }
    }
    // search Filter
    public void filetr(String charText)
    {
        charText = charText.toLowerCase(Locale.getDefault());
        Log.d("filter ",charText+"");
        studentArrayList.clear();
        if (charText.length()==0)
        {
            studentArrayList.addAll(studentArrayList_search);
            Log.d("load data" ,"all");
        }
        else
        {
            Log.d("load data","fltered");
            for(Student student: studentArrayList_search)
            {
                if (String.valueOf(student.studentid).toLowerCase(Locale.getDefault()).contains(charText)) {
                    studentArrayList.add(student);
                    customAdapter.notifyDataSetChanged();

                } else if (student.studentname.toLowerCase(Locale.getDefault()).contains(charText)) {
                    studentArrayList.add(student);
                    customAdapter.notifyDataSetChanged();

                }

            }
        }
    }

    //popup

}