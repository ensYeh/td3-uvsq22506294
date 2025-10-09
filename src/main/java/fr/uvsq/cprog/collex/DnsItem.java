package fr.uvsq.cprog.collex;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.Properties;
import java.util.Arrays;


public class DnsItem {

    private final NomMachine machine;
    private final AdresseIP addIp;
    
    public DnsItem(NomMachine nmachine,AdresseIP addip){
        this.addIp=addip;
        this.machine=nmachine;

        // //garder le couple dans un fichier
        // String dns = nmachine.getMachine() + " " + addip.getIP() ;
        // List<String> ligne = Arrays.asList(dns);

        // Properties prop = new Properties();
        // try(FileReader read = new FileReader("config.properties")) {
        //     prop.load(read);
            
        // } catch (IOException e) {
        //     e.getStackTrace();
        // }

        // String fileName= prop.getProperty("dns.file", "base_dns.txt");//valeurs par defaut si asence
        // Path path = Paths.get(fileName);

        // try{
        //     Files.write(path, ligne, StandardCharsets.UTF_8,StandardOpenOption.CREATE ,StandardOpenOption.APPEND);
        // } catch(IOException e){
        //     e.printStackTrace();
        // }  

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
