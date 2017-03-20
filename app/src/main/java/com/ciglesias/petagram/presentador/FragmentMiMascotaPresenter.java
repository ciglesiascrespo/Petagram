package com.ciglesias.petagram.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.ciglesias.petagram.fragment.IFragmentMiMacsota;
import com.ciglesias.petagram.pojo.MascotaImages;
import com.ciglesias.petagram.restApi.IEndPointsApi;
import com.ciglesias.petagram.restApi.adapter.RestApiAdapter;
import com.ciglesias.petagram.restApi.model.MascotaResponse;
import com.ciglesias.petagram.restApi.model.UserResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ciglesias-pc on 19/03/2017.
 */
public class FragmentMiMascotaPresenter implements IFragmentMiMascotaPresenter {
    private Context context;
    private ArrayList<MascotaImages> mascotaImages;
    private IFragmentMiMacsota iFragmentMiMacsota;


    public FragmentMiMascotaPresenter(Context context, IFragmentMiMacsota iFragmentMiMacsota, String user) {
        this.context = context;
        this.iFragmentMiMacsota = iFragmentMiMacsota;
        obtenerInfoUser(user);
//        obtenerMediaRecentUser(user);
    }


    @Override
    public void obtenerMediaRecentUser(String user) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        IEndPointsApi iEndPointsApi = restApiAdapter.establecerConexionApiInstagram(gsonMediaRecent);

        Call<MascotaResponse> contactoResponseCall = iEndPointsApi.getRecentMediaUser(user);

        contactoResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                if (response != null) {
                    mascotaImages = response.body().getListMascotas();
                    mostrarMediaRecentUser();
                } else {
                    Toast.makeText(context, "Algo falló", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Algo falló", Toast.LENGTH_SHORT).show();
                Log.e("Error conexion", "Error: " + t.getMessage());
            }
        });
    }

    @Override
    public void mostrarMediaRecentUser() {
        String nombre = mascotaImages.get(0).getNombrePerfil();
        String urlPerfil = mascotaImages.get(0).getUrlImagePerfil();
        iFragmentMiMacsota.mostrarInformacionUsuario(nombre,urlPerfil);
        iFragmentMiMacsota.generarGridLayoutManager();
        iFragmentMiMacsota.inicializarAdaptadorRV(iFragmentMiMacsota.crearAdaptador(mascotaImages));
    }

    @Override
    public void obtenerInfoUser(final String user) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonInfoUser = restApiAdapter.construyeGsonDeserializadorInfoUser();
        IEndPointsApi iEndPointsApi = restApiAdapter.establecerConexionApiInstagram(gsonInfoUser);

        Call<UserResponse> userResponseCall = iEndPointsApi.getInfoUser(user);

        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
//                Log.e("MiMascotaPresenter", "Url: " + response.raw().request().url() );
                if (response.body() != null) {

                    String userId = response.body().getUsuarios().get(0).getId();
                    obtenerMediaRecentUser(userId);
                } else {
                    Toast.makeText(context, "Usuario " + user + "no registrado" , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(context, "Usuario " + user + "no registrado" , Toast.LENGTH_SHORT).show();
                Log.e("Error conexion", "Error: " + t.getMessage());
            }
        });
    }
}
