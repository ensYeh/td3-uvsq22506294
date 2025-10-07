package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest 
{
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

}
