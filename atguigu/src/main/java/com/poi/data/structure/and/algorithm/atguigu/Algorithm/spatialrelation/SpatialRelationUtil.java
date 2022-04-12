package com.poi.data.structure.and.algorithm.atguigu.Algorithm.spatialrelation;




import com.poi.data.structure.and.algorithm.atguigu.Algorithm.spatialrelation.bean.Edge;
import com.poi.data.structure.and.algorithm.atguigu.Algorithm.spatialrelation.bean.Point;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 空间关系 工具类
 */
public class SpatialRelationUtil {

    /**
     * 返回一个点是否在一个多边形区域内（推荐）
     *
     * @param mPoints 多边形坐标点列表
     * @param point   待判断点
     * @return true 多边形包含这个点,false 多边形未包含这个点。
     */
    public static boolean isPolygonContainsPoint1(List<Point> mPoints, Point point) {

        boolean result = false;
        for (int i = 0; i < mPoints.size(); i++) {
            Point p1 = mPoints.get(i);
            Point p2 = mPoints.get((i + 1) % mPoints.size());
            Edge edge = new Edge(p1, p2);

            //思路:作p点平行于y轴的向下的射线
            //((edge.start.x < point.x && edge.end.x >= point.x) || (edge.end.x < point.x && edge.start.x >= point.x)) 只有x范围在两端之内 才有可能交点  注意 这是半开1区间
            //edge.start.y <= point.y || edge.end.y <= point.y   必须要有一个 在下 才可能存在射线向下的交点
            if (((edge.start.x < point.x && edge.end.x >= point.x) || (edge.end.x < point.x && edge.start.x >= point.x))
                    && (edge.start.y <= point.y || edge.end.y <= point.y)) {

                //运算规则：0^0=0；  0^1=1；  1^0=1；   1^1=0
                //即：参加运算的两个对象，如果两个相应位为 “异”（值不同），则该位结果为 1，否则为 0.
                //线段上与射线,即求射线与线段的交点
                double intersectionY = edge.end.y + (point.x - edge.end.x) / (edge.start.x - edge.end.x) * (edge.start.y - edge.end.y);

                //< point.y  判断交点位于下方？
                result ^= intersectionY < point.y;
                /*result ^= (edge.end.y +
                        (point.x - edge.end.x)
                                / (edge.start.x - edge.end.x)
                                * (edge.start.y - edge.end.y) < point.y);*/

            }
        }
        return result;
    }


    public static void main(String[] args) {
        //Point p = new Point(1.0, 2.4);
        //Point p = new Point(4.0, 1.5);
        List<Point> list = new ArrayList<Point>();
        /*list.add(new Point(1.0, 1.0));
        list.add(new Point(3.0, 1.0));
        list.add(new Point(3.0, 3.0));
        list.add(new Point(1.0, 3.0));
        Point p = new Point(2,6);*/

        //Point p = new Point(2,6);
        Point p = new Point(2,2);
        list.add(new Point(1.0, 2.0));
        list.add(new Point(2.0, 1.0));
        list.add(new Point(4.0, 3.0));
        list.add(new Point(3.0, 4.0));



        String polygon = "0,0;4,0;4,2;6,2;6,6;4,6;4,8;3,8;0,2";
        /*list.add(new Point(0.0, 0.0));
        list.add(new Point(4.0,0.0));
        list.add(new Point(4,2.0));
        list.add(new Point(6,2));
        list.add(new Point(6,6));
        list.add(new Point(4,6));
        list.add(new Point(4,8));
        list.add(new Point(3,8));
        list.add(new Point(0,2));*/
        //list.add(new Point(6,6));
        // list为多边形边界,p为一个待测点

        boolean flag = isPolygonContainsPoint1(list, p);
        System.out.println(flag);

    }

}
