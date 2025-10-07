package fr.uvsq.cprog.collex;

public class DnsItem {

    private final NomMachine machine;
    private final AdresseIP addIp;

    public DnsItem(AdresseIP addip, NomMachine nmachine){
        this.addIp=addip;
        this.machine=nmachine;
    }
    
    public NomMachine getMachine(){
        return this.machine;
    }

    public AdresseIP getAdresseIP(){
        return this.addIp;
    }

    @Override
    public String toString(){
        return this.addIp.toString() + " " + this.machine.toString();
    }

}
