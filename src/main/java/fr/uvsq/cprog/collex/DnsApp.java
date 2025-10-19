package fr.uvsq.cprog.collex;

public class DnsApp {

    private DnsTUI dnsTUI;

    public DnsApp() throws EchecException{
        dnsTUI= new DnsTUI();
    }

    public void run () throws EchecException{
        
        System.out.println(" \t Serveur DNS");
        System.out.println("\t La table des commandes est la suivantes : \\n");
        System.out.println("\t\t Add <nom>  <ip> : Ajouter une correspondance \n" +
                           "\t\t ip <nom>: Recherche l'adresse associé à une nom \n" +
                           "\t\t name <ip> : Recherche le nom associé à une ip \n" +
                           "\t\t ls <domaine> : Liste les machines du domaine \n" +
                           "\t\t ls -a <domaine> : Liste les machines du domaine triés par adresses ip \n" +
                           "\t\t help : Afficher la table de commande \n" +
                           "\t\t exit : Quitter le programme" );

        Commande cmd=dnsTUI.nextCommande();
        while(cmd!=null){
            dnsTUI.Afficher(cmd);
            cmd=dnsTUI.nextCommande();
        }
        
        

    }
    
}
