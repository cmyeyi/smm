package com.can.mz.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.tech.aile.permission.OnPermission;
import com.tech.aile.permission.PermissionsHelper;

import java.util.List;

/**
 * Created by bull on 2018/8/27.
 */

public class PermissionManager {

    //Permission.Group.STORAGE
    public static void requestPermission(final Activity activity, String... permissions) {
        PermissionsHelper.with(activity)
                .constantRequest() //可设置被拒绝后继续申请，直到用户授权或者永久拒绝
                //.permission(Permission.SYSTEM_ALERT_WINDOW, Permission.REQUEST_INSTALL_PACKAGES) //支持请求6.0悬浮窗权限8.0请求安装权限
                .permission(permissions) //不指定权限则自动获取清单中的危险权限
                .request(new OnPermission() {

                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {
                        if (isAll) {
                            Toast.makeText(activity, "获取权限成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(activity, "获取权限成功，部分权限未正常授予", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {
                        if (quick) {
                            Toast.makeText(activity, "被永久拒绝授权，请手动授予权限", Toast.LENGTH_SHORT).show();
                            //如果是被永久拒绝就跳转到应用权限系统设置页面
                            PermissionsHelper.gotoPermissionSettings(activity);
                        } else {
                            Toast.makeText(activity, "获取权限失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public static boolean isHasPermission(Context context, String... permissions) {
        if (PermissionsHelper.isHasPermission(context, permissions)) {
            Toast.makeText(context, "已经获取到权限，不需要再次申请了", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(context, "还没有获取到权限或者部分权限未授予", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public static void gotoPermissionSettings(Context context) {
        PermissionsHelper.gotoPermissionSettings(context);
    }
}
