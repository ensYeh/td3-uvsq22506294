package fr.uvsq.cprog.collex;

public interface Commande {
    void execute(Dns dns) throws EchecException;
}

