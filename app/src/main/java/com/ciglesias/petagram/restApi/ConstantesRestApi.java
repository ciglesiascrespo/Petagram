package com.ciglesias.petagram.restApi;

/**
 * Created by Ciglesias-pc on 16/03/2017.
 */
public class ConstantesRestApi {
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "4834759502.25800fd.cf71aa297aac43d996646a2f86ffc694";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECIENT_MEDIA_SELF_USER = "users/self/media/recent/";
    public static final String KEY_GET_RECIENT_MEDIA_USER = "users/{user}/media/recent/";
    public static final String KEY_GET_INFORMATION_USER_SEARCH = "users/search";
    public static final String KEY_AND = "&";

    public static final String URL_GET_RECIENT_MEDIA_SELF_USER = KEY_GET_RECIENT_MEDIA_SELF_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String URL_GET_RECIENT_MEDIA_USER = KEY_GET_RECIENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String URL_GET_INFORMATION_USER_SEARCH = KEY_GET_INFORMATION_USER_SEARCH + KEY_ACCESS_TOKEN + ACCESS_TOKEN;


    // Api Node
    public static final String ROOT_URL_NODE = "https://lit-fjord-42728.herokuapp.com/";
    public static final String KEY_POST_REGISTRAR_USUARIO = "registrar-usuario/";


}
