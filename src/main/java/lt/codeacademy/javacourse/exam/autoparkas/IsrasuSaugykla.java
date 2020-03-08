package lt.codeacademy.javacourse.exam.autoparkas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IsrasuSaugykla {
    List<PildymoIsrasas> pildymoIsrasai;
    List<PilimoIsrasas> pilimoIsrasai;
    LogPrinter logPrinter = new LogPrinter();

    public IsrasuSaugykla() {
        this.pildymoIsrasai = new ArrayList<PildymoIsrasas>();
        this.pilimoIsrasai = new ArrayList<PilimoIsrasas>();
    }

    public void addPildymoIsrasas(PildymoIsrasas israsas) {
        pildymoIsrasai.add(israsas);
    }
    public void addPilimoIsrasas(PilimoIsrasas israsas) {
        pilimoIsrasai.add(israsas);
    }
    public void printPilimoIsrasai() {
        for(PilimoIsrasas israsas : pilimoIsrasai)
            logPrinter.spausdintiPilimoIsrasa(israsas.getData(),israsas.getKiekis(),israsas.getKuroTipas(),israsas.getMasinosInfo());
    }
    public void printPildymoIsrasai() {
        for(PildymoIsrasas israsas : pildymoIsrasai)
            logPrinter.spausdintiPildymoIsrasa(israsas.getPilimoData(),israsas.getDyzelioKiekis(),israsas.getBenzinoKiekis(),israsas.getDujuKiekis());
    }

    public void issaugotiPildymoIsrasaIFaila() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("pildymoisrasai.txt"));
        for( PildymoIsrasas israsas : pildymoIsrasai) {

            writer.write("Data: " + israsas.getPilimoData() + " | Dyzelio kiekis: " + israsas.getDyzelioKiekis() + " l | Benzino kiekis: " + israsas.getBenzinoKiekis() + " | Duju kiekis: " + israsas.getDujuKiekis() + "\n");
        }
        writer.close();
    }
    public void issaugotiPilimoIsrasaIFaila() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("pilimoisrasai.txt"));
        for( PilimoIsrasas israsas : pilimoIsrasai) {

            writer.write("Data: " + israsas.getData() + " | Kiekis: " + israsas.getKiekis() + " l | Kuras: " + israsas.getKuroTipas() + " | Masinos info: " + israsas.getMasinosInfo() + "\n");
        }
        writer.close();
    }

    public void issaugotiDegaluLikuciusIFaila(int benzinoKiekis, int dyzelioKiekis, int dujuKiekis) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("degalulikuciai.txt"));
        writer.write("**************************************\n");
        writer.write("****** DEGALINES KURO LIKUČIAI ******\n");
        writer.write("Benzino kiekis: " + benzinoKiekis +  " l\n");
        writer.write("Dyzelio kiekis: " + dyzelioKiekis +  " l\n");
        writer.write("Duju kiekis: " + dujuKiekis +  " l\n");
        writer.write("**************************************");
        writer.close();
    }
}
