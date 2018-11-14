package com.soa.other.zk;

import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.Watcher.Event.KeeperState;

public class CreateSession {
	
	public static ZkClient connectZK(){
		//zk集群的地址  
        String ZKServers = "192.168.48.117:2181";  
      
        ZkClient zkClient = new ZkClient(ZKServers,10000,10000,new SerializableSerializer());  
        zkClient.subscribeStateChanges(new IZkStateListener() {
            @Override
            public void handleNewSession() throws Exception {
                System.out.println("handleNewSession()");
            }

            @Override
            public void handleStateChanged(KeeperState stat) throws Exception {
                System.out.println( "handleStateChanged,stat:" + stat);
            }
        });
        System.out.println("conneted ok!");  
        return zkClient;
	}
}
