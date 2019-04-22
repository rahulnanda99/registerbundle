package com.example.assid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class secondactivity extends AppCompatActivity
{
TextView t1,t2,t3,t4,t5;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView5);
        t4=findViewById(R.id.textView6);
        t5=findViewById(R.id.textView7);
        Bundle b=getIntent().getExtras();
        t1.setText(b.getString("name_key"));
        t2.setText(b.getString("phone_key"));
        t3.setText(b.getString("course_name"));
        t4.setText(b.getString("faculty_name"));
        t5.setText(b.getString("gender"));
    }
}
