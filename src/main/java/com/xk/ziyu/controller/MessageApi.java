package com.xk.ziyu.controller;

/*import com.pjb.springbootjjwt.entity.Favorite;
import com.pjb.springbootjjwt.entity.PrivateLetter;
import com.pjb.springbootjjwt.entity.User;
import com.pjb.springbootjjwt.entity.offlineMessage;
import com.pjb.springbootjjwt.service.PrivateLetterService;
import com.pjb.springbootjjwt.service.UserService;
import com.pjb.springbootjjwt.service.WebSocket;
import com.pjb.springbootjjwt.util.RetResponse;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

@RestController
@RequestMapping("api/message")
public class MessageApi {
    @Autowired
    private WebSocket webSocket;
/*    @Autowired
    PrivateLetterService PLService;
    @Autowired
    UserService userService;*/

    @RequestMapping("/sendAllWebSocket")
    public String test() {
        webSocket.sendAllMessage("清晨起来打开窗，心情美美哒~");
        return "websocket群体发送！";
    }

   /* @RequestMapping("/sendOneWebSocket/{userId}")
    public String sendOneWebSocket(@PathVariable int userId) {
        String strUserId = userId + "";
//        webSocket.sendOneMessage(strUserId, "只要你乖给你买条gai！");
        return "websocket单人发送";
    }*/
    // 离线消息存储在数据库里，原理关注消息相同
    // 在线时即使聊天--重点关注导航栏上消息total的显示问题
    // 关注用户 cancleFollow--关注成功推送该消息到被关注的用户
    // 只存离线消息--聊天消息是string 只能文字聊天【所有消息都存进去了】
   /* @PostMapping(value = "/read_send/private_letter")
    public Object getPrivateletter(@RequestBody Map<String, Object> object) {
        int status = 0;
        int readStatus = 0;// 消息存入数据库的状态 1未读 2已读
        Map<String, Object> data = new HashMap();
        JSONObject jsonObject = new JSONObject();
        JSONObject message = new JSONObject();
        String recievedUserId = object.get("recievedUserId").toString();
        String sendToUserId = object.get("sendToUserId").toString();
        String content = object.get("content").toString();

        System.out.println("sendToUserId:::"+sendToUserId+"recievedUserId:::"+recievedUserId);
        data.put("followedId",object.get("followedId"));
        data.put("followId",object.get("followId"));

        //返回前端的message里可以放入加载对话框需要的用户信息
        try {
            message.put("privateLetter", 1);
            message.put("sendUserId", object.get("sendToUserId"));
            message.put("content", content);
            status = webSocket.sendOneMessage(recievedUserId, message);
            System.out.println("是否推送成功：1=成功"+status);
        }catch (Exception e) {
            jsonObject.put("code", 500);
            System.out.println("private_letter--异常");
            System.out.println(e);
        } finally {
            System.out.println("private_letter--finally");
        }

        // 推送在线失败则将此消息以离线消息存入；推送成功标记为已读消息存入
        Map<String, Object> addMessage = new HashMap();
        addMessage.put("letterContent",content);
        addMessage.put("sendTime",object.get("sendTime").toString());
        addMessage.put("sendToUserId",object.get("sendToUserId"));
        addMessage.put("recievedUserId",object.get("recievedUserId"));
        if (status != 1) {
            readStatus = 1;
            addMessage.put("status",readStatus);
            try {
                PLService.addMessage(addMessage);
            } catch (Exception e) {
                System.out.println("addOffMessage--异常");
                System.out.println(e);
            }
        } else {
            // 已读
            readStatus = 2;
            addMessage.put("status",readStatus);
            try {
                PLService.addMessage(addMessage);
            } catch (Exception e) {
                System.out.println("addOffMessage--异常");
                System.out.println(e);
            }
        }
        return RetResponse.makeOKRsp(jsonObject);
    }
    //  获取所有聊天记录
    @PostMapping(value = "/getAllList/private_letter")
    public Object getAllPLMessage(@RequestBody Map<String, Object> object) {
        List<PrivateLetter> list = new ArrayList<PrivateLetter>();
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> getMessage = new HashMap();

        getMessage.put("recievedUserId",object.get("recievedUserId"));
        getMessage.put("sendToUserId",object.get("sendToUserId"));

        try {
            list = PLService.getAllPLMessage(getMessage);
            jsonObject.put("res",list);
        } catch (Exception e) {
            System.out.println("getAllPLMessage--异常");
            System.out.println(e);
        }
        return RetResponse.makeOKRsp(jsonObject);
    }
    //  获取即将要进行聊天用户的所有未读私信 指定用户之间
    @PostMapping(value = "/waitReadOne/private_letter")
    public Object getPLMessageNotRead(@RequestBody Map<String, Object> object) {
        List<PrivateLetter> list = new ArrayList<PrivateLetter>();
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> getMessage = new HashMap();

        getMessage.put("recievedUserId",object.get("recievedUserId"));
        getMessage.put("sendToUserId",object.get("sendToUserId"));
        getMessage.put("status",1);

        try {
            list = PLService.getOneNotReadMessage(getMessage);
            jsonObject.put("res",list);
        } catch (Exception e) {
            System.out.println("getOneNotReadMessage--异常");
            System.out.println(e);
        }
        return RetResponse.makeOKRsp(jsonObject);
    }
    //getPLNotReadMessage获取未读消息
    @PostMapping(value = "/waitRead/private_letter")
    public Object getPLNotReadMessage(@RequestBody Map<String, Object> object) {
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> getMessage = new HashMap();
        List<PrivateLetter> list = new ArrayList<PrivateLetter>();

        getMessage.put("status",object.get("status"));
        getMessage.put("recievedUserId",object.get("recievedUserId"));
        try {
            list = PLService.getPLNotReadMessage(getMessage);
        } catch (Exception e) {
            System.out.println("getPLNotReadMessage--异常");
            System.out.println(e);
        }
        //遍历消息list 给每一则消息提添加上消息来源的用户信息
        ListIterator<PrivateLetter> li = list.listIterator();
        while(li.hasNext()){
            PrivateLetter item  = li.next();
            User user = new User();
            try {
                user = userService.findUserById(item.getSendToUserId());
                item.setUser(user);
                li.set(item);
            } catch(Exception e) {
                System.out.println("封装私信异常");
                System.out.println(e);
            } finally {
                System.out.println("封装私信消息完毕");
            }
        }
        jsonObject.put("res", list);
        return RetResponse.makeOKRsp(jsonObject);
    }
    //  标记为已读 不删除
    @PostMapping(value = "/haveRead/private_letter")
    public Object deleteHaveReadMessage(@RequestBody Map<String, Object> object) {
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> haveRead = new HashMap();
        haveRead.put("recievedUserId",object.get("recievedUserId"));
        haveRead.put("sendToUserId",object.get("sendToUserId"));
        haveRead.put("status",2);
        int res = 0;
        try {
            res = PLService.messageHaveRead(haveRead);
            jsonObject.put("res",res);
        } catch(Exception e) {
            System.out.println("标记为已读异常");
            System.out.println(e);
        } finally {
            System.out.println("标记为已读完毕");
        }
        return RetResponse.makeOKRsp(jsonObject);
    }
    //  获取所有消息列表
    @RequestMapping(path = "/getMessageList/private_letter/{recievedUserId}", method = RequestMethod.GET)
    public Object getOfflineMessage(@PathVariable int recievedUserId){
        List<PrivateLetter> offMe = new ArrayList<PrivateLetter>();
        List<PrivateLetter> two = new ArrayList<PrivateLetter>();
        JSONObject jsonObject = new JSONObject();
        try {
            offMe = PLService.getMeByUserId(recievedUserId);
            two = PLService.getMeByUserIdTwo(recievedUserId);
        } catch(Exception e) {
            System.out.println("获取所有消息列表--异常");
        } finally {
            System.out.println("获取所有消息列表--finally");
        }

        //遍历消息list 给每一则消息提添加上消息来源的用户信息--当前用户是消息接收方，用户信息是发送消息的用户信息
        ListIterator<PrivateLetter> li = offMe.listIterator();
        while(li.hasNext()){
            PrivateLetter item  = li.next();
            User user = new User();
            try {
                user = userService.findUserById(item.getSendToUserId());
                item.setUser(user);
                li.set(item);
            } catch(Exception e) {
                System.out.println("封装所有消息列表异常");
                System.out.println(e);
            } finally {
                System.out.println("封装所有消息列表消息完毕");
            }
        }
        //遍历消息list 给每一则消息提添加上消息来源的用户信息--当前用户是消息发送收方，用户信息是接收消息的用户信息
        //        ListIterator<PrivateLetter> li = offMe.listIterator();
        ListIterator<PrivateLetter> litwo = two.listIterator();
        while(litwo.hasNext()){
            PrivateLetter item  = litwo.next();
            User user = new User();
            try {
                user = userService.findUserById(item.getRecievedUserId());
                item.setUser(user);
                litwo.set(item);
            } catch(Exception e) {
                System.out.println("封装所有消息列表异常2");
                System.out.println(e);
            } finally {
                System.out.println("封装所有消息列表消息完毕2");
            }
        }
        offMe.addAll(two);
        // 按照ID排序--不然聊天记录是乱的
        Collections.sort(offMe, new Comparator<PrivateLetter>() {
            public int compare(PrivateLetter u1, PrivateLetter u2) {
                return new Double(u1.getId()).compareTo(new Double(u2.getId())); //升序
                // return new Double(u2.getSalary()).compareTo(new Double(u2.getSalary())); //降序
            }
        });

        jsonObject.put("res", offMe);
        return RetResponse.makeOKRsp(jsonObject);
    }*/
    // 用户手动删除与另一个用户的消息框-删除与该用户所有的消息记录
}


