package com.ciglesias.petagram.restApi;

import com.ciglesias.petagram.restApi.model.MascotaResponse;
import com.ciglesias.petagram.restApi.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ciglesias-pc on 16/03/2017.
 */
public interface IEndPointsApi {
    @GET(ConstantesRestApi.URL_GET_RECIENT_MEDIA_SELF_USER)
    Call<MascotaResponse> getRecentMedia();

    @GET(ConstantesRestApi.URL_GET_RECIENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMediaUser(@Path("user") String user);

    @GET(ConstantesRestApi.URL_GET_INFORMATION_USER_SEARCH)
    Call<UserResponse> getInfoUser(@Query("q") String user);

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_REGISTRAR_USUARIO)
    Call<String> registrarUsuario(@Field("id_dispositivo") String idDispositivo, @Field("id_usuario_instagram") String idUsuario);
}
