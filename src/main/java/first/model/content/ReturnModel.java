package first.model.content;

/**
 * @author xiejiedun on 2018/12/13
 */
public class ReturnModel extends GeneralModel {

    /**
     * 从receive中那个字段来的，默认等于name
     */
    private String source;

    /**
     * 怎么来的，function，if null ，就采用source字段的toString
     */
    private String parse;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getParse() {
        return parse;
    }

    public void setParse(String parse) {
        this.parse = parse;
    }
}
