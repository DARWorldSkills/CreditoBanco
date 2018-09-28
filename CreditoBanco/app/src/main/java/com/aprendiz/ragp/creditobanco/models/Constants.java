package com.aprendiz.ragp.creditobanco.models;

public class Constants {
    public static final String DATABASE_NAME ="creditobanco.db";
    public static final int DATABASE_VERSION =1;
    public static final String TABLE_MODULO ="CREATE TABLE MODULO (IDMODULO INTEGER, NOMBRE TEXT);";
    public static final String TABLE_TIPO_SOLICITUD ="CREATE TABLE SOLICITUD (IDSOLICITUD INTEGER, NOMBRE TEXT, MODULO INTEGER);";
    public static final String TABLE_TIPO_CLIENTE ="CREATE TABLE CLIENTE (IDCLIENTE INTEGER, NOMBRE TEXT);";
    public static final String TABLE_TAPIZAR ="CREATE TABLE TAPIZAR (IDTAPIZAR INTEGER, SOLICITUD INTEGER, CLIENTE INTEGER ,RETORNO INTEGER);";
    public static final String TABLE_TASA ="CREATE TABLE TASA (RTAPIZAR INTEGER, TAMANO INTEGER, TATASA INTEGER);";
}
