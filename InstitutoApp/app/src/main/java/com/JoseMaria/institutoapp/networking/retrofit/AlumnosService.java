package com.JoseMaria.institutoapp.networking.retrofit;

import com.JoseMaria.institutoapp.model.Alumnos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlumnosService {

    @GET("alumnos")
    Call<List<Alumnos>> searchAll();

    @POST("alumnos")
    Call<Alumnos> add(@Body Alumnos entity);

    @PUT("alumnos/{id}")
    Call<Alumnos> update(@Path("id") String dni,
                        @Body Alumnos entity);

    @DELETE("alumnos/{id}")
    Call<Alumnos> delete(@Path("id") String dni);
}
