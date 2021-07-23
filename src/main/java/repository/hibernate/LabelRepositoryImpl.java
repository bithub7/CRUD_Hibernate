package repository.hibernate;

import model.Label;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.LabelRepository;

import java.sql.SQLException;
import java.util.List;

public class LabelRepositoryImpl implements LabelRepository {

    @Override
    public Label save(Label label) throws SQLException {
        Session session = CreatorSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(label);
        transaction.commit();
        session.close();
        return label;
    }

    @Override
    public Label update(Label label) {
        Session session = CreatorSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(label);
        transaction.commit();
        session.close();
        return label;
    }

    @Override
    public Label getById(Long id) {
        Session session = CreatorSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Label label = session.get(Label.class, id);
        transaction.commit();
        session.close();
        return label;
    }

    @Override
    public List<Label> getAll() {
        Session session = CreatorSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Label> labelList = session.createQuery("FROM Label").list();
        transaction.commit();
        session.close();
        return labelList;
    }

    @Override
    public void deleteById(Long id) {
        Session session = CreatorSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Label label = session.get(Label.class, id);
        session.delete(label);
        transaction.commit();
        session.close();
    }
}
