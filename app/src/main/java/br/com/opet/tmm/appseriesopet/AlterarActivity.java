package br.com.opet.tmm.appseriesopet;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlterarActivity extends Activity {

    EditText titulo;
    EditText ingredientes;
    EditText preparo;
    EditText porcao;
    EditText tempo;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        titulo = (EditText)findViewById(R.id.editText4);
        ingredientes = (EditText)findViewById(R.id.editText5);
        preparo = (EditText)findViewById(R.id.editText6);
        porcao = (EditText)findViewById(R.id.editText7);
        tempo = (EditText)findViewById(R.id.editText8);


        alterar = (Button)findViewById(R.id.button2);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        titulo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TITULO)));
        ingredientes.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.INGREDIENTES)));
        preparo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.PREPARO)));
        porcao.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.PORCAO)));
        tempo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TEMPO)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistro(Integer.parseInt(codigo), titulo.getText().toString(),ingredientes.getText().toString(),
                        preparo.getText().toString(), porcao.getText().toString(), tempo.getText().toString());
                Intent intent = new Intent(AlterarActivity.this,ConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = (Button)findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(AlterarActivity.this,ConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
