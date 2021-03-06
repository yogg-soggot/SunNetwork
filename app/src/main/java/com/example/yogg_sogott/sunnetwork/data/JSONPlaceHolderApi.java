package com.example.yogg_sogott.sunnetwork.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {
    @GET("posts/{id}")
    Call<PostDTO> getPostWithID(@Path("id") int id);

    @GET("posts")
    Call<List<PostDTO>> getAllPosts();

    @POST("posts/")
    Call<PostDTO> post(@Body PostDTO data);

    @GET("comments/")
    Call<List<CommentDTO>> getCommentWithPostId(@Query("post_id") int postId);
}
