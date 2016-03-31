package cayren.emparejador;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Cayren on 23/07/2015.
 */
public class ListadoMesas extends Activity {
    ArrayList<String> listaMesas = VariablesGlobales.getMesas();
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesaslistado);
        lv = (ListView) findViewById(R.id.LvMesas);
        final ListadoMesasAdapter adapter;
        adapter = new ListadoMesasAdapter(this, listaMesas);
        lv.setAdapter(adapter);
        //Deslizar item para borrarlo
        SwipeListViewTouchListener touchListener =new SwipeListViewTouchListener(lv,new SwipeListViewTouchListener.OnSwipeCallback() {
            @Override
            public void onSwipeLeft(ListView listView, int [] reverseSortedPositions) {

//Aqui ponemos lo que hara el programa cuando deslizamos un item ha la izquierda
                listaMesas.remove(reverseSortedPositions[0]);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onSwipeRight(ListView listView, int [] reverseSortedPositions) {

//Aqui ponemos lo que hara el programa cuando deslizamos un item ha la derecha
                listaMesas.remove(reverseSortedPositions[0]);
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