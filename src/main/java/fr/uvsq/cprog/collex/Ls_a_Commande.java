package fr.uvsq.cprog.collex;

import java.util.ArrayList;
import java.util.Collections;

public class Ls_a_Commande implements Commande {
    
    private String domaine;

    public Ls_a_Commande(String d){
        this.domaine=d;
    }

    @Override
    public void execute(Dns dns )throws EchecException{
        if(dns.getBaseDns().size()!=0){
            
            ArrayList<DnsItem> list= new ArrayList<>();
            for(DnsItem line : dns.getBaseDns()){
                
                if(line.getMachine().getDomaine().equals(this.domaine)) list.add(line);
            }
            
            Collections.sort(list);
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i).toString());
            }
        } else System.out.print("DNS vide ...");
    }
}
