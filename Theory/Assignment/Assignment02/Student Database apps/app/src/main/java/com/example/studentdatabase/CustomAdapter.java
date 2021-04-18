package com.example.studentdatabase;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<Student> dataset;
    Context context;
    



    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView  studentid_card;
        TextView studentname_card ;
        TextView  departname_cardview;
        TextView MobileNumber_cardview;
        Button btn;
      //  public Button popupde;

        public MyViewHolder (View itemView)
        {
            super(itemView);
            this.studentid_card=(TextView)itemView.findViewById(R.id.studentid_card);
            this.studentname_card=(TextView)itemView.findViewById(R.id.studentname_card);
            this.MobileNumber_cardview=(TextView)itemView.findViewById(R.id.MobileNumber_cardview);
            this.btn=(Button)itemView.findViewById(R.id.popupDetails);

        }

        //extra test
        


    }

    public CustomAdapter(ArrayList<Student>dataset,Context context)
    {
        this.dataset=dataset ;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_studentinfo,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView  studentid_card=holder.studentid_card;
        TextView studentname_card=holder.studentname_card;
        TextView  departname_cardview=holder.departname_cardview;
        TextView MobileNumber_cardview=holder.MobileNumber_cardview;
        studentid_card.setText(dataset.get(position).studentid+"");
        studentname_card.setText(dataset.get(position).studentname+"");

        MobileNumber_cardview.setText(dataset.get(position).phonenumber+"");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder =new AlertDialog.Builder(v.getRootView().getContext());

                View dialogView = LayoutInflater.from(v.getRootView().getContext()).inflate(R.layout.dialog_info,null);
                TextView tvname;
                TextView tvdepartment;

                tvname=dialogView.findViewById(R.id.tvname);
                tvdepartment=dialogView.findViewById(R.id.tvdepartment);
                tvname.setText(dataset.get(position).studentname);
                tvdepartment.setText(dataset.get(position).departmentname);
                builder.setView(dialogView);
                builder.setCancelable(true);
                builder.show();

            }
        });






    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }



    


}
