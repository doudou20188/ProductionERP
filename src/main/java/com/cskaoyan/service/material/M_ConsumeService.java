package com.cskaoyan.service.material;

import com.cskaoyan.controller.customize.CustomResult;
import com.cskaoyan.domain.Material.M_Consume;
import com.cskaoyan.domain.Material.Vo.MaterialConsumeVO;

import java.util.Map;


//物料消费
public interface M_ConsumeService {
    Map findlist(Integer page, Integer rows, MaterialConsumeVO materialConsume);
   CustomResult insert(M_Consume m_consume);
    CustomResult  delete_batch(String[] ids);
    CustomResult update(M_Consume m_consume);
   Map searchMaterialConsumeByConsumeId(Integer page, Integer rows,String searchValue);
   Map searchMaterialConsumeByMaterialId(Integer page, Integer rows, String searchValue);
   Map searchMaterialConsumeByWorkId(Integer page, Integer rows, String searchValue);
}
