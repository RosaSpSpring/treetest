package com.ko.accs2.util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import com.ko.accs2.LaunchActivity;

public class PermisionUtils {
    private static final String TAG = LaunchActivity.class.getSimpleName();

	//这是要申请的权限
	private static String[] PERMISSIONS_CAMERA_AND_STORAGE = {
			Manifest.permission.READ_EXTERNAL_STORAGE,
			Manifest.permission.WRITE_EXTERNAL_STORAGE,
			Manifest.permission.CAMERA};

	/**
	 * 解决安卓6.0以上版本不能读取外部存储权限的问题
	 *
	 * @param activity
	 * @return
	 */
	public static boolean isGrantExternalRW(Activity activity) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && activity.checkSelfPermission( Manifest.permission.WRITE_EXTERNAL_STORAGE ) != PackageManager.PERMISSION_GRANTED) {
			activity.requestPermissions( new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE}, 1 );
			return false;
		}
		return true;
	}

//	/**
//	 * 解决安卓6.0以上版本不能读取外部存储权限的问题
//	 *
//	 * @param activity
//	 * @param requestCode
//	 * @return
//	 */
//	public static boolean isGrantExternalRW(Activity activity, int requestCode) {
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//
//			int storagePermission = activity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//			int cameraPermission = activity.checkSelfPermission(Manifest.permission.CAMERA);
//			//检测是否有权限，如果没有权限，就需要申请
//			if (storagePermission != PackageManager.PERMISSION_GRANTED ||
//					cameraPermission != PackageManager.PERMISSION_GRANTED) {
//
//				//申请权限
//				activity.requestPermissions(PERMISSIONS_CAMERA_AND_STORAGE, requestCode);
//				//返回false。说明没有授权
//				return false;
//			}
//		}
//		//说明已经授权
//		return true;
//	}
}