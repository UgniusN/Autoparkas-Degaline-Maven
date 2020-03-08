package lt.codeacademy.javacourse.exam.autoparkas;

import lt.codeacademy.javacourse.exam.autoparkas.exceptions.NepakankamasKuroLikutisDegalineje;
import lt.codeacademy.javacourse.exam.autoparkas.exceptions.NetelpaIBakaException;

public interface DegalinesFunkcijos {
    void priimtiSunkvezimi(DegaluAtvezejas degaluAtvezejas) throws NepakankamasKuroLikutisDegalineje;

    void piltiDegalus(TransportoPriemone transportoPriemone, int kiekis) throws NepakankamasKuroLikutisDegalineje, NetelpaIBakaException;

    void informacija();
}
