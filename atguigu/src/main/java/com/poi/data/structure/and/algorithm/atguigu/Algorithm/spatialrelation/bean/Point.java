package com.poi.data.structure.and.algorithm.atguigu.Algorithm.spatialrelation.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Point implements Serializable {

    private static final long serialVersionUID = 4836528561956491436L;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //经度
    public double x;
    //纬度
    public double y;

    public Point() {
    }
}
