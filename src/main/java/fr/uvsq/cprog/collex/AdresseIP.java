package fr.uvsq.cprog.collex;

public class AdresseIP {

    private final String IP;
    
    public AdresseIP(String addIP){

        if(addIP==null) throw new IllegalArgumentException("Adress IP null");

        String[] part= addIP.split("\\.");
        if(part.length!=4)  throw new IllegalArgumentException("Adress IP invalide : "+ addIP);

        for(int i=0; i<4;i++){
            if(Integer.parseInt(part[i]) <0 || Integer.parseInt(part[i]) >255) throw new IllegalArgumentException("Adress IP invalide, les nombres hors plages : "+ addIP);
        }
           
        this.IP=addIP;
    }

    public String getIP(){
        return this.IP;
    }

    @Override
    public String toString(){
        return this.IP;
    }

}
    

