package com.it.mapper;

import com.it.bean.IoTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component(value = "IoTableMapper")
public interface IoTableMapper {

    List<IoTable> findByTag(IoTable ioTable);

    void editByTag(IoTable ioTable);


    List<String> findTag();

    int deleteByTag(IoTable ioTable);

    void addTag(IoTable ioTable);
}
