/*
 Navicat Premium Data Transfer

 Source Server         : 112.74.47.66_3306
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : 112.74.47.66:3306
 Source Schema         : 09.Spring-Boot-Redis-Cache

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 17/05/2022 00:18:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sno` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sname` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ssex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('001', '康康', 'M');
INSERT INTO `student` VALUES ('002', 'trump', 'M');
INSERT INTO `student` VALUES ('003', 'obama', 'M');
INSERT INTO `student` VALUES ('004', 'hillary', 'F');

SET FOREIGN_KEY_CHECKS = 1;
