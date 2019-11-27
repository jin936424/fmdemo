package com.server.zhserver.config;

import com.server.zhserver.pojo.Users;
import com.server.zhserver.service.UsersService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/***
 * Created by dz on 2019-11-27
 */
public class ZHRealm extends AuthorizingRealm {
    @Autowired
    private UsersService usersService;

    /**
     *  获取授权信息方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        return s;
    }

    /**
     * 获取认证信息
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = token.getPrincipal().toString();
        Users user = usersService.queryByuserName(userName);
        String passwordInDB = user.getPassword();
        String salt = user.getSalt();
        // 加密
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, passwordInDB,
                ByteSource.Util.bytes(salt), getName());
        return authenticationInfo;
    }
}
