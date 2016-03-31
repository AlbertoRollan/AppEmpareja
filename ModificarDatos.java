package cayren.emparejador;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;

/**
  * Created by Cayren on 22/07/2015.
 */

public class ModificarDatos extends DialogFragment {

    static int posicion = 0;
    ArrayList<Jugador> jugadores = VariablesGlobales.getJugadores();
    EditText nombre;
    EditText club;
    EditText ejercito;
    EditText its;
    EditText points;
    EditText pointsM;
    EditText pointsS;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.activity_modificarjugador, null);
        nombre = (EditText) v.findViewById(R.id.EtNombreMod);
        club = (EditText) v.findViewById(R.id.EtClubMod);
        ejercito = (EditText) v.findViewById(R.id.EtEjercitoMod);
        its = (EditText) v.findViewById(R.id.EtItsMod);
        points = (EditText) v.findViewById(R.id.EtPuntosRondasM);
        pointsM = (EditText) v.findViewById(R.id.EtPuntosMatadosRondasM);
        pointsS = (EditText) v.findViewById(R.id.EtPuntosSobrevividosRondasM);
        Jugador j = jugadores.get(posicion);
        nombre.setText(j.getNombre());
        club.setText(j.getGrupo());
        ejercito.setText(j.getFaccion());
        its.setText(j.getIts());
        points.setText(String.valueOf(j.getPuntos()));
        pointsM.setText(String.valueOf(j.getPuntosM()));
        pointsS.setText(String.valueOf(j.getPuntosS()));

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(v)
                // Add action buttons
                .setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        jugadores.get(posicion).setNombre(nombre.getText().toString());
                        jugadores.get(posicion).setFaccion(ejercito.getText().toString());
                        jugadores.get(posicion).setGrupo(club.getText().toString());
                        jugadores.get(posicion).setIts(its.getText().toString());
                        jugadores.get(posicion).setPuntos(Integer.parseInt(points.getText().toString()));
                        jugadores.get(posicion).setPuntosM(Integer.parseInt(pointsM.getText().toString()));
                        jugadores.get(posicion).setPuntosS(Integer.parseInt(pointsS.getText().toString()));
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ModificarDatos.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
