/*
 Navicat Premium Dump SQL

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80037 (8.0.37)
 Source Host           : localhost:3306
 Source Schema         : cqut

 Target Server Type    : MySQL
 Target Server Version : 80037 (8.0.37)
 File Encoding         : 65001

 Date: 18/06/2024 10:05:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `degree` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `desc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `state` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_UNIQUE`(`id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (2, '梁铭辉', '1', '2003-03-22', '17823768413', '3', '这是chatgpt', '1');
INSERT INTO `student` VALUES (3, '梁呆呆', '1', '2003-03-22', '13690555323', '5', '爱吃橡皮糖，爱玩波波池', '2');
INSERT INTO `student` VALUES (4, '张三', '1', '2002-05-05', '13800138000', '4', '热爱编程，喜欢挑战', '1');
INSERT INTO `student` VALUES (5, '唐花痴', '2', '2024-06-14', '19522007917', '5', '优秀学生', '2');
INSERT INTO `student` VALUES (6, '李四', '2', '2001-09-10', '13900139001', '3', '喜欢阅读和旅行', '2');
INSERT INTO `student` VALUES (7, '王五', '1', '1999-12-31', '13700137001', '5', '篮球爱好者，团队精神强', '1');
INSERT INTO `student` VALUES (8, '赵六', '2', '2005-08-08', '13500135001', '2', '音乐才女，擅长钢琴', '2');
INSERT INTO `student` VALUES (9, '孙七', '1', '2003-07-20', '13400134001', '3', '对科学充满好奇，喜欢探索未知', '1');
INSERT INTO `student` VALUES (10, '周八', '2', '2004-04-01', '13600136001', '4', '艺术设计专业，创意无限', '2');
INSERT INTO `student` VALUES (11, '吴九', '1', '2004-02-15', '13711111111', '3', '热爱运动，尤其擅长足球', '1');
INSERT INTO `student` VALUES (12, '郑十', '2', '2003-11-06', '13722222222', '4', '对历史有浓厚兴趣，喜欢研究古代文明', '2');
INSERT INTO `student` VALUES (13, '钱十一', '1', '2002-08-23', '13733333333', '5', '梦想成为一名宇航员，探索宇宙奥秘', '1');
INSERT INTO `student` VALUES (14, '孙十二', '2', '2005-01-01', '13744444444', '2', '喜欢绘画，作品多次获奖', '2');
INSERT INTO `student` VALUES (15, '周十三', '1', '2001-07-29', '13755555555', '3', '对编程有极高天赋，擅长多种编程语言', '1');
INSERT INTO `student` VALUES (16, '吴十四', '2', '2004-03-17', '13766666666', '4', '热爱文学，梦想成为一名作家', '2');
INSERT INTO `student` VALUES (17, '郑十五', '1', '2003-12-25', '13777777777', '5', '对数学有浓厚兴趣，喜欢解决复杂问题', '1');
INSERT INTO `student` VALUES (18, '钱十六', '2', '2005-09-30', '13788888888', '2', '对自然科学充满好奇，喜欢做实验', '2');
INSERT INTO `student` VALUES (19, '孙十七', '1', '2002-06-18', '13799999999', '3', '热爱音乐，擅长吉他和钢琴', '1');
INSERT INTO `student` VALUES (20, '周十八', '2', '2003-04-05', '13800000000', '4', '对心理学感兴趣，喜欢帮助他人', '2');
INSERT INTO `student` VALUES (21, '凯里欧文', '2', '2003-03-23', 'unknow', '5', '历史最佳控球运动员', '1');

SET FOREIGN_KEY_CHECKS = 1;
