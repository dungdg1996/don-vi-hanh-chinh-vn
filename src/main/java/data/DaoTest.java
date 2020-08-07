package data;

import entity.Level;

public class DaoTest {
    static DVHCDao dvhcDao = new DVHCDao();

    public static void main(String[] args) {
//        dvhcDao.findAll().forEach(System.out::println);
        dvhcDao.findByLevel(Level.TINH).stream().forEach(System.out::println);
    }
}
