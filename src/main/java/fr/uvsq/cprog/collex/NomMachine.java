package fr.uvsq.cprog.collex;

public class NomMachine {
    
    private final String machine;
    private final String nomMachine;
    private final String domaine;

    public NomMachine(String machine){
        
        if(machine == null) throw new IllegalArgumentException("le nom de la machine est null");

        if(!machine.contains(".") || machine.startsWith(".") || machine.endsWith("."))  throw new IllegalArgumentException("nom machine invalide : "+ machine);
           
        this.machine=machine;

        String parts[]=machine.split("\\.",2);
        this.nomMachine=parts[0];
        this.domaine=parts[1];
    }

    public String getMachine(){
        return this.machine;
    }

    public String getNomMachineStrin(){
        return this.nomMachine;
    }

    public String getDomaine(){
        return this.domaine;
    }

    @Override
    public String toString(){
        return this.machine;
    }
}
