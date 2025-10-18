package fr.uvsq.cprog.collex;

public class AddCommande implements Commande {
    
    private DnsItem Item;

    public AddCommande(NomMachine machine, AdresseIP ip) throws EchecException{
        Item= new DnsItem(machine, ip);
    }

    @Override
    public void execute(Dns dns ) throws EchecException{
        dns.addItem(this.Item.getAdresseIP(),this.Item.getMachine());
        System.out.println("Succès de l'ajout !");
    }

    public DnsItem getItem(){
        return this.Item;
    }
}
