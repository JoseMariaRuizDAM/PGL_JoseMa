package com.JoseMaria.institutoapp.networking;

import com.JoseMaria.institutoapp.networking.retrofit.AlumnosService;
import com.JoseMaria.institutoapp.networking.retrofit.RetrofitClient;

public class ApiUtils {

    private ApiUtils(){
    };

    public static final String API_URL = "https://rest-instituto.herokuapp.com/api/";


    public static AlumnosService getAlumnosService(){
        return RetrofitClient.getClient(API_URL).create(AlumnosService.class);
    }
}
