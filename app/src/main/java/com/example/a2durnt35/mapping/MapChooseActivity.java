package com.example.a2durnt35.mapping;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;

public class MapChooseActivity extends AppCompatActivity implements View.OnClickListener{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_choose);

        Button regular = (Button) findViewById(R.id.btnRegular);
        regular.setOnClickListener(this);
        Button hikebikemap = (Button) findViewById(R.id.btnHikeBikeMap);
        hikebikemap.setOnClickListener(this);
    }

        public void onClick(View view)
        {

            boolean hikebikemap=false;
            if (view.getId()==R.id.btnHikeBikeMap)
            {
                hikebikemap=true;
            }

            Intent intent = new Intent();
            Bundle returnedData=new Bundle();
            returnedData.putBoolean("com.example.a2durnt35.mapping.hikebikemap",hikebikemap);
            intent.putExtras(returnedData);
            setResult(RESULT_OK,intent);
            finish();
        }



    }

