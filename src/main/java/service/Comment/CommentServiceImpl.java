package service.Comment;

import base.service.BaseServiceImpl;
import model.Comment;
import org.hibernate.SessionFactory;
import repository.Comment.CommentRepository;


public class CommentServiceImpl extends BaseServiceImpl<Comment, Long, CommentRepository> implements CommentService {

    private final SessionFactory sessionFactory;

    public CommentServiceImpl(CommentRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

}
