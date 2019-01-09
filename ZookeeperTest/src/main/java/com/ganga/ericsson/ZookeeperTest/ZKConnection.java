package com.ganga.ericsson.ZookeeperTest;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZKConnection {

	private ZooKeeper zoo = null;
	final CountDownLatch countLatch = new CountDownLatch(1);
	
	public ZooKeeper connect(String node) throws IOException,InterruptedException{
		zoo = new ZooKeeper(node,2000,new Watcher(){
			public void process(WatchedEvent we) {
				if (we.getState() == KeeperState.SyncConnected) {
					countLatch.countDown();
				}
			}
		});
		countLatch.await();
		return zoo;
	}
	
	public void close() throws InterruptedException{
		zoo.close();
	}
	
	public static void main(String[] args) {
		try{
			String node = args[0];
			ZKConnection zk = new ZKConnection();
			if ( args.length == 1)
			{
				ZooKeeper zoo = zk.connect(node);
				if(zoo != null){
					//System.out.println("Zookeeper connection is created successfully!");
					//zoo.create("/ganga1", "test".getBytes(), CreateMode.PERSISTENT);
					System.out.println("Zookeeper connection is created successfully!");
				}
			   //Stat sta = zoo.exists("/ganga", true);
			  // System.out.println(sta.getAversion());
			}
			else
			{
				System.out.println("Please pass input values.");
				System.exit(1);
			}
		}catch(Exception e){
			System.out.println("Error is occured while trying connect zookeeper");
			e.printStackTrace();
		}
	}
}
