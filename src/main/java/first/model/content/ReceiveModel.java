package first.model.content;

/**
 * @author xiejiedun on 2018/12/13
 */
public class ReceiveModel extends GeneralModel {
    /**
     * 只针对type=array,default=string
     */
    private String elementType = "string";
    /**
     * html中th里对应的列名
     */
    private String colName;

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }
}
