package com.zju.hpec.service.logic;

import com.zju.hpec.domain.User;
import com.zju.hpec.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 16/7/20 下午9:34
 * @Description
 */
public class UserServiceImpl implements IUserService {
    public User getUserById(int id) {
        User user = new User();
        user.setId(id);
        user.setName("summer");
        user.setEmail("summer@sina.com");
        user.setAddress("浙江省杭州市西湖区浙大路38号");
        return user;
    }
}
