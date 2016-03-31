package cayren.emparejador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cayren on 05/07/2015.
 */
public class Ronda2Adapter extends ArrayAdapter {

    private Context context;
    private ArrayList datos;
    private ArrayList listaMesas = VariablesGlobales.getMesas();
    private ArrayList listaJugadores = VariablesGlobales.getJugadores();

    public Ronda2Adapter(Context context, ArrayList datos)
    {
        super(context,R.layout.bracketround1,datos);
        this.context=context;
        this.datos=datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.bracketround1, null);

        TextView jugador = (TextView) item.findViewById(R.id.TvJugador);
        Jugador j = (Jugador) listaJugadores.get(position);
        jugador.setText(j.nombre);

        TextView mesa = (TextView) item.findViewById(R.id.TvMesa);
        mesa.setText(listaMesas.get((int)Math.floor(position/2)).toString());

        return item;
    }
}
