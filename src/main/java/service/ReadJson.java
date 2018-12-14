package service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import first.model.JsonTree;
import first.model.RetJsonTree;
import first.model.content.ParamModel;
import first.model.content.ReceiveModel;
import first.model.content.ReturnModel;
import first.model.function.FunctionModel;
import first.model.object.ObjectModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xiejiedun on 2018/12/13
 */
public class ReadJson {

    private Gson gson = new Gson();

    public RetJsonTree readJson(String json, String md5)throws Exception{
        /*if (md5!=null&&md5.equals(md5(json))){

        }*/
        RetJsonTree retJsonTree = new RetJsonTree();
        JsonTree jsonTree = new JsonTree();
        retJsonTree.setJsonTree(jsonTree);
        JsonObject jsonObject = gson.fromJson(json,JsonObject.class);
        String loss = validHasHead(jsonObject);
        if (loss!=null){
            retJsonTree.setError("缺少"+loss);
            return retJsonTree;
        }
        String shellName = jsonObject.get("shellName").getAsString();
        String logName = jsonObject.get("logName").getAsString();
        jsonTree.setLogName(logName);
        jsonTree.setShellName(shellName);
        if (jsonObject.has("head")){
            List<Integer> list = gson.fromJson(jsonObject.get("head"), new TypeToken<ArrayList<Integer>>(){}.getType());
            jsonTree.setHead(list);
        }
        List<ParamModel> list = new ArrayList<>();
        JsonArray param = jsonObject.getAsJsonArray("param");
        Iterator<JsonElement> iterator = param.iterator();
        while (iterator.hasNext()){
            list.add(gson.fromJson(iterator.next(), ParamModel.class));
        }
        jsonTree.setParams(list);
        List<ReceiveModel> list1 = new ArrayList<>();
        JsonArray receive = jsonObject.getAsJsonArray("receive");
        iterator = receive.iterator();
        while (iterator.hasNext()){
            list1.add(gson.fromJson(iterator.next(), ReceiveModel.class));
        }
        jsonTree.setReceives(list1);
        List<ReturnModel> list2 = new ArrayList<>();
        JsonArray rets = jsonObject.getAsJsonArray("return");
        iterator = rets.iterator();
        while (iterator.hasNext()){
            list2.add(gson.fromJson(iterator.next(), ReturnModel.class));
        }
        jsonTree.setReturns(list2);
        JsonArray objects = jsonObject.getAsJsonArray("object");
        List<ObjectModel> list3 = new ArrayList<>();
        iterator = objects.iterator();
        while (iterator.hasNext()){
            list3.add(gson.fromJson(iterator.next(), ObjectModel.class));
        }
        jsonTree.setObjects(list3);
        JsonArray functions = jsonObject.getAsJsonArray("function");
        List<FunctionModel> list4 = new ArrayList<>();
        iterator = functions.iterator();
        while (iterator.hasNext()){
            list4.add(gson.fromJson(iterator.next(), FunctionModel.class));
        }
        jsonTree.setFunction(list4);
        return retJsonTree;
    }

    private String validHasHead(JsonObject jsonObject){
        String [] heads = new String[]{"shellName","param","receive","return"};
        for (String head: heads){
            if (!jsonObject.has(head)){
                return head;
            }
        }
        return null;
    }

    private String md5(String text){
        return "";
    }
}
