package com.can.mz.bean;

import com.can.mz.build.UnProguardable;

import java.io.Serializable;

public class ForumItemBean implements Serializable, UnProguardable {
    /**
     * is_praise : 0
     * is_new_comment : 0
     * new_comment_count : 0
     * forum_id : 10
     * release_user_id : 0
     * release_aid : 1514345205079
     * release_user_name : Pengguna-5079
     * title : 还钱
     * text : 借钱
     * view_count : 14
     * praise_count : 3
     * this_comment_count : 1
     * create_time : 2017-12-27 11:12:59
     * "is_hot": 1,
     * "is_new": 0,
     * "top": 100,
     */

    private int is_praise;
    private int is_new_comment;
    private int new_comment_count;
    private int forum_id;
    private int release_user_id;
    private String release_aid;
    private String release_user_name;
    private String title;
    private String text;
    private int view_count;
    private int praise_count;
    private int this_comment_count;
    private String create_time;
    private int is_hot;
    private int is_new;
    private int top;

    public int getIs_praise() {
        return is_praise;
    }

    public void setIs_praise(int is_praise) {
        this.is_praise = is_praise;
    }

    public int getIs_new_comment() {
        return is_new_comment;
    }

    public void setIs_new_comment(int is_new_comment) {
        this.is_new_comment = is_new_comment;
    }

    public int getNew_comment_count() {
        return new_comment_count;
    }

    public void setNew_comment_count(int new_comment_count) {
        this.new_comment_count = new_comment_count;
    }

    public int getForum_id() {
        return forum_id;
    }

    public void setForum_id(int forum_id) {
        this.forum_id = forum_id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public int getPraise_count() {
        return praise_count;
    }

    public void setPraise_count(int praise_count) {
        this.praise_count = praise_count;
    }

    public int getThis_comment_count() {
        return this_comment_count;
    }

    public void setThis_comment_count(int this_comment_count) {
        this.this_comment_count = this_comment_count;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }

    public int getIs_hot() {
        return is_hot;
    }

    public void setIs_new(int is_new) {
        this.is_new = is_new;
    }

    public int getIs_new() {
        return is_new;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getTop() {
        return top;
    }
}
