package lt.codeacademy.javacourse.exam.autoparkas;

public class KuroSaugykla {
    private int dyzelioKiekis;
    private int benzinoKiekis;
    private int dujuKiekis;
    private final int talpa;
    public KuroSaugykla(int DyzelioKiekis, int BenzinoKiekis, int DujuKiekis,int Talpa) {
        this.dyzelioKiekis = DyzelioKiekis;
        this.benzinoKiekis = BenzinoKiekis;
        this.dujuKiekis = DujuKiekis;
        this.talpa = Talpa;
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

    public void papildytiDegalu(Enums.Kuras kuroTipas, int kiekis) {
        switch (kuroTipas) {
            case DUJOS:
                dujuKiekis+=kiekis;
                break;
            case BENZINAS:
                benzinoKiekis+=kiekis;
                break;
            case DYZELIS:
                dyzelioKiekis+=kiekis;
                break;
        }
    }

    public void pradetiPiltiKuraIsSaugyklos(Enums.Kuras kuras,int kiekis) {
        switch (kuras) {
            case DUJOS:
                dujuKiekis-=kiekis;
                break;
            case BENZINAS:
                benzinoKiekis-=kiekis;
                break;
            case DYZELIS:
                dyzelioKiekis-=kiekis;
                break;
        }
    }
    public int getTalpa() {
        return talpa;
    }
}
