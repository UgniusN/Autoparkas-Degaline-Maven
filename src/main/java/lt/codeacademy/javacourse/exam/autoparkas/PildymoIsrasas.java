package lt.codeacademy.javacourse.exam.autoparkas;

import java.util.Date;

public class PildymoIsrasas extends Israsas {
    LogPrinter logPrinter = new LogPrinter();
    private String pilimoData;
    private int dyzelioKiekis;
    private int benzinoKiekis;
    private int dujuKiekis;
    public PildymoIsrasas(int DyzelioKiekis, int BenzinoKiekis, int DujuKiekis) {
        this.dyzelioKiekis = DyzelioKiekis;
        this.benzinoKiekis = BenzinoKiekis;
        this.dujuKiekis = DujuKiekis;
        pilimoData = new Date().toString();
    }

    public String getPilimoData() {
        return pilimoData;
    }

    public int getDyzelioKiekis() {
        return dyzelioKiekis;
    }

    public int getBenzinoKiekis() {
        return benzinoKiekis;
    }

    public int getDujuKiekis() {
        return dujuKiekis;
    }

    @Override
    void spausdintiIsrasa() {
        logPrinter.spausdintiPildymoIsrasa(pilimoData,dyzelioKiekis,benzinoKiekis,dujuKiekis);
    }
}
