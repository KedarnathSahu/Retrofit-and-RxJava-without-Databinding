package com.cumulations.retrofitandrxjavawithoutdatabinding.remote;

import com.cumulations.retrofitandrxjavawithoutdatabinding.model.EmployeeList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APICALL {

    @GET("f9qmk")
    Observable<EmployeeList> getEmployeeList();

}
