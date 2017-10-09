package edu.brandeis.cs.yanchengchen.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AlertDialog;



public class MainActivity extends AppCompatActivity {
    private Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent(this, Convert.class);



        button =(Button)findViewById(R.id.button_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent, 1);//
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    showDialog(returnedData);

                }
                break;
            default:
                showDialog("None");
        }
    }
    private void showDialog(String string) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("RESULT");
        builder.setMessage("The last excute result is " + string);
        builder.setNegativeButton("Dimiss", null);
        builder.setPositiveButton("OK", null);
        builder.show();
    }


}
