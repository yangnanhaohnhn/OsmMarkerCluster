package com.osm.mapapi.clusterutil;

import android.app.Activity;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import org.osmdroid.api.IGeoPoint;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

/**
 * Created by  on 2020/4/26.
 *
 * @author Desc:
 */
public class MapUtils {
    public static int getWidth(Activity activity) {
        WindowManager wm = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    public static int getHeight(Activity activity) {
        WindowManager wm = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }


    /*是否在中心点*/
    public static boolean compareLat(Activity activity, MapView mapView, GeoPoint geoPoint) {
        /*百度地图转换的的左上角经纬度*/
        if (activity == null)
            return false;
        Point pt = new Point();
        pt.x = 0;
        pt.y = 0;
        IGeoPoint ll = mapView.getProjection().fromPixels(pt.x, pt.y);

        /*百度地图转换的右下角经纬度*/
        Point ptr = new Point();
        ptr.x = getWidth(activity);
        ptr.y = getHeight(activity);
        IGeoPoint llr = mapView.getProjection().fromPixels(ptr.x, ptr.y);
        /*如果经度大于左上*/
        if (llr.getLatitude() < geoPoint.getLatitude() && geoPoint.getLatitude() < ll.getLatitude() && ll.getLongitude() < geoPoint.getLongitude() && geoPoint.getLongitude() < llr.getLongitude()) {
            return true;
        }
        return false;
    }
}
