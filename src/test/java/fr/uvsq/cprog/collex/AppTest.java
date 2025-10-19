package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class AppTest 
{
    DnsTest dns;

    @Test(expected=IllegalArgumentException.class)
    public void TestAdresseIP(){

        //cas ip null
        new AdresseIP(null);
        
        //cas ip composé de plus ou moins que 4 parties
        new AdresseIP("123.45.99.0.3");
        new AdresseIP("125.45"); 

        //cas ip est composé de nombre hors plage
        new AdresseIP("999.0.0.0");
        new AdresseIP("-1.0.0.0.");

        //cas ip composé de caracteres non numerique
        new AdresseIP("124.a.0.0");
        new AdresseIP("89.@.!.0");
          
    }

    @Test(expected=IllegalArgumentException.class)
    public void TestMachine(){

        //cas nom machine null
        new NomMachine(null);

        //cas nom machine ne contient au moins un point
        new NomMachine("ecampusuvsqfr");

        //cas nom machine commence/finie par un point
        new NomMachine("ecampus.uvsq.fr.");
        new NomMachine(".ecampus.uvsq.fr");
    }


    @Test(expected = EchecException.class)
    public void TestDns() throws EchecException{

            DnsTest dns_= new DnsTest("test1");
            AdresseIP ip = new AdresseIP("192.75.52.0");
            NomMachine machine= new NomMachine("ecampus.uvsq.fr");
            dns_.addItem(ip, machine);

            //test de l'ajout d'une machine existante, une exception doit etre levee
            AdresseIP ip2 = new AdresseIP("192.75.52.0");
            dns_.addItem(ip2, machine);

            //test de l'ajout d'aresse ip existante, une exception doit etre levee
            NomMachine machine2= new NomMachine("partage.uvsq.fr");
            dns_.addItem(ip, machine2);
            
            //verification de la valeur retourner cas appel avec NomMachine
            assertEquals("192.75.52.0 ecampus.uvsq.fr", dns_.getItem(machine).toString());

            //verification de la valeur retourner cas appel AdresseIP
            assertEquals("192.75.52.0 ecampus.uvsq.fr", dns_.getItem(ip).toString());



    }   

    @Test(expected=EchecException.class)
    public void testDnsItem() throws EchecException{
        new DnsItem(new NomMachine("ecampus.uvsq.fr"), null);
        new DnsItem(null, new AdresseIP("123.4.5.6"));
        new DnsItem(null, null);
    }

   
    
    @Test(expected=EchecException.class)
    public void testtypeCommande() throws EchecException{

        //test addCommande
        new AddCommande(new NomMachine("ecampus.uvsq.fr"),null);
        new AddCommande(new NomMachine("ecampus.uvsq"),null);
        new AddCommande(null,new AdresseIP("123.4.5.6"));
        new AddCommande(null,new AdresseIP("123.4.5"));
        new AddCommande(null,null);

        //test ipCommande
        new IpCommande(null);

        //test nameCommande
        new NameCommande(null);

    }


    @Before
    public void initialisation() throws EchecException{
        dns= new DnsTest("test_TypeCommande");
    }

     @Test(expected = EchecException.class)
    public void TestAddCommande() throws EchecException{
        
        AdresseIP ip = new AdresseIP("192.4.5.0");
        NomMachine machine= new NomMachine("ecampus.uvsq.fr");
        AddTest add = new AddTest(machine, ip);
        add.execute(dns);
    
        //test Add commande
        //verification que l'adresse et le nom machine sont bien ajouter au dns
        assertEquals("192.4.5.0 ecampus.uvsq.fr", dns.getItem(ip).toString());
        assertEquals("192.4.5.0 ecampus.uvsq.fr", dns.getItem(machine).toString());
        //cas ajout d'une adresse existante, une exception doit etre levée
        AddTest add2 = new AddTest(machine, ip);
        add2.execute(dns);

        //test Ip commande
        IpTest ipcmd=new IpTest(machine);
        ipcmd.execute(dns);
        //verifier si la commande ip retourne bien l'adresse ip du nom machine passé en paramettre
        assertEquals("192.4.5.0", ipcmd.getIp().toString());

        //test Name commande
        NameTest machine_cmd=new NameTest(ip);
        machine_cmd.execute(dns);

        //verifier si la commande name retourne bien le nom machine de l'@ passée en paramettre
        assertEquals("ecampus.uvsq.fr", machine_cmd.getMachine().toString());
    }

    
    // @Test
    // public void TestNameCommande() throws EchecException{
    //     AdresseIP ip= new AdresseIP("192.4.5.0");
    //     NameTest machine=new NameTest(ip);
    //     machine.execute(dns);

    //     //verifier si la commande name retourne bien le nom machine de l'@ passée en paramettre
    //     assertEquals("ecampus.uvsq.fr", machine.getMachine().toString());

    // }

    
}
