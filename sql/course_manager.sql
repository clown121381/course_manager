/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : course_manager

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 08/05/2020 14:27:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for choose_list
-- ----------------------------
DROP TABLE IF EXISTS `choose_list`;
CREATE TABLE `choose_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NULL DEFAULT NULL,
  `teacher_id` int(11) NULL DEFAULT NULL,
  `design_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKft3egnd95iyh6o8qwow7ikn81`(`design_id`) USING BTREE,
  INDEX `FK42d9oy6b9hr2ohonuw4jcy8by`(`student_id`) USING BTREE,
  INDEX `FKrt80ustfdwptbfkvbv8s6kmrb`(`teacher_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of choose_list
-- ----------------------------
INSERT INTO `choose_list` VALUES (6, 311, 16, 1);
INSERT INTO `choose_list` VALUES (7, 318, 16, 1);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `is_del` bit(1) NOT NULL,
  `weight` double NULL DEFAULT NULL,
  `course_id` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `total_score` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKsybhlxoejr4j3teomm5u2bx1n`(`teacher_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (14, 'Web系统框架-成绩单-测试用', 16, b'0', 1, 'X0601000', 3);
INSERT INTO `course` VALUES (18, 'golang核心编程-成绩单-测试用', 16, b'0', 1, 'X0601001', 2);

-- ----------------------------
-- Table structure for design
-- ----------------------------
DROP TABLE IF EXISTS `design`;
CREATE TABLE `design`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of design
-- ----------------------------
INSERT INTO `design` VALUES (1, '微信小程序');
INSERT INTO `design` VALUES (2, 'Web/微服务');
INSERT INTO `design` VALUES (3, '移动开发');
INSERT INTO `design` VALUES (4, '当前企业实习项目');

-- ----------------------------
-- Table structure for s_c_many_to_many
-- ----------------------------
DROP TABLE IF EXISTS `s_c_many_to_many`;
CREATE TABLE `s_c_many_to_many`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `score` double(5, 0) NOT NULL,
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKolr7wsbu6b50x41xg5nsdonyv`(`course_id`) USING BTREE,
  INDEX `FK4xjrg061sbe0t2aa8m6ik1vgi`(`student_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 370 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of s_c_many_to_many
-- ----------------------------
INSERT INTO `s_c_many_to_many` VALUES (327, 81, 14, 347);
INSERT INTO `s_c_many_to_many` VALUES (326, 71, 14, 346);
INSERT INTO `s_c_many_to_many` VALUES (325, 67, 14, 345);
INSERT INTO `s_c_many_to_many` VALUES (324, 80, 14, 344);
INSERT INTO `s_c_many_to_many` VALUES (323, 62, 14, 343);
INSERT INTO `s_c_many_to_many` VALUES (322, 94, 14, 342);
INSERT INTO `s_c_many_to_many` VALUES (321, 67, 14, 341);
INSERT INTO `s_c_many_to_many` VALUES (320, 83, 14, 340);
INSERT INTO `s_c_many_to_many` VALUES (319, 70, 14, 339);
INSERT INTO `s_c_many_to_many` VALUES (318, 86, 14, 338);
INSERT INTO `s_c_many_to_many` VALUES (317, 71, 14, 337);
INSERT INTO `s_c_many_to_many` VALUES (316, 82, 14, 336);
INSERT INTO `s_c_many_to_many` VALUES (315, 71, 14, 335);
INSERT INTO `s_c_many_to_many` VALUES (314, 77, 14, 334);
INSERT INTO `s_c_many_to_many` VALUES (313, 48, 14, 333);
INSERT INTO `s_c_many_to_many` VALUES (312, 92, 14, 332);
INSERT INTO `s_c_many_to_many` VALUES (311, 46, 14, 331);
INSERT INTO `s_c_many_to_many` VALUES (310, 49, 14, 330);
INSERT INTO `s_c_many_to_many` VALUES (309, 86, 14, 329);
INSERT INTO `s_c_many_to_many` VALUES (308, 51, 14, 328);
INSERT INTO `s_c_many_to_many` VALUES (307, 72, 14, 327);
INSERT INTO `s_c_many_to_many` VALUES (306, 47, 14, 326);
INSERT INTO `s_c_many_to_many` VALUES (305, 72, 14, 325);
INSERT INTO `s_c_many_to_many` VALUES (304, 67, 14, 324);
INSERT INTO `s_c_many_to_many` VALUES (303, 76, 14, 323);
INSERT INTO `s_c_many_to_many` VALUES (302, 94, 14, 322);
INSERT INTO `s_c_many_to_many` VALUES (301, 46, 14, 321);
INSERT INTO `s_c_many_to_many` VALUES (300, 87, 14, 320);
INSERT INTO `s_c_many_to_many` VALUES (299, 79, 14, 319);
INSERT INTO `s_c_many_to_many` VALUES (298, 97, 14, 318);
INSERT INTO `s_c_many_to_many` VALUES (297, 50, 14, 317);
INSERT INTO `s_c_many_to_many` VALUES (296, 66, 14, 316);
INSERT INTO `s_c_many_to_many` VALUES (295, 62, 14, 315);
INSERT INTO `s_c_many_to_many` VALUES (294, 50, 14, 314);
INSERT INTO `s_c_many_to_many` VALUES (293, 73, 14, 313);
INSERT INTO `s_c_many_to_many` VALUES (292, 72, 14, 312);
INSERT INTO `s_c_many_to_many` VALUES (291, 91, 14, 311);
INSERT INTO `s_c_many_to_many` VALUES (334, 72, 18, 312);
INSERT INTO `s_c_many_to_many` VALUES (333, 91, 18, 311);
INSERT INTO `s_c_many_to_many` VALUES (335, 73, 18, 313);
INSERT INTO `s_c_many_to_many` VALUES (336, 50, 18, 314);
INSERT INTO `s_c_many_to_many` VALUES (337, 62, 18, 315);
INSERT INTO `s_c_many_to_many` VALUES (338, 66, 18, 316);
INSERT INTO `s_c_many_to_many` VALUES (339, 50, 18, 317);
INSERT INTO `s_c_many_to_many` VALUES (340, 97, 18, 318);
INSERT INTO `s_c_many_to_many` VALUES (341, 79, 18, 319);
INSERT INTO `s_c_many_to_many` VALUES (342, 87, 18, 320);
INSERT INTO `s_c_many_to_many` VALUES (343, 46, 18, 321);
INSERT INTO `s_c_many_to_many` VALUES (344, 94, 18, 322);
INSERT INTO `s_c_many_to_many` VALUES (345, 76, 18, 323);
INSERT INTO `s_c_many_to_many` VALUES (346, 67, 18, 324);
INSERT INTO `s_c_many_to_many` VALUES (347, 72, 18, 325);
INSERT INTO `s_c_many_to_many` VALUES (348, 47, 18, 326);
INSERT INTO `s_c_many_to_many` VALUES (349, 72, 18, 327);
INSERT INTO `s_c_many_to_many` VALUES (350, 51, 18, 328);
INSERT INTO `s_c_many_to_many` VALUES (351, 86, 18, 329);
INSERT INTO `s_c_many_to_many` VALUES (352, 49, 18, 330);
INSERT INTO `s_c_many_to_many` VALUES (353, 46, 18, 331);
INSERT INTO `s_c_many_to_many` VALUES (354, 92, 18, 332);
INSERT INTO `s_c_many_to_many` VALUES (355, 48, 18, 333);
INSERT INTO `s_c_many_to_many` VALUES (356, 77, 18, 334);
INSERT INTO `s_c_many_to_many` VALUES (357, 71, 18, 335);
INSERT INTO `s_c_many_to_many` VALUES (358, 82, 18, 336);
INSERT INTO `s_c_many_to_many` VALUES (359, 71, 18, 337);
INSERT INTO `s_c_many_to_many` VALUES (360, 86, 18, 338);
INSERT INTO `s_c_many_to_many` VALUES (361, 70, 18, 339);
INSERT INTO `s_c_many_to_many` VALUES (362, 83, 18, 340);
INSERT INTO `s_c_many_to_many` VALUES (363, 67, 18, 341);
INSERT INTO `s_c_many_to_many` VALUES (364, 94, 18, 342);
INSERT INTO `s_c_many_to_many` VALUES (365, 62, 18, 343);
INSERT INTO `s_c_many_to_many` VALUES (366, 80, 18, 344);
INSERT INTO `s_c_many_to_many` VALUES (367, 67, 18, 345);
INSERT INTO `s_c_many_to_many` VALUES (368, 71, 18, 346);
INSERT INTO `s_c_many_to_many` VALUES (369, 81, 18, 347);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `school_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 349 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (347, '彭兰一香', '2017224492', '$2a$10$4U/H1LiHN6kUjzSfSPdLpey3lQhILz7oTc5tksh1xl7f/BVgPaqrG');
INSERT INTO `student` VALUES (346, '刘楠', '2017224465', '$2a$10$N5oRHcToNcb4ZQmTBylYeOmw.CAvT6N2UJxZ8suU7RhIQ2cMUFCOW');
INSERT INTO `student` VALUES (345, '敖婷婷', '2017224446', '$2a$10$WTW1Mj47h430zfLWv0FobOlvlagQUmHVO2xhBxyPj5dn3M1wuhUTC');
INSERT INTO `student` VALUES (344, '夏彤彤', '2017224420', '$2a$10$pDcWc2NrR.LE1yiOoBwmv.BvQYzHfFx9WWas1e4zeOEAcVsi06YLW');
INSERT INTO `student` VALUES (343, '娄静', '2017224417', '$2a$10$UBLIKqzLQB3xWxO0fJaYIO4oVTnMN1noNAO0zGxPBYjmXB3b2RtJe');
INSERT INTO `student` VALUES (340, '沈鑫', '2017214374', '$2a$10$uWUROs/QtAogIiGM1zMt4uJfC.jaG0gNzfuH6XnHoh5Bh7WiiO4hq');
INSERT INTO `student` VALUES (342, '傅芳杰', '2017214383', '$2a$10$xMDBHBqBPybGbhFPwVD1GuSYkUn8oe7/4JkzNxFVk8Q1enia5KFbu');
INSERT INTO `student` VALUES (341, '严文龙', '2017214378', '$2a$10$hSwNUfiU9h3mVslAx/ZEhum7.vZmZfphq0ud5JT30O0tlOT.kkNCW');
INSERT INTO `student` VALUES (339, '吕哲心', '2017214372', '$2a$10$SEFTuWxdU9MjMkP5OOrtUuWUaSYYa.WPCISW6GUxTGGFN4FRD6qK6');
INSERT INTO `student` VALUES (338, '高庆祝', '2017214369', '$2a$10$0o/OYPRrgh2xzg4cEDaVcutbAocqXjsq25UvEpsEvL3/7/Ynnwv1u');
INSERT INTO `student` VALUES (337, '郝正男', '2017214355', '$2a$10$SWiUwHxYACcdN/CljKOvj.HTUYgG/mGROGAAr8j0zUUThwpNDfFXG');
INSERT INTO `student` VALUES (336, '左德宝', '2017214352', '$2a$10$b2Qqc/urpc346BpuRt8AEe1yHDlQgoRqnT44xVS59my0KlbTMlcl6');
INSERT INTO `student` VALUES (335, '王思懿', '2017214345', '$2a$10$K0UofueRsl7Kjmi/Bqkjd.Jqp7gPKQ1iCKe8L7Q2682xmTGmFYDJq');
INSERT INTO `student` VALUES (334, '庞晨', '2017214342', '$2a$10$A0nug8Jkgt7V6.KIbdpYueAaMkXS6AAutr/4eDxSpkaCI4YqJOeXy');
INSERT INTO `student` VALUES (333, '张文翔', '2017214327', '$2a$10$ImYoWJie98ng7U5VUgxRS.OEpWPRCqZpcJNVEeCmqa3NizE34fLQ6');
INSERT INTO `student` VALUES (332, '姚世维', '2017214326', '$2a$10$PmdK5Dp/Kb04FHSbhhpmkee/jwk/O1ME5oRvOrA3pBxhEoozgz5SS');
INSERT INTO `student` VALUES (331, '徐斌', '2017214323', '$2a$10$ZJXypqSjj0r3sJM7SGKIgem/6oeRDj6xmbY35cOwVgzAFg6d6bvh.');
INSERT INTO `student` VALUES (328, '管作达', '2017214310', '$2a$10$ADxEkF3ERZJ6wT5u9tXg4.30ea13ddZVepzHJ.hKpnDLZmuNzwG7y');
INSERT INTO `student` VALUES (330, '王子阳', '2017214320', '$2a$10$XlCCOvfZavQ8UxXwc5/LyuDBwpOayATaWLiML3a2X9Y/Gwv1u8nUC');
INSERT INTO `student` VALUES (329, '谭文韬', '2017214317', '$2a$10$npW3ZR85X6ocTdJrc5es5uqJwocVI1oFAxOYh.5IVPT64JXrDju6O');
INSERT INTO `student` VALUES (327, '陈俊伯', '2017214307', '$2a$10$W9tj7RSYOArJTmpH6xS62O5V8hCaYHgoHmN8yxQrYo/MsskBHOcnq');
INSERT INTO `student` VALUES (326, '熊曦', '2017214271', '$2a$10$qRGs0eG0hqdIth6WFCzX.u6nUP5ZoHG56UOFwZqJH/6Hxe.NExuPm');
INSERT INTO `student` VALUES (323, '李景阳', '2017214239', '$2a$10$YWAtI7M8JTYEslTLyd/XRuJ/8Hy5zesSAGOaCZpF89Gocctch7dAK');
INSERT INTO `student` VALUES (325, '尚飞跃', '2017214265', '$2a$10$gDNcCkWMph/NGUzRnAT/jOY6gvlIJn8w0VrjwBoIQhkhQFIna0sia');
INSERT INTO `student` VALUES (324, '李一锋', '2017214241', '$2a$10$2fBrc5LU9NlcGn8CvneV1esd3Q7OcuoDjgTrjr.Uy47D.RSA1WSOq');
INSERT INTO `student` VALUES (322, '战浩宇', '2017214232', '$2a$10$w3IKZu9JehAX1DQs/3LbR.leQpGHFrMzfX3xn0ttpEvON5SCQ3h02');
INSERT INTO `student` VALUES (321, '覃玉锦', '2017214228', '$2a$10$oKOLUxqiB9UBW4eaSPAlyOLeYse9s0vH8WbkJ.soeWa1VCbDfVSbq');
INSERT INTO `student` VALUES (320, '季晓亮', '2017214221', '$2a$10$g88gtv/ynEABUlWRLVrRceZ89bPWSWs5Tsu/sICRQqBbbi/Ey.AUe');
INSERT INTO `student` VALUES (319, '高睿杰', '2017214218', '$2a$10$BsMwv6/0cSn4vlwGpgD2jeOTCOUFg88r.j/Mq2nvU7xCIDyEFuEpe');
INSERT INTO `student` VALUES (318, '张师原', '2017214216', '$2a$10$jX2SAJDreavwRkN.0QAynO4L8QDPEzaJ3bGKE388QMjH2KYXyWk5y');
INSERT INTO `student` VALUES (317, '张澎', '2017214215', '$2a$10$b21j8nYlnqlXPP0BOg1G6e1cuwwTF93C4oEBYJP7.lXXLigvr1drq');
INSERT INTO `student` VALUES (316, '杨恩宇', '2017214213', '$2a$10$AXyAyqunD5sSNLoFEXsNzeW3pRI20YjBX1evv0bU6Su4h//GrowrC');
INSERT INTO `student` VALUES (315, '郝伟', '2017214206', '$2a$10$aHsf3nVP9J9kJBptvmkI8.T.XnKJxGyFWe7i0G1HjWTFd8lUlvs6.');
INSERT INTO `student` VALUES (314, '董天宇', '2017214203', '$2a$10$7PlpfnBXDRaqHUnsY5P7JuwS/kmWxRV1TJKCnEcyV45X8Z6yynyeu');
INSERT INTO `student` VALUES (312, '高尔健', '2017214169', '$2a$10$aXy2VFTv9hArqtk2dQTUm.dbctzHy4rQcOe9NKByi.HHAv7mx6QNS');
INSERT INTO `student` VALUES (313, '郭子钰', '2017214186', '$2a$10$G9KZsqqE8cQPiV51/mMQyee1sm0vPpe3Ip/Op/o8JOtBjsX10psv.');
INSERT INTO `student` VALUES (311, '冯永民', '2016214390', '$2a$10$1FQ2TRESlOQ8Xq9GHF/dKeMz5MN4AhQbaSlb0taWtDBsRAEvnBJLG');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `school_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '张玲', '2008214210', '$2a$10$nrpM1H9Qmd4PRLnzlXW4w.YAVHlxb3jxwBVxH4euK5bp9.4uv9K/e');
INSERT INTO `teacher` VALUES (4, 'zhangsan', '2008214213', '$2a$10$RHxsAlpXmshAQO6COSmW9uMPee.V1Igxlb9NklVe3PRrv4SN0ntEe');
INSERT INTO `teacher` VALUES (5, 'zhangsi', '2008214214', '$2a$10$CcwopKkIfrE4vbUQDCKLAu17k7azLcunuYaqgWyqKION0AFflXH6C');
INSERT INTO `teacher` VALUES (6, 'zhangwu', '2008214215', '$2a$10$higLTdTIm.Nx839EgAFFM.6H.8wEEKSrlH0mwTy6eHH6ZqFEtVHYi');
INSERT INTO `teacher` VALUES (7, 'zhangliu', '2008214216', '$2a$10$ET0Jk0.tgVqBsF03dLxseOYjgAxnJUKLOOa1IuUD4ucm69uLvW136');
INSERT INTO `teacher` VALUES (8, 'zhangqi', '2008214217', '$2a$10$bu9XfrhocYyTQchCZDeoUOBcRuqjpsr/sc.VQKfetM/1ItHaucDWi');
INSERT INTO `teacher` VALUES (9, 'zhangba', '2008214218', '$2a$10$ohos92MErA.MFnj2e1SQAeSXPZw5jU9aD.bhcBoc7juAo9YGuD66G');
INSERT INTO `teacher` VALUES (10, 'zhangjiu', '2008214219', '$2a$10$TZaf.NlEpzyYUbPuCIOAYepBC/1wkuNptYtIJGMBMNdvCW6O0FS4W');
INSERT INTO `teacher` VALUES (16, '王波', '1020090008', '$2a$10$xvVQrUNu1bLgh4sZJpu34OiUcnLy5SduiJ7kRot.tQoZ6zza4t0Fu');

SET FOREIGN_KEY_CHECKS = 1;
