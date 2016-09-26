package entity;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class TelNumberInfo {
    public String name;
    public String number;
    public TelNumberInfo(String name,String number){
        super();
        this.name=name;
        this.number=number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
