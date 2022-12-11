package org.ms.payementprojetservice.exceptions;

public class FactureNotExist extends Exception{
    public FactureNotExist() {
        super("Facture inexistante");
    }
}
