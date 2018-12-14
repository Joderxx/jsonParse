package first.model.object;

import com.google.gson.annotations.SerializedName;

/**
 * @author xiejiedun on 2018/12/13
 */
public class FieldModel {

    /**
     * 参数名
     */
    private String name;
    /**
     * 类型
     */
    @SerializedName("type")
    private String typc = "string";
    /**
     * 是否为空
     */
    private Boolean isnull = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypc() {
        return typc;
    }

    public void setTypc(String typc) {
        this.typc = typc;
    }

    public Boolean getIsnull() {
        return isnull;
    }

    public void setIsnull(Boolean isnull) {
        this.isnull = isnull;
    }
}
