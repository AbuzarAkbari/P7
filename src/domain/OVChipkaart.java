package domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="ov_chipkaart")
public class OVChipkaart {
    @Id
    @Column(name = "kaart_nummer")
    private int kaart_nummer;

    @Column(name = "geldig_tot")
    private Date geldigTot;
    private int klasse;
    private Double saldo;

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE } )
    @JoinColumn(name = "reiziger_id")
    private Reiziger reiziger;

    @ManyToMany(mappedBy = "ovChipkaart", cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    private List<Product> product;

    public OVChipkaart(){}

    public OVChipkaart(int kaart_nummer, Date geldig_tot, int klasse, double saldo, Reiziger reiziger) {
        this.kaart_nummer = kaart_nummer;
        this.geldig_tot = geldig_tot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reiziger = reiziger;
        this.products = new ArrayList<>();

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public boolean voegProductToe(Product product){
        boolean isToegevoeegd = false;
        for (Product p : products){
            if(!p.equals(product)){
                products.add(product);
                isToegevoeegd = true;
            }
        }
        return isToegevoeegd;
    }
    public boolean verwijderProduct(Product product){
        boolean isVerwijderd = false;
        for (Product p : products){
            if(!p.equals(product)){
                products.remove(product);
                isVerwijderd = true;
            }
        }
        return isVerwijderd;
    }

    public int getKaart_nummer() {
        return kaart_nummer;
    }

    public void setKaart_nummer(int kaart_nummer) {
        this.kaart_nummer = kaart_nummer;
    }

    public Date getGeldig_tot() {
        return geldig_tot;
    }

    public void setGeldig_tot(Date geldig_tot) {
        this.geldig_tot = geldig_tot;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }


    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }

    @Override
    public String toString() {
        return "OVChipkaart{" +
                "kaart_nummer=" + kaart_nummer +
                ", geldig_tot=" + geldig_tot +
                ", klasse=" + klasse +
                ", saldo=" + saldo +
                ", reiziger=" + reiziger.getNaam() +
                ", products=" + products +
                '}';
    }
}