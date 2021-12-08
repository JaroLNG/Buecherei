public class Buch {
    public String name;
    public String autor;
    public String jahr;
    public int Seiten;
    public String genre;
    public String ausgeliehenVon = null;
    public String zusammenfassung;

    public void ausleihen(String ausleihenAn){
        if(ausgeliehenVon == null){
            ausgeliehenVon = ausleihenAn;
            System.out.println("Das Buch " + name + " wurde an " + ausgeliehenVon + " ausgeliehen.");
        }
        else{
            System.out.println("Fehler! Dieses Buch wurde bereits von " + ausgeliehenVon + " ausgeliehen!");
        }

    }

    public void getAusleiher(){
        if(ausgeliehenVon != null){
            System.out.println("Dieses Buch wurde von " + ausgeliehenVon + " ausgeliehen.");
        }
        else{
            System.out.println("Dieses Buch ist nicht ausgeliehen");
        }
    }

    public void ruckgabe(){
        if(ausgeliehenVon != null){
            System.out.println("Buch zurückgegeben!");
            ausgeliehenVon = null;
        }
        else{
            System.out.println("Fehler! Dieses Buch ist nicht ausgeliehen!");
        }
    }
}
