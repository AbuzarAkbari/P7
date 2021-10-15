package dao;

public class OVChipkaartDAO {

    public boolean save(OVChipkaart ovChipkaart) throws SQLException;

    public boolean update(OVChipkaart ovChipkaart) throws SQLException;

    public boolean delete(OVChipkaart ovChipkaart) throws SQLException;

    public OVChipkaart findByKaartnummer(int kaartnummer) throws SQLException;

    public List<OVChipkaart> findAll() throws SQLException;

    public List<OVChipkaart> findByReiziger(Reiziger reiziger) throws SQLException;

}
