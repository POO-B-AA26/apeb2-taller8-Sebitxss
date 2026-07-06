
import java.util.ArrayList;

/**
 * Problema 4 - Sistema de monitoreo de impactos del cambio climático en Ecuador

Una red de monitoreo ambiental tiene como objetivo registrar, 
analizar y reportar los impactos del cambio climático en diferentes regiones. 
En cada ubicación se instalan dispositivos capaces de medir distintos indicadores 
climáticos como temperatura, precipitación, calidad del aire, y humedad del suelo. 
Dependiendo de la región (costa, sierra y oriente), los dispositivos pueden 
variar en capacidades y protocolos de recolección.

Los datos recolectados deben almacenarse y analizarse periódicamente. 
Además, ciertas ubicaciones requieren generar reportes personalizados que 
destaquen riesgos ambientales como sequías, deslizamientos o contaminación del aire. 
Algunos dispositivos pueden comportarse de forma especializada para detectar 
únicamente ciertos tipos de indicadores dependiendo de la región (costa, sierra y oriente).

Requisitos funcionales:

Representar diferentes tipos de dispositivos y sus especializaciones, para la costa, sierra y oriente.
Implementar métodos polimórficos que permitan procesar los datos según los tipos de dispositivos y sus especializaciones, para la costa, sierra y oriente.
Generar reportes dinámicos en función del tipo de riesgo ambiental detectado según la región
Note

Plantee una solución polimórfica dada una jerarquía de clases con ventajas de herencia. Y para la generación de reportería, use los toString() base.
 * @author sebas
 */

abstract class DispositivoMonitoreo{
    public String rut, ubi;
    public double temperatura, precipitacion, calidadAire, humedadSuelo;
    public abstract String procesarDatos();
    public abstract String detectarRiesgo();

    public DispositivoMonitoreo(String rut, String ubi, double temperatura, double precipitacion, double calidadAire, double humedadSuelo) {
        this.rut = rut;
        this.ubi = ubi;
        this.temperatura = temperatura;
        this.precipitacion = precipitacion;
        this.calidadAire = calidadAire;
        this.humedadSuelo = humedadSuelo;
    }

    @Override
    public String toString() {
        return "DispositivoMonitoreo{" + "rut=" + rut + ", ubi=" + ubi + ", temperatura=" + temperatura + "C" +", precipitacion=" + precipitacion + " mm" + ", calidadAire=" + calidadAire + ", humedadSuelo=" + humedadSuelo + "%" + '}';
    } 
}
class Costa extends DispositivoMonitoreo{

    public Costa(String rut, String ubi, double temperatura, double precipitacion, double calidadAire, double humedadSuelo) {
        super(rut, ubi, temperatura, precipitacion, calidadAire, humedadSuelo);
    }
    
    @Override
    public String procesarDatos(){
        return "Región Costa - Analizando Sequia";
    }
    
    @Override
    public String detectarRiesgo(){
        if(precipitacion < 20 && temperatura > 28){
            return "RIESGO ALTO! Sequia";
        } else if(precipitacion < 40){
            return "Riesgo Medio";
        }
        return "Sin Riesgo";
    }

    @Override
    public String toString() {
        return  super.toString() + "Costa{" + '}' + detectarRiesgo();
    } 
}
class Sierra extends DispositivoMonitoreo{

    public Sierra(String rut, String ubi, double temperatura, double precipitacion, double calidadAire, double humedadSuelo) {
        super(rut, ubi, temperatura, precipitacion, calidadAire, humedadSuelo);
    }
    
    @Override
    public String procesarDatos(){
        return "Región Sierra - Analizando Humedad del Suelo";
    }
    
    @Override
    public String detectarRiesgo(){
        if (humedadSuelo > 80 && precipitacion > 60) {
            return "RIESGO ALTO! Deslizamiento";
        } else if (humedadSuelo > 65) {
            return "Riesgo Medio";
        }
        return "Sin Riesgo";
    }

    @Override
    public String toString() {
        return super.toString() + "Sierra{" + '}' + detectarRiesgo();
    }
}
class Oriente extends DispositivoMonitoreo{

    public Oriente(String rut, String ubi, double temperatura, double precipitacion, double calidadAire, double humedadSuelo) {
        super(rut, ubi, temperatura, precipitacion, calidadAire, humedadSuelo);
    }
    
    @Override
    public String procesarDatos(){
        return "Región Oriental - Analizando calidad del aire";
    }
    
    @Override
    public String detectarRiesgo(){
        if (calidadAire > 150) {
            return "RIESGO ALTO! Contaminacion del aire";
        } else if (calidadAire > 100) {
            return "Riesgo Medio";
        }
        return "Sin Riesgo";
    }

    @Override
    public String toString() {
        return super.toString() + "Oriente{" + '}' + detectarRiesgo();
    }
    
}
public class EjecutorProblema_4_SistemaMonitoreo {
    public static void main(String[] args) {
        ArrayList<DispositivoMonitoreo> red = new ArrayList<>();
        
        red.add(new Costa("D01", "Manta", 30.5, 10, 40, 35));
        red.add(new Sierra("D02", "Quito", 15.0, 70, 30, 85));
        red.add(new Oriente("D03", "Tena", 26.0, 90, 160, 60));
        red.add(new Costa("D04", "Esmeraldas", 27.0, 55, 50, 40));
        System.out.println(red);
    }
}
/***
 * run:
[DispositivoMonitoreo{rut=D01, ubi=Manta, temperatura=30.5C, precipitacion=10.0 mm, calidadAire=40.0, humedadSuelo=35.0%}Costa{}RIESGO ALTO! Sequia, 
* DispositivoMonitoreo{rut=D02, ubi=Quito, temperatura=15.0C, precipitacion=70.0 mm, calidadAire=30.0, humedadSuelo=85.0%}Sierra{}RIESGO ALTO! Deslizamiento, 
* DispositivoMonitoreo{rut=D03, ubi=Tena, temperatura=26.0C, precipitacion=90.0 mm, calidadAire=160.0, humedadSuelo=60.0%}Oriente{}RIESGO ALTO! Contaminacion del aire, 
* DispositivoMonitoreo{rut=D04, ubi=Esmeraldas, temperatura=27.0C, precipitacion=55.0 mm, calidadAire=50.0, humedadSuelo=40.0%}Costa{}Sin Riesgo]
BUILD SUCCESSFUL (total time: 0 seconds)
 */