package lt.codeacademy.javacourse.exam.autoparkas;

public class DegaluAtvezejas implements DegaluAtvezejoFunkcijos {
    private int dyzelioKiekis;
    private int dujuKiekis;
    private int benzinoKiekis;
    LogPrinter logPrinter;

    public DegaluAtvezejas(int dyzelioKiekis, int dujuKiekis, int benzinoKiekis) {
        this.dyzelioKiekis = dyzelioKiekis;
        this.dujuKiekis = dujuKiekis;
        this.benzinoKiekis = benzinoKiekis;
        this.logPrinter = new LogPrinter();
    }

    public int getDyzelioKiekis() {
        return dyzelioKiekis;
    }

    public int getDujuKiekis() {
        return dujuKiekis;
    }

    public int getBenzinoKiekis() {
        return benzinoKiekis;
    }

    public void setDyzelioKiekis(int dyzelioKiekis) {
        this.dyzelioKiekis = dyzelioKiekis;
    }

    public void setDujuKiekis(int dujuKiekis) {
        this.dujuKiekis = dujuKiekis;
    }

    public void setBenzinoKiekis(int benzinoKiekis) {
        this.benzinoKiekis = benzinoKiekis;
    }

    @Override
    public boolean arPakankaKuro(int kiekis, Enums.Kuras kuroTipas) {
        switch (kuroTipas) {
            case DYZELIS:
                if (kiekis > dyzelioKiekis) return false;
                else return true;
            case BENZINAS:
                if (kiekis > benzinoKiekis) return false;
                else return true;
            case DUJOS:
                if (kiekis > dujuKiekis) return false;
                else return true;
        }
        return true;
    }

    public void iskrautiKura(KuroSaugykla kuroSaugykla) {
        logPrinter.printPradedamaPildytiMessage();
        //BENZINAS
        int ipilamasKiekis;
        int talpa = kuroSaugykla.getTalpa();
        if (kuroSaugykla.getBenzinoKiekis() < talpa) { // pildo jei maziau negu max bakas
            if (talpa < benzinoKiekis + kuroSaugykla.getBenzinoKiekis()) {  // tikrinama ar talpa yra mazesne uz benzino likuti saugykloje sudejus su benzovezio
                ipilamasKiekis = talpa - kuroSaugykla.getBenzinoKiekis();
                kuroSaugykla.papildytiDegalu(Enums.Kuras.BENZINAS, ipilamasKiekis);
                benzinoKiekis -= ipilamasKiekis;
            } else {
                kuroSaugykla.papildytiDegalu(Enums.Kuras.BENZINAS, benzinoKiekis);
                benzinoKiekis = 0;
            }
        }
        //DYZELIS
        if (kuroSaugykla.getDyzelioKiekis() < talpa) { // pildo jei maziau negu max bakas
            if (talpa < dyzelioKiekis + kuroSaugykla.getDyzelioKiekis()) {  // tikrinama ar talpa yra mazesne uz benzino likuti saugykloje sudejus su dyzelio
                ipilamasKiekis = talpa - kuroSaugykla.getDyzelioKiekis();
                kuroSaugykla.papildytiDegalu(Enums.Kuras.DYZELIS, ipilamasKiekis);
                dyzelioKiekis -= ipilamasKiekis;
            } else {
                kuroSaugykla.papildytiDegalu(Enums.Kuras.DYZELIS, dyzelioKiekis);
                dyzelioKiekis -= dyzelioKiekis;
            }
        }
        //DUJUS
        if (kuroSaugykla.getDujuKiekis() < talpa) { // pildo jei maziau negu max bakas
            if (talpa < benzinoKiekis + kuroSaugykla.getDujuKiekis()) {  // tikrinama ar talpa yra mazesne uz benzino likuti saugykloje sudejus su benzovezio
                ipilamasKiekis = talpa - kuroSaugykla.getDujuKiekis();
                kuroSaugykla.papildytiDegalu(Enums.Kuras.DUJOS, ipilamasKiekis);
                dujuKiekis -= ipilamasKiekis;
            } else {
                kuroSaugykla.papildytiDegalu(Enums.Kuras.DUJOS, dujuKiekis);
                dujuKiekis -= dujuKiekis;
            }
        }
    }

    public void gautiBenzovezioLikucius() {
        logPrinter.printBenzovezioKuroLikuciai(dyzelioKiekis, dujuKiekis, benzinoKiekis);
    }
}
