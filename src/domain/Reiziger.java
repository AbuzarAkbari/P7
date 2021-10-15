package domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="reiziger")
public class Reiziger {
    @Id
    @Column(name = "reiziger_id")
    private int id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboorteDatum;

    @OneToOne(mappedBy = "reiziger", cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    private Adres adres;

    @OneToMany(mappedBy = "reiziger", cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    private List<OVChipkaart> ovChipkaart;

    public Reiziger(){}


    public Reiziger(int id, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
        this.id = id;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getNaam() {
        if (this.tussenvoegsel == null) {
            return this.voorletters + " " + this.achternaam;
        } else{
            return this.voorletters + " " + this.tussenvoegsel + " " + this.achternaam;
        }
    }

    public void addOVchipkaart(OVChipkaart ovChipkaart){
        for(OVChipkaart o : ovChipkaarts){
            if (o.equals(ovChipkaart))
                ovChipkaarts.add(ovChipkaart);
        }


    }

    public void deleteOVchipkaart(OVChipkaart ovChipkaart){
        for(OVChipkaart o : ovChipkaarts){
            if (o.equals(ovChipkaart))
                ovChipkaarts.remove(ovChipkaart);
        }

    }



    public List<OVChipkaart> getOvChipkaarts() {
        return ovChipkaarts;
    }

    public void setOvChipkaarts(List<OVChipkaart> ovChipkaarts) {
        this.ovChipkaarts = ovChipkaarts;
    }
    @OneToOne(mappedBy = "adres")
    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        String a ="";
        if (adres!=null){
            a = adres.toString();;
        }

        ArrayList<String> ovchipkarten = new ArrayList<>();
        if (ovChipkaarts.size() != 0){
            for (OVChipkaart o : ovChipkaarts){
                ovchipkarten.add(String.valueOf(o.getKaart_nummer()));
            }}

        return "Reiziger{" +
                "id=" + id +
                ", voorletters='" + voorletters + '\'' +
                ", tussenvoegsel='" + tussenvoegsel + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", geboortedatum=" + geboortedatum +
                ", adres=" + a +
                ", ovChipkaarts=" + ovchipkarten +
                '}';
    }


}}