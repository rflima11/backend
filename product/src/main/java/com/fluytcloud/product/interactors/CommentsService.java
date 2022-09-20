package com.fluytcloud.product.interactors;

import com.fluycloud.support.core.CrudRepository;
import com.fluycloud.support.core.CrudServiceImpl;
import com.fluytcloud.product.entities.Comments;
import com.fluytcloud.product.repositories.CommentsRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CommentsService extends CrudServiceImpl<Comments, Integer> {

    private final CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    protected CrudRepository<Comments, Integer> getRepository() {
        return commentsRepository;
    }

}
