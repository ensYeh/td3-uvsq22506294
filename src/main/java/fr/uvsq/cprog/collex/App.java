package fr.uvsq.cprog.collex;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )  throws EchecException
    {
        System.out.println(" \t Serveur DNS");
        System.out.println("\t La table des commandes est la suivantes : \\n");
        System.out.println("\t\t Add <nom>  <ip> : Ajouter une correspondance \n" +
                           "\t\t ip <nom>: Recherche l'adresse associé à une nom \n" +
                           "\t\t name <ip> : Recherche le nom associé à une ip \n" +
                           "\t\t ls <domaine> : Liste les machines du dommaien \n" +
                           "\t\t help : Afficher la table de commande \n" +
                           "\t\t exit : Quitter le programme" );
        
        Dns dns = new Dns();
        AdresseIP ip;
        NomMachine machine;

        Scanner scan= new Scanner(System.in);
        String rep= scan.nextLine();

        while(!rep.equals("exit")){
            
            String[] parts = rep.split(" ");

            switch (parts[0]) {
                case "add":{
                    machine= new NomMachine(parts[1]);
                    ip= new AdresseIP(parts[2]);
                    dns.addItem(ip, machine);
                }
                    break;

                case "ip":{
                    machine= new NomMachine(parts[1]);
                    System.out.println(dns.getItem(machine).getAdresseIP().toString());
                }
                    break;
                case "name":{
                    ip= new AdresseIP(parts[1]);
                    System.out.println(dns.getItem(ip).getMachine().toString());
                }
                    break;
                
                case "ls":{
                    
                }
                    break;
                
                case "help":{
                    System.out.println("\t La table des commandes est la suivantes : \\n");
                    System.out.println("\t\t Add <nom>  <ip> : Ajouter une correspondance \n" +
                                    "\t\t ip <nom>: Recherche l'adresse associé à une nom \n" +
                                    "\t\t name <ip> : Recherche le nom associé à une ip \n" +
                                    "\t\t ls <domaine> : Liste les machines du dommaien \n" +
                                    "\t\t help : Afficher la table de commande" +
                                    "\t\t exit : Quitter le programme" );
                }
                    break;

                case "quit":{
                    
                }
                    break;

                default:
                    System.out.println(" Le text saisie est invalide ou commande introuvable");
                    break;
            }

            if(!rep.equals("quit")) rep=scan.nextLine();

        }
    }
}
