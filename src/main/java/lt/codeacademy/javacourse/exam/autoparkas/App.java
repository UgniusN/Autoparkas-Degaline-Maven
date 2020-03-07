package lt.codeacademy.javacourse.exam.autoparkas;

import lt.codeacademy.javacourse.exam.autoparkas.exceptions.NepakankamasKuroLikutisDegalineje;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NepakankamasKuroLikutisDegalineje {
        TransportoPriemone sportineMasina = new SportineMasina("KJG135", Enums.Kuras.DYZELIS, 50, 15, 10);
        TransportoPriemone autobusas = new Autobusas("EJT643", Enums.Kuras.DUJOS, 100, 24, 12);
        TransportoPriemone traktorius = new Traktorius("TEG346", Enums.Kuras.BENZINAS, 200, 100, 20);
        DegaluAtvezejas degaluAtvezejas = new DegaluAtvezejas(150, 20, 74);
        Degaline degaline = new Degaline(200, 150, 200, 60);
        degaline.piltiDegalus(sportineMasina,15);
        degaline.piltiDegalus(autobusas,20);
        degaline.piltiDegalus(traktorius, 17);
        degaline.informacija();
        degaline.priimtiSunkvezimi(degaluAtvezejas);
        degaline.informacija();
        degaluAtvezejas.gautiBenzovezioLikucius();
    }
}
