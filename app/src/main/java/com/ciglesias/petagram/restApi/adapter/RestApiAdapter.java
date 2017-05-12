package com.ciglesias.petagram.restApi.adapter;


import com.ciglesias.petagram.restApi.ConstantesRestApi;
import com.ciglesias.petagram.restApi.IEndPointsApi;
import com.ciglesias.petagram.restApi.deserializador.MascotaImagesDeserializador;
import com.ciglesias.petagram.restApi.deserializador.UsuarioDeserializador;
import com.ciglesias.petagram.restApi.model.MascotaResponse;
import com.ciglesias.petagram.restApi.model.UserResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ciglesias-pc on 17/03/2017.
 */
public class RestApiAdapter {
    public IEndPointsApi establecerConexionApiInstagram(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IEndPointsApi.class);
    }

    public IEndPointsApi establecerConexionApiNode() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL_NODE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IEndPointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaImagesDeserializador());
        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializadorInfoUser() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(UserResponse.class, new UsuarioDeserializador());
        return gsonBuilder.create();
    }

}
