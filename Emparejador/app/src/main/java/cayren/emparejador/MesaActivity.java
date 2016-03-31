package cayren.emparejador;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by cayren on 30/06/2015.
 */
public class MesaActivity extends Activity {
    EditText campo;
    Context contexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesa);
        final Button bnAnadir = (Button) findViewById(R.id.BnAnadirMesa);
        final Button bnMesa = (Button) findViewById(R.id.BnMesas);
        campo = (EditText) findViewById(R.id.EtNombreMesa);
        contexto = this;
        bnMesa.setText(String.valueOf(VariablesGlobales.getMesas().size()));
        bnMesa.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(contexto,ListadoMesas.class);
                startActivity(i);
            }
        });
        bnAnadir.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = "";
                if(campo.getText().toString().equals(""))
                {
                    Toast.makeText(contexto, "Campo nombre vacio",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    nombre = campo.getText().toString();
                    ArrayList listaMesas = VariablesGlobales.getMesas();
                    listaMesas.add(nombre);
                    Toast.makeText(contexto,nombre + " Añadido",
                            Toast.LENGTH_SHORT).show();
                }
                bnMesa.setText(String.valueOf(VariablesGlobales.getMesas().size()));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
