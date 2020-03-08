package lt.codeacademy.javacourse.exam.autoparkas;

import lt.codeacademy.javacourse.exam.autoparkas.exceptions.NepakankamasKuroLikutisDegalineje;
import lt.codeacademy.javacourse.exam.autoparkas.exceptions.NetelpaIBakaException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 */
public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) throws NepakankamasKuroLikutisDegalineje, NetelpaIBakaException {
        TransportoPriemone sportineMasina = new SportineMasina("KJG135", Enums.Kuras.DYZELIS, 50, 16, 10);
        TransportoPriemone autobusas = new Autobusas("EJT643", Enums.Kuras.DYZELIS, 1000, 100, 12);
        TransportoPriemone traktorius = new Traktorius("TEG346", Enums.Kuras.BENZINAS, 1000, 200, 20);
        DegaluAtvezejas degaluAtvezejas = new DegaluAtvezejas(150, 20, 74);
        Degaline degaline = new Degaline(200, 150, 200, 60);
            try {
                degaline.piltiDegalus(sportineMasina, 30);
                degaline.piltiDegalus(traktorius, 17);
                degaline.priimtiSunkvezimi(degaluAtvezejas);
                degaline.informacija();
                degaluAtvezejas.gautiBenzovezioLikucius();
                degaline.priimtiSunkvezimi(degaluAtvezejas);
                degaline.piltiDegalus(autobusas, 210);
            }
            catch (NepakankamasKuroLikutisDegalineje e) {
                LOG.error(e.getMessage());
            }
            catch (NetelpaIBakaException e) {
                LOG.error(e.getMessage());
            }
        }
    }
