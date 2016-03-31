package cayren.emparejador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cayren on 22/07/2015.
 */
public class RankingFinalAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList datos;
    private ArrayList listaJugadores = VariablesGlobales.getJugadores();

    public RankingFinalAdapter(Context context,ArrayList datos)
    {
        super(context,R.layout.bracketrankingfinal,datos);
        this.context=context;
        this.datos=datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.bracketrankingfinal, null);

        TextView juga = (TextView) item.findViewById(R.id.TvJugadorRF);
        Jugador j = (Jugador) listaJugadores.get(position);
        juga.setText(j.getNombre());

        TextView puntos = (TextView) item.findViewById(R.id.PuntosF);
        puntos.setText(String.valueOf(j.getPuntos()));

        TextView puntosM = (TextView) item.findViewById(R.id.PuntosMF);
        puntosM.setText(String.valueOf(j.getPuntosM()));

        TextView puntosS = (TextView) item.findViewById(R.id.PuntosSF);
        puntosS.setText(String.valueOf(j.getPuntosS()));

        TextView pintado = (TextView) item.findViewById(R.id.Pintura);
        pintado.setText(j.getPintado());

        return item;
    }
}
