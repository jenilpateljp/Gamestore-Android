package com.example.parctice26;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.*;
import android.content.*;

public class Form extends AppCompatActivity {


    RadioGroup radiocc;
    ImageView imgcc;
    Integer []photos = {R.drawable.visa,R.drawable.mastercard,R.drawable.amex};
    TextView title_form;
    ImageView img_form;
    int imgint;



    String data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        title_form = findViewById(R.id.title_form);
        img_form = findViewById(R.id.img_form);
        imgcc = findViewById(R.id.imgcc);
        radiocc = findViewById(R.id.radiocc);
        radiocc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                imgcc.setImageResource(photos[index]);
            }
        });

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("data1")){
            data1 =getIntent().getStringExtra("data1");
            imgint = getIntent().getIntExtra("display_imageView",1);

        }else {
            Toast.makeText(this,"No Data Found",Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title_form.setText(data1);
        img_form.setImageResource(imgint);


    }

}
