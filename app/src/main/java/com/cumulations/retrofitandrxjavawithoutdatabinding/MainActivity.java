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

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                APICALL apicall = RetroFitClass.getAPIinstance();

                Observable<EmployeeList> observable = apicall.getEmployeeList()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());

                observable.subscribe(new Observer<EmployeeList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(EmployeeList employeeList) {
                        arraylist = new ArrayList<>();
                        List<Employee> employees = employeeList.getEmployees();

                        for (int i = 0; i < employees.size(); i++) {
                            Employee employee = new Employee();
                            employee.setFirstName(employees.get(i).getFirstName());
                            employee.setLastName(employees.get(i).getLastName());
                            arraylist.add(employee);
                        }

                        customAdapter = new CustomAdapter(MainActivity.this, arraylist);
                        listView.setAdapter(customAdapter);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });

    }


}