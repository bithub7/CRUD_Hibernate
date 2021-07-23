package repository.hibernate;

import model.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.PostRepository;

import java.util.List;

public class PostRepositoryImpl implements PostRepository {
    @Override
    public Post save(Post post){
        Session session = CreatorSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(post);
        transaction.commit();
        session.close();
        return post;
    }

    @Override
    public Post update(Post post) {
        Post postForGetData = getById(post.getId());
        post.setCreated(postForGetData.getCreated());
        Session session = CreatorSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(post);
        transaction.commit();
        session.close();
        return post;
    }

    @Override
    public Post getById(Long id) {
        Session session = CreatorSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Post post = session.get(Post.class, id);
        transaction.commit();
        session.close();
        return post;    }

    @Override
    public List<Post> getAll() {
        Session session = CreatorSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Post> postList = session.createQuery("FROM Post").list();
        transaction.commit();
        session.close();
        return postList;
    }

    @Override
    public void deleteById(Long id) {
        Session session = CreatorSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Post post = session.get(Post.class, id);
        session.delete(post);
        transaction.commit();
        session.close();
    }
}
