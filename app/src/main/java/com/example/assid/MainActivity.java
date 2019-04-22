package com.example.assid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText e1,e2;
    Spinner s1;
    TextView t1,t2;
    RadioButton r1,r2;
    CheckBox c1;
    Button b1;
    String data[];
    String result;
    String m[]={"rahul","manish","shubham"};
    String d;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        s1=findViewById(R.id.spinner);
        t1=findViewById(R.id.textView4);
        t2=findViewById(R.id.textView3);
        r1=findViewById(R.id.radio);
        r2=findViewById(R.id.radio1);
        c1=findViewById(R.id.checkBox);
        b1=findViewById(R.id.button);
        b1.setEnabled(false);
        data=getResources().getStringArray(R.array.fac);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                 d=data[position];
                if(d.equals(data[1]))
                {
                    t1.setText(m[0]);

                }
                if(d.equals(data[2]))
                {
                    t1.setText(m[1]);
                }
                if(d.equals(data[3]))
                {
                    t1.setText(m[2]);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String s2=e1.getText().toString();
                String s3=e2.getText().toString();

                if (r1.isChecked())
                {
                    result=r1.getText().toString();
                }
                else
                {
                    result=r2.getText().toString();
                }
                Intent intent=new Intent(MainActivity.this,secondactivity.class);
                intent.putExtra("name_key",s2);
                intent.putExtra("phone_key",s3);
                intent.putExtra("course_name",d);
                intent.putExtra("faculty_name",t1.getText());
                intent.putExtra("gender",result);
                startActivity(intent);

            }
        });
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                b1.setEnabled(isChecked);
            }
        });
    }
}
