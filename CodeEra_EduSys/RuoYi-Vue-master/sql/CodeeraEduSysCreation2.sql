use codeera_edusys;
# 班级状态审批表
CREATE TABLE class_status_approval (
                                       approval_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '审批ID（主键）',
                                       class_id BIGINT NOT NULL COMMENT '班级ID（外键，关联class_info）',
                                       approver_content VARCHAR(255) NOT NULL COMMENT '审批内容',
                                       approver VARCHAR(255) NOT NULL COMMENT '审批人',
                                       approval_status VARCHAR(255) NOT NULL DEFAULT '待审批' COMMENT '审批状态',
                                       approval_time DATETIME DEFAULT NULL COMMENT '审批时间',
                                       approval_remark TEXT DEFAULT NULL COMMENT '审批意见',
                                       FOREIGN KEY (class_id) REFERENCES classes(class_id),
                                       create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                       create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                       update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                       update_time DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                       remark TEXT DEFAULT NULL COMMENT '备注'
);
# 学员转正审批表
CREATE TABLE student_regular_approval (
                                          approval_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '审批ID（主键）',
                                          student_id BIGINT NOT NULL COMMENT '学员ID（外键，关联students）',
                                          trial_student_id BIGINT NOT NULL COMMENT '试听学员ID（外键，关联trial_students）',
                                          approver VARCHAR(255) NOT NULL COMMENT '审批人',
                                          approval_status VARCHAR(255) NOT NULL DEFAULT '待审批' COMMENT '审批状态',
                                          approval_time DATETIME DEFAULT NULL COMMENT '审批时间',
                                          approval_remark TEXT DEFAULT NULL COMMENT '审批意见',
                                          create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                          create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                          update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                          update_time DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                          remark TEXT DEFAULT NULL COMMENT '备注',
                                          FOREIGN KEY (student_id) REFERENCES students(student_id),
                                          FOREIGN KEY (trial_student_id) REFERENCES trial_students(student_id)
);
# 学员流程审批表
# 这个表可以是一个通用的审批表，用于管理学员的留级、休学、提前离校、退学等审批流程。

CREATE TABLE student_process_approval (
                                          approval_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '审批ID（主键）',
                                          student_id BIGINT NOT NULL COMMENT '学员ID（外键，关联students）',
                                          process_type VARCHAR(255) NOT NULL COMMENT '审批类型',
                                          approver VARCHAR(255) NOT NULL COMMENT '审批人',
                                          approval_status VARCHAR(255) NOT NULL DEFAULT '待审批' COMMENT '审批状态',
                                          approval_time DATETIME DEFAULT NULL COMMENT '审批时间',
                                          approval_remark TEXT DEFAULT NULL COMMENT '审批意见',
                                          create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                          create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                          update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                          update_time DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                          remark TEXT DEFAULT NULL COMMENT '备注',
                                          FOREIGN KEY (student_id) REFERENCES students(Student_id)
);
# 请假审批表
CREATE TABLE leave_approval (
                                approval_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '审批ID（主键）',
                                leave_id BIGINT NOT NULL COMMENT '请假ID（外键，关联student_leave）',
                                approver VARCHAR(255) NOT NULL COMMENT '审批人',
                                approval_status VARCHAR(255) NOT NULL DEFAULT '待审批' COMMENT '审批状态',
                                approval_time DATETIME DEFAULT NULL COMMENT '审批时间',
                                approval_remark TEXT DEFAULT NULL COMMENT '审批意见',
                                create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                update_time DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                remark TEXT DEFAULT NULL COMMENT '备注',
                                FOREIGN KEY (leave_id) REFERENCES student_leave(leave_id)
);