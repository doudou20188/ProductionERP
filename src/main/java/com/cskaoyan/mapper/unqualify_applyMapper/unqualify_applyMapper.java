package com.cskaoyan.mapper.unqualify_applyMapper;


import com.cskaoyan.domain.unqualify_apply.department;
import com.cskaoyan.domain.unqualify_apply.employee;
import com.cskaoyan.domain.unqualify_apply.product;
import com.cskaoyan.domain.unqualify_apply.unqualify_apply;
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

    List<department> selectAllDepartment();

    String selectempNameById(@Param("empId") String empId);

    String selectproductNameById(@Param("productId") String productId);

    List<employee> selectAllEmployee();

    List<product> selectAllProduct();

    int addUnqualify_apply(@Param("unqualify_apply") unqualify_apply newunqualify_apply);
}