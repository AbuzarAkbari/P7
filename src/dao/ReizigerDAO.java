package dao;

public class ReizigerDAO {
    public boolean save(Reiziger reiziger) throws SQLException;

    public boolean update(Reiziger reiziger) throws SQLException;

    public boolean delete(Reiziger reiziger) throws SQLException;

    public Reiziger findById(int id) throws SQLException;

    public List<Reiziger> findByGbdatum(String datum) throws SQLException;

    public List<Reiziger> findAll() throws SQLException;
}
