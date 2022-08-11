package cn.chendapeng.shardingsphere.mapper;

import cn.chendapeng.shardingsphere.bean.Laogong;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 行百里者
 * @since 2020/11/19 21:05
 **/
@Repository
@Mapper
public interface LaogongMapper {

    @Insert("insert into laogong(id, name, age) values(#{id}, #{name}, #{age})")
    void addLaogong(Laogong laogong);

    @Select("select * from laogong where id=#{id}")
    Laogong queryLaogong(Integer id);
}
