/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */

package com.example.day1227_zonghe.clusterutil.clustering;


import com.baidu.mapapi.model.LatLng;

import java.util.Collection;

/**
 * A collection of ClusterItems that are nearby each other.
 */
public interface Cluster<T extends com.example.day1227_zonghe.clusterutil.clustering.ClusterItem> {
    public LatLng getPosition();

    Collection<T> getItems();

    int getSize();
}