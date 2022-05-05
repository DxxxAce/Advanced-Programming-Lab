package com.lab8;

public abstract class Distance {

    public static double toRadians(float degree) {

        return Math.PI / 180 * degree;
    }

    public static double getDistance(float x1, float y1, float x2, float y2) {

        double lat1 = toRadians(x1);
        double long1 = toRadians(y1);
        double lat2 = toRadians(x2);
        double long2 = toRadians(y2);

        double dlong = long2 - long1;
        double dlat = lat2 - lat1;

        double ans = Math.pow(Math.sin(dlat / 2), 2) +
            Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlong / 2), 2);

        ans = 2 * Math.asin(Math.sqrt(ans));

        double R = 6371;

        ans = ans * R;

        return ans;
    }
}
