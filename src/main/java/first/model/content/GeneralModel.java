package first.model.content;

import com.google.gson.annotations.SerializedName;

/**
 * @author xiejiedun on 2018/12/13
 */
public class GeneralModel {

    private String name;

    /**
     * 类型,default=string
     */
    @SerializedName("type")
    private String typc = "string";
    /**
     * 当typc=dateString,timestamp有效
     */
    private String format = "yyyy-MM-dd";

    public String getTypc() {
        return typc;
    }

    public void setTypc(String typc) {
        this.typc = typc;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
