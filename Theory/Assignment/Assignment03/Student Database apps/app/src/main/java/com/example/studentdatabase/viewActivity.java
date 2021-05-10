package com.example.studentdatabase;

import androidx.annotation.NonNull;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    DatabaseReference databaseReference;





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
        databaseReference= FirebaseDatabase.getInstance().getReference("students");

        customAdapter= new CustomAdapter(viewActivity.this, studentArrayList) {
            @Override
            public int getItemCount() {
                return 0;
            }
        };
        studentArrayList=new ArrayList<>();
        studentArrayList_search=new ArrayList<>();






       //Search
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




    }

    @Override
    protected void onStart() {
        super.onStart();
        customAdapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        customAdapter.stopListening();
    }
    /// @Override
   // public void onStart() {
        //   databaseReference.addValueEventListener(new ValueEventListener() {
        //    @Override
        //  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

       // studentArrayList.clear();
       // for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
         //   Student student = dataSnapshot1.getValue(Student.class);

         //   studentArrayList.add(student);

       // }
      //  recyclerView.setAdapter(customAdapter);

  //  }

          //  @Override
          //  public void onCancelled(@NonNull DatabaseError error) {

        //    }
       /// });
       // super.onStart();
  //  }


   /* class LoadDataTask extends AsyncTask<Void,Void,Void>

    {

        List<Student> studentList;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            studentList= (List<Student>)databaseReference.getDatabase();
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
    } */
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