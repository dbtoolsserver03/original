package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.entity.Card;
import com.baizhi.entity.Emp;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestPOI{



    //查询所有记录
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setName("小陈_"+i);
            user.setAge(10+i);
            user.setBir(new Date());

            //身份信息
            Card card = new Card();
            card.setNo("134234342343233221");
            card.setAddress("北京市朝阳区国贸大厦3层507A");
            user.setCard(card);

            //订单信息
            List<Order> orders = new ArrayList<>();
            orders.add(new Order("12","超短裙"));
            orders.add(new Order("13","超短裙连衣裙"));
            orders.add(new Order("14","连衣裙"));
            user.setOrders(orders);

            //绝对路径
            user.setPhoto("/Users/chenyannan/Desktop/1.jpg");

            if(i%2==0){
                user.setStatus("1");
                user.setHabbys(Arrays.asList("打篮球","看书","看片"));
            }else{
                user.setStatus("0");
                user.setHabbys(Arrays.asList("喝酒","抽样","烫头"));
            }
            users.add(user);
        }
        return users;
    }


    //导出Excel   普通数量数据导出
    @Test
    public void testExport() throws IOException {
        //获取数据
        List<User> users = getUsers();
        //导出excel
        //参数1:exportParams 导出配置对象  参数2:导出的类型  参数3:导出数据集合
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息列表", "用户信息"), User.class, users);
        //将excel写入指定位置
        FileOutputStream outputStream = new FileOutputStream("/Users/chenyannan/Desktop/aa.xls");
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }


    @Test
    public void testBigExport() throws IOException {
        //获取数据
        List<User> users = getUsers();
        //导出excel
        //参数1:exportParams 导出配置对象  参数2:导出的类型  参数3:导出数据集合
        Workbook workbook = ExcelExportUtil.exportBigExcel(new ExportParams("用户信息列表", "用户信息"), User.class, users);
        //将excel写入指定位置
        FileOutputStream outputStream = new FileOutputStream("/Users/chenyannan/Desktop/big.xls");
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }
    
    
    @Test
    public void testImport() throws Exception {
        //参数1:导入excel文件流  参数2:导入类型 参数3:导入的配置对象
        ImportParams params = new ImportParams();
        params.setTitleRows(1);//标题列占几行
        params.setHeadRows(1);//header列占几行
        //params.setStartSheetIndex(2);
        //params.setSheetNum(3);
        params.setNeedSave(true);//是否保存本次上传的excel
        params.setSaveUrl("/Users/chenyannan/IdeaProjects/180codes/easypoi_helloworld/src/main/imgs");
        params.setImportFields(new String[]{"编号","状态"});
        List<Emp> emps = ExcelImportUtil.importExcel(new FileInputStream("/Users/chenyannan/Desktop/big.xls"), Emp.class, params);
        emps.forEach(System.out::println);
    }

}
