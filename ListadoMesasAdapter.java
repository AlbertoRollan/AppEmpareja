package cayren.emparejador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cayren on 23/07/2015.
 */
public class ListadoMesasAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList datos;

    public ListadoMesasAdapter(Context context, ArrayList datos) {
        super(context, R.layout.bracketmesas, datos);
        this.context = context;
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.bracketmesas, null);

        TextView juga = (TextView) item.findViewById(R.id.TvMesa);
        ArrayList<String> m = VariablesGlobales.getMesas();
        juga.setText(m.get(position));

        return item;
    }
}
