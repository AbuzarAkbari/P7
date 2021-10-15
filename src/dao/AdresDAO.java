package dao.hibernate;

public class AdresDAO {
    public boolean save(Adres adres) throws SQLException;

    public boolean update(Adres adres) throws SQLException;

    public boolean delete(Adres adres) throws SQLException;

    public List<Adres> findByReiziger(Reiziger reiziger) throws SQLException;

    public List<Adres> findAll() throws SQLException;

}
