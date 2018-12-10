package com.cskaoyan.service;

import com.cskaoyan.domain.Manufacture;

import java.util.List;

/**
 * @Auther: YangTao
 * @Date: 2018/12/7 0007
 */
public interface ManufactureService {

    List<Manufacture> findAllManufacture();

    boolean addManfacture(Manufacture manufacture);

    boolean deleteManufactureById(String ids);

    boolean updateManufacture(Manufacture manufacture);

    Manufacture findManufactureById(String searchValue);

    List<Manufacture> findManufactureByOrderId(String searchValue);

    List<Manufacture> findManufactureByTeachnologyId(String technologyId);


    Manufacture findManutureByTechID(String technologyId);
}
