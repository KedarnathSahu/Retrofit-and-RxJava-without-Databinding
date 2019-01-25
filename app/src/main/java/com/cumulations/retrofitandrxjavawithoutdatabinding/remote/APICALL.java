package com.cumulations.retrofitandrxjavawithoutdatabinding.remote;

import com.cumulations.retrofitandrxjavawithoutdatabinding.model.EmployeeList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICALL {

    @GET("f9qmk")
    Call<EmployeeList> getEmployeeList();

}
