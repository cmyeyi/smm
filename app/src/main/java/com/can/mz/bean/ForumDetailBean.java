package com.can.mz.bean;

import com.can.mz.build.UnProguardable;

import java.io.Serializable;
import java.util.List;

public class ForumDetailBean implements Serializable, UnProguardable {


    /**
     * is_new_comment : 0
     * this_forum_id : 20
     * is_praise : 0
     * release_aid : 1514345330785
     * title : title。。。
     * text : content。。。。。。。。。。。。。。。
     * praise_count : 1
     * view_count : 12
     * create_time : 2017-12-27 16:12:57
     * status : 1
     * release_user_name : Pengguna-0785
     * this_comment_count : 2
     * surplus_comment_count : 0
     * this_forum_comment : [{"is_praise":1,"comment_id":67,"release_user_id":0,"release_aid":"1514345330785","release_user_name":"Pengguna-0785","forum_id":20,"text":"是这样的对吧","is_reply":0,"reply_user_id":0,"reply_aid":"","reply_user_name":"Pengguna-","praise_count":1,"create_time":"2017-12-27 08:42:33"},{"is_praise":1,"comment_id":66,"release_user_id":0,"release_aid":"1514345330785","release_user_name":"Pengguna-0785","forum_id":20,"text":"真的是这样吗","is_reply":0,"reply_user_id":0,"reply_aid":"","reply_user_name":"Pengguna-","praise_count":1,"create_time":"2017-12-27 08:41:41"}]
     */

    public static final String FORUM_ID = "forum_id";
    public static final String VIEW_COUNT = "view_count";
    public static final String PRAISE_COUNT = "praise_count";
    public static final String COMMENT_COUNT = "comment_count";
    public static final int IS_PRAISE = 1;
    private int is_new_comment;
    private int this_forum_id;
    private int is_praise;
    private String release_aid;
    private String title;
    private String text;
    private int praise_count;
    private int view_count;
    private String create_time;
    private int status;
    private String release_user_name;
    private int this_comment_count;
    private int surplus_comment_count;
    private List<ForumCommentBean> this_forum_comment;

    public int getIs_new_comment() {
        return is_new_comment;
    }

    public void setIs_new_comment(int is_new_comment) {
        this.is_new_comment = is_new_comment;
    }

    public int getThis_forum_id() {
        return this_forum_id;
    }

    public void setThis_forum_id(int this_forum_id) {
        this.this_forum_id = this_forum_id;
    }

    public int getIs_praise() {
        return is_praise;
    }

    public void setIs_praise(int is_praise) {
        this.is_praise = is_praise;
    }

    public String getRelease_aid() {
        return release_aid;
    }

    public void setRelease_aid(String release_aid) {
        this.release_aid = release_aid;
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

    public int getPraise_count() {
        return praise_count;
    }

    public void setPraise_count(int praise_count) {
        this.praise_count = praise_count;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRelease_user_name() {
        return release_user_name;
    }

    public void setRelease_user_name(String release_user_name) {
        this.release_user_name = release_user_name;
    }

    public int getThis_comment_count() {
        return this_comment_count;
    }

    public void setThis_comment_count(int this_comment_count) {
        this.this_comment_count = this_comment_count;
    }

    public int getSurplus_comment_count() {
        return surplus_comment_count;
    }

    public void setSurplus_comment_count(int surplus_comment_count) {
        this.surplus_comment_count = surplus_comment_count;
    }

    public List<ForumCommentBean> getThis_forum_comment() {
        return this_forum_comment;
    }

    public void setThis_forum_comment(List<ForumCommentBean> this_forum_comment) {
        this.this_forum_comment = this_forum_comment;
    }

}
