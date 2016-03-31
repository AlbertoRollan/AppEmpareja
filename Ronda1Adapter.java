package cayren.emparejador;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by cayren on 05/07/2015.
 */
public class Ronda1Adapter extends ArrayAdapter {

    private Context context;
    private ArrayList datos;
    private ArrayList listaMesas = VariablesGlobales.getMesas();
    private ArrayList listaJugadores = VariablesGlobales.getJugadores();
    ListView lv;

    public Ronda1Adapter(Context context,ArrayList datos,ListView lv)
    {
        super(context,R.layout.bracketround1,datos);
        this.context=context;
        this.datos=datos;
        this.lv = lv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            LayoutInflater inflater = LayoutInflater.from(context);
            View item = inflater.inflate(R.layout.bracketround1, null);

            TextView jugador = (TextView) item.findViewById(R.id.TvJugador);
            Jugador j = (Jugador) listaJugadores.get(position);
            jugador.setText(j.nombre);

            TextView mesa = (TextView) item.findViewById(R.id.TvMesa);
            mesa.setText(listaMesas.get((int) Math.floor(position / 2)).toString());
            return item;
        }catch (IndexOutOfBoundsException ex)
        {
            View v = new View(context);
            Toast.makeText(context,"Por favor, mire que la cantidad de jugadores es la correcta.",
                    Toast.LENGTH_SHORT).show();
            //falta limpiar la lista
            return v;
        }
    }
}
