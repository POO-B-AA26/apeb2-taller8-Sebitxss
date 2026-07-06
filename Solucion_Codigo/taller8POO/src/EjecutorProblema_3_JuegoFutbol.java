
/**
 * Problema 3 - Juego de fútbol "Estadísticas"

Se desea realizar una aplicación que permita a un periodista deportivo 
llevar las estadísticas de los jugadores de un equipo de fútbol para poder valorar su actuación en el partido.

Cada jugador se identifica por su nombre, número de dorsal y Rut

Los jugadores se dividen en tres categorías:

Atacantes
Defensores
Porteros
Para todos los jugadores se desea contabilizar el número de goles marcados, 
además en el caso de los jugadores de campo se contabilizan los pases 
realizados con éxito y el número de balones recuperados. 
En el caso de los porteros se contabilizan las atajadas realizadas.

Valoración del jugador

Cálculo base para todos los jugadores:

valor_goles = goles * 30
Valor adicional según tipo de jugador:

Atacantes

valor += recuperaciones * 3
Defensores

valor += recuperaciones * 4
Porteros

valor += atajadas * 5
 * @author sebas
 */
abstract class Jugador{
    public String nombre;
    public String numeroDorsal;
    public String rut;
    public int gol;

    public Jugador(String nombre, String numeroDorsal, String rut, int gol) {
        this.nombre = nombre;
        this.numeroDorsal = numeroDorsal;
        this.rut = rut;
        this.gol = gol;
    }
    
    public int CalcularGoles(){
        return this.gol * 30;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", numeroDorsal=" + numeroDorsal + ", rut=" + rut + ", gol=" + gol + '}';
    }
    
}

class CampoJugador extends Jugador{
    public int pase;
    public int recuperacion;

    public CampoJugador(int pase, int recuperacion, String nombre, String numeroDorsal, String rut, int gol) {
        super(nombre, numeroDorsal, rut, gol);
        this.pase = pase;
        this.recuperacion = recuperacion;
    } 

    @Override
    public String toString() {
        return "CampoJugador{" + "pase=" + pase + ", recuperacion=" + recuperacion + '}' + super.toString();
    }
    
}

class Potero extends Jugador{
    public int atajadas;

    public Potero(int atajadas, String nombre, String numeroDorsal, String rut, int gol) {
        super(nombre, numeroDorsal, rut, gol);
        this.atajadas = atajadas;
    }
    
    public int calcularValor() {
        int valor = CalcularGoles();
        valor += this.atajadas * 5;
        return valor;
    }

    @Override
    public String toString() {
        return "Potero{" + "atajadas=" + atajadas + '}';
    }
    
}
class Atacante extends CampoJugador{

    public Atacante(int pase, int recuperacion, String nombre, String numeroDorsal, String rut, int gol) {
        super(pase, recuperacion, nombre, numeroDorsal, rut, gol);
    }
    
    public int calcularValor() {
        int valor = CalcularGoles();
        valor += this.recuperacion * 3;
        return valor;
    }

    @Override
    public String toString() {
        return "Atacante{" + '}' + super.toString();
    }
    
}

class Defensa extends CampoJugador{

    public Defensa(int pase, int recuperacion, String nombre, String numeroDorsal, String rut, int gol) {
        super(pase, recuperacion, nombre, numeroDorsal, rut, gol);
    }
        
    public int calcularValor() {
        int valor = CalcularGoles();
        valor += this.recuperacion * 4;
        return valor;
    }

    @Override
    public String toString() {
        return "Defensa{" + '}' + super.toString();
    }
    
}
public class EjecutorProblema_3_JuegoFutbol {
    public static void main(String[] args) {
        Jugador del = new Atacante(30, 5, "Messi", "10","1105493393930", 9);
        del.CalcularGoles();
        System.out.println(del);
        
        Jugador dfs = new Defensa(43, 17, "Ramos", "4", "1103840944674", 3);
        dfs.CalcularGoles();
        System.out.println(dfs);
        
        Jugador por = new Potero(20, "Galindez", "1", "1900043848859", 0);
        por.CalcularGoles();
        System.out.println(por);
    }
}
/***
 * run:
Atacante{}CampoJugador{pase=30, recuperacion=5}Jugador{nombre=Messi, numeroDorsal=10, rut=1105493393930, gol=9}
Defensa{}CampoJugador{pase=43, recuperacion=17}Jugador{nombre=Ramos, numeroDorsal=4, rut=1103840944674, gol=3}
Potero{atajadas=20}
BUILD SUCCESSFUL (total time: 0 seconds)
 */