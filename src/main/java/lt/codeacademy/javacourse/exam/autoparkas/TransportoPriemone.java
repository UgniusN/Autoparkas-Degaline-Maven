package lt.codeacademy.javacourse.exam.autoparkas;

public class TransportoPriemone {
    private String autoNumeriai;
    private Enums.Kuras kuroTipas;
    private int bakoTuris,variklioLitrazas,likutis;
    public TransportoPriemone(String AutoNumeriai, Enums.Kuras KuroTipas, int BakoTuris, int Likutis, int Litrazas) {
        this.autoNumeriai = AutoNumeriai;
        this.kuroTipas = KuroTipas;
        this.bakoTuris = BakoTuris;
        this.likutis = Likutis;
        this.variklioLitrazas = Litrazas;
    }

    public String getAutoNumeriai() {
        return autoNumeriai;
    }

    public Enums.Kuras getKuroTipas() {
        return kuroTipas;
    }

    public int getBakoTuris() {
        return bakoTuris;
    }

    public int getLikutis() {
        return likutis;
    }

    public int getVariklioLitrazas() {
        return variklioLitrazas;
    }
    public void ipiltiDegalu(int kiekis) {
        likutis+=kiekis;
    }
    @Override
    public String toString() {
        return "AutoNr: " + autoNumeriai + " , Kuro tipas: " +  kuroTipas + ", Bako turis: " + bakoTuris + ", Kuro likutis: " + likutis + ", Variklio Litrazas: " + variklioLitrazas;
    }
}
