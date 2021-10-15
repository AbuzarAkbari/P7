package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="product")
public class Product {
    @Id
    @Column(name = "product_nummer")
    private int product_nummer;
    private String naam;
    private String beschrijving;
    private Double prijs;

    @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable( name = "ov_chipkaart_product",
            joinColumns = { @JoinColumn(name="kaart_nummer") },
            inverseJoinColumns = { @JoinColumn(name="product_nummer") }
    )
    private List<OVChipkaart> ovChipkaart;
    public Product(){

    }

    public Product(int product_nummer, String naam, String beschrijving, float prijs) {
        this.product_nummer = product_nummer;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        ovchipkaarts  = new ArrayList<>();
    }

    public int getProductNummer() {
        return product_nummer;
    }

    public void setProductNummer(int productNumme) {
        this.product_nummer = product_nummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public float getPrijs() {
        return prijs;
    }

    public void setPrijs(float prijs) {
        this.prijs = prijs;
    }

    public List<OVChipkaart> getOvChipkaarts() {
        return ovchipkaarts ;
    }

    public void setOvChipkaartNummers(List<OVChipkaart> ovChipkaarts) {
        this.ovchipkaarts  = ovChipkaarts;
    }


    public boolean voegOvChipKaartToe(OVChipkaart ovChipkaart){
        boolean isToegevoegd = false;
        for (OVChipkaart o : ovchipkaarts ){
            if(o.equals(ovChipkaart)){
                ovchipkaarts.add(ovChipkaart);
                isToegevoegd = true;
            }
        }
        return isToegevoegd;
    }
    public boolean verwijderOvChipKaart(OVChipkaart ovChipkaart){
        boolean isVerwijderd = false;
        for (OVChipkaart o : ovchipkaarts ){
            if(o.equals(ovChipkaart)){
                ovchipkaarts .remove(ovChipkaart);
                isVerwijderd = true;
            }
        }
        return isVerwijderd;
    }


    @Override
    public String toString() {
        ArrayList<String> ovchipkarten = new ArrayList<>();
        if (ovchipkaarts.size() !=0){
            for (OVChipkaart o : ovchipkaarts){
                ovchipkarten.add(String.valueOf(o.getKaart_nummer()));
            }}
        return "Product{ " +
                "product_nummer=" + product_nummer +
                ", naam='" + naam + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", prijs=" + prijs +
                ", ovchipkaarts =" + ovchipkarten+
                '}';
    }
}}