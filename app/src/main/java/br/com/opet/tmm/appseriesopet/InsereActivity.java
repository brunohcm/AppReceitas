package br.com.opet.tmm.appseriesopet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsereActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText titulo = (EditText)findViewById(R.id.editText);
                EditText ingredientes = (EditText)findViewById((R.id.editText2));
                EditText preparo = (EditText)findViewById(R.id.editText3);
                EditText porcao = (EditText)findViewById(R.id.editText4);
                EditText tempo = (EditText)findViewById(R.id.editText5);
                String tituloString = titulo.getText().toString();
                String ingredientesString = ingredientes.getText().toString();
                String preparoString = preparo.getText().toString();
                String porcaoString = porcao.getText().toString();
                String tempoString = tempo.getText().toString();
                String resultado;

                resultado = crud.insereDado(tituloString,ingredientesString,preparoString, porcaoString, tempoString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}
