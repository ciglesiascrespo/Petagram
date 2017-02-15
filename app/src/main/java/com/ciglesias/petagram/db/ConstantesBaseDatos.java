package com.ciglesias.petagram.db;

/**
 * Created by Ciglesias-pc on 05/03/2017.
 */
public class ConstantesBaseDatos {
    public static final String DATABASE_NAME = "MascotasDb";
    public static final int DATABASE_VERSION = 1;

    // TABLA MASCOTAS
    public static final String TABLE_MASCOTAS = "Mascota";
    public static final String TABLE_MASCOTA_NOMBRE = "nombre";
    public static final String TABLE_MASCOTA_NRO_LIKES = "nro_likes";
    public static final String TABLE_MASCOTA_ID = "id";
    public static final String TABLE_MASCOTA_ID_IMAGEN = "id_imagen";

    // TABLA MASCOTAS LIKE
    public static final String TABLE_MASCOTAS_LIKE = "Mascotas_likes";
    public static final String TABLE_MASCOTAS_LIKE_ID = "id";
    public static final String TABLE_MASCOTAS_LIKE_ID_MASCOTA = "id_mascota";

}
