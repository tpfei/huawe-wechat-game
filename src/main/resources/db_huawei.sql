/*
 Navicat Premium Data Transfer

 Source Server         : management
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : db_huawei

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 23/08/2019 19:40:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `privilege` int(11) NOT NULL DEFAULT 0,
  `mobile` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'Y',
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for day_visit_log
-- ----------------------------
DROP TABLE IF EXISTS `day_visit_log`;
CREATE TABLE `day_visit_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `days` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `visit_count` smallint(6) NULL DEFAULT 0,
  `tick_count` int(11) NULL DEFAULT 0,
  `sign_count` tinyint(4) NULL DEFAULT 0,
  `task_count` smallint(6) NULL DEFAULT 0,
  `pk_count` smallint(6) NULL DEFAULT 0,
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `userid`(`userid`, `days`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hour_visit_log
-- ----------------------------
DROP TABLE IF EXISTS `hour_visit_log`;
CREATE TABLE `hour_visit_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `hours` int(11) NOT NULL,
  `visit_count` smallint(6) NULL DEFAULT 0,
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `userid`(`userid`, `hours`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ip_table
-- ----------------------------
DROP TABLE IF EXISTS `ip_table`;
CREATE TABLE `ip_table`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `created_at` int(11) NULL DEFAULT 0,
  `update_at` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ip`(`ip`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ip_table
-- ----------------------------
INSERT INTO `ip_table` VALUES (1, '119.123.207.96', '', 0, 0);

-- ----------------------------
-- Table structure for map_data
-- ----------------------------
DROP TABLE IF EXISTS `map_data`;
CREATE TABLE `map_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for npc
-- ----------------------------
DROP TABLE IF EXISTS `npc`;
CREATE TABLE `npc`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `avatar` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for openid_uid
-- ----------------------------
DROP TABLE IF EXISTS `openid_uid`;
CREATE TABLE `openid_uid`  (
  `uid` int(11) NOT NULL,
  `openid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nick` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `avatar` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `openid`(`openid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pass_log
-- ----------------------------
DROP TABLE IF EXISTS `pass_log`;
CREATE TABLE `pass_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `pass_id` int(11) NULL DEFAULT 0,
  `rights` tinyint(4) NULL DEFAULT 0,
  `stars` tinyint(4) NULL DEFAULT 0,
  `score` smallint(6) NULL DEFAULT 0,
  `turn_score` smallint(6) NULL DEFAULT 0,
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `userid`(`userid`, `pass_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pk_log
-- ----------------------------
DROP TABLE IF EXISTS `pk_log`;
CREATE TABLE `pk_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `room_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `days` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `answer_count` smallint(6) NULL DEFAULT 0,
  `answer_score` smallint(6) NULL DEFAULT 0,
  `turn_count` smallint(6) NULL DEFAULT 0,
  `turn_score` smallint(6) NULL DEFAULT 0,
  `prize_score_count` smallint(6) NULL DEFAULT 0,
  `prize_score` smallint(6) NULL DEFAULT 0,
  `win` tinyint(4) NULL DEFAULT 0,
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `userid`(`userid`, `room_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for posts
-- ----------------------------
DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pass_id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `praise` int(11) NULL DEFAULT 0,
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for prize_members
-- ----------------------------
DROP TABLE IF EXISTS `prize_members`;
CREATE TABLE `prize_members`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prize_set_id` int(11) NOT NULL,
  `prize_set_rank` smallint(6) NOT NULL,
  `seg1` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `seg2` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `seg3` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `prize_set_id`(`prize_set_id`, `prize_set_rank`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for prize_set
-- ----------------------------
DROP TABLE IF EXISTS `prize_set`;
CREATE TABLE `prize_set`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prize_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `prize_gift` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `prize_value` int(11) NULL DEFAULT 0,
  `prize_num` smallint(6) NULL DEFAULT 0,
  `rule` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rank_week_log
-- ----------------------------
DROP TABLE IF EXISTS `rank_week_log`;
CREATE TABLE `rank_week_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `groupid` int(11) NULL DEFAULT 0,
  `topgroup` int(11) NULL DEFAULT 0,
  `score` int(11) NULL DEFAULT 0,
  `rank_type` tinyint(4) NULL DEFAULT 0,
  `rank_id` smallint(6) NULL DEFAULT 0,
  `weeks` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `rank_type`(`rank_type`, `weeks`, `rank_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `catagory` tinyint(4) NOT NULL,
  `types` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `relate_pass` int(11) NULL DEFAULT 0,
  `question` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `answer1` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `answer2` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `answer3` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `answer4` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `results` int(11) NULL DEFAULT 0,
  `result_type` tinyint(4) NULL DEFAULT 0,
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for topic_log
-- ----------------------------
DROP TABLE IF EXISTS `topic_log`;
CREATE TABLE `topic_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `results` tinyint(4) NULL DEFAULT 0,
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parentid` int(11) NULL DEFAULT 0,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  `status` tinyint(4) NULL DEFAULT 0,
  `user_count` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `average_score` int(11) NULL DEFAULT NULL,
  `sum_score` int(11) NULL DEFAULT NULL,
  `sum_score_rank` int(11) NULL DEFAULT NULL,
  `task_conut` int(11) NULL DEFAULT NULL,
  `task_score` int(11) NULL DEFAULT NULL,
  `pk_count` int(11) NULL DEFAULT NULL,
  `pk_win` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pk_lost` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pk_winrate` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pk_score` int(11) NULL DEFAULT NULL,
  `lottery_count` int(11) NULL DEFAULT NULL,
  `lottery_score` int(11) NULL DEFAULT NULL,
  `sign_count` int(11) NULL DEFAULT NULL,
  `sign_score` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_group
-- ----------------------------
INSERT INTO `user_group` VALUES (3, -1, '参数三', 1565090951, 1565343926, 0, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '55%', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_group` VALUES (4, 0, '小卖部', 1565090951, 1565090951, 0, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '54%', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_group` VALUES (5, 0, '食堂', 1565090951, 1565090951, 0, '3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '66%', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_group` VALUES (6, 0, '面包店', 1565090951, 1565090951, 0, '4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '47%', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_group` VALUES (7, 0, '小卖部', 1565090951, 1565090951, 0, '5', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '60%', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_group` VALUES (8, 0, '食堂', 1565102003, 1565102003, 0, '4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '30%', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_group` VALUES (9, 0, '小卖部', 1565102032, 1565102032, 0, '5', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_group` VALUES (10, 0, '研发部', 1565105353, 1565105353, 0, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '100%', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_week_scores
-- ----------------------------
DROP TABLE IF EXISTS `user_week_scores`;
CREATE TABLE `user_week_scores`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `groupid` int(11) NULL DEFAULT 0,
  `topgroup` int(11) NULL DEFAULT 0,
  `weeks` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `score` int(11) NOT NULL,
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `userid`(`userid`, `weeks`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `groupid` int(11) NULL DEFAULT 0,
  `topgroup` int(11) NULL DEFAULT 0,
  `groups` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mobile` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `energy` int(11) NULL DEFAULT 0,
  `sum_score` int(11) NULL DEFAULT 0,
  `sum_score_rank` int(11) NULL DEFAULT 0,
  `weeks` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `week_score` int(11) NULL DEFAULT 0,
  `week_score_rank` int(11) NULL DEFAULT 0,
  `sign_count` int(11) NULL DEFAULT 0,
  `sign_score` int(11) NULL DEFAULT 0,
  `task_lvl` int(11) NULL DEFAULT 1,
  `task_count` int(11) NULL DEFAULT 0,
  `task_score` int(11) NULL DEFAULT 0,
  `pk_count` int(11) NULL DEFAULT 0,
  `pk_score` int(11) NULL DEFAULT 0,
  `pk_win` int(11) NULL DEFAULT 0,
  `pk_lose` int(11) NULL DEFAULT 0,
  `created_at` int(11) NOT NULL,
  `update_at` int(11) NOT NULL,
  `online_at` int(11) NOT NULL DEFAULT 0,
  `status` tinyint(4) NULL DEFAULT 0,
  `nickname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pk_winrate` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lottery_count` int(11) NULL DEFAULT NULL,
  `lottery_score` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `mobile`(`mobile`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (10001, 1, 0, '', 'tpf', '13131313131', '', 0, 800, 3, '0', 800, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '666', NULL, NULL, NULL);
INSERT INTO `users` VALUES (10002, 2, 0, '', '还有', '1515115151', '', 0, 1000, 2, '1', 1000, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '哈哈', NULL, NULL, NULL);
INSERT INTO `users` VALUES (10003, 1, 0, '', '我的', '1616161616', '', 0, 1200, 1, '0', 1200, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '取个名字真难', NULL, NULL, NULL);
INSERT INTO `users` VALUES (10004, 2, 0, '', '而非', '178171717178', '', 0, 100, 5, '1', 100, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '我我我我我我', NULL, NULL, NULL);
INSERT INTO `users` VALUES (10005, 3, 0, '', '啊', '1814818181', '', 0, 500, 4, '1', 500, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '我得到的多', NULL, NULL, NULL);
INSERT INTO `users` VALUES (10006, 3, 0, '', '不喝', '19191919111', '', 0, 0, 6, '0', 0, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, '发发发', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
