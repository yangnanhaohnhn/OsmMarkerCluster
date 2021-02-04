/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */

package com.osm.mapapi.clusterutil.clustering.algo;


import com.osm.mapapi.clusterutil.clustering.Cluster;
import com.osm.mapapi.clusterutil.clustering.ClusterItem;

import org.osmdroid.util.GeoPoint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A cluster whose center is determined upon creation.
 */
public class StaticCluster<T extends ClusterItem> implements Cluster<T> {
    private final GeoPoint mCenter;
    private final List<T> mItems = new ArrayList<T>();

    public StaticCluster(GeoPoint center) {
        mCenter = center;
    }



    public boolean add(T t) {
        return mItems.add(t);
    }

    @Override
    public GeoPoint getPosition() {
        return mCenter;
    }

    public boolean remove(T t) {
        return mItems.remove(t);
    }

    @Override
    public Collection<T> getItems() {
        return mItems;
    }

    @Override
    public int getSize() {
        return mItems.size();
    }

    @Override
    public String toString() {
        return "StaticCluster{"
                + "mCenter=" + mCenter
                + ", mItems.size=" + mItems.size()
                + '}';
    }
}