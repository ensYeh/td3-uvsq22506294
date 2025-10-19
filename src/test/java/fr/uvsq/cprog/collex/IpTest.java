package fr.uvsq.cprog.collex;

public class IpTest implements CommandeTest{
    private NomMachine machine;
    private AdresseIP ip;

    public IpTest(NomMachine nom)  throws EchecException{
        if(nom!=null) this.machine=nom;
        else throw new EchecException("ERROR: Le nom de la machine ne peut pas etre null");
    }
    
    @Override
    public void execute(DnsTest dns) throws EchecException{
        if(dns.getBaseDns().size()!=0)
        {
        for(DnsItem line : dns.getBaseDns()){
            if(line.getMachine().getMachine().equals(this.machine.getMachine()) && line.getMachine().getDomaine().equals(this.machine.getDomaine())) this.ip=dns.getItem(this.machine).getAdresseIP();
        }
        }   
    }

    public AdresseIP getIp(){
        return this.ip;
    }
}
