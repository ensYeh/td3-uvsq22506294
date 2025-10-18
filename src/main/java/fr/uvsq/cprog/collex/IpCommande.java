package fr.uvsq.cprog.collex;

public class IpCommande implements Commande {

    private NomMachine machine;

    public IpCommande(NomMachine nom)  throws EchecException{
        if(nom!=null) this.machine=nom;
        else throw new EchecException("ERROR: Le nom de la machine ne peut pas etre null");
    }
    
    @Override
    public void execute(Dns dns) throws EchecException{
        if(dns.getBaseDns().size()!=0)
        {
        for(DnsItem line : dns.getBaseDns()){
            if(line.getMachine().getMachine().equals(this.machine.getMachine()) && line.getMachine().getDomaine().equals(this.machine.getDomaine())) System.out.println(dns.getItem(this.machine).getAdresseIP().toString());
        }
        }else System.out.print("DNS vide ...");
    }
}
