package no.hiof.larseknu.json.model;

import sun.jvm.hotspot.oops.Klass;

public class Barbar extends Klasse {
    private int raseriAnfall;

    public Barbar() {
    }

    public Barbar(String navn, String beskrivelse, int terning, int raseriAnfall) {
        super(navn, beskrivelse, terning);
        this.raseriAnfall = raseriAnfall;
    }

    public void brukRaseriAnfall() {
        raseriAnfall--;
    }

    public int getRaseriAnfall() {
        return raseriAnfall;
    }

    public void setRaseriAnfall(int raseriAnfall) {
        this.raseriAnfall = raseriAnfall;
    }
}
