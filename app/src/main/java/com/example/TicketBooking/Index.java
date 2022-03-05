package com.example.TicketBooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.example.TicketBooking.databinding.ActivityIndexBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Index extends AppCompatActivity {

    ActivityIndexBinding binding;

    String[] number = {"One", "Two", "Three", "Four", "Five"};
    String[] selectclass = {"VIP", "Normal"};
    String[] selecttrain = {"RajDhaniExpress"};
    String[] selectprice = {"500"};
    int year;
    int month;
    int day;


    Spinner spinnerfrom, spinnerto;
    ArrayList<String>  fromList = new ArrayList<>();
    ArrayList<String> toList = new ArrayList<>();
    ArrayAdapter<String> fromAdapter;
    ArrayAdapter<String> toAdapter;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIndexBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // getSupportActionBar().hide();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Calendar calendar = Calendar.getInstance();

//        requestQueue = Volley.newRequestQueue(this);
//        spinnerfrom = findViewById(R.id.form);
//        spinnerto = findViewById(R.id.to);
       String url = "http://172.24.96.1/Api/inserdata.php";
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
//                url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONArray jsonArray = response.getJSONArray("station");
//                    for (int i=0; i<jsonArray.length();i++){
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        String from = jsonObject.optString("station_name");
//                        Toast.makeText(Index.this, ""+from, Toast.LENGTH_SHORT).show();
//                        fromList.add(from);
//                        fromAdapter = new ArrayAdapter<>(Index.this,
//                                android.R.layout.simple_spinner_item, fromList);
//                        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                        spinnerfrom.setAdapter(fromAdapter);
//
//                        String to = jsonObject.optString("to");
//                        toList.add(to);
//                        toAdapter = new ArrayAdapter<>(Index.this,
//                                android.R.layout.simple_spinner_item, fromList);
//                        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                        spinnerto.setAdapter(toAdapter);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        requestQueue.add(jsonObjectRequest);
//        spinnerfrom.setOnItemSelectedListener(this);


        ArrayList<String> citylist = new ArrayList<>();
        citylist.add("Rajkot");
        citylist.add("Surat");
        citylist.add("Borovali");
        citylist.add("Dehli");


        binding.form.setAdapter(new ArrayAdapter<>(Index.this,
                android.R.layout.simple_spinner_dropdown_item, citylist));

        binding.form.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
//                    Toast.makeText(getApplicationContext(), "pleese select the city", Toast.LENGTH_SHORT).show();
//                     binding.textView.setText("");
                } else {
//                     String sCity = parent.getItemAtPosition(position).toString();
//                    binding.textView.setText(sCity);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.to.setAdapter(new ArrayAdapter<>(Index.this,
                android.R.layout.simple_spinner_dropdown_item, citylist));

        binding.to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
//                   Toast.makeText(getApplicationContext(), "pleese select the city", Toast.LENGTH_SHORT).show();
//                     binding.textView.setText("");
                } else {
//                    String sCity = parent.getItemAtPosition(position).toString();
//                    binding.textView.setText(sCity);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, number);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.seat.setAdapter(arrayAdapter);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,selectclass);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.cls.setAdapter(adapter);


        ArrayAdapter aryad = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,selecttrain);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.trainselceted.setAdapter(aryad);

        ArrayAdapter ardt = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,selectprice);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.tktprice.setAdapter(ardt);

        binding.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getApplicationContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        binding.date.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_rtms, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.logout:
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                Toast.makeText(this, "Log Out Successfully", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        return true;
    }
}