package repository.hibernate;

import model.Label;
import model.Writer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.WriterRepository;

import java.sql.SQLException;
import java.util.List;

public class WriterRepositoryImpl implements WriterRepository {
    @Override
    public Writer save(Writer writer) throws SQLException {
        Session session = CreatorSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(writer);
        transaction.commit();
        session.close();
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        Session session = CreatorSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(writer);
        transaction.commit();
        session.close();
        return writer;
    }

    @Override
    public Writer getById(Long id) {
        Session session = CreatorSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Writer writer = session.get(Writer.class, id);
        transaction.commit();
        session.close();
        return writer;
    }

    @Override
    public List<Writer> getAll() {
        Session session = CreatorSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Writer> writerList = session.createQuery("FROM Writer").list();
        transaction.commit();
        session.close();
        return writerList;
    }

    @Override
    public void deleteById(Long id) {
        Session session = CreatorSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Writer writer = session.get(Writer.class, id);
        session.delete(writer);
        transaction.commit();
        session.close();
    }
}
