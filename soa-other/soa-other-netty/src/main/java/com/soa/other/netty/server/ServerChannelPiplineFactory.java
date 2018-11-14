package com.soa.other.netty.server;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

public class ServerChannelPiplineFactory implements ChannelPipelineFactory {

	@Override
	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline channelPipeline = Channels.pipeline();
		channelPipeline.addLast("decoder", new StringDecoder());
		channelPipeline.addLast("encoder", new StringEncoder());
		channelPipeline.addLast("handler", new ServerLogicHandler());
		return channelPipeline;
	}

}