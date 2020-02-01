package com.it.service.impl;

import com.it.bean.IoTable;
import com.it.mapper.IoTableMapper;
import com.it.service.IoTableServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("IoTableServer")
public class IoTableServerImpl implements IoTableServer {
    @Autowired
    IoTableMapper ioTableMapper;


    @Override
    public List<IoTable> findByTag(IoTable ioTable) {

        return ioTableMapper.findByTag(ioTable);
    }

    @Override
    public void editByTag(IoTable ioTable) {
        ioTableMapper.editByTag(ioTable);
    }

    @Override
    public List<String> findTag() {
        return ioTableMapper.findTag();
    }

    @Override
    public int deleteByTag(IoTable ioTable) {
        return ioTableMapper.deleteByTag(ioTable);
    }

    @Override
    public void addTag(IoTable ioTable) {
        ioTableMapper.addTag(ioTable);
    }

}
