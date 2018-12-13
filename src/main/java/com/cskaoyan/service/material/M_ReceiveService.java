package com.cskaoyan.service.material;

import com.cskaoyan.controller.customize.CustomResult;
import com.cskaoyan.domain.Material.M_Receive;

import java.util.List;
import java.util.Map;

//收到物料
public interface M_ReceiveService {
     Map findm_receiveService(Integer page, Integer rows);
     List getData();
     CustomResult insert(M_Receive m_recive);
     CustomResult update_all(M_Receive m_receive);
     CustomResult delete_batch(String [] ids);
     Map SearchMaterialReceiveByMaterialId(Integer page, Integer rows,String searchValue);
     Map SearchMaterialReceiveByReceiveId(Integer page, Integer rows,String searchValue);

}

