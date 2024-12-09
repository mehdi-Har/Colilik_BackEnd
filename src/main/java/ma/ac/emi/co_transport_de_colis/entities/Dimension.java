package ma.ac.emi.co_transport_de_colis.entities;

public class Dimension {

    private double longueur;
    private double largeur;
    private double hauteur;
    public Dimension(double longueur, double largeur, double hauteur) {
        if (longueur < 0 || largeur < 0 || hauteur < 0) {
            throw new IllegalArgumentException();
        }
        else{
            setHauteur(hauteur);
            setLargeur(largeur);
            setLongueur(longueur);
        }
    }
    public Dimension() {}

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    @Override
    public String toString() {
        return "Dimension{" +
                "longueur=" + longueur +
                ", largeur=" + largeur +
                ", hauteur=" + hauteur +
                '}';
    }
}