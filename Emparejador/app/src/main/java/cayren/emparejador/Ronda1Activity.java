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
import android.widget.CheckBox;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Cayren on 01/07/2015.
 */
public class Ronda1Activity extends Activity {

    ArrayList<Jugador> listaJugadores = VariablesGlobales.getJugadores();
    ListView lv;
    Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ronda1);
        lv = (ListView) findViewById(R.id.LvRondaOne);
        contexto = this;
        final Button bnEmparejar = (Button) findViewById(R.id.BnEmparejar);
        final Button bnSiguiente = (Button) findViewById(R.id.BnSiguienteRound);
        final CheckBox emparejar = (CheckBox) findViewById(R.id.CbClub);
        Collections.shuffle(listaJugadores);
        //boton de emparejar
        bnEmparejar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!emparejar.isChecked()) {
                    emparejarNoClub();
                }
                Ronda1Adapter adapter;
// Inicializamos el adapter.

                adapter = new Ronda1Adapter(contexto, listaJugadores,lv);
// Asignamos el Adapter al ListView, en este punto hacemos que el
// ListView muestre los datos que queremos.
                lv.setAdapter(adapter);
            }
        });
        //pulsar una lista
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DialogFragment df = new InsercionDatos();
                InsercionDatos.posicion = position;
                InsercionDatos.ronda = 1;
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
                Intent i = new Intent(contexto,Ronda2Activity.class);
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

    public void emparejarNoClub() {
        ArrayList<Jugador> listaOriginal = VariablesGlobales.getJugadores();
        for (int j = 0;j<listaOriginal.size()-1;j++) {
            if (j % 2 == 0) {
                if(listaOriginal.get(j).getGrupo().equals(listaOriginal.get(j + 1).getGrupo())) {
                    for (int i = j+2; i < listaOriginal.size(); i++) {
                        //Intercambiamos valores
                        Jugador variableauxiliar = listaOriginal.get(j);
                        listaOriginal.set(j, listaOriginal.get(i));
                        listaOriginal.set(i, variableauxiliar);
                        //comprobar que las dos parejas no se rompan
                        if((listaOriginal.get(j).getGrupo().equals(listaOriginal.get(j + 1).getGrupo())) || (listaOriginal.get(i).getGrupo().equals(listaOriginal.get(i + 1).getGrupo())))
                        {
                            //Intercambiamos valores
                            Jugador aux = listaOriginal.get(j);
                            listaOriginal.set(j, listaOriginal.get(i));
                            listaOriginal.set(i, aux);
                        }
                    }
                }
            }
        }
    }
}
