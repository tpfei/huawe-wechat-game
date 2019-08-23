package com.huaweisoft.huawei5g.consts;


import java.text.SimpleDateFormat;

public class ExcelConstant {

    /**
     * 生成文件存放路径
     */
    public static final String FILE_PATH = "C:\\Users\\hw\\Desktop\\";

    /**
     * 表格默认名称
     */
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMddhhmmss");

    public static final String PERSON_TITLE = "个人排行榜";

    public static final String USERGROUP_TITLE = "用户组排行榜";

    public static final String PERSON_RANK = "person_rank_";

    public static final String USERGROUP_RANK = "usergroup_rank_";

    public static final String[] USER_COLUMN_NAMES = {"用户名", "昵称", "组织", "关卡", "参与次数（任务闯关）", "积分（任务闯关）",
            "参与次数（竞赛）", "获胜", "失败", "胜率", "积分（竞赛）", "抽奖次数", "积分（抽奖）", "签到次数", "积分（签到）",
            "周总积分", "周总排名", "总积分", "总排名"};

    public static final String[] USERGROUP_COLUMN_NAMES = {"组织名", "用户数", "参与次数（任务闯关）", "积分（任务闯关）",
            "参与次数（竞赛）", "获胜", "失败", "胜率", "积分（竞赛）", "抽奖次数", "积分(抽奖)", "签到次数", "积分（签到）",
            "总积分", "人均积分", "总排名"};

}