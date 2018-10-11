package com.mcs.mikyas.studentroomdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mcs.mikyas.studentroomdb.Model.Student;
import com.mcs.mikyas.studentroomdb.Utilities.MockFactory;
import com.mcs.mikyas.studentroomdb.database.AppDatabase;

import java.util.List;

public class DisplayStudents extends AppCompatActivity {

    private List<Student> dataset;
    RecyclerView rv;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_students);

        db=AppDatabase.getInstance(this);

        dataset= db.studentItemDao().getAll();



    rv = findViewById(R.id.display_recycler);
    LinearLayoutManager llm = new LinearLayoutManager(this);
                rv.setLayoutManager(llm);

        DisplayStudentsAdapter adapter=new DisplayStudentsAdapter(dataset,this);
                rv.setAdapter(adapter);


    }
}
