
import java.util.Random;

/**
 *
 * @author sebas
 */
abstract class Personaje{
    public int vidas;
    public int experiencia;
    public int batallasGanadas;
    public abstract boolean ataque(Personaje personaje);
    public abstract boolean defensa(Personaje personaje);

    public Personaje(int vidas) {
        this.vidas = vidas;
    }

    @Override
    public String toString() {
        return "Personaje{" + "vidas=" + vidas + ", experiencia=" + experiencia + ", batallasGanadas=" + batallasGanadas + '}';
    }
        
}
class Guerrero extends Personaje{
    public int fuerza; //1-10

    public Guerrero(int fuerza, int vidas) {
        super(vidas);
        this.fuerza = fuerza;
    }
    
    
    public boolean ataque(Personaje personaje){
        Random ale = new Random();
        boolean lucha = ale.nextBoolean();
        this.experiencia++;
        personaje.experiencia++;
        if(lucha){
            this.batallasGanadas++;
            personaje.vidas--;
        }else{
            this.vidas--;
            personaje.batallasGanadas++;
        }
        return false;
    }
    public boolean defensa(Personaje personaje){
        
        return false;
    }

    @Override
    public String toString() {
        return "Guerrero{" + "fuerza=" + fuerza + '}' + super.toString();
    }
    
}
class Mago extends Personaje{
    public String hechizo;

    public Mago(String hechizo, int vidas) {
        super(vidas);
        this.hechizo = hechizo;
    }
        public boolean ataque(Personaje personaje){
        return false;
    }
    public boolean defensa(Personaje personaje){
        return false;
    }

    @Override
    public String toString() {
        return "Mago{" + "hechizo=" + hechizo + '}' + super.toString();
    }
    
}
class Arquero extends Personaje{
    public int precision, cantidadFlecha;

    public Arquero(int precision, int cantidadFlecha, int vidas) {
        super(vidas);
        this.precision = precision;
        this.cantidadFlecha = cantidadFlecha;
    }
    
    
        public boolean ataque(Personaje personaje){
        Random ale = new Random();
        boolean lucha = ale.nextBoolean();
        this.experiencia++;
        personaje.experiencia++;
        if(lucha){
            this.batallasGanadas++;
            personaje.vidas--;
        }else{
            this.vidas--;
            personaje.batallasGanadas++;
        }
        return false;
    }
    public boolean defensa(Personaje personaje){
        return false;
    }

    @Override
    public String toString() {
        return "Arquero{" + "precision=" + precision + ", cantidadFlecha=" + cantidadFlecha + '}' + super.toString();
    }
    
}
public class EjecutorBatalla {
    public static void main(String[] args) {
        Personaje guerrero = new Guerrero(7,3);
        Personaje mago = new Mago("Abracadabra", 2);
        Personaje arquero = new Arquero(10, 7, 2);
        System.out.println("Resultado ataque del Guerrero: " + guerrero.ataque(mago));
        System.out.println(guerrero);
        System.out.println(mago);
        System.out.println("Resultado ataque del Arquero: " + arquero.ataque(guerrero));
        System.out.println(arquero);
        System.out.println(guerrero);
    }
}
