package com.aprendiz.ragp.creditobanco.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ManagerDB {
    Context context;
    GestorDB gestorDB;
    SQLiteDatabase db;

    public ManagerDB(Context context) {
        this.context = context;
    }

    public void openDBRead(){
        gestorDB = new GestorDB(context);
        db = gestorDB.getReadableDatabase();
    }

    public void openDBWrite(){
        gestorDB = new GestorDB(context);
        db = gestorDB.getWritableDatabase();
    }

    public void closeDB(){
        db.close();
    }

    public void inputModulo(Modulo modulo){
        openDBWrite();
        ContentValues values = new ContentValues();
        values.put("IDMODULO",modulo.getId());
        values.put("NOMBRE",modulo.getNombre());
        db.insert("MODULO",null,values);
        closeDB();
    }

    public void inputSolicitud(Solicitud solicitud){
        openDBWrite();
        ContentValues values = new ContentValues();
        values.put("IDSOLICITUD",solicitud.getId());
        values.put("NOMBRE",solicitud.getNombre());
        values.put("MODULO",solicitud.getModulo());
        db.insert("SOLICITUD",null,values);
        closeDB();
    }

    public void inputCliente(Cliente cliente){
        openDBWrite();
        ContentValues values = new ContentValues();
        values.put("IDCLIENTE",cliente.getId());
        values.put("NOMBRE",cliente.getNombre());
        db.insert("CLIENTE",null,values);
        closeDB();
    }

    public void inputTapizar(Tapizar tapizar){
        openDBWrite();
        ContentValues values = new ContentValues();
        values.put("IDTAPIZAR",tapizar.getId());
        values.put("SOLICITUD",tapizar.getSolicitud());
        values.put("CLIENTE",tapizar.getCliente());
        values.put("RETORNO",tapizar.getRetorno());
        db.insert("TAPIZAR",null,values);
        closeDB();
    }


    public void inputTasa(Tasa tasa){
        openDBWrite();
        ContentValues values = new ContentValues();
        values.put("RTAPIZAR",tasa.getrTapizar());
        values.put("TAMANO",tasa.getTamano());
        values.put("TATASA",tasa.getTasaTa());
        db.insert("TASA",null,values);
        closeDB();
    }


    public List<Modulo> selectModulo(){
        List<Modulo> results = new ArrayList<>();
        openDBRead();
        Cursor cursor = db.rawQuery("SELECT * FROM MODULO;",null);
        if (cursor.moveToFirst()){
            do {
                Modulo modulo = new Modulo();
                modulo.setId(cursor.getInt(0));
                modulo.setNombre(cursor.getString(1));

                results.add(modulo);
            }while (cursor.moveToNext());
        }

        cursor.close();
        closeDB();

        return results;
    }

    public List<Solicitud> selectSolicitud(int modulo){
        List<Solicitud> results = new ArrayList<>();
        openDBRead();
        Cursor cursor = db.rawQuery("SELECT * FROM SOLICITUD WHERE MODULO="+modulo+";",null);
        if (cursor.moveToFirst()){
            do {
                Solicitud solicitud = new Solicitud();
                solicitud.setId(cursor.getInt(0));
                solicitud.setNombre(cursor.getString(1));
                solicitud.setModulo(cursor.getInt(2));

                results.add(solicitud);
            }while (cursor.moveToNext());
        }

        cursor.close();
        closeDB();

        return results;
    }

    public List<Cliente> selectCliente(){
        List<Cliente> results = new ArrayList<>();
        openDBRead();
        Cursor cursor = db.rawQuery("SELECT * FROM CLIENTE;",null);
        if (cursor.moveToFirst()){
            do {
                Cliente cliente = new Cliente();
                cliente.setId(cursor.getInt(0));
                cliente.setNombre(cursor.getString(1));

                results.add(cliente);
            }while (cursor.moveToNext());
        }

        cursor.close();
        closeDB();

        return results;
    }

    public List<Tapizar> selectTapizar(int solicitud, int cliente){
        List<Tapizar> results = new ArrayList<>();
        openDBRead();
        Cursor cursor = db.rawQuery("SELECT RETORNO FROM TAPIZAR WHERE SOLICITUD="+solicitud+" AND CLIENTE="+cliente+";",null);
        if (cursor.moveToFirst()){
            do {
                Tapizar tapizar = new Tapizar();
                tapizar.setRetorno(cursor.getInt(0));


                results.add(tapizar);
            }while (cursor.moveToNext());
        }

        cursor.close();
        closeDB();

        return results;
    }


    public float selectTasa(int rTapizar, int tamano){
        float tasa =0;
        openDBRead();
        Cursor cursor = db.rawQuery("SELECT TATASA FROM TASA WHERE RTAPIZAR="+rTapizar+" AND TAMANO<"+tamano+";",null);
        if (cursor.moveToFirst()){
            do {
                if (tasa == 0) {
                    tasa = cursor.getFloat(0);
                }

            }while (cursor.moveToNext());
        }
        cursor.close();
        closeDB();
        return tasa;
    }


}
