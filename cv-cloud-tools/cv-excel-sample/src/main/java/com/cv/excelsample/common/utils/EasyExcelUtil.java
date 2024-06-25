package com.cv.excelsample.common.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xutu
 * @date 2022/08/04 10:34
 */
public class EasyExcelUtil {


    private static class MapExcelListener extends AnalysisEventListener {

        private List<Map<Integer, Object>> datas = new ArrayList<>();


        @Override
        public void invoke(Object object, AnalysisContext context) {
            Map<Integer, Object> map = (Map<Integer, Object>) object;
            datas.add(map);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
        }

        public List<Map<Integer, Object>> getDatas() {
            return datas;
        }

        public void setDatas(List<Map<Integer, Object>> datas) {
            this.datas = datas;
        }
    }

    private static class StringExcelListener extends AnalysisEventListener {
        private List<List<String>> datas = new ArrayList<>();

        @Override
        public void invoke(Object object, AnalysisContext context) {
            List<String> stringList = (List<String>) object;
            datas.add(stringList);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {

        }

        public List<List<String>> getDatas() {
            return datas;
        }

        public void setDatas(List<List<String>> datas) {
            this.datas = datas;
        }
    }


    public static List<List<String>> readExcelWithStringList(InputStream inputStream) {
        StringExcelListener listener = new StringExcelListener();
        EasyExcelFactory.read(inputStream, listener).build().readAll();
        if (null != inputStream) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listener.getDatas();
    }


    private static class ModelExcelListener<E> extends AnalysisEventListener<E> {
        private List<E> dataList = new ArrayList<>();

        @Override
        public void invoke(E object, AnalysisContext context) {
            dataList.add(object);
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
        }


        public List<E> getDataList() {
            return dataList;
        }

        @SuppressWarnings("unused")
        public void setDataList(List<E> dataList) {
            this.dataList = dataList;
        }
    }

    private static class HeadDataListener extends AnalysisEventListener<Map<Integer, String>> {
        Map<Integer, String> headMapResult = new HashMap<>();

        @Override
        public void invoke(Map<Integer, String> data, AnalysisContext context) {

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {

        }

        @Override
        public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
            headMapResult = headMap;
        }

        public Map<Integer, String> getHeadMapResult() {
            return headMapResult;
        }

        public void setHeadMapResult(Map<Integer, String> headMapResult) {
            this.headMapResult = headMapResult;
        }
    }

    private static class HeadDataListenerByMoreHead extends AnalysisEventListener<Map<Integer, String>> {
        List<Map<Integer, String>> headMapResult = new ArrayList<>();

        @Override
        public void invoke(Map<Integer, String> data, AnalysisContext context) {

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {

        }

        @Override
        public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
            headMapResult.add(headMap);
        }

        public List<Map<Integer, String>> getHeadMapResult() {
            return headMapResult;
        }

        public void setHeadMapResult(List<Map<Integer, String>> headMapResult) {
            this.headMapResult = headMapResult;
        }
    }


    public static List<Map<Integer, String>> getExcelHeader(MultipartFile file, Integer headRowNumber) {
        InputStream inputStream;
        HeadDataListenerByMoreHead headDataListener = new HeadDataListenerByMoreHead();
        try {
            if (null == headRowNumber) {
                headRowNumber = 1;
            }
            inputStream = file.getInputStream();
            EasyExcelFactory.read(inputStream, headDataListener).headRowNumber(headRowNumber).build().readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return headDataListener.getHeadMapResult();
    }


    public static List<Map<Integer, String>> getExcelHeader(InputStream inputStream, Integer headRowNumber) {
        HeadDataListenerByMoreHead headDataListener = new HeadDataListenerByMoreHead();
        if (null == headRowNumber) {
            headRowNumber = 1;
        }
        EasyExcelFactory.read(inputStream, headDataListener).headRowNumber(headRowNumber).build().readAll();
        return headDataListener.getHeadMapResult();
    }


    public static Map<Integer, String> getExcelHeader(InputStream inputStream) {
        HeadDataListener headDataListener = new HeadDataListener();
        EasyExcelFactory.read(inputStream, headDataListener).build().readAll();
        return headDataListener.getHeadMapResult();
    }


    public static Map<Integer, String> getExcelHeader(MultipartFile file) {
        HeadDataListener headDataListener = new HeadDataListener();
        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
            EasyExcelFactory.read(inputStream, headDataListener).build().readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return headDataListener.getHeadMapResult();
    }


    public static List<Map<Integer, Object>> readExcelWithMapList(InputStream inputStream) {
        MapExcelListener listener = new MapExcelListener();
        EasyExcelFactory.read(inputStream, listener).build().readAll();
        return listener.getDatas();
    }


    public static <E> List<E> readExcelWithModel(InputStream inputStream, Class<E> clazz) {
        ModelExcelListener<E> listener = new ModelExcelListener<>();
        try {
            EasyExcelFactory.read(inputStream, clazz, listener).autoCloseStream(true).build().readAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listener.getDataList();
    }

    public static <E> List<E> readExcelWithModel(File file, Class<E> clazz) {
        InputStream inputStream = null;
        ModelExcelListener<E> listener = new ModelExcelListener<>();
        try {
            inputStream = new FileInputStream(file);
            EasyExcelFactory.read(inputStream, clazz, listener).autoCloseStream(true).build().readAll();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listener.dataList;
    }

    public static <E> List<E> readExcelWithModel(MultipartFile file, Class<E> clazz) {
        InputStream inputStream = null;
        ModelExcelListener<E> listener = new ModelExcelListener<>();
        try {
            inputStream = file.getInputStream();
            EasyExcelFactory.read(inputStream, clazz, listener).autoCloseStream(true).build().readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listener.dataList;
    }

    public static <E> List<E> readExcelWithModel(MultipartFile file, Class<E> clazz, Integer headRowNumber) {
        InputStream inputStream = null;
        ModelExcelListener<E> listener = new ModelExcelListener<>();
        try {
            if (null == headRowNumber) {
                headRowNumber = 1;
            }
            inputStream = file.getInputStream();
            EasyExcelFactory.read(inputStream, clazz, listener).headRowNumber(headRowNumber).autoCloseStream(true).build().readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listener.getDataList();
    }


    public static <E> List<E> readExcelWithModel(File file, Class<E> clazz, Integer headRowNumber) {
        InputStream inputStream;
        ModelExcelListener<E> listener = new ModelExcelListener<>();
        try {
            if (null == headRowNumber) {
                headRowNumber = 1;
            }
            inputStream = new FileInputStream(file);
            EasyExcelFactory.read(inputStream, clazz, listener).headRowNumber(headRowNumber).autoCloseStream(true).build().readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listener.getDataList();
    }


}
