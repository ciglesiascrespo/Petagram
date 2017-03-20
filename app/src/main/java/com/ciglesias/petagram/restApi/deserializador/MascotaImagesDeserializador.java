package com.ciglesias.petagram.restApi.deserializador;

import android.util.Log;

import com.ciglesias.petagram.pojo.MascotaImages;
import com.ciglesias.petagram.restApi.JsonKeys;
import com.ciglesias.petagram.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Ciglesias-pc on 18/03/2017.
 */
public class MascotaImagesDeserializador implements JsonDeserializer<MascotaResponse> {
    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);

        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
//        Log.e("MascotaImagesDeseria", "response: " + mascotaResponseData.toString());
        mascotaResponse.setListMascotas(deserializarMascotaImagesFromJson(mascotaResponseData));
        return mascotaResponse;
    }


    private ArrayList<MascotaImages> deserializarMascotaImagesFromJson(JsonArray mascotaResponseData) {
        ArrayList<MascotaImages> mascotas = new ArrayList<MascotaImages>();
        for (int i = 0; i < mascotaResponseData.size(); i++) {
            JsonObject contactoResponseObjet = mascotaResponseData.get(i).getAsJsonObject();
            JsonObject userJson = contactoResponseObjet.getAsJsonObject(JsonKeys.USER);

            String id = userJson.get(JsonKeys.USER_ID).getAsString();
            String nombreCompleto = userJson.get(JsonKeys.USER_FULL_NAME).getAsString();
            String urlImagePerfil = userJson.get(JsonKeys.USER_URL_IMAGE_PERFIL).getAsString();

            JsonObject imageJson = contactoResponseObjet.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);

            String url = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = contactoResponseObjet.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            MascotaImages mascotaActual = new MascotaImages(id, url, likes,urlImagePerfil,nombreCompleto);

            mascotas.add(mascotaActual);
        }

        return mascotas;
    }
}
