package com.winterchen.model;

public class datas implements Comparable<datas> {
    public data d;
    private String type;

    public data getD() {
        return d;
    }

    public void setD(data d) {
        this.d = d;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int compareTo(datas o) {
        long time1 = this.d.getTimestamp().getTime();
        long time2 = o.d.getTimestamp().getTime();
        if(time1 > time2) {
            return 1;
        } else if(time1 < time2) {
            return -1;
        } else {
            return 0;
        }
    }
}
