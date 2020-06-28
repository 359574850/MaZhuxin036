package com.mzx.mazhuxin36;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

        private static final int REQUEST_CODE_EDT = 10;
        private Button mContentTxt;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            mContentTxt = findViewById(R.id.edt_commit);
            final EditText nameEdt = findViewById(R.id.edt_name);
            final android.widget.EditText pwdEdt = findViewById(R.id.edt_pwd);
            Button cmitBtn = findViewById(R.id.edt_commit);
            cmitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nameVal = nameEdt.getText().toString().trim();
                    String pwdVal = pwdEdt.getText().toString().trim();
                    if (TextUtils.isEmpty(nameVal)) {
                        Toast.makeText(LoginActivity.this, "请输入姓名", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(pwdVal)) {
                        Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent(LoginActivity.this, NetListActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_EDT);
                    intent.putExtra("name", nameVal);
                    intent.putExtra("pwd", Integer.valueOf(pwdVal));
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }
    }