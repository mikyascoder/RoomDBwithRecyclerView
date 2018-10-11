package com.mcs.mikyas.studentroomdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mcs.mikyas.studentroomdb.Model.Student;
import com.mcs.mikyas.studentroomdb.Utilities.MockFactory;
import com.mcs.mikyas.studentroomdb.database.AppDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase dbb;
    String TAG="roomdbtxt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"created");
        final Student nstudent = null;
        final EditText fn=(EditText) findViewById(R.id.edit_text_first_name);
        final EditText ln=(EditText) findViewById(R.id.edit_text_last_name);
        final EditText rn=(EditText) findViewById(R.id.edit_text_rollno);

        dbb=AppDatabase.getInstance(this);
        int itemcount=dbb.studentItemDao().countitems();
        if (itemcount==0){
            List<Student> studentlist=MockFactory.getstudents();
            dbb.studentItemDao().insertAll(studentlist);
            Log.d(TAG,"data inserted");
        }else{
            Log.d(TAG,"data already exists");
        }



        Button btn=findViewById(R.id.display_student_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent= new Intent(MainActivity.this,DisplayStudents.class);

                startActivity(intent);

            }
        });




        Button addbtn=(Button) findViewById(R.id.add_student_button);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 Student nnstudent= new Student(fn.getText().toString(),ln.getText().toString(),rn.getText().toString());
                 dbb.studentItemDao().insert(nnstudent);
            }
        });


    }
    @Override
    protected void onDestroy(){
        AppDatabase.destroyInstance();
        super.onDestroy();

    }
}
