package lt.codeacademy.javacourse.exam.autoparkas;

public class Enums {
    enum Kuras {
        DUJOS("dujų"),
        DYZELIS("dyzelio"),
        BENZINAS("benzino"),
        ;
        public final String label;
        private Kuras(String label) {
            this.label = label;
        }
    }
}
