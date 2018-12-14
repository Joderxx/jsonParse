package first.model.content;

import first.model.html.HtmlOption;

import java.util.List;

/**
 * @author xiejiedun on 2018/12/13
 */
public class ParamModel extends GeneralModel {

    /**
     * 前端input的type
     */
    private String html="text";

    /**
     * 前端样式css,style
     */
    private List<HtmlOption> options;

    /**
     * 转换,只有html=select有用
     */
    private String parse;

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public List<HtmlOption> getOptions() {
        return options;
    }

    public void setOptions(List<HtmlOption> options) {
        this.options = options;
    }

    public String getParse() {
        return parse;
    }

    public void setParse(String parse) {
        this.parse = parse;
    }
}
