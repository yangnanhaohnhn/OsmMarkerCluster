/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */

package com.osm.mapapi.clusterutil.clustering;


import android.graphics.drawable.Drawable;


import org.osmdroid.util.GeoPoint;

/**
 * ClusterItem represents a marker on the map.
 */
public interface ClusterItem {

    /**
     * The position of this marker. This must always return the same value.
     */
    GeoPoint getPosition();

    Drawable getBitmapDescriptor();

    /**
     * 额外的信息 以json的形式存在
     */
    String getExtraInfo();
}