package cayren.emparejador;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
  *  Created by Cayren on 17/07/2015.
 */
public class Ronda3Activity extends Activity {

    ArrayList<Jugador> listaJugadores = VariablesGlobales.getJugadores();
    ListView lv;
    Context contexto;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ronda3);
        lv = (ListView) findViewById(R.id.LvLista3);
        contexto = this;
        final Button bnEmparejar = (Button) findViewById(R.id.BnEmparejarRonda3);
        final Button bnSiguiente = (Button) findViewById(R.id.BnFin);
        final Button bnRanking = (Button) findViewById(R.id.BnRankingRound3);
        //boton ranking
        bnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(contexto,RankingActivity.class);
                startActivity(i);
            }
        });
        //bo
        //boton de emparejar
        bnEmparejar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ronda3Adapter adapter;
                adapter = new Ronda3Adapter(contexto, listaJugadores);
                lv.setAdapter(adapter);
            }
        });
        //pulsar una lista
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DialogFragment df = new InsercionDatos();
                InsercionDatos.posicion = position;
                InsercionDatos.ronda = 3;
                InsercionDatos.mesa = VariablesGlobales.getMesas().get((int)Math.floor(position/2)).toString();
                InsercionDatos.nombre = listaJugadores.get(position).getNombre();
                df.show(getFragmentManager(),"Datos");

            }
        });
        //boton siguiente
        bnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VariablesGlobales.ordenarRanking();
                establecerPintura();
                Intent i = new Intent(contexto,RankingFinalActivity.class);
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

    public void establecerPintura()
    {
        for(Jugador j : listaJugadores)
        {
            boolean[] arraypintado = j.getPintura();
            if(arraypintado[0] && arraypintado[1] && arraypintado[2])
            {
                j.setPintado("Si");
                j.setPuntos(j.getPuntos()+2);
            }
        }
    }
}
