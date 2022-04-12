package com.poi.data.structure.and.algorithm.atguigu.Algorithm.spatialrelation.bean;


import lombok.Data;

import java.io.Serializable;

//边
@Data
public class Edge implements Serializable {

    private static final long serialVersionUID = -268068673991099285L;
    //开始点 结束点
    public Edge(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point start;

    public Point end;
}
