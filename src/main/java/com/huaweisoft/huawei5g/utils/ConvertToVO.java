package com.huaweisoft.huawei5g.utils;

import com.huaweisoft.huawei5g.model.User;
import com.huaweisoft.huawei5g.model.UserGroup;
import com.huaweisoft.huawei5g.model.UserGroupVO;
import com.huaweisoft.huawei5g.model.UserVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertToVO {
    public List<UserVO> toUserVO(List<User> users) {
        UserVO userVO;
        List<UserVO> result = new ArrayList<>();
        if (users != null) {
            for (User user : users) {
                userVO = new UserVO();
                userVO.setGroups(user.getGroups());
                userVO.setPkCount(user.getPkCount());
                userVO.setPkLose(user.getPkLose());
                userVO.setPkScore(user.getPkScore());
                userVO.setPkWin(user.getPkWin());
                userVO.setSignCount(user.getSignCount());
                userVO.setSignScore(user.getSignScore());
                userVO.setSumScore(user.getSumScore());
                userVO.setSumScoreRank(user.getSumScoreRank());
                userVO.setTaskCount(user.getTaskCount());
                userVO.setTaskLvl(user.getTaskLvl());
                userVO.setTaskScore(user.getTaskScore());
                userVO.setUsername(user.getUsername());
                userVO.setNickname(user.getNickname());
                userVO.setPkWinrate(user.getPkWinrate());
                userVO.setLotteryCount(user.getLotteryCount());
                userVO.setLotteryScore(user.getLotteryScore());
                userVO.setWeekScore(user.getWeekScore());
                userVO.setWeekScoreRank(user.getWeekScoreRank());
                result.add(userVO);
            }
            return result;
        }
        return result;
    }

    public List<UserGroupVO> toUserGroupVO(List<UserGroup> userGroups) {

        UserGroupVO userGroupVO;
        List<UserGroupVO> result = new ArrayList<>();
        if (userGroups != null) {
            for (UserGroup userGroup : userGroups) {
                userGroupVO = new UserGroupVO();
                userGroupVO.setAverageScore(userGroup.getAverageScore());
                userGroupVO.setLotteryCount(userGroup.getLotteryCount());
                userGroupVO.setLotteryScore(userGroup.getLotteryScore());
                userGroupVO.setName(userGroup.getName());
                userGroupVO.setPkCount(userGroup.getPkCount());
                userGroupVO.setPkLost(userGroup.getPkLost());
                userGroupVO.setPkScore(userGroup.getPkScore());
                userGroupVO.setPkWin(userGroup.getPkWin());
                userGroupVO.setPkWinrate(userGroup.getPkWinrate());
                userGroupVO.setSignCount(userGroup.getSignCount());
                userGroupVO.setSignScore(userGroup.getSignScore());
                userGroupVO.setUserCount(userGroup.getUserCount());
                userGroupVO.setTaskConut(userGroup.getTaskConut());
                userGroupVO.setTaskScore(userGroup.getTaskScore());
                userGroupVO.setSumScore(userGroup.getSumScore());
                userGroupVO.setSumScoreRank(userGroup.getSumScoreRank());
                result.add(userGroupVO);
            }
        }
        return result;
    }
}
