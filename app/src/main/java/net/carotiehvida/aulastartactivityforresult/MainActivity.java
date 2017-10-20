package net.carotiehvida.aulastartactivityforresult;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final Integer evenCode = 26;
    public static Integer succesCode = 324;
    public static Integer failCode = 666;
    public final Integer contactCode = 845;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCalc = (Button) findViewById(R.id.button);
        Button btContato = (Button) findViewById(R.id.button2) ;

        btContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri agenda = Uri.parse("content://contacts");
                Intent it = new Intent(Intent.ACTION_PICK, agenda);
                it.setType(ContactsContract.Contacts.CONTENT_TYPE);
                startActivityForResult(it, contactCode);
            }
        });

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numeroEt = (EditText) findViewById(R.id.editText);
                Double numero = Double.parseDouble( numeroEt.getText().toString());

                Intent it = new Intent(MainActivity.this, CalculaPar.class);
                it.putExtra("number", numero);
                startActivityForResult(it, evenCode);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == this.evenCode){
            if(resultCode == MainActivity.failCode) {
                Toast.makeText(MainActivity.this, "Algo de errado não está certo", Toast.LENGTH_LONG).show();
            }else if(requestCode == MainActivity.succesCode){
                String resultado = data.getStringExtra("mensagem");
                Toast.makeText(MainActivity.this, resultado, Toast.LENGTH_LONG).show();
            }else if(requestCode == contactCode){
                Log.i("Resultado Contatos", resultCode+"");
                Log.i("Resultado Contatos", data.getData().toString());

                Uri uriContato = data.getData();
                Intent it = new Intent(Intent.ACTION_VIEW, uriContato);
                startActivity(it);
            }
        }
    }
}
