package com.cskaoyan.service.material;




//物料

import com.cskaoyan.controller.customize.CustomResult;

import com.cskaoyan.domain.Material.Material;

import java.util.List;
import java.util.Map;

public interface MaterialService {
    //PageInfo<Material> findmaterial(Integer page, Integer rows);
    List<Material> getdata();
     Map findmaterial(Integer page, Integer rows);
     CustomResult insertMaterial(Material material);
     CustomResult delete_batch (String[] ids);
     CustomResult  update_all(Material material);
     Map  SearchMaterialByMaterialId(Integer page, Integer rows,String searchValue);
     Map  SearchMaterialByMaterialType(Integer page, Integer rows,String searchValue);

}
