package com.can.mz.net;

import com.can.mz.bean.ForumDetailBean;
import com.can.mz.bean.ForumList;
import com.can.mz.bean.ForumNotification;
import com.can.mz.bean.ForumResponseResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PintarService {

    @GET("forum/forumList/")
    Call<ForumList> getForumList(@Query("current_aid") String current_aid);

    @GET("notification/isNoticeCommentByCurrentAid/")
    Call<ForumNotification> hasNoticeComment(@Query("current_aid") String current_aid);

    @GET("forum/forumDetailPage/")
    Call<ForumDetailBean> getForumDetailPage(@Query("forum_id") String forum_id, @Query("is_new_comment") int is_new_comment, @Query("current_aid") String current_aid);

    @POST("forum/addForumText/")
    @FormUrlEncoded
    Call<ForumResponseResult> postForumText(
            @Field("forum_title") String forum_title,
            @Field("forum_text") String forum_text,
            @Field("current_aid") String current_aid);

    @POST("forum/addCommentText")
    @FormUrlEncoded
    Call<ForumResponseResult> postComment(
            @Field("comment_text") String comment_text,
            @Field("is_reply") int is_reply,
            @Field("current_aid") String current_aid,
            @Field("forum_release_aid") String forum_release_aid,
            @Field("forum_id") String forum_id
    );

    @POST("forum/addCommentText")
    @FormUrlEncoded
    Call<ForumResponseResult> postReplayComment(
            @Field("comment_text") String comment_text,
            @Field("is_reply") int is_reply,
            @Field("current_aid") String current_aid,
            @Field("forum_release_aid") String forum_release_aid,
            @Field("forum_id") String forum_id,
            @Field("reply_aid") String reply_aid
    );

}
