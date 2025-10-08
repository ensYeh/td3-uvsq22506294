package fr.uvsq.cprog.collex;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;
import java.util.ArrayList;

public class Dns {

    private List<DnsItem> basedns= new ArrayList<>();

    public Dns(){

        Properties prop = new Properties();
        try(FileReader read = new FileReader("config.properties")) {
            prop.load(read);
            
        } catch (IOException e) {
            e.getStackTrace();
        }

        String fileName= prop.getProperty("dns.file", "base_base.txt");//valeurs par defaut si asence
        Path path = Paths.get(fileName);

        //recharger la base de données
        try{
            List<String> ligne = Files.readAllLines(path);

            for( String line: ligne){
                String parts[]= line.split(" ");
                if(!this.basedns.contains(new DnsItem(new NomMachine(parts[0]), new AdresseIP(parts[1]))))  this.basedns.add(new DnsItem(new NomMachine(parts[0]), new AdresseIP(parts[1])));

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public DnsItem getItem(AdresseIP ip){

        for(DnsItem line : this.basedns){
            if(line.getAdresseIP().getIP().equals(ip.getIP())) return line;
        }
        return null;
    }

    public DnsItem getItem(NomMachine machine){

        for(DnsItem line : this.basedns){
            if(line.getMachine().getMachine().equals(machine.getMachine()) && line.getMachine().getDomaine().equals(machine.getDomaine())) return line;
        }
        return null;
    }

    public void addItem(AdresseIP ip, NomMachine machine) throws EchecException{

        for(DnsItem line : this.basedns){
            if(line.getAdresseIP().getIP().equals(ip.getIP()) ) throw new EchecException("Eror : l'adresse ip existe deja ");
            if(line.getMachine().getMachine().equals(machine.getMachine()) && line.getMachine().getDomaine().equals(machine.getDomaine()))  throw new EchecException("Eror : la machine existe deja ");
        }
        
        DnsItem nouvel = new DnsItem(machine, ip);
        this.basedns.add(nouvel);

    }
    
}
