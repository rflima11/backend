package com.fluytcloud.product.datasources.relational.repository;

import com.fluycloud.support.core.CrudMapper;
import com.fluycloud.support.core.CrudRepositoryImpl;
import com.fluytcloud.product.datasources.relational.mapper.CommentsModelMapper;
import com.fluytcloud.product.datasources.relational.model.CommentsModel;
import com.fluytcloud.product.entities.Comments;
import com.fluytcloud.product.repositories.CommentsRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CommentsRepositoryImpl extends CrudRepositoryImpl<Comments, CommentsModel, Integer> implements CommentsRepository {

    private final CommentsJpaRepository commentsJpaRepository;

    public CommentsRepositoryImpl(CommentsJpaRepository commentsJpaRepository) {
        this.commentsJpaRepository = commentsJpaRepository;
    }

    @Override
    protected JpaRepository<CommentsModel, Integer> getJpaRepository() {
        return commentsJpaRepository;
    }

    @Override
    protected CrudMapper<Comments, CommentsModel> getMapper() {
        return new CommentsModelMapper();
    }

    @Override
    public List<Comments> search(String search) {
        var list = StringUtils.isBlank(search)
                ? commentsJpaRepository.findAll(pageable).getContent()
                : commentsJpaRepository.findByNameContainingIgnoreCase(search, pageable);
        return list.stream()
                .map(it -> getMapper().mapToEntity(it))
                .toList();
    }

}
