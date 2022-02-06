package com.JoseMaria.institutoapp.networking;

import com.JoseMaria.institutoapp.model.Alumnos;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AlumnosFetchResults {

    @SerializedName("results")
    @Expose
    private List<Alumnos> results;

    public List<Alumnos> getResults() {
        return results;
    }

    public void setResults(ArrayList<Alumnos> results) {this.results = results;}
}
