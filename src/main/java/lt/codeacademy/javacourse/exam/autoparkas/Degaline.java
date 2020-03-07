package lt.codeacademy.javacourse.exam.autoparkas;

import lt.codeacademy.javacourse.exam.autoparkas.exceptions.NepakankamasKuroLikutisDegalineje;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Degaline {
    private List<PilimoIsrasas> pilimoIsrasai;
    private KuroSaugykla kuroSaugykla;
    private KiekioTikrintojas kiekioTikrintojas;
    private TekstuSpausdinimas spausdinti = new TekstuSpausdinimas();

    public Degaline(int Talpa, int dyzelis, int benzinas, int dujos) {
        this.kuroSaugykla = new KuroSaugykla(dyzelis, benzinas, dujos,200);
        pilimoIsrasai = new ArrayList<PilimoIsrasas>();
        kiekioTikrintojas = new KiekioTikrintojas();
    }


    public void priimtiSunkvezimi(DegaluAtvezejas degaluAtvezejas, KuroSaugykla kuroSaugykla) throws NepakankamasKuroLikutisDegalineje {
        degaluAtvezejas.iskrautiKura(kuroSaugykla);

    }

    public void piltiDegalus(TransportoPriemone transportoPriemone, int kiekis) {
        System.out.println(transportoPriemone.toString());
        switch (transportoPriemone.getKuroTipas()) {
            case DYZELIS:
                if (kiekis <= kuroSaugykla.getDyzelioKiekis() && transportoPriemone.getBakoTuris() >= kiekis + transportoPriemone.getLikutis()) {
                    System.out.println("Pilama");
                    transportoPriemone.ipiltiDegalu(kiekis);
                    kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.DYZELIS, kiekis);
                    System.out.println(transportoPriemone.toString());
                }
                else System.out.println("Nepilama");
                break;
            case BENZINAS:
                if (kiekis <= kuroSaugykla.getBenzinoKiekis() && transportoPriemone.getBakoTuris() >= kiekis + transportoPriemone.getLikutis()) {
                    System.out.println("Pilama");
                    transportoPriemone.ipiltiDegalu(kiekis);
                    kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.BENZINAS, kiekis);
                }
                else System.out.println("Nepilama");
                break;
            case DUJOS:
                if (kiekis <= kuroSaugykla.getDujuKiekis() && transportoPriemone.getBakoTuris() >= kiekis + transportoPriemone.getLikutis()) {
                    System.out.println("Pilama");
                    transportoPriemone.ipiltiDegalu(kiekis);
                    kuroSaugykla.pradetiPiltiKuraIsSaugyklos(Enums.Kuras.DUJOS, kiekis);
                }
                else System.out.println("Nepilama");
                break;
        }
    }

    public void informacija() {
        spausdinti.Likucius(kuroSaugykla.getBenzinoKiekis(), kuroSaugykla.getDyzelioKiekis(), kuroSaugykla.getDujuKiekis());
    }
}
