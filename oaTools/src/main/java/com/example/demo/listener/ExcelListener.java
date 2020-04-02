package com.example.demo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/***
 * Created by dz on 2020-3-17
 * @author Administrator
 */
@Slf4j
public class ExcelListener<T extends BaseRowModel> extends AnalysisEventListener<T> {

    private final List<T> rows = new ArrayList<>();

    @Override
    public void invoke(T obj, AnalysisContext analysisContext) {
        rows.add(obj);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("read {} rows %n",rows.size());
    }

    public List<T> getRows() {
        return rows;
    }
}
