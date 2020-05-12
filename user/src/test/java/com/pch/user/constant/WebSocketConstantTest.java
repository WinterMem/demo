package com.pch.user.constant;

import com.pch.user.config.ErrnoConstant;
import com.pch.user.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

@Slf4j
public class WebSocketConstantTest {

    @Test
    public void testCase() {
        log.info("constant :{}", WebSocketConstant.CLIENT_TO_CLIENT);
    }

    @Test
    public void testCase1() {
        Set<UserPO> treeSet = new TreeSet<>((user1, user2) -> {

            if (!user1.getUsername().equals(user2.getUsername())) {
                return user1.getUsername().compareTo(user2.getUsername());
            }

            return user1.getLoginName().compareTo(user2.getLoginName());
        });

        treeSet.add(new UserPO(0, "start", "ttt", null, null));
        treeSet.add(new UserPO(0, "start", "uuu", null, null));
        treeSet.add(new UserPO(0, "end", "888", null, null));
        treeSet.add(new UserPO(0, "tom", "uuu", null, null));
        treeSet.add(new UserPO(0, "end", "iii", null, null));

//        treeSet.forEach(log::info);
        for (UserPO userPO : treeSet) {
            log.info("treeSet 排序为: {}", userPO);
        }
    }

    @Test
    public void testCase2() {
        String realMsg = ErrnoConstant.getRealMsg("5");
        realMsg = "tttt";
    }
}