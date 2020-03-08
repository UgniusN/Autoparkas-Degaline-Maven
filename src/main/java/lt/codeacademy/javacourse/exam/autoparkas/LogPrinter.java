package lt.codeacademy.javacourse.exam.autoparkas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogPrinter {
    private static final Logger LOGDEGALINE = LogManager.getLogger(Degaline.class);
    private static final Logger LOGDEGALUATVEZEJAS = LogManager.getLogger(DegaluAtvezejas.class);

    public void printPilamaMessage(int kiekis, TransportoPriemone transportoPriemone) {
        LOGDEGALINE.info("Pilama {} l {} į mašiną valst. numeriai {} ",kiekis,transportoPriemone.getKuroTipas().label,transportoPriemone.getAutoNumeriai());
    }

    public void printPradedamaPildytiMessage() {
        LOGDEGALUATVEZEJAS.info("Pradedama pildyti degalines kuro saugyklos kura...");
    }

    public void printPapildytaKuroDegalineje(Enums.Kuras kuras, int kiekis) {
        LOGDEGALINE.info("Degalines kuro saugykloje papildyta {} l {}.",kiekis,kuras);
    }

    public void printBenzovezioKuroLikuciai(int dyzelioKiekis,int dujuKiekis,int benzinoKiekis) {
        LOGDEGALUATVEZEJAS.info("");
        LOGDEGALUATVEZEJAS.info("**************************************");
        LOGDEGALUATVEZEJAS.info("****** BENZOVĖŽIO KURO LIKUČIAI ******");
        LOGDEGALUATVEZEJAS.info("****** Benzinas: {} l",benzinoKiekis);
        LOGDEGALUATVEZEJAS.info("****** Dyzelis: {} l",dyzelioKiekis);
        LOGDEGALUATVEZEJAS.info("****** Dujos: {} l",dujuKiekis);
        LOGDEGALUATVEZEJAS.info("**************************************");
        LOGDEGALUATVEZEJAS.info("");
    }

    public void printDegalinesKuroLikuciai(int dyzelioKiekis,int dujuKiekis,int benzinoKiekis) {
        LOGDEGALINE.info("");
        LOGDEGALINE.info("**************************************");
        LOGDEGALINE.info("****** DEGALINES KURO LIKUČIAI ******");
        LOGDEGALINE.info("****** Benzino likutis: " + benzinoKiekis + " l");
        LOGDEGALINE.info("****** Dyzelio likutis: " + dyzelioKiekis + " l");
        LOGDEGALINE.info("****** Duju likutis: " + dujuKiekis + " l");
        LOGDEGALINE.info("**************************************");
        LOGDEGALINE.info("");
    }

    public void spausdintiPildymoIsrasa(String data, int dyzelioKiekis, int benzinoKiekis,int dujuKiekis) {
        LOGDEGALINE.info("Data: {} | Dyzelio kiekis: {} l | Benzino kiekis: {} l | Duju kiekis: {} l",data,dyzelioKiekis,benzinoKiekis,dujuKiekis);
    }

    public void spausdintiPilimoIsrasa(String data, int kiekis, Enums.Kuras kuroTipas, String masinosInfo) {
        LOGDEGALINE.info("Data: {} | Kiekis: {} l | Kuras: {} | Masinos info: {}",data,kiekis,kuroTipas,masinosInfo);
    }
}
