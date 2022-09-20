package com.fluytcloud.api.transport.mapper;

import com.fluytcloud.api.transport.request.CommentsRequest;
import com.fluytcloud.api.transport.response.CommentsResponse;
import com.fluytcloud.product.entities.Comments;

public class CommentsMapper  {

    private CommentsMapper() {}

    public static Comments map(CommentsRequest request) {
        return map(null, request);
    }

    public static Comments map(Integer id, CommentsRequest request) {
        return new Comments(id, request.name(), request.enable());
    }

    public static CommentsResponse map(Comments comments) {
        return new CommentsResponse(comments.id(), comments.name(), comments.enable());
    }

}
