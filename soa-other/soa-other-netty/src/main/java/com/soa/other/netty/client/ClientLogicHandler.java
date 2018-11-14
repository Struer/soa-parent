package com.soa.other.netty.client;
import org.jboss.netty.channel.Channel;  
import org.jboss.netty.channel.ChannelFuture;  
import org.jboss.netty.channel.ChannelFutureListener;  
import org.jboss.netty.channel.ChannelHandlerContext;  
import org.jboss.netty.channel.ChannelStateEvent;  
import org.jboss.netty.channel.ExceptionEvent;  
import org.jboss.netty.channel.MessageEvent;  
import org.jboss.netty.channel.SimpleChannelHandler;  
import org.jboss.netty.channel.WriteCompletionEvent;  
  
public class ClientLogicHandler extends SimpleChannelHandler {  
      
    @Override  
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)  
            throws Exception {  
        System.out.println("######channelConnected");  
          
        Channel ch = e.getChannel();  
        String msg = "Hi, Server.by agan";  
        ch.write(msg);  
    }  
  
    @Override  
    public void writeComplete(ChannelHandlerContext ctx, WriteCompletionEvent e)  
            throws Exception {  
        System.out.println("######writeComplete");  
    }  
  
    @Override  
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {  
        System.out.println("######messageReceived");  
          
        String msg = (String)e.getMessage();  
        System.out.println("The message gotten from server is : " + msg);  
          
        ChannelFuture channelFuture = e.getChannel().close();  
        channelFuture.addListener(ChannelFutureListener.CLOSE);  
    }  
  
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {  
        e.getCause().printStackTrace();  
        Channel ch = e.getChannel();  
        ch.close();  
    }  
}  