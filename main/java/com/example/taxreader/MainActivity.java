package com.example.taxreader;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText edit_tax;
    Button calbtn;
    TextView textResult1, textResult2, textResult3,textResult4;
    String result;
    int integer;
    double resulttax1, resulttax2, tax3, tax4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setTitle("소득세 판독기");

        edit_tax = findViewById(R.id.Edit1);

        calbtn = findViewById(R.id.btn_add);

        textResult1 = findViewById(R.id.TextResult1);
        textResult2 = findViewById(R.id.TextResult3);
        textResult3 = findViewById(R.id.TextResult2);
        textResult4 = findViewById(R.id.TextResult4);



        calbtn.setOnTouchListener(new View.OnTouchListener(){
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event){

                result = edit_tax.getText().toString();
               integer = Integer.parseInt(result);

               resulttax1 = integer*0.08;
               resulttax2 = integer*0.03;
               tax3 = resulttax1*0.1;
               tax4 = resulttax2*0.1;


               textResult1.setText("기타 소득세 : " + resulttax1);
               textResult2.setText("사업 소득세 : " + resulttax2);
               textResult3.setText("기타 지방소득세 : " + tax3);
               textResult4.setText("사업 지방소득세 : " + tax4);

               return false;
           }
        });

    }

}