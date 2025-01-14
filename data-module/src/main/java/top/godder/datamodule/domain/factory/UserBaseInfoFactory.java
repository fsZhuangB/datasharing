package top.godder.datamodule.domain.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.godder.datamodule.domain.dao.FieldDao;
import top.godder.datamodule.domain.dao.RoleDao;
import top.godder.datamodule.domain.dao.UserLocalInfoDao;
import top.godder.datamoduleapi.domain.aggregate.UserBaseInfo;
import top.godder.datamoduleapi.domain.entity.Field;
import top.godder.datamoduleapi.domain.entity.Role;
import top.godder.datamoduleapi.domain.entity.UserLocalInfo;

import java.util.List;

/**
 * @author: godder
 * @date: 2019/5/19
 */
@Repository
public class UserBaseInfoFactory {
    @Autowired
    private UserLocalInfoDao userLocalInfoDao;

    @Autowired
    private FieldDao fieldDao;

    @Autowired
    private RoleDao roleDao;

    public UserBaseInfo createUserBaseInfo(Long userId) {
        if (userId == null) {
            return null;
        }
        UserLocalInfo userLocalInfo = userLocalInfoDao.findOne(userId);
        List<Role> roleList = roleDao.findByUserId(userId);
        List<Field> fieldList = fieldDao.findByUserId(userId);
        if (userLocalInfo == null && roleList.size() == 0) {
            return null;
        }
        UserBaseInfo userBaseInfo = UserBaseInfo.builder()
                .userId(userId)
                .localName(userLocalInfo.getName())
                .credit(userLocalInfo.getCredit())
                .fieldList(fieldList)
                .roleList(roleList)
                .build();
        return userBaseInfo;
    }
}
