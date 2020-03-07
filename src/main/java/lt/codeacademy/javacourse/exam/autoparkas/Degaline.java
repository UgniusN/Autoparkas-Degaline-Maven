package lt.codeacademy.javacourse.exam.autoparkas;

import lt.codeacademy.javacourse.exam.autoparkas.exceptions.NepakankamasKuroLikutisDegalineje;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Degaline {
    private static final Logger LOG = LogManager.getLogger(Degaline.class);
    private List<PilimoIsrasas> pilimoIsrasai;
    private KuroSaugykla kuroSaugykla;
    private KiekioTikrintojas kiekioTikrintojas;
    private TekstuSpausdinimas spausdinti = new TekstuSpausdinimas();
    private LogPrinter logPrinter;

    public Degaline(int Talpa, int dyzelis, int benzinas, int dujos) {
        this.kuroSaugykla = new KuroSaugykla(dyzelis, benzinas, dujos,200);
        pilimoIsrasai = new ArrayList<PilimoIsrasas>();
        kiekioTikrintojas = new KiekioTikrintojas();
        logPrinter = new LogPrinter();
    }


    public void priimtiSunkvezimi(DegaluAtvezejas degaluAtvezejas) throws NepakankamasKuroLikutisDegalineje {
        degaluAtvezejas.iskrautiKura(kuroSaugykla);

    }

    public void piltiDegalus(TransportoPriemone transportoPriemone, int kiekis) {
        switch (transportoPriemone.getKuroTipas()) {
            case DYZELIS:
                if (kiekis <= kuroSaugykla.getDyzelioKiekis() && transportoPriemone.getBakoTuris() >= kiekis + transportoPriemone.getLikutis()) {
                    logPrinter.printPilamaMessage(kiekis,transportoPriemone);
                    transportoPriemone.ipiltiDegalu(kiekis);
                    kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.DYZELIS, kiekis);
                }
                else System.out.println("Nepilama");
                break;
            case BENZINAS:
                if (kiekis <= kuroSaugykla.getBenzinoKiekis() && transportoPriemone.getBakoTuris() >= kiekis + transportoPriemone.getLikutis()) {
                    logPrinter.printPilamaMessage(kiekis,transportoPriemone);
                    transportoPriemone.ipiltiDegalu(kiekis);
                    kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.BENZINAS, kiekis);
                }
                else System.out.println("Nepilama");
                break;
            case DUJOS:
                if (kiekis <= kuroSaugykla.getDujuKiekis() && transportoPriemone.getBakoTuris() >= kiekis + transportoPriemone.getLikutis()) {
                    logPrinter.printPilamaMessage(kiekis,transportoPriemone);
                    transportoPriemone.ipiltiDegalu(kiekis);
                    kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.DUJOS, kiekis);
                }
                else System.out.println("Nepilama");
                break;
        }
    }

    public void informacija() {
        spausdinti.Likucius(kuroSaugykla.getBenzinoKiekis(), kuroSaugykla.getDyzelioKiekis(), kuroSaugykla.getDujuKiekis());
    }
}
