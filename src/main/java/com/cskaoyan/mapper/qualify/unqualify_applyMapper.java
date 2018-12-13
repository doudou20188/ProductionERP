package com.cskaoyan.mapper.qualify;


import com.cskaoyan.domain.qualify.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface unqualify_applyMapper {
    /*这些是自动生成的*/
    int deleteByPrimaryKey(String unqualifyApplyId);
    int insert(unqualify_apply record);
    int insertSelective(unqualify_apply record);
    unqualify_apply selectByPrimaryKey(String unqualifyApplyId);
    int updateByPrimaryKeySelective(unqualify_apply record);
    int updateByPrimaryKey(unqualify_apply record);
    /*到这里为止，下面是需要用到的*/
    List<unqualify_apply> selectAllQualifyMessage();



    String selectempNameById(@Param("empId") String empId);

    String selectproductNameById(@Param("productId") String productId);





    int addUnqualify_apply(@Param("unqualify_apply") unqualify_apply newunqualify_apply);

    int updateUnqualify_applyByunqualify(@Param("unqualify_apply") unqualify_apply unqualify_apply);

    int deleteUnqualify_applyByunqualify(@Param("ids") String ids);

    List<unqualify_apply> selectQualifyById(@Param("id") String searchValue);

    List<unqualify_apply> selectQualifyByproductId(@Param("productId") String searchValue);

    String selectProductIdByproductname(@Param("productName") String searchValue);

    List<final_measuret_check> selectAllfinal_measuret_check();



    int updatefinal_measuret_checkByfinal_measuret(@Param("final_measuret") final_measuret_check final_measuret_check);

    int insertfinal_measuret_checkByfinal_measuret(@Param("final_measuret") final_measuret_check final_measuret_check);



    int deletemeasureByMeasureId(@Param("id") String ids);

    List<final_measuret_check> selectMeasureById(@Param("id") String searchValue);

    List<final_measuret_check> selectC_orderfromMeasuretByOrderId(@Param("id") String searchValue);

    List<final_count_check> selectAllfinal_count_check();

    int insertFinal_count_checkByfinal_count(@Param("final_count_check") final_count_check final_count_check);



    int updatefinal_count_checkByfinal_count(@Param("final_count_check") final_count_check final_count_check);

    int deleteFinal_count_checkByfinal_countId(@Param("id") String ids);

    List<final_count_check> selectfinal_count_checkByfCountCheckId(@Param("id") String searchValue);


    List<final_count_check> selectfinal_count_checkByorderId(@Param("id") String searchValue);

    List<process_measure_check> selectAllProcess_measure_check();

    int insertProcess_measure_checkByProcess_measure(@Param("process_measure_check") process_measure_check process_measure_check);



    int updateProcess_measure_checkByProcess_measure(@Param("process_measure_check") process_measure_check process_measure_check);

    int deleteProcess_measure_checkByprocess_measure(@Param("id") String ids);

    List<process_measure_check> selectprocess_measure_checkByprocess_measure(@Param("id") String searchValue);


    List<process_count_check> selectAllProcess_count_check();

    int insertProcess_count_checkByProcess_count(@Param("process_count_check") process_count_check process_count_check);

    int updateProcess_count_checkByProcess_count(@Param("process_count_check") process_count_check process_count_check);



    int deleteProcess_count_checkByprocess_count(@Param("id") String ids);

    List<process_count_check> selectprocess_count_checkByprocess_count(@Param("id") String searchValue);







}