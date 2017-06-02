package br.com.opet.tmm.appseriesopet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Diego on 04/05/2017.
 */

public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "receitas";
    public static final String ID = "_id";
    public static final String TITULO = "titulo";
    public static final String INGREDIENTES = "ingredientes";
    public static final String PREPARO = "preparo";
    public static final String PORCAO = "porcao";
    public static final String TEMPO = "tempo";
    public static final int VERSAO = 1;

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + TITULO + " text,"
                + INGREDIENTES + " text,"
                + PREPARO + " text"
                + PORCAO + " text"
                + TEMPO + " text"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
