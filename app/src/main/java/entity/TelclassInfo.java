package entity;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class TelclassInfo {
    public String name;
    public int idx;
    public TelclassInfo(String name,int idx){
        super();
        this.name=name;
        this.idx=idx;
    }
    public TelclassInfo(){
        super();
    }

    public int getIdx() {
        return idx;
    }

    public String getName() {
        return name;
    }
}
