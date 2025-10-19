package fr.uvsq.cprog.collex;

public class HelpCommande implements Commande {

    @Override
    public void execute(Dns dns){
        System.out.println("\t La table des commandes est la suivantes : \\n");
            System.out.println("\t\t Add <nom>  <ip> : Ajouter une correspondance \n" +
                            "\t\t ip <nom>: Recherche l'adresse associé à une nom \n" +
                            "\t\t name <ip> : Recherche le nom associé à une ip \n" +
                            "\t\t ls <domaine> : Liste les machines du domaine \n" +
                            "\t\t ls -a <domaine> : Liste les machines du domaine tries par adresses ip \n" +
                            "\t\t help : Afficher la table de commande \n" +
                            "\t\t exit : Quitter le programme" );
    }
    
}
