package lt.codeacademy.javacourse.exam.autoparkas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KuroSaugykla {
    private int dyzelioKiekis, benzinoKiekis, dujuKiekis;
    private int pripiltaDyzelio, pripiltaBenzino, pripiltaDuju;
    private final int talpa;
    LogPrinter logPrinter = new LogPrinter();
    PildymoIsrasas pildymoIsrasas;

    public KuroSaugykla(int DyzelioKiekis, int BenzinoKiekis, int DujuKiekis, int Talpa) {
        this.dyzelioKiekis = DyzelioKiekis;
        this.benzinoKiekis = BenzinoKiekis;
        this.dujuKiekis = DujuKiekis;
        this.talpa = Talpa;
    }
//pildymoIsrasas = new PildymoIsrasas(pripildytaDyzelio,pripildytaBenzino,pripildytaDuju);
    public int getDyzelioKiekis() {
        return dyzelioKiekis;
    }

    public int getBenzinoKiekis() {
        return benzinoKiekis;
    }

    public int getDujuKiekis() {
        return dujuKiekis;
    }

    public void papildytiDegalu(Enums.Kuras kuroTipas, int kiekis) {
        int pripildytaDyzelio, pripildytaBenzino, pripildytaDuju;
        switch (kuroTipas) {
            case DUJOS:
                pripiltaDuju = kiekis;
                dujuKiekis += kiekis;
                if (kiekis != 0)
                    logPrinter.printPapildytaKuroDegalineje(Enums.Kuras.DUJOS, kiekis);
                break;
            case BENZINAS:
                pripiltaBenzino = kiekis;
                benzinoKiekis += kiekis;
                if (kiekis != 0)
                    logPrinter.printPapildytaKuroDegalineje(Enums.Kuras.BENZINAS, kiekis);
                break;
            case DYZELIS:
                pripiltaDyzelio = kiekis;
                dyzelioKiekis += kiekis;
                if (kiekis != 0)
                    logPrinter.printPapildytaKuroDegalineje(Enums.Kuras.DYZELIS, kiekis);
                break;
        }
    }

    public void pradetiPiltiKuraIsSaugyklos(Enums.Kuras kuras, int kiekis) {
        switch (kuras) {
            case DUJOS:
                dujuKiekis -= kiekis;
                break;
            case BENZINAS:
                benzinoKiekis -= kiekis;
                break;
            case DYZELIS:
                dyzelioKiekis -= kiekis;
                break;
        }
    }

    public int getTalpa() {
        return talpa;
    }

    public PildymoIsrasas grazintiIsrasa() {
        return pildymoIsrasas;
    }
    public int getPripiltaDyzelio() {
        return  pripiltaDyzelio;
    }
    public int getPripiltaDuju() {
        return  pripiltaDuju;
    }
    public int getPripiltaBenzino() {
        return  pripiltaBenzino;
    }
    public void resetCounter() {
        pripiltaBenzino = 0;
        pripiltaDuju = 0;
        pripiltaDyzelio = 0;
    }
}
