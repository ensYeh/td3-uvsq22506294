package fr.uvsq.cprog.collex;

public class NameCommande implements Commande {

    private AdresseIP ip;

    public NameCommande(AdresseIP Ip){
        this.ip=Ip;
    }
    
    @Override
    public void execute(Dns dns) throws EchecException{
        if(dns.getBaseDns().size()!=0)
        {
        for(DnsItem line : dns.getBaseDns()){
            if(line.getAdresseIP().getIP().equals(this.ip.getIP())) System.out.println(dns.getItem(this.ip).getMachine().toString());
        }
        }else System.out.print("DNS vide ...");
    }
}
