package cayren.emparejador;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by Cayren on 15/07/2015.
 */

public class RankingActivity extends Activity
{
    ArrayList<Jugador> listaJugadores = VariablesGlobales.getJugadores();
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        lv = (ListView) findViewById(R.id.LvRanking);
        final RankingAdapter adapter;
        adapter = new RankingAdapter(this, listaJugadores);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DialogFragment df = new ModificarDatos();
                ModificarDatos.posicion = position;
                df.show(getFragmentManager(),"Modificar");
                adapter.notifyDataSetChanged();
            }
        });
        //Deslizar item para borrarlo
        SwipeListViewTouchListener touchListener =new SwipeListViewTouchListener(lv,new SwipeListViewTouchListener.OnSwipeCallback() {
            @Override
            public void onSwipeLeft(ListView listView, int [] reverseSortedPositions) {

//Aqui ponemos lo que hara el programa cuando deslizamos un item ha la izquierda
                listaJugadores.remove(reverseSortedPositions[0]);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onSwipeRight(ListView listView, int [] reverseSortedPositions) {

//Aqui ponemos lo que hara el programa cuando deslizamos un item ha la derecha
                listaJugadores.remove(reverseSortedPositions[0]);
                adapter.notifyDataSetChanged();
            }
        },true, false);
        //Escuchadores del listView
        lv.setOnTouchListener(touchListener);
        lv.setOnScrollListener(touchListener.makeScrollListener());
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
