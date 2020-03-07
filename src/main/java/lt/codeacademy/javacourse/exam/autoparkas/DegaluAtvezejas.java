package lt.codeacademy.javacourse.exam.autoparkas;

public class DegaluAtvezejas implements DegaluMasinosKuroTikrintuvas {
    private int dyzelioKiekis;
    private int dujuKiekis;
    private int benzinoKiekis;

    public DegaluAtvezejas(int dyzelioKiekis, int dujuKiekis, int benzinoKiekis) {
        this.dyzelioKiekis = dyzelioKiekis;
        this.dujuKiekis = dujuKiekis;
        this.benzinoKiekis = benzinoKiekis;
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
        //BENZINAS
        int talpa = kuroSaugykla.getTalpa();
        if(kuroSaugykla.getBenzinoKiekis() < talpa) { // pildo jei maziau negu max bakas
            if(kuroSaugykla.getTalpa() < benzinoKiekis + kuroSaugykla.getBenzinoKiekis()) {  // tikrinama ar talpa yra mazesne uz benzino likuti saugykloje sudejus su benzovezio
                kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.BENZINAS,talpa-benzinoKiekis);
            } else {
                kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.BENZINAS,benzinoKiekis);
            }
        }
        //DYZELIS
        if(kuroSaugykla.getDyzelioKiekis() < talpa) { // pildo jei maziau negu max bakas
            if(kuroSaugykla.getTalpa() < dyzelioKiekis + kuroSaugykla.getDyzelioKiekis()) {  // tikrinama ar talpa yra mazesne uz benzino likuti saugykloje sudejus su dyzelio
                kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.DYZELIS,talpa-dyzelioKiekis);
            } else {
                kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.DYZELIS,dyzelioKiekis);
            }
        }
        //DUJUS
        if(kuroSaugykla.getDujuKiekis() < talpa) { // pildo jei maziau negu max bakas
            if(talpa < benzinoKiekis + kuroSaugykla.getDujuKiekis() ) {  // tikrinama ar talpa yra mazesne uz benzino likuti saugykloje sudejus su benzovezio
                kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.DUJOS,talpa-dujuKiekis);
            } else {
                kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.DUJOS,dujuKiekis);
            }
        }
    }
}
