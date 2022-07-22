package com.clearvision.shardingtest;

import com.clearvision.common.enums.ErrorCodeEnum;
import com.clearvision.common.exception.CustomBusinessException;
import com.clearvision.shardingspheresample.mapper.OrderMapper;
import com.clearvision.shardingspheresample.pojo.entity.Order;
import com.clearvision.shardingspheresample.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;
import java.util.Date;

@org.springframework.boot.test.context.SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class SpringBootTest {


    @Resource
    private IOrderService orderService;


    @Resource
    private OrderMapper orderMapper;


    @Test
    public void test01() {

        //聚合维度查询
//        examEyesightResultBirthDao.testShardingSqlGroup()



        //聚合查询测试
//        Example example = new Example(ExamEyesightResultBirthPO.class);
//        List<Integer> shardList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
//        example.createCriteria().andIn("batchesSharding", shardList);
//        List<ExamEyesightResultBirthPO> birthPOS = examEyesightResultBirthDao.selectByExample(example);
//        birthPOS.forEach(System.out::println);

        int test = 3;

        //order 策略
        // 数据库 ds_${user_id % 3}
        // 数据库表 t_order_${order_id % 3}
        for (int i = 1; i < 4; i++) {
            Order order = new Order();
            order.setOrderName("测试数据路由"+i);
            order.setUserId(Long.valueOf(i));
            order.setOrderId(Long.valueOf(i));
            int insert = orderMapper.insert(order);
            if (insert<1){
                throw new CustomBusinessException(ErrorCodeEnum.OPERATION_FAIL);
            }
        }
        System.out.println("测试结束...");








        //插入测试
//        for (int i = 0; i < 5; i++) {
//            int batchesYear = 2020;
//            if (i % 2 == 0){
//                batchesYear = 2021;
//            }else {
//                batchesYear = 2022;
//            }

//            switch (test){
//                case 1:
//                    ExamEyesightResultBirthPO birthPO0 = getExamBirthPO(i,batchesYear);
//                    birthPO0.initDateForInsertNoAuth();
//                    int count = examEyesightResultBirthDao.insert(birthPO0);
//                    if (count < 0) {
//                        throw new BizException(BusinessErrorCodeEnum.OPERATION_FAIL);
//                    }
//                    break;
//                case 2:
//                    ExamEyesightResultPO resultPO = getExamResultPO(i,batchesYear);
//                    resultPO.initDateForInsertNoAuth();
//                    int count1 = examEyesightResultDao.insert(resultPO);
//                    if (count1 < 0) {
//                        throw new BizException(BusinessErrorCodeEnum.OPERATION_FAIL);
//                    }
//                    break;
//                case 4:
//                    try {
//                        ExamEyesightResultClassPO classPO = getExamClassPO(i,batchesYear);
//                        classPO.initDateForInsertNoAuth();
//                        int count2 = examEyesightResultClassDao.insert(classPO);
//                        if (count2 < 0) {
//                            throw new BizException(BusinessErrorCodeEnum.OPERATION_FAIL);
//                        }
//                    } catch (BizException e) {
//                        System.out.println("catch a Exception, do nothing...");
//                    }
//                    break;
//                default:
//                    System.out.println("llllll");
//            }

    }
    //查询测试

//        for (int i = 0; i < 6; i++) {
//            int batchesYear = 2020;
//            if (i % 2 == 0){
//                batchesYear = 2021;
//            }else {
//                batchesYear = 2022;
//            }
//            switch (test){
//                case 1:
//                    System.out.println("这是第"+(i+1)+"次查询，改次的 sharding 字段为："+i);
//                    Example example = new Example(ExamEyesightResultBirthPO.class);
//                    example.createCriteria().andEqualTo("batchesSharding",i);
//                    List<ExamEyesightResultBirthPO> birthPOS = examEyesightResultBirthDao.selectByExample(example);
//                    birthPOS.forEach(System.out::println);
//                    break;
//                case 2:
//                    System.out.println("这是第"+(i+1)+"次查询，改次的 sharding 字段为："+i);
//                    Example example1 = new Example(ExamEyesightResultPO.class);
//                    example1.createCriteria().andEqualTo("batchesSharding",i);
//                    List<ExamEyesightResultPO> resultPOS = examEyesightResultDao.selectByExample(example1);
//                    resultPOS.forEach(System.out::println);
//                    break;
//                case 3:
//                    System.out.println("这是第"+(i+1)+"次查询，改次的 batches_year 字段为："+batchesYear);
//                    Example example2 = new Example(ExamEyesightResultClassPO.class);
//                    example2.createCriteria().andEqualTo("batchesYear",batchesYear);
//                    List<ExamEyesightResultClassPO> classPOS = examEyesightResultClassDao.selectByExample(example2);
//                    classPOS.forEach(System.out::println);
//                    break;
//                default:
//                    System.out.println("lllll");
//
//            }
//
//        }


//}

//    private ExamEyesightResultClassPO getExamClassPO(int i, int batchesYear) {
//        ExamEyesightResultClassPO classPO = new ExamEyesightResultClassPO();
//
//
//        return classPO;
//
//    }
//
//    private ExamEyesightResultPO getExamResultPO(int i, int batchesYear) {
//        ExamEyesightResultPO resultPO = new ExamEyesightResultPO();
//
//        return resultPO;
//
//    }
//
//    private ExamEyesightResultBirthPO getExamBirthPO(int sharding,int batchesYear) {
//        ExamEyesightResultBirthPO birthPO = new ExamEyesightResultBirthPO();
//
//        return birthPO;
//
//    }


}
