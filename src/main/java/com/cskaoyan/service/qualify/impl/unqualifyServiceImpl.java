package com.cskaoyan.service.qualify.impl;

import com.cskaoyan.domain.qualify.*;
import com.cskaoyan.service.qualify.unqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class unqualifyServiceImpl implements unqualifyService {
    @Autowired
    com.cskaoyan.mapper.qualify.unqualify_applyMapper unqualify_applyMapper ;
    @Override
    public List<unqualify_apply> selectAllQualify() {

        return unqualify_applyMapper.selectAllQualifyMessage();
    }


    @Override
    public String selectempNameById(String empId) {
        return unqualify_applyMapper.selectempNameById(empId);
    }

    @Override
    public String selectproductNameById(String productId) {
        return unqualify_applyMapper.selectproductNameById( productId);
    }



    @Override
    public int addUnqualify_apply(unqualify_apply newunqualify_apply) {
        return unqualify_applyMapper.addUnqualify_apply(newunqualify_apply);
    }

    @Override
    public int updateUnqualify_applyByunqualify(unqualify_apply unqualify_apply) {
        return unqualify_applyMapper.updateUnqualify_applyByunqualify( unqualify_apply);
    }

    @Override
    public int deleteUnqualify_applyByunqualify(String ids) {
        return unqualify_applyMapper.deleteUnqualify_applyByunqualify(ids);
    }

    @Override
    public List<unqualify_apply> selectQualifyById(String searchValue) {
        return unqualify_applyMapper.selectQualifyById(searchValue);
    }

    @Override
    public List<unqualify_apply> selectQualifyByproductId(String searchValue) {
        return unqualify_applyMapper.selectQualifyByproductId(searchValue);
    }

    @Override
    public String selectProductIdByproductname(String searchValue) {
        return unqualify_applyMapper.selectProductIdByproductname(searchValue);
    }

    @Override
    public List<final_measuret_check> selectAllfinal_measuret_check() {
        return unqualify_applyMapper.selectAllfinal_measuret_check();
    }



    @Override
    public int updatefinal_measuret_checkByfinal_measuret(final_measuret_check final_measuret_check) {
        return unqualify_applyMapper.updatefinal_measuret_checkByfinal_measuret(final_measuret_check ) ;
    }

    @Override
    public int insertfinal_measuret_checkByfinal_measuret(final_measuret_check final_measuret_check) {
        return unqualify_applyMapper.insertfinal_measuret_checkByfinal_measuret( final_measuret_check);
    }



    @Override
    public int deletemeasureByMeasureId(String ids) {
        return unqualify_applyMapper.deletemeasureByMeasureId( ids);
    }

    @Override
    public List<final_measuret_check> selectMeasureById(String searchValue) {
        return unqualify_applyMapper.selectMeasureById(searchValue);
    }

    @Override
    public List<final_measuret_check> selectC_orderfromMeasuretByOrderId(String searchValue) {
        return unqualify_applyMapper.selectC_orderfromMeasuretByOrderId( searchValue);
    }

    @Override
    public List<final_count_check> selectAllfinal_count_check() {
        return unqualify_applyMapper.selectAllfinal_count_check();
    }

    @Override
    public int insertFinal_count_checkByfinal_count(final_count_check final_count_check) {
        return unqualify_applyMapper.insertFinal_count_checkByfinal_count( final_count_check);
    }


    @Override
    public int updatefinal_count_checkByfinal_count(final_count_check final_count_check) {
        return unqualify_applyMapper.updatefinal_count_checkByfinal_count(final_count_check);
    }

    @Override
    public int deleteFinal_count_checkByfinal_countId(String ids) {
        return unqualify_applyMapper.deleteFinal_count_checkByfinal_countId(ids);
    }

    @Override
    public List<final_count_check> selectfinal_count_checkByfCountCheckId(String searchValue) {
        return unqualify_applyMapper.selectfinal_count_checkByfCountCheckId(searchValue);
    }

    @Override
    public List<final_count_check> selectfinal_count_checkByorderId(String searchValue) {
        return unqualify_applyMapper.selectfinal_count_checkByorderId(searchValue);
    }

    @Override
    public List<process_measure_check> selectAllProcess_measure_check() {
        return unqualify_applyMapper.selectAllProcess_measure_check();
    }

    @Override
    public int insertProcess_measure_checkByProcess_measure(process_measure_check process_measure_check) {
        return unqualify_applyMapper.insertProcess_measure_checkByProcess_measure(process_measure_check ) ;
    }

    @Override
    public List<technology_plan> selectAllTechnologyPlan() {
        return unqualify_applyMapper.selectAllTechnologyPlan();
    }

    @Override
    public int updateProcess_measure_checkByProcess_measure(process_measure_check process_measure_check) {
        return unqualify_applyMapper.updateProcess_measure_checkByProcess_measure(process_measure_check);
    }

    @Override
    public int deleteProcess_measure_checkByprocess_measure(String ids) {
        return unqualify_applyMapper.deleteProcess_measure_checkByprocess_measure( ids);
    }

    @Override
    public List<process_measure_check> selectprocess_measure_checkByprocess_measure(String searchValue) {
        return unqualify_applyMapper.selectprocess_measure_checkByprocess_measure(searchValue) ;
    }


    @Override
    public List<process_count_check> selectAllProcess_count_check() {
        return unqualify_applyMapper.selectAllProcess_count_check();
    }

    @Override
    public int insertProcess_count_checkByProcess_count(process_count_check process_count_check) {
        return unqualify_applyMapper.insertProcess_count_checkByProcess_count( process_count_check);
    }

    @Override
    public int updateProcess_count_checkByProcess_count(process_count_check process_count_check) {
        return unqualify_applyMapper.updateProcess_count_checkByProcess_count(process_count_check);
    }


    @Override
    public int deleteProcess_count_checkByprocess_count(String ids) {
        return unqualify_applyMapper.deleteProcess_count_checkByprocess_count( ids);
    }

    @Override
    public List<process_count_check> selectprocess_count_checkByprocess_count(String searchValue) {
        return unqualify_applyMapper.selectprocess_count_checkByprocess_count(searchValue);
    }






   }
