import ru.suptex.Dao.Dao;
import ru.suptex.Dao.impl.UserDaoImpl;
import ru.suptex.model.User;
import ru.suptex.util.Connector;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection connection = Connector.getInstance();
        Dao<User, Long> userDao = new UserDaoImpl(connection);

        System.out.println("Конкретный id");
        System.out.println(userDao.findById(1L));

//        userDao.save(new User("Aleksey", "Gribkov"));

        User userUpdater = userDao.findById(1L);
        userUpdater.setFirstName("Dmitry");
        userUpdater.setLastName("Antonovich");
        userDao.update(userUpdater);

        userDao.delete(7L);

        System.out.println("Все данные");
        userDao.findAll().forEach(System.out::println);


        Connector.close(connection);

    }

}
