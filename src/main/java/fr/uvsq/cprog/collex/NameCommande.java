package fr.uvsq.cprog.collex;

public class NameCommande implements Commande {

    private AdresseIP ip;

    public NameCommande(AdresseIP Ip) throws EchecException{
        if(Ip!=null) this.ip=Ip;
        else throw new EchecException("ERROR: L'adresse ip ne peut pas etre null");
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
