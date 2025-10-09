package fr.uvsq.cprog.collex;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Arrays;

public class Dns  {

    private List<DnsItem> basedns= new ArrayList<>();

    public Dns() throws EchecException {

        Properties prop = new Properties();
        try(FileReader read = new FileReader("config.properties")) {
            prop.load(read); 
        } catch (IOException e) {
            
            throw new EchecException("Impossible de lire 'config.properties' ");
        }

        String fileName= prop.getProperty("dns.file", "base_dns.txt");//valeurs par defaut si absence

        Path path = Paths.get(fileName);
        try{
            if (Files.notExists(path)) {
            Files.createFile(path);
            }
        }catch(IOException e){
            throw new EchecException("Impossible de creer le fichier " + fileName);
        }
        

        
        //recharger la base de données
    
     try{
            if(Files.size(path)>1) {

                List<String> ligne = Files.readAllLines(path);

                for( String line: ligne){
                    String parts[]= line.split(" ");
                    if(!this.basedns.contains(new DnsItem(new NomMachine(parts[0]), new AdresseIP(parts[1]))) && parts.length!=0) this.basedns.add(new DnsItem(new NomMachine(parts[0]), new AdresseIP(parts[1])));
                   
                }  
            }
    }catch(IOException e){
        throw new EchecException("Erreur lors de la lecture de " + fileName);
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
            if(line.getMachine().getMachine().equals(machine.getMachine()) && line.getMachine().getDomaine().equals(machine.getDomaine()) && line.getAdresseIP().getIP().equals(ip.getIP()))  throw new EchecException("Error : la machine existe deja ");
        }
        
        DnsItem nouvel = new DnsItem(machine, ip);
        this.basedns.add(nouvel);

        //garder le couple dans un fichier
        String dns = machine.getMachine() + " " + ip.getIP() ;
        List<String> ligne = Arrays.asList(dns);

        Properties prop = new Properties();
        try(FileReader read = new FileReader("config.properties")) {
            prop.load(read);
            
        } catch (IOException e) {
            throw new EchecException("Impossible de  lire 'config.properties'" );
        }

        String fileName= prop.getProperty("dns.file", "base_dns.txt");//valeurs par defaut si asence
        Path path = Paths.get(fileName);

        try{
            Files.write(path, ligne, StandardCharsets.UTF_8,StandardOpenOption.CREATE ,StandardOpenOption.APPEND);
        } catch(IOException e){
            throw new EchecException("Impossible d'ecrir dans le fichier "+ fileName);
        }  
    }
    
    public void ListerDnsItem(String domaine){
        if(this.basedns.size()!=0){
            for(DnsItem line : this.basedns){
                if(line.getMachine().getDomaine().equals(domaine)) System.out.println(line.toString());
            }
        }
    }

    public void ListerDnsItem_a(String domaine){
        
        if(this.basedns.size()!=0){
            
            ArrayList<DnsItem> list= new ArrayList<>();
            for(DnsItem line : this.basedns){
                
                if(line.getMachine().getDomaine().equals(domaine)) list.add(line);
            }
            
            Collections.sort(list);
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i).toString());
            }
        } else System.out.print("La base du dns est vide \n");
    }
}
