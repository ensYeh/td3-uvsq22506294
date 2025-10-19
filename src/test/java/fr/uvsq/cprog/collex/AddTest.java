package fr.uvsq.cprog.collex;

public class AddTest implements CommandeTest {
    private DnsItem Item;

    public AddTest(NomMachine machine, AdresseIP ip) throws EchecException{
        Item= new DnsItem(machine, ip);
    }

    @Override
    public void execute(DnsTest dns ) throws EchecException{
        dns.addItem(this.Item.getAdresseIP(),this.Item.getMachine());
        System.out.println("Succès de l'ajout !");
    }

    public DnsItem getItem(){
        return this.Item;
    }
}
