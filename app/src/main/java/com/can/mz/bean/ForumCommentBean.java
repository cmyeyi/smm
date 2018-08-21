package com.can.mz.bean;

import com.can.mz.build.UnProguardable;

import java.io.Serializable;

public class ForumCommentBean implements Serializable, UnProguardable {

    /**
     * is_praise : 1
     * comment_id : 67
     * release_user_id : 0
     * release_aid : 1514345330785
     * release_user_name : Pengguna-0785
     * forum_id : 20
     * text : 是这样的对吧
     * is_reply : 0
     * reply_user_id : 0
     * reply_aid :
     * reply_user_name : Pengguna-
     * praise_count : 1
     * create_time : 2017-12-27 08:42:33
     */
    public static final int IS_PRAISE = 1;
    public static final int IS_REPLY = 1;
    private int is_praise;
    private int comment_id;
    private int release_user_id;
    private String release_aid;
    private String release_user_name;
    private int forum_id;
    private String text;
    private int is_reply;
    private int reply_user_id;
    private String reply_aid;
    private String reply_user_name;
    private int praise_count;
    private String create_time;

    public int getIs_praise() {
        return is_praise;
    }

    public void setIs_praise(int is_praise) {
        this.is_praise = is_praise;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getRelease_user_id() {
        return release_user_id;
    }

    public void setRelease_user_id(int release_user_id) {
        this.release_user_id = release_user_id;
    }

    public String getRelease_aid() {
        return release_aid;
    }

    public void setRelease_aid(String release_aid) {
        this.release_aid = release_aid;
    }

    public String getRelease_user_name() {
        return release_user_name;
    }

    public void setRelease_user_name(String release_user_name) {
        this.release_user_name = release_user_name;
    }

    public int getForum_id() {
        return forum_id;
    }

    public void setForum_id(int forum_id) {
        this.forum_id = forum_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIs_reply() {
        return is_reply;
    }

    public void setIs_reply(int is_reply) {
        this.is_reply = is_reply;
    }

    public int getReply_user_id() {
        return reply_user_id;
    }

    public void setReply_user_id(int reply_user_id) {
        this.reply_user_id = reply_user_id;
    }

    public String getReply_aid() {
        return reply_aid;
    }

    public void setReply_aid(String reply_aid) {
        this.reply_aid = reply_aid;
    }

    public String getReply_user_name() {
        return reply_user_name;
    }

    public void setReply_user_name(String reply_user_name) {
        this.reply_user_name = reply_user_name;
    }

    public int getPraise_count() {
        return praise_count;
    }

    public void setPraise_count(int praise_count) {
        this.praise_count = praise_count;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
