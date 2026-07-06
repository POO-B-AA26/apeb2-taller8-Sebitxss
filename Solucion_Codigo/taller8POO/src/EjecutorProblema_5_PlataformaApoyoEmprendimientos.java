
import java.util.ArrayList;

/**
 * Problema 5 - Plataforma de apoyo a emprendimientos en Loja

Una organización local ha creado una plataforma digital para registrar y 
promover emprendimientos de la ciudad de Loja. 
Los emprendimientos pueden clasificarse por tipo
(tecnológico, artesanal, agrícola, gastronómico, etc.), 
y cada uno presenta información detallada sobre su misión, productos o servicios, 
y datos de contacto. Algunos emprendimientos requieren acompañamiento 
técnico por parte de mentores especializados, quienes brindan asesoría en 
áreas como marketing, contabilidad o desarrollo de software. 
Además, los emprendimientos pueden participar en ferias locales, donde presentan 
sus productos y compiten por reconocimientos. Existen emprendimientos que 
evolucionan a lo largo del tiempo y extienden sus líneas de productos o abren nuevas sedes.

Requisitos funcionales:

Diferenciar los distintos tipos de emprendimientos mediante herencia.
Asociar uno o más mentores a los emprendimientos que lo requieran.
Implementar comportamientos polimórficos en función del tipo de feria o actividad en la que participan.
Permitir registrar productos o servicios que ofrece cada emprendimiento.
Simular la evolución de un emprendimiento con el tiempo (crecimiento, diversificación, expansión).
Note

Plantee una solución polimórfica dada una jerarquía de clases con ventajas de herencia. Para la visualización de resultados use los toString() base.
 * @author sebas
 */
class Mentor{
    public String nombre, especialidad;

    public Mentor(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Mentor{" + "nombre=" + nombre + ", especialidad=" + especialidad + '}';
    }
}
abstract class Emprendimiento{
    public String nombre, mision, contacto, ubi;
    public int sedes;
    public ArrayList<String> productos;
    public ArrayList<Mentor> mentores;

    public Emprendimiento(String nombre, String mision, String contacto, String ubi) {
        this.nombre = nombre;
        this.mision = mision;
        this.contacto = contacto;
        this.ubi = ubi;
        this.productos = new ArrayList<>();
        this.mentores = new ArrayList<>();
    }
    
    
    public void agregarProductos(String producto){
        productos.add(producto);
    }
    
    public void asignarMentor(Mentor mentor){
        mentores.add(mentor);
    }
    public abstract String participarEnFeria();
    public abstract void evolucionar();

    @Override
    public String toString() {
        return "Emprendimiento{" + "nombre=" + nombre + ", mision=" + mision + ", contacto=" + contacto + ", ubi=" + ubi + ", sedes=" + sedes + ", productos=" + productos + ", mentores=" + mentores + '}';
    }
}
class EmpTecnologico extends Emprendimiento{

    public EmpTecnologico(String nombre, String mision, String contacto, String ubi) {
        super(nombre, mision, contacto, ubi);
    }
    
    @Override
    public String participarEnFeria(){
        return nombre + " participa en la feria Tecnologicas";
    }
    
    @Override
    public void evolucionar(){
        productos.add("Nuevo SoftWare");
    }

    @Override
    public String toString() {
        return super.toString() + "EmpTecnologico{" + '}' + participarEnFeria();
    }
}
class EmpArtesanal extends Emprendimiento{

    public EmpArtesanal(String nombre, String mision, String contacto, String ubi) {
        super(nombre, mision, contacto, ubi);
    }
    
    @Override
    public String participarEnFeria() {
        return nombre + " participa en la Feria Artesanal";
    }
    
    @Override
    public void evolucionar() {
        productos.add("Nueva linea de productos artesanales");
    }

    @Override
    public String toString() {
        return super.toString() + "EmpArtesanal{" + '}' + participarEnFeria();
    }
}
class EmpAgricola extends Emprendimiento{

    public EmpAgricola(String nombre, String mision, String contacto, String ubi) {
        super(nombre, mision, contacto, ubi);
    }
    
    @Override
    public String participarEnFeria() {
        return nombre + " participa en la Feria Agroecologica";
    }
    
    @Override
    public void evolucionar() {
        sedes++;
    }

    @Override
    public String toString() {
        return super.toString() + "EmpAgricola{" + '}' + participarEnFeria();
    }
}
class EmpGastronomico extends Emprendimiento{

    public EmpGastronomico(String nombre, String mision, String contacto, String ubi) {
        super(nombre, mision, contacto, ubi);
    }
    
    @Override
    public String participarEnFeria() {
        return nombre + " participa en la Feria Gastronomica";
    }
    
    @Override
    public void evolucionar() {
        sedes++;
        productos.add("Nuevo plato en el menu");
    }

    @Override
    public String toString() {
        return super.toString() + "EmpGastronomico{" + '}' + participarEnFeria();
    }
}
public class EjecutorProblema_5_PlataformaApoyoEmprendimientos {
    public static void main(String[] args) {
        ArrayList<Emprendimiento> plataforma = new ArrayList<>();
        
        Emprendimiento tec = new EmpTecnologico("LojaSoft", "Crear soluciones digitales para la movilización","0991234567", "Punzara");
        tec.agregarProductos("App de gestion de movilización");
        tec.asignarMentor(new Mentor("Carlos Morales", "Desarrollo de software"));
        
        Emprendimiento art = new EmpArtesanal("Manos Lojanas", "Preservar la tradicion artesanal de la region","0987654321", "El Valle");
        art.agregarProductos("Sombreros de paja toquilla");
        art.asignarMentor(new Mentor("Juan Vivanco", "Marketing"));
        
        Emprendimiento agr = new EmpAgricola("Sabor Andino", "Comercializar productos organicos de la zona","0976543210", "Malacatos");
        agr.agregarProductos("Café");
        
        Emprendimiento gas = new EmpGastronomico("Sabores de Loja", "Difundir la gastronomia tradicional lojana","0965432109", "Centro Historico");
        gas.agregarProductos("Repe lojano");
        gas.asignarMentor(new Mentor("Diana Torres", "Contabilidad"));

        plataforma.add(tec);
        plataforma.add(art);
        plataforma.add(agr);
        plataforma.add(gas);
        
        for (Emprendimiento e : plataforma) {
            System.out.println(e.participarEnFeria());
        }
        for (Emprendimiento e : plataforma) {
            e.evolucionar();
        }
    }
}
/***
 * run:
LojaSoft participa en la feria Tecnologicas
Manos Lojanas participa en la Feria Artesanal
Sabor Andino participa en la Feria Agroecologica
Sabores de Loja participa en la Feria Gastronomica
BUILD SUCCESSFUL (total time: 0 seconds)
 */