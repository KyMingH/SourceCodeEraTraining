-- 学员基本信息表
CREATE TABLE codeera_edusys.students (
                                         student_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '学员ID',
                                         name VARCHAR(255) NOT NULL COMMENT '姓名',
                                         gender VARCHAR(10) COMMENT '性别',
                                         status varchar(255) DEFAULT NULL COMMENT '学员状态',
                                         birth_date DATE COMMENT '出生日期',
                                         contact_number VARCHAR(20) COMMENT '联系电话',
                                         email VARCHAR(255) COMMENT '电子邮箱',
                                         emergency_contact VARCHAR(255) COMMENT '紧急联系人',
                                         emergency_contact_number VARCHAR(20) COMMENT '紧急联系人电话',
                                         create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                         create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                         update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                         update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                         remark VARCHAR(500) DEFAULT NULL COMMENT '备注'
);

-- 学员状态表
CREATE TABLE codeera_edusys.student_status (
                                               status_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '状态ID',
                                               student_id BIGINT COMMENT '学员ID',
                                               status_type VARCHAR(50) COMMENT '状态类型',
                                               status_start_date DATE COMMENT '状态开始日期',
                                               status_end_date DATE COMMENT '状态结束日期',
                                               create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                               create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                               update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                               update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                               remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
                                               FOREIGN KEY (student_id) REFERENCES codeera_edusys.students(student_id)
);

-- 学员意向度记录表
CREATE TABLE codeera_edusys.student_intention (
                                                  record_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '记录ID',
                                                  student_id BIGINT COMMENT '学员ID',
                                                  intention_description TEXT COMMENT '意向描述',
                                                  record_date DATE COMMENT '记录日期',
                                                  follow_up_person VARCHAR(255) COMMENT '跟进人',
                                                  create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                                  create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                                  update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                                  update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                                  remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
                                                  FOREIGN KEY (student_id) REFERENCES codeera_edusys.students(student_id)
);

-- 试听学员管理表
CREATE TABLE codeera_edusys.trial_students (
                                               trial_student_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '试听学员ID',
                                               student_id BIGINT COMMENT '学员ID',
                                               trial_course VARCHAR(255) COMMENT '试听课程',
                                               trial_date DATE COMMENT '试听日期',
                                               conversion_status BOOLEAN COMMENT '转化状态',
                                               create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                               create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                               update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                               update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                               remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
                                               FOREIGN KEY (student_id) REFERENCES codeera_edusys.students(student_id)
);

-- 班级信息表
CREATE TABLE codeera_edusys.classes (
                                        class_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '班级ID',
                                        class_name VARCHAR(255) COMMENT '班级名称',
                                        start_date DATE COMMENT '开始日期',
                                        end_date DATE COMMENT '结束日期',
                                        class_status VARCHAR(50) COMMENT '班级状态',
                                        create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                        create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                        update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                        update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                        remark VARCHAR(500) DEFAULT NULL COMMENT '备注'
);

-- 教师信息表
CREATE TABLE codeera_edusys.teachers (
                                         teacher_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '教师ID',
                                         name VARCHAR(255) COMMENT '姓名',
                                         contact_number VARCHAR(20) COMMENT '联系电话',
                                         specialization VARCHAR(255) COMMENT '专业领域',
                                         create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                         create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                         update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                         update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                         remark VARCHAR(500) DEFAULT NULL COMMENT '备注'
);

-- 班级课表表
CREATE TABLE codeera_edusys.class_schedule (
                                               schedule_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '课表ID',
                                               class_id BIGINT COMMENT '班级ID',
                                               course_name VARCHAR(255) COMMENT '课程名称',
                                               course_time DATETIME COMMENT '课程时间',
                                               teacher_id BIGINT COMMENT '教师ID',
                                               create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                               create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                               update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                               update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                               remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
                                               FOREIGN KEY (class_id) REFERENCES codeera_edusys.classes(class_id)
    -- 需要先创建教师信息表，教师ID的外键约束将在此表创建后添加
);

-- 班级考勤表
CREATE TABLE codeera_edusys.class_attendance (
                                                 attendance_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '考勤ID',
                                                 class_id BIGINT COMMENT '班级ID',
                                                 student_id BIGINT COMMENT '学员ID',
                                                 attendance_date DATE COMMENT '考勤日期',
                                                 attendance_status VARCHAR(50) COMMENT '考勤状态',
                                                 create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                                 create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                                 update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                                 update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                                 remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
                                                 FOREIGN KEY (class_id) REFERENCES codeera_edusys.classes(class_id),
                                                 FOREIGN KEY (student_id) REFERENCES codeera_edusys.students(student_id)
);

-- 班级管理操作表
CREATE TABLE codeera_edusys.class_management (
                                                 operation_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '操作ID',
                                                 class_id BIGINT COMMENT '班级ID',
                                                 operation_type VARCHAR(50) COMMENT '操作类型',
                                                 operation_date DATETIME COMMENT '操作日期',
                                                 operator VARCHAR(255) COMMENT '操作员',
                                                 create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                                 create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                                 update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                                 update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                                 remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
                                                 FOREIGN KEY (class_id) REFERENCES codeera_edusys.classes(class_id)
);

-- 问题学员分类与沟通记录表
CREATE TABLE codeera_edusys.problem_student (
                                                record_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '记录ID',
                                                student_id BIGINT COMMENT '学员ID',
                                                category VARCHAR(255) COMMENT '分类',
                                                communication_content TEXT COMMENT '沟通内容',
                                                communication_date DATE COMMENT '沟通日期',
                                                follow_up_person VARCHAR(255) COMMENT '跟进人',
                                                create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                                create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                                update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                                update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                                remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
                                                FOREIGN KEY (student_id) REFERENCES codeera_edusys.students(student_id)
);

-- 班级管理日报表
CREATE TABLE codeera_edusys.class_daily_report (
                                                   report_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '报告ID',
                                                   class_id BIGINT COMMENT '班级ID',
                                                   date DATE COMMENT '日期',
                                                   report_content TEXT COMMENT '报告内容',
                                                   submitter VARCHAR(255) COMMENT '提交者',
                                                   create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                                   create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                                   update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                                   update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                                   remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
                                                   FOREIGN KEY (class_id) REFERENCES codeera_edusys.classes(class_id)
);

-- 学生请假申请表
CREATE TABLE codeera_edusys.student_leave (
                                              leave_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '请假ID',
                                              student_id BIGINT COMMENT '学员ID',
                                              leave_type VARCHAR(50) COMMENT '请假类型',
                                              leave_start_date DATE COMMENT '请假开始日期',
                                              leave_end_date DATE COMMENT '请假结束日期',
                                              approval_status VARCHAR(50) COMMENT '审批状态',
                                              create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                              create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                              update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                              update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                              remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
                                              FOREIGN KEY (student_id) REFERENCES codeera_edusys.students(student_id)
);

-- 留级/休学/退学申请表
CREATE TABLE codeera_edusys.student_application (
                                                    application_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '申请ID',
                                                    student_id BIGINT COMMENT '学员ID',
                                                    application_type VARCHAR(50) COMMENT '申请类型',
                                                    application_date DATE COMMENT '申请日期',
                                                    approval_status VARCHAR(50) COMMENT '审批状态',
                                                    create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                                    create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                                    update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                                    update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                                    remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
                                                    FOREIGN KEY (student_id) REFERENCES codeera_edusys.students(student_id)
);

-- 学生操行分表
CREATE TABLE codeera_edusys.student_conduct (
                                                conduct_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '操行分ID',
                                                student_id BIGINT COMMENT '学员ID',
                                                conduct_score INT COMMENT '操行分',
                                                conduct_change_reason TEXT COMMENT '操行分变动原因',
                                                record_date DATE COMMENT '记录日期',
                                                create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                                create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                                update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                                update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                                remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
                                                FOREIGN KEY (student_id) REFERENCES codeera_edusys.students(student_id)
);

-- 班级活动记录表
CREATE TABLE codeera_edusys.class_activities (
                                                 activity_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '活动ID',
                                                 class_id BIGINT COMMENT '班级ID',
                                                 activity_name VARCHAR(255) COMMENT '活动名称',
                                                 activity_date DATE COMMENT '活动日期',
                                                 activity_description TEXT COMMENT '活动描述',
                                                 create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                                 create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                                 update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                                 update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                                 remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
                                                 FOREIGN KEY (class_id) REFERENCES codeera_edusys.classes(class_id)
);

-- 老学员回访记录表
CREATE TABLE codeera_edusys.alumni_follow_up (
                                                 follow_up_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '回访ID',
                                                 student_id BIGINT COMMENT '学员ID',
                                                 follow_up_date DATE COMMENT '回访日期',
                                                 follow_up_content TEXT COMMENT '回访内容',
                                                 follow_up_person VARCHAR(255) COMMENT '回访人',
                                                 create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                                 create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                                 update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                                 update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                                 remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
                                                 FOREIGN KEY (student_id) REFERENCES codeera_edusys.students(student_id)
);

CREATE TABLE codeera_edusys.class_meetings (
                                meeting_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '会议ID（主键）',
                                class_id BIGINT NOT NULL COMMENT '班级ID（外键，关联classes）',
                                meeting_type VARCHAR(100) DEFAULT NULL COMMENT '会议类型',
                                meeting_date DATETIME NOT NULL COMMENT '会议日期',
                                meeting_content TEXT COMMENT '会议内容',
                                meeting_outcome TEXT COMMENT '会议结果或决议',
                                create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                update_time DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
                                FOREIGN KEY (class_id) REFERENCES classes(class_id)
);

CREATE TABLE codeera_edusys.trial_student_communication (
                                             communication_id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '沟通记录ID（主键）',
                                             trial_student_id BIGINT COMMENT '试听学员ID（外键，关联trial_students）',
                                             communication_date DATETIME COMMENT '沟通日期',
                                             communication_content TEXT COMMENT '沟通内容',
                                             follow_up_actions TEXT COMMENT '后续行动计划',
                                             create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
                                             create_time DATETIME DEFAULT NULL COMMENT '创建时间',
                                             update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
                                             update_time DATETIME DEFAULT NULL COMMENT '更新时间',
                                             remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
                                             FOREIGN KEY (trial_student_id) REFERENCES trial_students(trial_student_id)
);