package edu.brandeis.cs.yanchengchen.assignment2;

/**
 * Created by yancheng on 2017/10/9.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
//edu.brandies.cs.yourname.helloorientation


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;



/**
 * Created by yancheng on 2017/10/6.
 */

public class Convert extends Activity {
    //private Button return_button;
    private String string = "0";
    EditText edit_text2,edit_text1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        edit_text1 = (EditText) findViewById(R.id.edit_text1);
        edit_text2 = (EditText) findViewById(R.id.edit_text2);


        //convert button
        Button convert_Button = (Button) findViewById(R.id.button_convert);
        convert_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                string = edit_text1.getText().toString();
                double km = 0;
                try {
                    km = Double.parseDouble(string);
                }catch (Exception e) {

                }
                double mile = km * (1/1.6093);
                BigDecimal b = new BigDecimal(mile);
                mile = b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();

                string = Double.toString(mile);

                edit_text2.setText(string, TextView.BufferType.EDITABLE);
            }
        });

        //clear button
        Button clear_button = (Button) findViewById(R.id.button_clear);
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_text1.setText("", TextView.BufferType.NORMAL);
                edit_text2.setText("", TextView.BufferType.NORMAL);
            }
        });


        //about button
        Button about_button = (Button) findViewById(R.id.button_about);
        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        //return button
        Button return_button = (Button) findViewById(R.id.button_return) ;
        return_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return", string);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

    private void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ABOUT");
        builder.setMessage("This convertion is coverting km to mile.\n" +
                "Formula: \n" +
                "1 km = (1/1.6093) mile = 0.621 mile");
        builder.setNegativeButton("Dimiss", null);
        builder.setPositiveButton("OK", null);
        builder.create().show();
    }
}
