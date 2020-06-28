package com.mzx.mazhuxin36;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignActivity extends AppCompatActivity {
        private static final int REQUEST_CODE_EDT = 10;
        private TextView sign_text;
        private Button mContentTxt;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign);
            sign_text = findViewById(R.id.sign_button);
            sign_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sign_text.setText("");
                    Log.e("", "");
                }
            });
            mContentTxt = findViewById(R.id.sign_button);
            Button cmitBtn = findViewById(R.id.sign_button);
            cmitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SignActivity.this, "修改完成", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignActivity.this, NetListActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_EDT);
                }
            });
        }
    }
