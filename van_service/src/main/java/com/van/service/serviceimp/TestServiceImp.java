package com.van.service.serviceimp;

import com.van.mapper.TestDao;
import com.van.moudle.Testpojo;
import com.van.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImp implements TestService {

    @Autowired
    private TestDao testDao;
    @Override
    public Testpojo login(Testpojo admin) {
        return testDao.login(admin);
    }
}
