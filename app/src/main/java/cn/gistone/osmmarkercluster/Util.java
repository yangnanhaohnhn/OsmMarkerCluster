package cn.gistone.osmmarkercluster;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.WindowManager;


import com.osm.mapapi.clusterutil.projection.Point;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

/**
 * Created by Administrator on 2018/4/8.
 */

public class Util {

    private static Activity mcontext;

    public Util(Activity context) {
        mcontext = context;
    }


    public static int getWidth() {
        WindowManager wm = mcontext.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    public static int getHeight() {
        WindowManager wm = mcontext.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

//    /*是否在中心点*/
//    public static boolean compareLat(MapView mapView, GeoPoint mlatlng) {
//        if (mcontext == null)
//            return false;
//        /*百度地图转换的的左上角经纬度*/
//        Point pt = new Point(0,0);
//        GeoPoint ll = mapView.getProjection().fromScreenLocation(pt);
//
//        /*百度地图转换的右下角经纬度*/
//        Point ptr = new Point(getWidth(),getHeight());
//        GeoPoint llr = mapView.getProjection().fromScreenLocation(ptr);
//        /*如果经度大于左上*/
//        if (llr.getLatitude() < mlatlng.getLatitude() && mlatlng.getLatitude() < ll.getLatitude() && ll.getLongitude() < mlatlng.getLongitude() && mlatlng.getLongitude() < llr.getLongitude()) {
//            return true;
//        }
//        return false;
//    }

}
