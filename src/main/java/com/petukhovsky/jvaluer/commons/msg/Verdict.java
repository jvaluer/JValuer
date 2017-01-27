package com.petukhovsky.jvaluer.commons.msg;

/**
 * Created by arthur on 27.01.17.
 */
public class Verdict {
    private final VerdictLabel label;
    private final String comment;

    public Verdict(VerdictLabel label, String comment) {
        this.label = label;
        this.comment = comment;
    }

    public VerdictLabel getLabel() {
        return label;
    }

    public String getComment() {
        return comment;
    }

    public String toString() {
        if (comment == null || comment == "") return label.toString();
        return label + "(" + comment + ")";
    }
}
