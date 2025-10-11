package fr.uvsq.cprog.collex;

public class ExitCommande implements Commande {
    @Override
    public void execute(Dns dns){
        System.out.println("Fermiture du DNS...");
        System.exit(0);
    }
}
