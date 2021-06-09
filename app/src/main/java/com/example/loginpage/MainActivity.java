package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private  EditText name;
    private EditText pass;
    private Button btn;
    private TextView txt;
    private int counter=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name =(EditText)findViewById(R.id.usNamee);
        pass=(EditText)findViewById(R.id.usPass);
        btn=(Button)findViewById(R.id.lgBtn);
        txt=(TextView)findViewById(R.id.tvInf);
        txt.setText("No Of Attemps Remaining :5");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),pass.getText().toString());

            }
        });
    }
    private void validate(String uname, String upass)
    {
        String u="madiha";
        String p="abc";
        if(uname.equals(u) && upass.equals(p))
        {
            Intent intent=new Intent(MainActivity.this,SecActivity.class);
            startActivity(intent);
        }
        else{
              counter--;
              txt.setText("No of attempts remaining "+ String.valueOf(counter));
              if(counter==0)
              {
                  btn.setEnabled(false);
              }
        }
    }
}