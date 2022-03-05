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

import com.example.TicketBooking.databinding.ActivityRegisterBinding;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Register extends AppCompatActivity {

    ActivityRegisterBinding binding;
        EditText fname, uname, addres, phnumber, gmail, pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       // getSupportActionBar().setTitle("Register");
        //getSupportActionBar() .setDisplayHomeAsUpEnabled(true);

        fname = findViewById(R.id.txtFullname);
        uname = findViewById(R.id.txtUsername);
        addres = findViewById(R.id.txtAddress);
        phnumber = findViewById(R.id.txtPhonenumber);
        gmail = findViewById(R.id.txtEmail);
        pwd = findViewById(R.id.txtPassword);


       binding.iHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext() , Login.class);
                startActivity(intent);


            }
        });

       binding.btnRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              final String fullname, username, address, mobile, email, password;
               fullname = String.valueOf(fname.getText());
               username = String.valueOf(uname.getText());
               address = String.valueOf(addres.getText());
               mobile = String.valueOf(phnumber.getText());
               email = String.valueOf(gmail.getText());
               password = String.valueOf(pwd.getText());

               if (!fullname.equals("") && !username.equals("") && !address.equals("") &&
                       !mobile.equals("") && !email.equals("") && !password.equals("")) {
                    binding.progressBar.setVisibility(View.VISIBLE);

                   Handler handler = new Handler(Looper.getMainLooper());
                   handler.post(new Runnable(){
                       @Override
                       public void run() {

                           String[] field = new String[6];
                           field[0] = "fullname";
                           field[1] = "username";
                           field[2] = "address";
                           field[3] = "mobile";
                           field[4] = "email";
                           field[5] = "password";

                           String[] data = new String[6];
                           data[0] = fullname;
                           data[1] = username;
                           data[2] = address;
                           data[3] = mobile;
                           data[4] = email;
                           data[5] = password;
                           PutData putData = new PutData("http://172.24.96.1/Api/signup.php", "POST", field, data);
                           if (putData.startPut()) {
                               if (putData.onComplete()) {
                                   binding.progressBar.setVisibility(View.GONE);
                                   String result = putData.getResult();
                                    Log.i("PutData", result);
                                   if (result.equals("Register Success")){
                                       Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                       Intent intent = new Intent(Register.this,Login.class);
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