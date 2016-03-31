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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by usuario on 09/07/2015.
 */
public class Ronda2Activity extends Activity {

    ArrayList<Jugador> listaJugadores = VariablesGlobales.getJugadores();
    ListView lv;
    Context contexto;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ronda2);
        lv = (ListView) findViewById(R.id.LvLista2);
        contexto = this;
        final Button bnEmparejar = (Button) findViewById(R.id.BnEmparejarRonda2);
        final Button bnSiguiente = (Button) findViewById(R.id.BnSiguienteRound3);
        final Button bnRanking = (Button) findViewById(R.id.BnRankingRound2);
        //boton ranking
        bnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(contexto,RankingActivity.class);
                startActivity(i);
            }
        });
        //boton de emparejar
        bnEmparejar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ronda2Adapter adapter;
                adapter = new Ronda2Adapter(contexto, listaJugadores);
                lv.setAdapter(adapter);
            }
        });
         //pulsar una lista
         lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 DialogFragment df = new InsercionDatos();
                 InsercionDatos.posicion = position;
                 InsercionDatos.ronda = 2;
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
                 Collections.shuffle(VariablesGlobales.getMesas());
                 Intent i = new Intent(contexto,Ronda3Activity.class);
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
