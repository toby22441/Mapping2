package com.example.a2durnt35.mapping;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;




public class SetLocationActivity extends AppCompatActivity implements View.OnClickListener {


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_set_location);
            Button search =(Button)findViewById(R.id.btnSearchLocation);
            search.setOnClickListener(this);
        }

        public void onClick(View view)
        {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();


            EditText lat = (EditText)findViewById(R.id.lat);
            double latitude = Double.parseDouble(lat.getText().toString());

            EditText lon = (EditText)findViewById(R.id.lon);
            double longitude = Double.parseDouble(lon.getText().toString());

            bundle.putDouble("com.example.a2durnt35.mapping.latitude",latitude);
            bundle.putDouble("com.example.a2durnt35.mapping.longitude",longitude);

           

            intent.putExtras(bundle);
            setResult(RESULT_OK,intent);
            finish();

        }
    }



