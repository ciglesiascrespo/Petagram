package com.ciglesias.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ciglesias.petagram.R;
import com.ciglesias.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Ciglesias-pc on 05/03/2017.
 */
public class BaseDatos extends SQLiteOpenHelper {
    private Context context;


    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        insertarRegistrosIniciales();
    }

    @Override


    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "Create Table " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_ID_IMAGEN + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NRO_LIKES + " INTEGER" +
                ")";
        String queryCrearTablaMascotaLike = "Create Table " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKE + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKE_ID_MASCOTA + " INTEGER, " +
                "FOREIGN KEY(" + ConstantesBaseDatos.TABLE_MASCOTAS_LIKE_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTA_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaMascotaLike);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKE);
        onCreate(db);
    }

    public void insertarRegistrosIniciales() {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = " select * from " + ConstantesBaseDatos.TABLE_MASCOTAS;
        Cursor c = db.rawQuery(query, null);
//        Log.e("BaseDatos", "count: " + c.getCount());
        if (c != null && c.getCount() ==0) {
            insertarMascota(new Mascota("Alex", 0, R.drawable.img_mascota_1));
            insertarMascota(new Mascota("Dante", 0, R.drawable.img_mascota_2));
            insertarMascota(new Mascota("Kelpie", 0, R.drawable.img_mascota_3));
            insertarMascota(new Mascota("Kiba", 0, R.drawable.img_mascota_4));
            insertarMascota(new Mascota("Akamaru", 0, R.drawable.img_mascota_5));
            insertarMascota(new Mascota("Tyson", 0, R.drawable.img_mascota_6));
            insertarMascota(new Mascota("Tom", 0, R.drawable.img_mascota_7));
            insertarMascota(new Mascota("Toby", 0, R.drawable.img_mascota_8));
            insertarMascota(new Mascota("Firulais", 0, R.drawable.img_mascota_9));
        }

    }

    public void insertarMascota(Mascota mascota) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, mascota.getNombre());
        cv.put(ConstantesBaseDatos.TABLE_MASCOTA_ID_IMAGEN, mascota.getIdImage());
        cv.put(ConstantesBaseDatos.TABLE_MASCOTA_NRO_LIKES, mascota.getNroLikes());
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, cv);
        db.close();
    }

    public void insertarMascotaLike(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKE_ID_MASCOTA,id);
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS_LIKE, null, cv);
        db.close();
    }

    public void actualizarNroLike(Mascota mascota) {
        ContentValues cv = new ContentValues();
        cv.put(ConstantesBaseDatos.TABLE_MASCOTA_NRO_LIKES, mascota.getNroLikes());

        SQLiteDatabase db = this.getWritableDatabase();

        db.update(ConstantesBaseDatos.TABLE_MASCOTAS, cv, "id = " + mascota.getIdMascota(), null);
        db.close();
    }

    public int obtenerNroLikeMascota(int id) {
        int likes = 0;

        String query = "select " + ConstantesBaseDatos.TABLE_MASCOTA_NRO_LIKES + " from " + ConstantesBaseDatos.TABLE_MASCOTAS +
                " where " + ConstantesBaseDatos.TABLE_MASCOTA_ID + " = " + id;
        Cursor c = null;
        SQLiteDatabase db;
        try {
            db = this.getWritableDatabase();
            c = db.rawQuery(query, null);
            db.close();

            if (c != null) {
                if (c.moveToFirst()) {
                    if (!c.isNull(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_ID))) {
                        id = c.getInt(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_ID));
                    }
                }
            }
        } catch (Exception e) {
            Log.e("BaseDatos", "Error Obteniendo nro de la likes: " + e.getMessage());
            if (c != null && !c.isClosed()) {
                c.close();
            }
        } finally {
            if (c != null && !c.isClosed()) {
                c.close();
            }
        }
        return id;
    }

    public ArrayList<Mascota> obtenerUltimasMascotas(int limit) {
        ArrayList<Mascota> list = new ArrayList<Mascota>();
        Cursor c = null;
        SQLiteDatabase db = null;
        try {


            String query = "SELECT DISTINCT T.* " +
                    " FROM " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKE + " AS A " +
                    " INNER JOIN " + ConstantesBaseDatos.TABLE_MASCOTAS + " AS T ON A." + ConstantesBaseDatos.TABLE_MASCOTAS_LIKE_ID_MASCOTA + " = T." + ConstantesBaseDatos.TABLE_MASCOTA_ID +
                    " order by " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKE_ID + " desc" +
                    " LIMIT " + limit ;
            db = this.getWritableDatabase();
            c = db.rawQuery(query, null);

            if (c != null && c.moveToFirst()) {
                do {
                    int idMascota = 0, nroLikes = 0, idImagen = 0;
                    String nombreMascota = "";


                    if (!c.isNull(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_ID))) {
                        idMascota = c.getInt(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_ID));
                    }

                    if (!c.isNull(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_ID_IMAGEN))) {
                        idImagen = c.getInt(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_ID_IMAGEN));
                    }

                    if (!c.isNull(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_NRO_LIKES))) {
                        nroLikes = c.getInt(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_NRO_LIKES));
                    }

                    if (!c.isNull(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE))) {
                        nombreMascota = c.getString(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE));
                    }
                    list.add(new Mascota(idMascota, nombreMascota, nroLikes, idImagen));
                } while (c.moveToNext());
            }

        } catch (Exception e) {
            Log.e("BaseDatos", "Error obteniendo mascotas favoritas: " + e.getMessage());

            if (c != null && !c.isClosed()) {
                c.close();
            }
        } finally {
            if (c != null && !c.isClosed()) {
                c.close();
            }
        }
        db.close();
        return list;

    }

    public ArrayList<Mascota> obtenerTodasLasMAscotas() {
        ArrayList<Mascota> list = new ArrayList<Mascota>();
        Cursor c = null;
        SQLiteDatabase db = null;
        try {
            String query = "select * from " + ConstantesBaseDatos.TABLE_MASCOTAS;
            db = this.getWritableDatabase();
            c = db.rawQuery(query, null);
//            Log.e("BaseDatos", "Obtener todas las mascotas");
//            Log.e("BaseDatos", "sql : " + query);
//            Log.e("BaseDatos", "count: " + c.getCount());
            if (c != null && c.moveToFirst()) {
                Log.e("BaseDatos", "count: " + c.getCount());
                do {
                    int idMascota = 0, nroLikes = 0, idImagen = 0;
                    String nombreMascota = "";


                    if (!c.isNull(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_ID))) {
                        idMascota = c.getInt(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_ID));
                    }

                    if (!c.isNull(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_ID_IMAGEN))) {
                        idImagen = c.getInt(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_ID_IMAGEN));
                    }

                    if (!c.isNull(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_NRO_LIKES))) {
                        nroLikes = c.getInt(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_NRO_LIKES));
                    }

                    if (!c.isNull(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE))) {
                        nombreMascota = c.getString(c.getColumnIndex(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE));
                    }

//                    Log.e("BaseDatos", "id:" + idMascota + ", nombre: " + nombreMascota);
                    list.add(new Mascota(idMascota, nombreMascota, nroLikes, idImagen));
                } while (c.moveToNext());
            }

        } catch (Exception e) {
            Log.e("BaseDatos", "Error obteniendo mascotas: " + e.getMessage());

            if (c != null && !c.isClosed()) {
                c.close();
            }
        } finally {
            if (c != null && !c.isClosed()) {
                c.close();
            }
        }

        db.close();
        return list;

    }

}
