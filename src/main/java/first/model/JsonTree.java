package first.model;

import first.model.content.GeneralModel;
import first.model.content.ParamModel;
import first.model.content.ReceiveModel;
import first.model.content.ReturnModel;
import first.model.function.FunctionModel;
import first.model.object.ObjectModel;

import java.util.List;

/**
 * @author xiejiedun on 2018/12/13
 */
public class JsonTree {

    /**
     * 日志名称
     */
    private String logName;
    /**
     * 日志查询时对应的shell_name
     */
    private String shellName;
    /**
     * 对返回每一列的宽度进行设置,可选
     */
    private List<Integer> head;
    /**
     * 参数
     */
    private List<ParamModel> params;
    /**
     * 需要接收json对应的值
     */
    private List<ReceiveModel> receives;
    /**
     * 需要返回的值
     */
    private List<ReturnModel> returns;

    /**
     * 自定义对象,可选
     */
    private List<ObjectModel> objects;
    /**
     * 自定义函数
     */
    private List<FunctionModel> function;

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getShellName() {
        return shellName;
    }

    public void setShellName(String shellName) {
        this.shellName = shellName;
    }

    public List<Integer> getHead() {
        return head;
    }

    public void setHead(List<Integer> head) {
        this.head = head;
    }

    public List<ParamModel> getParams() {
        return params;
    }

    public void setParams(List<ParamModel> params) {
        this.params = params;
    }

    public List<ReceiveModel> getReceives() {
        return receives;
    }

    public void setReceives(List<ReceiveModel> receives) {
        this.receives = receives;
    }

    public List<ReturnModel> getReturns() {
        return returns;
    }

    public void setReturns(List<ReturnModel> returns) {
        this.returns = returns;
    }

    public List<ObjectModel> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectModel> objects) {
        this.objects = objects;
    }

    public List<FunctionModel> getFunction() {
        return function;
    }

    public void setFunction(List<FunctionModel> function) {
        this.function = function;
    }
}
