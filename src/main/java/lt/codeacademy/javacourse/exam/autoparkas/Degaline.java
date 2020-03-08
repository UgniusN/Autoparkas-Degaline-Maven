package lt.codeacademy.javacourse.exam.autoparkas;

import lt.codeacademy.javacourse.exam.autoparkas.exceptions.NepakankamasKuroLikutisDegalineje;
import lt.codeacademy.javacourse.exam.autoparkas.exceptions.NetelpaIBakaException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Degaline implements DegalinesFunkcijos {
    private static final Logger LOG = LogManager.getLogger(Degaline.class);
    private List<PilimoIsrasas> pilimoIsrasai;
    private List<PildymoIsrasas> pildymoIsrasai;
    private KuroSaugykla kuroSaugykla;
    private KiekioTikrintojas kiekioTikrintojas;
    private LogPrinter logPrinter;
    private IsrasuSaugykla israsuSaugykla;

    public Degaline(int Talpa, int dyzelis, int benzinas, int dujos) {
        this.kuroSaugykla = new KuroSaugykla(dyzelis, benzinas, dujos, 200);
        pilimoIsrasai = new ArrayList<PilimoIsrasas>();
        pildymoIsrasai = new ArrayList<PildymoIsrasas>();
        kiekioTikrintojas = new KiekioTikrintojas();
        logPrinter = new LogPrinter();
        this.israsuSaugykla = new IsrasuSaugykla();
    }

    public void priimtiSunkvezimi(DegaluAtvezejas degaluAtvezejas) {
        degaluAtvezejas.iskrautiKura(kuroSaugykla);
        israsuSaugykla.addPildymoIsrasas(new PildymoIsrasas(kuroSaugykla.getPripiltaDyzelio(),kuroSaugykla.getPripiltaDuju(),kuroSaugykla.getPripiltaBenzino()));
        kuroSaugykla.resetCounter();

    }

    public void piltiDegalus(TransportoPriemone transportoPriemone, int kiekis) throws NetelpaIBakaException, NepakankamasKuroLikutisDegalineje {
        switch (transportoPriemone.getKuroTipas()) {
            case DYZELIS:
                if (kiekis <= kuroSaugykla.getDyzelioKiekis()) {
                    if (transportoPriemone.getBakoTuris() >= kiekis + transportoPriemone.getLikutis()) {
                        logPrinter.printPilamaMessage(kiekis, transportoPriemone);
                        transportoPriemone.ipiltiDegalu(kiekis);
                        kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.DYZELIS, kiekis);
                        israsuSaugykla.addPilimoIsrasas(new PilimoIsrasas(kiekis, Enums.Kuras.DYZELIS,transportoPriemone.toString()));
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
                        israsuSaugykla.addPilimoIsrasas(new PilimoIsrasas(kiekis, Enums.Kuras.BENZINAS,transportoPriemone.toString()));
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
                        israsuSaugykla.addPilimoIsrasas(new PilimoIsrasas(kiekis, Enums.Kuras.DUJOS,transportoPriemone.toString()));
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
    public void printPildymoIsrasai() {
        israsuSaugykla.printPildymoIsrasai();
    }

    public void printPilimoIsrasai() {
        israsuSaugykla.printPilimoIsrasai();
    }
    public void issaugotiIFailaPilimoIsrasus() throws IOException {
        israsuSaugykla.issaugotiPilimoIsrasaIFaila();
    }
    public void issaugotiIFailaPildymoIsrasus() throws IOException {
        israsuSaugykla.issaugotiPildymoIsrasaIFaila();
    }

    public void issaugotiIFailaKuroLikucius() throws IOException {
        israsuSaugykla.issaugotiDegaluLikuciusIFaila(kuroSaugykla.getBenzinoKiekis(),kuroSaugykla.getDyzelioKiekis(),kuroSaugykla.getDujuKiekis());
    }
}