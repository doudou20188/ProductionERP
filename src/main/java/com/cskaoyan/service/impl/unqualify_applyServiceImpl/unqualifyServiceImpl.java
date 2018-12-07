package com.cskaoyan.service.impl.unqualify_applyServiceImpl;

import com.cskaoyan.domain.unqualify_apply.department;
import com.cskaoyan.domain.unqualify_apply.employee;
import com.cskaoyan.domain.unqualify_apply.product;
import com.cskaoyan.domain.unqualify_apply.unqualify_apply;
import com.cskaoyan.service.unqualify_applyService.unqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class unqualifyServiceImpl implements unqualifyService {
    @Autowired
    com.cskaoyan.mapper.unqualify_applyMapper.unqualify_applyMapper unqualify_applyMapper ;
    @Override
    public List<unqualify_apply> selectAllQualify() {

        return unqualify_applyMapper.selectAllQualifyMessage();
    }

    @Override
    public List<department> selectAllDepartment() {
        return unqualify_applyMapper.selectAllDepartment();
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
    public List<employee> selectAllEmployee() {
        return unqualify_applyMapper.selectAllEmployee();
    }

    @Override
    public List<product> selectAllProduct() {
        return unqualify_applyMapper.selectAllProduct();
    }

    @Override
    public int addUnqualify_apply(unqualify_apply newunqualify_apply) {
        return unqualify_applyMapper.addUnqualify_apply(newunqualify_apply);
    }
}
