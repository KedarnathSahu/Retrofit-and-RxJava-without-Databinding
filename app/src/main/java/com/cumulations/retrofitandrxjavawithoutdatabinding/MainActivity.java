package com.cumulations.retrofitandrxjavawithoutdatabinding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.cumulations.retrofitandrxjavawithoutdatabinding.CustomAdapter.CustomAdapter;
import com.cumulations.retrofitandrxjavawithoutdatabinding.model.Employee;
import com.cumulations.retrofitandrxjavawithoutdatabinding.model.EmployeeList;
import com.cumulations.retrofitandrxjavawithoutdatabinding.remote.APICALL;
import com.cumulations.retrofitandrxjavawithoutdatabinding.remote.RetroFitClass;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ListView listView;
    private CustomAdapter customAdapter;
    private List<Employee> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        button = (Button) findViewById(R.id.button);
        arraylist = new ArrayList<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                APICALL apicall = RetroFitClass.getAPIinstance();
                Call<EmployeeList> employeeListCall = apicall.getEmployeeList();
                employeeListCall.enqueue(new Callback<EmployeeList>() {
                    @Override
                    public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                        arraylist = response.body().getEmployees();
                        customAdapter = new CustomAdapter(MainActivity.this, arraylist);
                        listView.setAdapter(customAdapter);
                    }

                    @Override
                    public void onFailure(Call<EmployeeList> call, Throwable t) {

                    }
                });
            }
        });

    }


}