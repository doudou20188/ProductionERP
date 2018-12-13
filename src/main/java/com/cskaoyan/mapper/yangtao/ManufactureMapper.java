package com.cskaoyan.mapper.yangtao;

import com.cskaoyan.domain.yangtao.Manufacture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManufactureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbg.generated Fri Dec 07 20:44:02 CST 2018
     */
    int deleteByPrimaryKey(String manufactureSn);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbg.generated Fri Dec 07 20:44:02 CST 2018
     */
    int insert(Manufacture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbg.generated Fri Dec 07 20:44:02 CST 2018
     */
    int insertSelective(Manufacture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbg.generated Fri Dec 07 20:44:02 CST 2018
     */
    Manufacture selectByPrimaryKey(String manufactureSn);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbg.generated Fri Dec 07 20:44:02 CST 2018
     */
    int updateByPrimaryKeySelective(Manufacture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manufacture
     *
     * @mbg.generated Fri Dec 07 20:44:02 CST 2018
     */
    int updateByPrimaryKey(Manufacture record);

    List<Manufacture> findAllManufactureFromDB();

    List<Manufacture> findManufactureByOrderIdFromDB(@Param("searchValue") String searchValue);

    List<Manufacture> findManufactureByTeachnologyIdFromDB(@Param("searchValue") String technologyId);

    Manufacture findManutureByTechIDFromDB(@Param("technologyId") String technologyId);
}