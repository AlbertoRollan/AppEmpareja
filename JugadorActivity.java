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
 * Created by Cayren on 30/06/2015.
 */

public class JugadorActivity extends Activity {

    Context contexto;
    EditText nombreJ;
    EditText clubJ;
    EditText itsJ;
    EditText faccionJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugador);
        contexto = this;
        final Button bnAnadir = (Button) findViewById(R.id.BnAnadirJugador);
        final Button bnBye = (Button) findViewById(R.id.BnAnadirBye);
        final Button bnCantidad = (Button) findViewById(R.id.BnCantidadJ);
        bnCantidad.setText(String.valueOf(VariablesGlobales.getJugadores().size()));
        nombreJ = (EditText) findViewById(R.id.EtNombreJugador);
        clubJ = (EditText) findViewById(R.id.EtClub);
        itsJ = (EditText) findViewById(R.id.EtIts);
        faccionJ = (EditText) findViewById(R.id.EtFaccion);
        bnAnadir.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre ="";
                String club = "";
                String its = "";
                String faccion = "";
                nombre = nombreJ.getText().toString();
                club = clubJ.getText().toString();
                its = itsJ.getText().toString();
                faccion = faccionJ.getText().toString();
                if(nombre.equals(""))
                {
                    Toast.makeText(contexto, "Campo nombre vacio",
                            Toast.LENGTH_SHORT).show();
                }
                else if(club.equals(""))
                {
                    Toast.makeText(contexto, "Campo club vacio",
                            Toast.LENGTH_SHORT).show();
                }
                else if(faccion.equals(""))
                {
                    Toast.makeText(contexto, "Campo Ejercito vacio",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Jugador j = new Jugador(nombre,its,club,faccion);
                    j.setPuntos(0);
                    j.setPuntosM(0);
                    j.setPuntosS(0);
                    ArrayList listaJugadores = VariablesGlobales.getJugadores();
                    listaJugadores.add(j);
                    Toast.makeText(contexto, nombre +" "+ club+" "+faccion+" "+ its+ " Añadido",
                            Toast.LENGTH_SHORT).show();
                }
                bnCantidad.setText(String.valueOf(VariablesGlobales.getJugadores().size()));
            }
        });
        bnBye.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList listaJugadores = VariablesGlobales.getJugadores();
                Jugador bye = new Jugador("bye","bye","bye","bye");
                bye.setPuntos(0);
                bye.setPuntosM(0);
                bye.setPuntosS(0);
                listaJugadores.add(bye);
                Toast.makeText(contexto, "Jugador Bye Added",
                        Toast.LENGTH_SHORT).show();
                bnCantidad.setText(String.valueOf(VariablesGlobales.getJugadores().size()));
            }
        });
        bnCantidad.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(contexto,RankingActivity.class);
                startActivity(i);
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
