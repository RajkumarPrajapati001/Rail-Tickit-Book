package com.example.TicketBooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.TicketBooking.databinding.ActivityLoginBinding;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Login extends AppCompatActivity {

    ActivityLoginBinding binding;
    EditText uname, pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       // getSupportActionBar().setTitle("Login");
        //getSupportActionBar() .setDisplayHomeAsUpEnabled(true);

        uname = findViewById(R.id.txtUsername);
        pwd = findViewById(R.id.txtPassword);

       binding.dontHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);

            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String  username, password;
                username = String.valueOf(uname.getText());
                password = String.valueOf(pwd.getText());

                if (!username.equals("") && !password.equals("")) {
                    binding.progressBar.setVisibility(View.VISIBLE);

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable(){
                        @Override
                        public void run() {

                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "password";

                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;
                            PutData putData = new PutData("http://172.24.96.1/Api/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    binding.progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    Log.i("PutData", result);
                                    if (result.equals("Login Success")){
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),Index.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }

                                }
                            }

                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(),"All Field Requred", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
//    @Override
//    public boolean onSupportNavigateUp(){
//        onBackPressed();
//        return super.onSupportNavigateUp();
//    }

}