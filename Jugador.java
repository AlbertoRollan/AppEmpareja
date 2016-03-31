package cayren.emparejador;

/**
 * Created by Cayren on 29/06/2015.
 */
public class Jugador
{
    String nombre;
    String its;
    String grupo;
    String faccion;
    int puntos;
    int puntosM;
    int puntosS;
    String pintado;
    boolean pintura[]=new boolean[3];
    String mesas[] = new String[3];

    public Jugador(String nombre, String its, String grupo,String faccion) {
        this.nombre = nombre;
        this.its = its;
        this.grupo = grupo;
        this.faccion = faccion;
        pintado = "No";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIts() {
        return its;
    }

    public void setIts(String its) {
        this.its = its;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getPuntosM() {
        return puntosM;
    }

    public void setPuntosM(int puntosM) {
        this.puntosM = puntosM;
    }

    public int getPuntosS() {
        return puntosS;
    }

    public void setPuntosS(int puntosS) {
        this.puntosS = puntosS;
    }

    public String getFaccion() {
        return faccion;
    }

    public void setFaccion(String faccion) {
        this.faccion = faccion;
    }

    public String[] getMesas() {
        return mesas;
    }

    public void setMesas(String[] mesas) {
        this.mesas = mesas;
    }

    public boolean[] getPintura() {
        return pintura;
    }

    public void setPintura(boolean[] pintura) {
        this.pintura = pintura;
    }

    public void setMesasRonda(String mesa,int ronda) {
       mesas[ronda-1] = mesa;
    }

    public String getMesaRonda(int ronda)
    {
        return mesas[ronda-1];
    }

    public void setPinturaRonda(boolean pintado,int ronda) {
        pintura[ronda-1] = pintado;
    }

    public boolean getPinturaRonda(int ronda)
    {
        return pintura[ronda-1];
    }

    public String getPintado() {
        return pintado;
    }

    public void setPintado(String pintado) {
        this.pintado = pintado;
    }
}
