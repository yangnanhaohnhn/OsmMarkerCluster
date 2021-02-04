package cn.gistone.osmmarkercluster;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.osm.mapapi.clusterutil.clustering.ClusterItem;

import org.osmdroid.util.GeoPoint;

/**
 * Created by Nan on 2020/3/26.
 *
 * @author Nan
 * Desc:
 * * 每个Marker点，包含Marker点坐标以及图标
 */
public class ItemMarker implements ClusterItem {
    private final GeoPoint mPosition;
    private final Context mContext;
    private String bundle;

    public ItemMarker(Context context, GeoPoint latLng) {
        this(context,latLng,"");
    }

    public ItemMarker(Context context, GeoPoint latLng, String bundle) {
        mPosition = latLng;
        this.bundle = bundle;
        this.mContext = context;
    }

    @Override
    public GeoPoint getPosition() {
        return mPosition;
    }

    @Override
    public Drawable getBitmapDescriptor() {
        return mContext.getResources().getDrawable(R.mipmap.img_bhd_yd);
    }

    @Override
    public String getExtraInfo() {
        return bundle;
    }
}
