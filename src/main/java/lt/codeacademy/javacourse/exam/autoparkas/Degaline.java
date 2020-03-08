package lt.codeacademy.javacourse.exam.autoparkas;

import lt.codeacademy.javacourse.exam.autoparkas.exceptions.NepakankamasKuroLikutisDegalineje;
import lt.codeacademy.javacourse.exam.autoparkas.exceptions.NetelpaIBakaException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Degaline implements DegalinesFunkcijos {
    private static final Logger LOG = LogManager.getLogger(Degaline.class);
    private List<PilimoIsrasas> pilimoIsrasai;
    private KuroSaugykla kuroSaugykla;
    private KiekioTikrintojas kiekioTikrintojas;
    private TekstuSpausdinimas spausdinti = new TekstuSpausdinimas();
    private LogPrinter logPrinter;

    public Degaline(int Talpa, int dyzelis, int benzinas, int dujos) {
        this.kuroSaugykla = new KuroSaugykla(dyzelis, benzinas, dujos, 200);
        pilimoIsrasai = new ArrayList<PilimoIsrasas>();
        kiekioTikrintojas = new KiekioTikrintojas();
        logPrinter = new LogPrinter();
    }

    public void priimtiSunkvezimi(DegaluAtvezejas degaluAtvezejas) {
        degaluAtvezejas.iskrautiKura(kuroSaugykla);

    }

    public void piltiDegalus(TransportoPriemone transportoPriemone, int kiekis) throws NetelpaIBakaException, NepakankamasKuroLikutisDegalineje {
        switch (transportoPriemone.getKuroTipas()) {
            case DYZELIS:
                if (kiekis <= kuroSaugykla.getDyzelioKiekis()) {
                    if (transportoPriemone.getBakoTuris() >= kiekis + transportoPriemone.getLikutis()) {
                        logPrinter.printPilamaMessage(kiekis, transportoPriemone);
                        transportoPriemone.ipiltiDegalu(kiekis);
                        kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.DYZELIS, kiekis);
                    } else {
                        throw new NetelpaIBakaException();
                    }
                } else {
                    throw new NepakankamasKuroLikutisDegalineje();
                }
                break;
            case BENZINAS:
                if (kiekis <= kuroSaugykla.getBenzinoKiekis()) {
                    if (transportoPriemone.getBakoTuris() >= kiekis + transportoPriemone.getLikutis()) {
                        logPrinter.printPilamaMessage(kiekis, transportoPriemone);
                        transportoPriemone.ipiltiDegalu(kiekis);
                        kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.BENZINAS, kiekis);
                    } else {
                        throw new NetelpaIBakaException();
                    }
                } else {
                    throw new NepakankamasKuroLikutisDegalineje();
                }
                break;
            case DUJOS:
                System.out.println(kuroSaugykla.getDujuKiekis());
                if (kiekis <= kuroSaugykla.getDujuKiekis()) {
                    System.out.println(true);
                    if (transportoPriemone.getBakoTuris() >= kiekis + transportoPriemone.getLikutis()) {
                        logPrinter.printPilamaMessage(kiekis, transportoPriemone);
                        transportoPriemone.ipiltiDegalu(kiekis);
                        kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.DUJOS, kiekis);
                    } else {
                        throw new NetelpaIBakaException();
                    }
                } else {
                    throw new NepakankamasKuroLikutisDegalineje();
                }
                break;
        }
    }

    public void informacija() {
        logPrinter.printDegalinesKuroLikuciai(kuroSaugykla.getDyzelioKiekis(), kuroSaugykla.getDujuKiekis(), kuroSaugykla.getBenzinoKiekis());
    }
}
