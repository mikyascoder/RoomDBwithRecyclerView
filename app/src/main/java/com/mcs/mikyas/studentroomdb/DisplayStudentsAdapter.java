package com.mcs.mikyas.studentroomdb;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mcs.mikyas.studentroomdb.Model.Student;

import java.util.List;

public class DisplayStudentsAdapter extends RecyclerView.Adapter<DisplayStudentsAdapter.ViewHolder> {
    private Context mContext;
    private List<Student> mDataSet;


    public DisplayStudentsAdapter(
            List<Student> dataset, Context context) {

        this.mDataSet = dataset;
        this.mContext = context;
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_student_list_item,parent,false);
        ViewHolder holder =new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        final Student student=mDataSet.get(position);
        holder.firstname.setText(student.getFirstname());
        holder.lastname.setText(student.getLastname());
        holder.rollnumber.setText(student.getRollnumber());


    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView firstname;
        TextView lastname;
        TextView rollnumber;
        LinearLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);

            firstname= itemView.findViewById(R.id.student_first_name);
            lastname=itemView.findViewById(R.id.student_last_name);
            rollnumber= itemView.findViewById(R.id.rollnumber);
            parentLayout = itemView.findViewById(R.id.display_parent_layout);

        }
    }
}
