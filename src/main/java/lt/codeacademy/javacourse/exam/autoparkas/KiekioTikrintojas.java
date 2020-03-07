package lt.codeacademy.javacourse.exam.autoparkas;

import lt.codeacademy.javacourse.exam.autoparkas.exceptions.NepakankamasKuroLikutisDegalineje;

public class KiekioTikrintojas {
    public boolean tikrintiIpilusKieki(int maxKiekis, int dabartinisKiekis, int ipiltasKiekis) throws NepakankamasKuroLikutisDegalineje {
        try {
        if (maxKiekis >= dabartinisKiekis + ipiltasKiekis) {
            return true;
        }
        else
            throw new NepakankamasKuroLikutisDegalineje();
        }
        catch (NepakankamasKuroLikutisDegalineje e) {

        }
        finally {
            return false;
        }
    }

}
