package cayren.emparejador;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by usuario on 07/07/2015.
 */
public class InsercionDatos extends DialogFragment{

    static int posicion = 0;
    static int ronda = 0;
    static String nombre = "";
    static String mesa = "";
    ArrayList<Jugador> jugadores = VariablesGlobales.getJugadores();
    EditText puntos;
    EditText puntosM;
    EditText puntosS;
    TextView nombreEti;
    CheckBox caja;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.activity_insercionpoints, null);
        nombreEti = (TextView) v.findViewById(R.id.TvNombrePla);
        nombreEti.setText(nombre);
        caja = (CheckBox) v.findViewById(R.id.CbPintura);
        puntos = (EditText) v.findViewById(R.id.EtPuntosRondas);
        puntosM = (EditText) v.findViewById(R.id.EtPuntosMatadosRondas);
        puntosS = (EditText) v.findViewById(R.id.EtPuntosSobrevividosRondas);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(v)
                // Add action buttons
                .setPositiveButton("Añadir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        boolean pintado = caja.isChecked();
                        int Ipuntos = 0;
                        int IpuntosM = 0;
                        int IpuntosS = 0;
                        if(!puntos.getText().toString().equals(""))
                        {
                            Ipuntos = Integer.parseInt(puntos.getText().toString());
                        }
                        if(!puntosM.getText().toString().equals(""))
                        {
                            IpuntosM = Integer.parseInt(puntosM.getText().toString());
                        }
                        if(!puntosS.getText().toString().equals(""))
                        {
                            IpuntosS= Integer.parseInt(puntosS.getText().toString());
                        }
                        jugadores.get(posicion).setPuntos(jugadores.get(posicion).getPuntos() + Ipuntos);
                        jugadores.get(posicion).setPuntosM(jugadores.get(posicion).getPuntosM() + IpuntosM);
                        jugadores.get(posicion).setPuntosS(jugadores.get(posicion).getPuntosS() + IpuntosS);
                        jugadores.get(posicion).setPinturaRonda(pintado,ronda);
                        jugadores.get(posicion).setMesasRonda(mesa,ronda);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                            InsercionDatos.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
