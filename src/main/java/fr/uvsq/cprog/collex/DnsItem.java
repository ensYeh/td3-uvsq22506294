package fr.uvsq.cprog.collex;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.Properties;
import java.util.Arrays;


public class DnsItem implements Comparable<DnsItem>{

    private final NomMachine machine;
    private final AdresseIP addIp;
    
    public DnsItem(NomMachine nmachine,AdresseIP addip )throws EchecException {
        if(nmachine!=null && addip!=null){
            this.addIp=addip;
            this.machine=nmachine;
        } else{
            if(nmachine==null) throw new EchecException("ERROR: Le nom de la machine ne doit pas etre null");
            else  throw new EchecException("ERROR: L'adresse ip ne doit pas etre null");
        }
        
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

    @Override
    public int compareTo(DnsItem autre) {
        
        return this.addIp.getIP().compareTo(autre.getAdresseIP().getIP());
    }

}
