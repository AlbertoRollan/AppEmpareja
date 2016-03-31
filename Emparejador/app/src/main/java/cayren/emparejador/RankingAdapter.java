package cayren.emparejador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cayren on 15/07/2015.
 */
public class RankingAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList datos;
    private ArrayList listaJugadores = VariablesGlobales.getJugadores();

    public RankingAdapter(Context context,ArrayList datos)
    {
        super(context,R.layout.bracketranking,datos);
        this.context=context;
        this.datos=datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.bracketranking, null);

        TextView juga = (TextView) item.findViewById(R.id.TvJugadorRk);
        Jugador j = (Jugador) listaJugadores.get(position);
        juga.setText(j.getNombre());

        TextView puntos = (TextView) item.findViewById(R.id.PuntosK);
        puntos.setText(String.valueOf(j.getPuntos()));

        TextView puntosM = (TextView) item.findViewById(R.id.PuntosMK);
        puntosM.setText(String.valueOf(j.getPuntosM()));

        TextView puntosS = (TextView) item.findViewById(R.id.PuntosSK);
        puntosS.setText(String.valueOf(j.getPuntosS()));

        return item;
    }
}