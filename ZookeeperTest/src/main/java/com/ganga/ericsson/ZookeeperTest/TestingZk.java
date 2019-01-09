package com.ganga.ericsson.ZookeeperTest;

import java.io.FileReader;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TestingZk {

	private static ZooKeeper zoo = null;
	public void createZnode(String name) throws Exception
	{
		System.out.println("Creation of znode");
		if(zoo!=null)
		{
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("/opt/eps/etc/storagePlugin.json"));
			JSONObject o = (JSONObject)obj;
			
			zoo.create(name, o.toJSONString().getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			System.out.println("znode creation is completed");
		}
	}
	
	public void checkZnodeExist(String name)throws Exception
	{
		System.out.println("checking of znode");
		if(zoo!=null)
		{
			Stat s = zoo.exists(name, true);
			if(s!=null)
			{
				System.out.println("Znode is exist");
			}
			
			Stat s1 = zoo.exists(name+"golla", true);
			if(s1!=null)
			{
				System.out.println("Znode is exist");
			}
			else
			{
				System.out.println("I am not exist");
			}
		}
	}
	
	public void getZondeData(String name)throws Exception
	{
		System.out.println("getting of znode");
		if(zoo!=null)
		{
			Stat s = new Stat();
			byte[] b = zoo.getData(name, true, s);
			System.out.println(b.toString());
		}
	}
	
	public void updateZnodeData(String name)throws Exception
	{
		System.out.println("update of znode");
		if(zoo!=null)
		{
			zoo.setData(name, "Mallikarjuna".getBytes(), 1);
		}
	}
	
	public void creation(String node)
	{
		try
		{
			zoo = new ZooKeeper(node,2000,new Watcher(){
				public void process(WatchedEvent we) {
					if (we.getState() == KeeperState.SyncConnected) {
					}
				}
			});
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		if(args.length == 2)
		{
			String node = args[0];
			String name = args[1];
			try
			{
				TestingZk zk = new TestingZk();
				 zk.creation(node);
				 zk.createZnode(name);
				// zk.checkZnodeExist(name);
				 //zk.getZondeData(name);
				 //zk.updateZnodeData(name);
				// zk.getZondeData(name);
				 
				 zoo.close();
				 
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception is occured so i am unable to create zookeeper");
				System.exit(1);
			}
			
			
		}
		else
		{
			System.out.println("Please pass input parameters properly");
			System.exit(1);
		}
	}
}
