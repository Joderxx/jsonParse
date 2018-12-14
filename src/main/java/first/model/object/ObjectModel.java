package first.model.object;

import java.util.List;

/**
 * @author xiejiedun on 2018/12/13
 */
public class ObjectModel {

    /**
     * 对象名
     */
    private String name;
    /**
     * 参数值
     */
    private List<FieldModel> fields;
    /**
     * toString方法
     */
    private String toString;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FieldModel> getFields() {
        return fields;
    }

    public void setFields(List<FieldModel> fields) {
        this.fields = fields;
    }

    public String getToString() {
        return toString;
    }

    public void setToString(String toString) {
        this.toString = toString;
    }
}
