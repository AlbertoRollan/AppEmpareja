package cayren.emparejador;

import java.util.ArrayList;

/**
 * Created by Cayren on 29/06/2015.
 */
public class VariablesGlobales
{
      private  static ArrayList Mesas = new ArrayList();
     private   static ArrayList<Jugador> jugadores = new ArrayList();

    public static ArrayList getJugadores() {
        return jugadores;
    }

    public static void setJugadores(ArrayList jugadores) {
        VariablesGlobales.jugadores = jugadores;
    }

    public static ArrayList getMesas() {
        return Mesas;
    }

    public static void setMesas(ArrayList mesas) {
        Mesas = mesas;
    }

    public static void ordenarRanking()
    {
        ArrayList<Jugador> listaOriginal = VariablesGlobales.getJugadores();
        //ArrayList listaAux = new ArrayList(listaOriginal.size());
        int cuentaintercambios=0;
        //Usamos un bucle anidado, saldra cuando este ordenado el array
        for (boolean ordenado=false;!ordenado;){
            for (int i=0;i<listaOriginal.size()-1;i++){
                if (listaOriginal.get(i).getPuntos()<listaOriginal.get(i+1).getPuntos()){
                    //Intercambiamos valores
                    Jugador variableauxiliar=listaOriginal.get(i);
                    listaOriginal.set(i,listaOriginal.get(i+1));
                    listaOriginal.set(i+1,variableauxiliar);
                    //indicamos que hay un cambio
                    cuentaintercambios++;
                }
                else if(listaOriginal.get(i).getPuntos()==listaOriginal.get(i+1).getPuntos())
                {
                    if(listaOriginal.get(i).getPuntosM()<listaOriginal.get(i+1).getPuntosM())
                    {
                        //Intercambiamos valores
                        Jugador variableauxiliar=listaOriginal.get(i);
                        listaOriginal.set(i,listaOriginal.get(i+1));
                        listaOriginal.set(i+1,variableauxiliar);
                        //indicamos que hay un cambio
                        cuentaintercambios++;
                    }
                    else if(listaOriginal.get(i).getPuntosM()==listaOriginal.get(i+1).getPuntosM())
                    {
                        if(listaOriginal.get(i).getPuntosS()<listaOriginal.get(i+1).getPuntosS())
                        {
                            //Intercambiamos valores
                            Jugador variableauxiliar=listaOriginal.get(i);
                            listaOriginal.set(i,listaOriginal.get(i+1));
                            listaOriginal.set(i+1,variableauxiliar);
                            //indicamos que hay un cambio
                            cuentaintercambios++;
                        }
                    }
                }
            }
            //Si no hay intercambios, es que esta ordenado.
            if (cuentaintercambios==0){
                ordenado=true;
            }
            //Inicializamos la variable de nuevo para que empiece a contar de nuevo
            cuentaintercambios=0;
        }
    }
}

