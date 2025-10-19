package fr.uvsq.cprog.collex;

public class NameTest implements CommandeTest {

    private AdresseIP ip;
    private NomMachine machine;

    public NameTest(AdresseIP Ip) throws EchecException{
        if(Ip!=null) this.ip=Ip;
        else throw new EchecException("ERROR: L'adresse ip ne peut pas etre null");
    }
    
    @Override
    public void execute(DnsTest dns) throws EchecException{
        if(dns.getBaseDns().size()!=0)
        {
        for(DnsItem line : dns.getBaseDns()){
            if(line.getAdresseIP().getIP().equals(this.ip.getIP())) this.machine=dns.getItem(this.ip).getMachine();
        }
        }else System.out.print("DNS vide ...");
    }

    public NomMachine getMachine(){
        return this.machine;
    }
}
