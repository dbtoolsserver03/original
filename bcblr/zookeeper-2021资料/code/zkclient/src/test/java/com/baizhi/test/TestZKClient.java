package com.baizhi.test;

import com.baizhi.entity.User;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.java2d.pipe.SpanIterator;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TestZKClient {

    private ZkClient zkClient;


    //1.在zk创建节点
    @Test
    public void testCreateNode() {
        //1.持久节点
        zkClient.create("/node1", "xiaochen", CreateMode.PERSISTENT);
        //2.持久顺序节点
        zkClient.create("/node1/names", "zhagnsan", CreateMode.PERSISTENT_SEQUENTIAL);
        //3.临时节点
        zkClient.create("/node1/lists", "xiaoxiao", CreateMode.EPHEMERAL_SEQUENTIAL);
        //4.临时顺序节点
        zkClient.create("/node1/lists11", "xiaoming", CreateMode.EPHEMERAL_SEQUENTIAL);

    }

    //2.删除节点
    @Test
    public void testDeleteNode() {
        //删除没有子节点的节点  返回值:是否删除成功
        //boolean delete = zkClient.delete("/node1");
        //System.out.println(delete);
        //递归删除节点信息 返回值:是否删除成功
        boolean recursive = zkClient.deleteRecursive("/node1");
        System.out.println(recursive);
    }

    //3.查询当前节点下所有子节点
    @Test
    public void testFindNodes() {
        //获取指定路径的节点信息  //返回值: 为当前节点的子节点信息
        List<String> children = zkClient.getChildren("/");
        for (String child : children) {
            System.out.println(child);
        }
    }

    //4.查看某个节点数据  注意:通过java客户端操作需要保证节点存储的数据和获取节点时数据序列化方式必须一致
    @Test
    public void testFindNodeData() {
        Object readData = zkClient.readData("/node1");
        System.out.println(readData);
    }

    //5.查看节点状态信息
    @Test
    public void testFindNodeDataAndStat() {
        Stat stat = new Stat();
        Object readData = zkClient.readData("/node1", stat);
        System.out.println(readData);
        System.out.println(stat.getCversion());
        System.out.println(stat.getCtime());
        System.out.println(stat.getCzxid());
    }

    //6.修改节点数据
    @Test
    public void testWriteData() {
        User user = new User();
        user.setId(1);
        user.setName("小陈");
        user.setAge(23);
        user.setBir(new Date());
        zkClient.writeData("/node1", "小张");
        Object o = zkClient.readData("/node1");
        System.out.println(o);
        //System.out.println(o.getId()+" "+o.getName()+"  "+o.getAge()+"  "+o.getBir());
    }


    //7.监听节点数据变化
    @Test
    public void testWatchDataChange() throws IOException {
        zkClient.subscribeDataChanges("/node1", new IZkDataListener() {
            //当前节点数据变化时触发对应这个方法
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("当前节点路径: " + dataPath);
                System.out.println("当前节点变化后数据: " + data);
            }

            //当前节点删除时触发这个方法
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("当前节点路径: " + dataPath);
            }
        });
        System.in.read();//阻塞当前监听
    }

    //8.监听节点目录变化
    @Test
    public void testOnNodesChange() throws IOException {
        zkClient.subscribeChildChanges("/node1", new IZkChildListener() {
            //当节点的发生变化时,会自动调用这个方法
            //参数1:父节点名称
            //参数2:父节点中的所有子节点名称
            public void handleChildChange(String nodeName, List<String> list) throws Exception {
                System.out.println("父节点名称: " + nodeName);
                System.out.println("发生变更后字节孩子节点名称:");
                for (String name : list) {
                    System.out.println(name);
                }
            }
        });
        //阻塞客户端
        System.in.read();
    }


    @Before//初始化客户端对象
    public void before() {

        //参数1:zk server 服务器ip地址:端口号
        //参数2:会话超时时间
        //参数3:连接超时时间
        //参数4:序列化方式  对象
        zkClient = new ZkClient("10.15.0.5:3001,10.15.0.5:4001,10.15.0.5:5001", 60000 * 30, 60000, new SerializableSerializer());
    }


    @After //释放资源
    public void after() throws InterruptedException {
        //Thread.sleep(50000);
        zkClient.close();
    }

}
