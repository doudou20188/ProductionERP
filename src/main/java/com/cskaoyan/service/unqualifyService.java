package com.cskaoyan.service;

import com.cskaoyan.domain.*;

import java.util.List;

public interface unqualifyService {
    List<unqualify_apply> selectAllQualify();

    List<department> selectAllDepartment();

    String selectempNameById(String empId);

    String selectproductNameById(String productId);

    List<employee> selectAllEmployee();

    List<product> selectAllProduct();
    int addUnqualify_apply(unqualify_apply newunqualify_apply);
    int updateUnqualify_applyByunqualify(unqualify_apply unqualify_apply);
    int deleteUnqualify_applyByunqualify(String ids);

    List<unqualify_apply> selectQualifyById(String searchValue);

    List<unqualify_apply> selectQualifyByproductId(String searchValue);

    String selectProductIdByproductname(String searchValue);

    List<final_measuret_check> selectAllfinal_measuret_check();

    List<custom> selectAllCustom();

    c_order selectC_orderByOrderId(String id);

    List<c_order> selectAllC_order();

    int updatefinal_measuret_checkByfinal_measuret(final_measuret_check final_measuret_check);

    int insertfinal_measuret_checkByfinal_measuret(final_measuret_check final_measuret_check);

    employee selectemployeeByEmployeeId(String id);

    int deletemeasureByMeasureId(String ids);

    List<final_measuret_check> selectMeasureById(String searchValue);

    List<final_measuret_check> selectC_orderfromMeasuretByOrderId(String searchValue);

    List<final_count_check> selectAllfinal_count_check();

    int insertFinal_count_checkByfinal_count(final_count_check final_count_check);

    List<process> selectAllProcess();

    int updatefinal_count_checkByfinal_count(final_count_check final_count_check);

    int deleteFinal_count_checkByfinal_countId(String ids);

    List<final_count_check> selectfinal_count_checkByfCountCheckId(String searchValue);


    List<final_count_check> selectfinal_count_checkByorderId(String searchValue);

    List<process_measure_check> selectAllProcess_measure_check();

    int insertProcess_measure_checkByProcess_measure(process_measure_check process_measure_check);

    List<technology> selectAllTechnology();

    int updateProcess_measure_checkByProcess_measure(process_measure_check process_measure_check);

    int deleteProcess_measure_checkByprocess_measure(String ids);

    List<process_measure_check> selectprocess_measure_checkByprocess_measure(String searchValue);

    product selectProductByProductId(String id);

    List<process_count_check> selectAllProcess_count_check();

    int insertProcess_count_checkByProcess_count(process_count_check process_count_check);

    int updateProcess_count_checkByProcess_count(process_count_check process_count_check);

    process selectProcessByProcessId(String id);

    int deleteProcess_count_checkByprocess_count(String ids);

    List<process_count_check> selectprocess_count_checkByprocess_count(String searchValue);
}
