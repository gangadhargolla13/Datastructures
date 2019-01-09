package com.ganga.ericsson.ZookeeperTest;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;

public class SecurityZookeeperConnection {

	public void secureConnection(){
		//to connect secure zookeeper MD5 ACL and SASL  to pass security java values
		List<ACL> myAclList = new ArrayList<ACL>();
		myAclList.add(new ACL(ZooDefs.Perms.ALL, ZooDefs.Ids.AUTH_IDS));
		//client.create(withACL(myAclList)).forPath("/zk_test");
	}
}
