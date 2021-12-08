public class Main {

    public Buch[] buchliste = new Buch[100];
    public int IDNumer = 0;

    public Main() {
    }

    public static void main(String[] args){
        Main biblio = new Main();
        GUI gui = new GUI();
    }

    public void neuesBuch(String BuchName, String BuchAutor, String BuchAlter, String BuchGenre){
        IDNumer = IDNumer + 1;
        buchliste[IDNumer] = new Buch();
        buchliste[IDNumer].name = BuchName;
        buchliste[IDNumer].autor = BuchAutor;
        buchliste[IDNumer].jahr = BuchAlter;
        buchliste[IDNumer].genre = BuchGenre;
        System.out.println("Das Buch mit dem Namen " + BuchName + " wurde mit der ID " + IDNumer + " hinzugefügt. (Object: " + buchliste[IDNumer] + ")");
    }

    public void getName(int ID){
        System.out.println("Buchname für " + ID + " ist " + buchliste[ID].name);
    }



}
