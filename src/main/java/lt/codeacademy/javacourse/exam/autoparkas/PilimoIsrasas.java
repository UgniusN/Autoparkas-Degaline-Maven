package lt.codeacademy.javacourse.exam.autoparkas;

public class PilimoIsrasas extends Israsas {
    private String automobilioIndentifikavimoNumeris;
    private int kartuPilta;
    private int kiekis;

    public PilimoIsrasas(String AutomobilioNr, int KartuPilta, int Kiekis) {
        this.automobilioIndentifikavimoNumeris = AutomobilioNr;
        this.kartuPilta = KartuPilta;
        this.kiekis = Kiekis;
    }

    @Override
    public void spausdintiIsrasa() {

    }
}
