package com.boot.mapper;

import com.boot.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {

    @Select("select m.id,m.addTime,m.`name` from t_menu m left join t_user_menu um on m.id = um.menu_id where um.user_id = #{userId}")
    List<Menu> selectByUserId(Long userId);

}

