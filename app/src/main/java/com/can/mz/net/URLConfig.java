package com.can.mz.net;

public class URLConfig {
    public final static boolean isProduct = false;//true 正式环境
    public final static String BASE_HOST = isProduct ? "https://rupiahstore.cmcm.com/api/" : "http://10.60.81.109/api/";


}
