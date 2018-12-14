package first.valid;

import first.model.JsonTree;
import first.model.content.ParamModel;
import first.model.content.ReceiveModel;
import first.model.content.ReturnModel;
import first.model.function.FunctionModel;
import first.model.object.ObjectModel;
import util.ThreadPoolUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;

/**
 * @author xiejiedun on 2018/12/13
 */
public class Validation {

    public ErrorInfo validate(JsonTree jsonTree){
        ErrorInfo errorInfo = new ErrorInfo();
        final ConcurrentLinkedQueue<String> list = new ConcurrentLinkedQueue<>();

        List<ParamModel> params = jsonTree.getParams();
        List<ReceiveModel> receives = jsonTree.getReceives();
        List<ReturnModel> returns = jsonTree.getReturns();
        List<ObjectModel> objects = jsonTree.getObjects();
        List<FunctionModel> functions = jsonTree.getFunction();
        List<Future> futures = new ArrayList<>();
        if (params==null||params.size()==0){
            list.add("参数为空");
        }else {
            for (final ParamModel paramModel:params){
                futures.add(ThreadPoolUtil.submit(new Runnable() {
                    @Override
                    public void run() {
                        validParam(paramModel,list);
                    }
                }));
            }
        }if (receives==null||receives.size()==0){
            list.add("接收参数为空");
        }else {
            for (final ReceiveModel receiveModel:receives){
                futures.add(ThreadPoolUtil.submit(new Runnable() {
                    @Override
                    public void run() {
                        validReceive(receiveModel,list);
                    }
                }));
            }
        }if (returns==null||returns.size()==0){
            list.add("返回参数为空");
        }else {
            for (final ReturnModel returnModel:returns){
                futures.add(ThreadPoolUtil.submit(new Runnable() {
                    @Override
                    public void run() {
                        validReturn(returnModel,list);
                    }
                }));
            }
        }
        if (objects!=null&&objects.size()>0){
            for (final ObjectModel objectModel:objects){
                futures.add(ThreadPoolUtil.submit(new Runnable() {
                    @Override
                    public void run() {
                        validObject(objectModel,list);
                    }
                }));
            }
        }

        if (functions!=null&&functions.size()>0){
            for (final FunctionModel functionModel:functions){
                futures.add(ThreadPoolUtil.submit(new Runnable() {
                    @Override
                    public void run() {
                        validFunction(functionModel,list);
                    }
                }));
            }
        }
        if (list.size()>0){
            List<String> ls = new ArrayList<>();
            for (String s:list){
                ls.add(s);
            }
            errorInfo.setErrors(ls);
            return errorInfo;
        }else {
            return null;
        }
    }

    private void validParam(ParamModel paramModel,ConcurrentLinkedQueue<String> list){
        if (paramModel.getName()==null||"".equals(paramModel.getName().trim())){
            list.add("param有参数name为空");
        }
        if (!("text".equalsIgnoreCase(paramModel.getHtml())||"select".equalsIgnoreCase(paramModel.getHtml()))){
            list.add("param中name="+paramModel.getName()+"的html值有误");
        }
        if (paramModel.getParse()!=null&&!charValid(paramModel.getParse())){
            list.add("param中name="+paramModel.getName()+"的parse格式有误");
        }
    }

    private void validReceive(ReceiveModel receiveModel,ConcurrentLinkedQueue<String> list){
        if (receiveModel.getName()==null||"".equals(receiveModel.getName().trim())){
            list.add("receive有参数name为空");
        }
    }

    private void validReturn(ReturnModel returnModel,ConcurrentLinkedQueue<String> list){
        if (returnModel.getName()==null||"".equals(returnModel.getName().trim())){
            list.add("return有参数name为空");
        }if (returnModel.getParse()!=null&&!charValid(returnModel.getParse())){
            list.add("return中name="+returnModel.getName()+"的parse格式有误");
        }
    }

    private void validObject(ObjectModel objectModel,ConcurrentLinkedQueue<String> list){
        if (objectModel.getName()==null||"".equals(objectModel.getName().trim())){
            list.add("object有参数name为空");
        }if (objectModel.getToString()!=null&&!charValid(objectModel.getToString())){
            list.add("object中name="+objectModel.getName()+"的toString格式有误");
        }
    }

    private void validFunction(FunctionModel functionModel,ConcurrentLinkedQueue<String> list){
        if (functionModel.getName()==null||"".equals(functionModel.getName().trim())){
            list.add("function有参数name为空");
        }if (functionModel.getRet()!=null&&!charValid(functionModel.getRet())){
            list.add("function中name="+functionModel.getName()+"的return格式有误");
        }
    }

    /**
     * 验证括号匹配
     * @param s
     * @return
     */
    private boolean charValid(String s){
        // {}
        Stack<Character> bracesStack = new Stack<>();
        //()
        Stack<Character> parenthesesStack = new Stack<>();
        //@
        Stack<Character> atStack = new Stack<>();
        char[] cs = s.toCharArray();
        for (char c:cs){
            if (c!='@'&&c!='{'&&c!='}'&&c!='('&&c!=')'){
                continue;
            }
            if (c=='{'||c=='}'){
                if (bracesStack.isEmpty()||c=='{'){
                    bracesStack.push(c);
                }else if (bracesStack.peek().equals('{')){
                    bracesStack.pop();
                }else {
                    return false;
                }
            }else if (c=='('||c==')'){
                if (parenthesesStack.isEmpty()||c=='('){
                    parenthesesStack.push(c);
                }else if (parenthesesStack.peek().equals('(')){
                    parenthesesStack.pop();
                }else {
                    return false;
                }
            }else {
                if (atStack.isEmpty()||!atStack.peek().equals(c)){
                    parenthesesStack.push(c);
                }else{
                    parenthesesStack.pop();
                }
            }
        }
        return !bracesStack.isEmpty()||!parenthesesStack.isEmpty()||!atStack.isEmpty();
    }
}
