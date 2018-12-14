package first.model.function;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author xiejiedun on 2018/12/13
 */
public class FunctionModel {

    /**
     * 方法名
     */
    private String name;
    /**
     * 参数名
     */
    private List<String> param;
    /**
     * 方法类型 find,other(find:根据文件找; other:普通方法)
     */
    private String methodType;
    /**
     * 映射文件
     */
    private String mapFile;
    /**
     * 参数名对应表的列名
     */
    private List<String> mapName;
    /**
     * 返回字符串
     */
    @SerializedName("return")
    private String ret;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParam() {
        return param;
    }

    public void setParam(List<String> param) {
        this.param = param;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public String getMapFile() {
        return mapFile;
    }

    public void setMapFile(String mapFile) {
        this.mapFile = mapFile;
    }

    public List<String> getMapName() {
        return mapName;
    }

    public void setMapName(List<String> mapName) {
        this.mapName = mapName;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }
}
