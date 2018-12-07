package com.cskaoyan.service.unqualify_applyService;

import com.cskaoyan.domain.unqualify_apply.department;
import com.cskaoyan.domain.unqualify_apply.employee;
import com.cskaoyan.domain.unqualify_apply.product;
import com.cskaoyan.domain.unqualify_apply.unqualify_apply;

import java.util.List;

public interface unqualifyService {
    List<unqualify_apply> selectAllQualify();

    List<department> selectAllDepartment();

    String selectempNameById(String empId);

    String selectproductNameById(String productId);

    List<employee> selectAllEmployee();

    List<product> selectAllProduct();
    int addUnqualify_apply(unqualify_apply newunqualify_apply);
}
