package com.suns.netty.handler;

import com.suns.netty.domain.Session;
import com.suns.netty.message.LoginRequestMessage;
import com.suns.netty.message.LoginResponseMessage;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@ChannelHandler.Sharable
public class LoginRequestMessageHandler extends SimpleChannelInboundHandler<LoginRequestMessage> {

    private static Map<String, String> userDB = new HashMap<>();

    static {
        userDB.put("suns1", "123456");
        userDB.put("suns2", "123456");
        userDB.put("suns3", "123456");
        userDB.put("suns4", "123456");
        userDB.put("suns5", "123456");
    }


    //服务器端 专门用于进行登录验证的方法
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestMessage msg) throws Exception {
        log.debug("login method invoke ....");
        String username = msg.getUsername();
        String password = msg.getPassword();

        //DB查询 进行用户名 密码验证
        boolean isLogin = login(username, password);
        //如果验证成功
        //建立于服务端的Session

        //如果没有验证成功 登录失败
        if (isLogin) {
            log.debug("login is ok....");
            Session session = new Session();
            session.bind(ctx.channel(), username);
            ctx.writeAndFlush(new LoginResponseMessage("200", "Login IS OK"));
        } else {
            log.debug("login is error");
            ctx.writeAndFlush(new LoginResponseMessage("500", "Check you Name or Password"));
        }
    }

    private boolean login(String username, String password) {
        String storePassword = userDB.get(username);
        if (storePassword == null || !password.equals(storePassword)) {
            return false;
        }
        return true;
    }
}
