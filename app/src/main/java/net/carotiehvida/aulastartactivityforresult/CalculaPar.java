package net.carotiehvida.aulastartactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class CalculaPar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula_par);

        Intent it = getIntent();
        Log.i("Par", "Prigunda Tela");
        if( it != null) {
            Double number = it.getDoubleExtra("number", 0);
            int resto = (int) (number % 2);
            String retorno = "impar";

            if (resto == 0) retorno = "É par!";

            Intent it2 = new Intent();
            it2.putExtra("mensagem", retorno);

            setResult(MainActivity.succesCode, it2);
            finish();
        }else{
            setResult(MainActivity.failCode, null);
            finish();
        }
    }
}
