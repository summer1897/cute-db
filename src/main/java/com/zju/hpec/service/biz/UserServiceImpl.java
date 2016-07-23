package com.zju.hpec.service.biz;

import com.zju.hpec.domain.User;
import com.zju.hpec.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * Created by summer on 16/7/20.
 */
public class UserServiceImpl implements IUserService {
    public User getUserById(int id) {
        User user = new User();
        user.setId(id);
        user.setName("solstice");
        user.setEmail("solstice@sina.com");
        user.setAddress("浙江省杭州市西湖区浙大路38号");
        return user;
    }
}
