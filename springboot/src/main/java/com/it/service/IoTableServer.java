package com.it.service;

import com.it.bean.IoTable;

import java.util.List;

public interface IoTableServer {

    List<IoTable> findByTag(IoTable ioTable);

    void editByTag(IoTable ioTable);


    List<String> findTag();

    int deleteByTag(IoTable ioTable);

    void addTag(IoTable ioTable);


}
