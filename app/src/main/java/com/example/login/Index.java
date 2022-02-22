package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.databinding.ActivityIndexBinding;

import java.util.ArrayList;

public class Index extends AppCompatActivity{

    ActivityIndexBinding binding;

    String[] number = {"One","Two","Three","Four","Five"};
    String[] sleectclass = {"Sleepar","Genreal","First Class"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIndexBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("RTMS");
        getSupportActionBar() .setDisplayHomeAsUpEnabled(true);


        ArrayList<String> citylist = new ArrayList<>();

        citylist.add("Rajkot");
        citylist.add("gghg");
        citylist.add("mayurrf");
        citylist.add("kothghg");
        citylist.add("Rajkot");
        citylist.add("Rajkot");
        citylist.add("Rajkot");


        binding.spinner.setAdapter(new ArrayAdapter<>(Index.this,
                android.R.layout.simple_spinner_dropdown_item,citylist));

       binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
//                    Toast.makeText(getApplicationContext(), "pleese select the city", Toast.LENGTH_SHORT).show();
//                     binding.textView.setText("");
                }
                else {
                   // String sCity = parent.getItemAtPosition(position).toString();
//                    binding.textView.setText(sCity);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.spinner2.setAdapter(new ArrayAdapter<>(Index.this,
                android.R.layout.simple_spinner_dropdown_item,citylist));

        binding.spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
//                    Toast.makeText(getApplicationContext(), "pleese select the city", Toast.LENGTH_SHORT).show();
//                     binding.textView.setText("");
                }
                else {
                    String sCity = parent.getItemAtPosition(position).toString();
//                    binding.textView.setText(sCity);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Index.this, BookTicketRtms.class);
                startActivity(intent);
            }
        });

       ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,number);
       arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       binding.spinner3.setAdapter(arrayAdapter);

       ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,sleectclass);
       arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       binding.spinner4.setAdapter(adapter);



    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}