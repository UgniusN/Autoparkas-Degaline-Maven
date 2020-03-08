package lt.codeacademy.javacourse.exam.autoparkas;

import java.util.Date;

public class PilimoIsrasas extends Israsas {
    LogPrinter logPrinter = new LogPrinter();
    private String data;
    private int kiekis;
    private Enums.Kuras kuroTipas;
    private String masinosInfo;
    private Date date;

    public String getData() {
        return data;
    }

    public int getKiekis() {
        return kiekis;
    }

    public Enums.Kuras getKuroTipas() {
        return kuroTipas;
    }

    public String getMasinosInfo() {
        return masinosInfo;
    }

    public PilimoIsrasas(int Kiekis, Enums.Kuras KuroTipas, String MasinosInfo) {
        this.data = new Date().toString();
        this.kiekis = Kiekis;
        this.kuroTipas = KuroTipas;
        this.masinosInfo = MasinosInfo;
    }

    @Override
    public void spausdintiIsrasa() {
        logPrinter.spausdintiPilimoIsrasa(data,kiekis,kuroTipas,masinosInfo);
    }
}
