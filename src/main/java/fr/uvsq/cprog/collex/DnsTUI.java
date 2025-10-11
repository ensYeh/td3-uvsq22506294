package fr.uvsq.cprog.collex;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class DnsTUI{

    private  Dns dns;

    public DnsTUI() throws EchecException{
        this.dns= new Dns();
    }
    

    public Commande nextCommande(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("> ");
        String ligne = scanner.nextLine().trim();
        String[] parts = ligne.split(" ");
        String cmd= parts[0].toLowerCase();
       

        switch (cmd) {
            case "add":{
                    if(parts.length<3){
                        System.out.println("Usage : add <nom> <ip> ");
                        return null;
                    }
                    return new AddCommande(new NomMachine(parts[1]), new AdresseIP(parts[2]));
                }
            case "ip":{
                    if(parts.length<2){
                        System.out.println("Usage : ip <nom> ");
                        return null;
                    }
                    return new IpCommande(new NomMachine(parts[1]));
                }
            case "name":{
                    if(parts.length<2){
                        System.out.println("Usage : name <ip> ");
                        return null;
                    }
                    return new NameCommande(new AdresseIP(parts[1]));
                }
            case "ls":{
                    if(parts.length<2){
                        System.out.println("Usage : ls <domaine> ");
                        return null;
                    }
                    return new LsCommande(parts[1]);
                }
            case "ls-a":{
                    if(parts.length<2){
                        System.out.println("Usage : ls-a <domaine> ");
                        return null;
                    }
                    return new Ls_a_Commande(parts[1]);
                }
            case "exit":{
                    return new ExitCommande();
                }
            default:
                {
                System.out.println("Veuillez saisir une commande affichee sur le menu");
                return null;
                }
        }
    }

    public void Afficher(Commande cmd) throws EchecException{
        if(!cmd.equals(null)) cmd.execute(this.dns);
        else throw new EchecException("Votre commande n'as pas de resultats");
    }

    
}
