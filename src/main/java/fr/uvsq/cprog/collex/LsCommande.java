package fr.uvsq.cprog.collex;

import java.util.ArrayList;
import java.util.Collections;

public class LsCommande implements Commande{
    
    private String domaine;

    public LsCommande(String d){
        this.domaine=d;
    }

    @Override
    public void execute(Dns dns )throws EchecException{
        if(dns.getBaseDns().size()!=0){
            for(DnsItem line : dns.getBaseDns()){
                if(line.getMachine().getDomaine().equals(this.domaine)) System.out.println(line.toString());
            }
        }else System.out.print("DNS vide ...");
}
}