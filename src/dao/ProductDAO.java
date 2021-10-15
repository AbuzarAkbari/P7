package dao;

public class ProductDAO {

    public boolean save(Product product) throws SQLException;

    public boolean update(Product product) throws SQLException;

    public boolean delete(Product product) throws SQLException;

    public Product findByProductNummer(int productNummer) throws SQLException;

    public List<Product> findAll() throws SQLException;

    public List<Product> findByOVChipkaart(OVChipkaart ovChipkaart) throws SQLException;
}
