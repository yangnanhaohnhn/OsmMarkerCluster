/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */

package com.osm.mapapi.clusterutil.clustering;


import org.osmdroid.util.GeoPoint;

import java.util.Collection;

/**
 * A collection of ClusterItems that are nearby each other.
 */
public interface Cluster<T extends ClusterItem> {
    GeoPoint getPosition();

    Collection<T> getItems();

    int getSize();
}