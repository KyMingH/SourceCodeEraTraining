# 学员基本信息表 students
INSERT INTO codeera_edusys.students (name, gender, status, birth_date, contact_number, email, emergency_contact, emergency_contact_number, create_by, create_time, update_by, update_time, remark)
VALUES
    ('张三', '男', '正式学员', '2001-05-21', '13800138000', 'zhangsan@example.com', '李四', '13900139000', 'admin', '2024-06-24 10:00:00', 'admin', '2024-06-24 10:05:00', '无特殊情况'),
    ('李华', '女', '试听阶段', '1998-09-15', '13900139001', 'lihua@example.com', '王五', '13700137000', 'admin', '2024-06-24 10:01:00', 'admin', '2024-06-24 10:06:00', '需要特别关注'),
    ('赵六', '男', '请假中', '1995-12-05', '13500135001', 'zhaoliu@example.com', '孙七', '13600136000', 'admin', '2024-06-24 10:02:00', 'admin', '2024-06-24 10:07:00', '已参加过多次活动'),
    ('王红', '女', '正式学员', '1989-08-02', '13400134000', 'wanghong@example.com', '陈八', '13510135100', 'admin', '2024-06-24 10:03:00', 'admin', '2024-06-24 10:08:00', '对课程有浓厚兴趣'),
    ('刘九', '男', '就业中', '1992-11-11', '13200132000', 'liujiu@example.com', '郭十', '13100131000', 'admin', '2024-06-24 10:04:00', 'admin', '2024-06-24 10:09:00', '曾咨询过课程详情');
# 学员状态表 student_status
INSERT INTO codeera_edusys.student_status (student_id, status_type, status_start_date, status_end_date, create_by, create_time, update_by, update_time, remark)
VALUES
    (1, '正式学员', '2024-06-24', NULL, 'admin', '2024-06-24 10:10:00', 'admin', '2024-06-24 10:15:00', '新注册学员'),
    (2, '试听阶段', '2024-06-25', '2024-06-26', 'admin', '2024-06-24 10:11:00', 'admin', '2024-06-24 10:16:00', '参加了两天的试听课程'),
    (3, '请假中', '2024-06-27', '2024-06-29', 'admin', '2024-06-24 10:12:00', 'admin', '2024-06-24 10:17:00', '因私事请假三天'),
    (4, '正式学员', '2024-06-30', NULL, 'admin', '2024-06-24 10:13:00', 'admin', '2024-06-24 10:18:00', '已恢复正常上课'),
    (5, '就业中', '2024-07-01', NULL, 'admin', '2024-06-24 10:14:00', 'admin', '2024-06-24 10:19:00', '已完成所有课程学习');
# 学员意向度记录表 student_intention
INSERT INTO codeera_edusys.student_intention (student_id, intention_description, record_date, follow_up_person, create_by, create_time, update_by, update_time, remark)
VALUES
    (1, '对编程课程感兴趣，询问了课程大纲', '2024-06-24', '刘老师', 'admin', '2024-06-24 10:20:00', 'admin', '2024-06-24 10:25:00', '需要进一步沟通'),
    (2, '考虑报名周末班，需要了解时间安排', '2024-06-25', '王老师', 'admin', '2024-06-24 10:21:00', 'admin', '2024-06-24 10:26:00', '已安排跟进'),
    (3, '对学费有疑虑，需要了解优惠政策', '2024-06-26', '赵老师', 'admin', '2024-06-24 10:22:00', 'admin', '2024-06-24 10:27:00', '已提供优惠政策信息'),
    (4, '对课程质量有疑问，希望了解更多成功案例', '2024-06-27', '陈老师', 'admin', '2024-06-24 10:23:00', 'admin', '2024-06-24 10:28:00', '已发送成功案例资料'),
    (5, '已决定报名，需要办理报名手续', '2024-06-28', '张老师', 'admin', '2024-06-24 10:24:00', 'admin', '2024-06-24 10:29:00', '正在办理报名手续');
# 试听学员管理表 trial_students
INSERT INTO codeera_edusys.trial_students (student_id, trial_course, trial_date, conversion_status, create_by, create_time, update_by, update_time, remark)
VALUES
    (1, 'Python基础课程', '2024-06-25', FALSE, 'admin', '2024-06-24 10:30:00', 'admin', '2024-06-24 10:35:00', '试听后未立即报名'),
    (2, 'Java进阶课程', '2024-06-26', TRUE, 'admin', '2024-06-24 10:31:00', 'admin', '2024-06-24 10:36:00', '试听后决定报名'),
    (3, '前端开发入门', '2024-06-27', FALSE, 'admin', '2024-06-24 10:32:00', 'admin', '2024-06-24 10:37:00', '对课程内容感兴趣，但需要考虑'),
    (4, '数据科学与大数据', '2024-06-28', TRUE, 'admin', '2024-06-24 10:33:00', 'admin', '2024-06-24 10:38:00', '试听后对课程非常满意'),
    (5, '人工智能与机器学习', '2024-06-29', FALSE, 'admin', '2024-06-24 10:34:00', 'admin', '2024-06-24 10:39:00', '需要了解更多课程细节');
# 班级信息表 classes
INSERT INTO codeera_edusys.classes (class_name, start_date, end_date, class_status, create_by, create_time, update_by, update_time, remark)
VALUES
    ('Python编程基础班', '2024-09-01', '2025-01-15', '已开课', 'admin', '2024-06-24 11:00:00', 'admin', '2024-06-24 11:05:00', '基础班，适合初学者'),
    ('Java开发进阶班', '2024-09-02', '2025-01-16', '已开课', 'admin', '2024-06-24 11:01:00', 'admin', '2024-06-24 11:06:00', '适合有一定基础的学员'),
    ('前端开发实战班', '2024-09-03', '2025-01-17', '未开课', 'admin', '2024-06-24 11:02:00', 'admin', '2024-06-24 11:07:00', '实战项目驱动教学'),
    ('数据科学与分析班', '2024-09-04', '2025-01-18', '已结课', 'admin', '2024-06-24 11:03:00', 'admin', '2024-06-24 11:08:00', '已成功结课，学员反馈良好'),
    ('人工智能与机器学习班', '2024-09-05', '2025-01-19', '未开课', 'admin', '2024-06-24 11:04:00', 'admin', '2024-06-24 11:09:00', '热门课程，招生火爆');
# 教师信息表 teachers
INSERT INTO codeera_edusys.teachers (name, contact_number, specialization, create_by, create_time, update_by, update_time, remark)
VALUES
    ('刘老师', '13500012340', 'Python编程', 'admin', '2024-06-24 11:10:00', 'admin', '2024-06-24 11:15:00', '资深Python讲师'),
    ('王老师', '13600023456', 'Java开发', 'admin', '2024-06-24 11:11:00', 'admin', '2024-06-24 11:16:00', 'Java领域专家'),
    ('赵老师', '13700034567', '前端开发', 'admin', '2024-06-24 11:12:00', 'admin', '2024-06-24 11:17:00', '前端技术达人'),
    ('陈老师', '13800045678', '数据科学', 'admin', '2024-06-24 11:13:00', 'admin', '2024-06-24 11:18:00', '数据分析师'),
    ('张老师', '13900056789', '人工智能', 'admin', '2024-06-24 11:14:00', 'admin', '2024-06-24 11:19:00', 'AI领域研究者');
# 班级课表表 class_schedule
INSERT INTO codeera_edusys.class_schedule (class_id, course_name, course_time, teacher_id, create_by, create_time, update_by, update_time, remark)
VALUES
    (1, 'Python基础课程', '2024-09-01 09:00:00', 1, 'admin', '2024-06-24 11:20:00', 'admin', '2024-06-24 11:25:00', '每周一、三、五上午'),
    (2, 'Java进阶课程', '2024-09-02 10:00:00', 2, 'admin', '2024-06-24 11:21:00', 'admin', '2024-06-24 11:26:00', '每周二、四上午'),
    (3, '前端开发实战', '2024-09-03 14:00:00', 3, 'admin', '2024-06-24 11:22:00', 'admin', '2024-06-24 11:27:00', '每周一、三下午'),
    (4, '数据科学导论', '2024-09-04 09:00:00', 4, 'admin', '2024-06-24 11:23:00', 'admin', '2024-06-24 11:28:00', '每周五上午'),
    (5, '机器学习入门', '2024-09-05 10:00:00', 5, 'admin', '2024-06-24 11:24:00', 'admin', '2024-06-24 11:29:00', '每周二、四上午');
# 班级考勤表 class_attendance
INSERT INTO codeera_edusys.class_attendance (class_id, student_id, attendance_date, attendance_status, create_by, create_time, update_by, update_time, remark)
VALUES
    (1, 1, '2024-09-01', '出勤', 'admin', '2024-06-24 11:30:00', 'admin', '2024-06-24 11:35:00', '学员准时到达'),
    (1, 2, '2024-09-01', '迟到', 'admin', '2024-06-24 11:31:00', 'admin', '2024-06-24 11:36:00', '学员迟到10分钟'),
    (2, 3, '2024-09-02', '出勤', 'admin', '2024-06-24 11:32:00', 'admin', '2024-06-24 11:37:00', '学员表现优秀'),
    (3, 4, '2024-09-03', '请假', 'admin', '2024-06-24 11:33:00', 'admin', '2024-06-24 11:38:00', '学员因事请假'),
    (4, 5, '2024-09-04', '出勤', 'admin', '2024-06-24 11:34:00', 'admin', '2024-06-24 11:39:00', '学员积极参与讨论');
# 班级管理操作表 class_management
INSERT INTO codeera_edusys.class_management (class_id, operation_type, operation_date, operator, create_by, create_time, update_by, update_time, remark)
VALUES
    (1, '添加', '2024-06-24 08:00:00', '教务管理员', 'admin', '2024-06-24 12:00:00', 'admin', '2024-06-24 12:05:00', '创建了Python编程基础班'),
    (2, '修改', '2024-06-28 10:00:00', '班主任', 'admin', '2024-06-24 12:10:00', 'admin', '2024-06-24 12:15:00', '调整了Java开发进阶班的课程安排'),
    (3, '修改', '2024-06-29 11:00:00', '教务助理', 'admin', '2024-06-24 12:20:00', 'admin', '2024-06-24 12:25:00', '完成了前端开发实战班学员的注册工作'),
    (4, '删除', '2024-07-01 15:00:00', '教务主任', 'admin', '2024-06-24 12:30:00', 'admin', '2024-06-24 12:35:00', '数据科学与分析班课程结束，班级解散'),
    (5, '修改', '2024-07-02 16:00:00', '课程负责人', 'admin', '2024-06-24 12:40:00', 'admin', '2024-06-24 12:45:00', '收集人工智能与机器学习班的教学反馈');
# 问题学员分类与沟通记录表 problem_student
INSERT INTO codeera_edusys.problem_student (student_id, category, communication_content, communication_date, follow_up_person, create_by, create_time, update_by, update_time, remark)
VALUES
    (2, '学习困难', '学生张三在Python编程课程中遇到理解难题，已安排辅导老师进行一对一辅导。', '2024-06-25', '刘老师', 'admin', '2024-06-24 12:50:00', 'admin', '2024-06-24 12:55:00', '学生反应积极，期待辅导效果'),
    (3, '纪律问题', '学生李华在课堂上玩手机，已进行口头警告，并通知家长。', '2024-06-26', '王老师', 'admin', '2024-06-24 13:00:00', 'admin', '2024-06-24 13:05:00', '家长表示会加强家庭教育'),
    (5, '情绪问题', '学生刘九表现出焦虑情绪，已安排心理老师进行咨询。', '2024-06-27', '陈老师', 'admin', '2024-06-24 13:10:00', 'admin', '2024-06-24 13:15:00', '学生情绪有所缓解，将继续跟进');
# 班级管理日报表 class_daily_report
INSERT INTO codeera_edusys.class_daily_report (class_id, date, report_content, submitter, create_by, create_time, update_by, update_time, remark)
VALUES
    (1, '2024-06-24', 'Python编程基础班今日出勤率95%，学员学习热情高，课堂互动良好。', '班主任', 'admin', '2024-06-24 13:20:00', 'admin', '2024-06-24 13:25:00', '无特殊情况'),
    (2, '2024-06-24', 'Java开发进阶班今日有3名学员请假，课程进度按计划进行。', '助教', 'admin', '2024-06-24 13:30:00', 'admin', '2024-06-24 13:35:00', '请假学员将提供补课'),
    (3, '2024-06-24', '前端开发实战班今日进行了项目实战演练，学员参与度高。', '课程负责人', 'admin', '2024-06-24 13:40:00', 'admin', '2024-06-24 13:45:00', '实战演练效果超出预期');
# 学生请假申请表 student_leave
INSERT INTO codeera_edusys.student_leave (student_id, leave_type, leave_start_date, leave_end_date, approval_status, create_by, create_time, update_by, update_time, remark)
VALUES
    (3, '病假', '2024-06-28', '2024-06-30', '通过', 'admin', '2024-06-24 13:50:00', 'admin', '2024-06-24 13:55:00', '学生因感冒请假，已安排补课'),
    (4, '事假', '2024-07-01', '2024-07-01', '审批中', 'admin', '2024-06-24 14:00:00', 'admin', '2024-06-24 14:05:00', '学生因家庭原因请假一天'),
    (5, '公假', '2024-07-02', '2024-07-02', '通过', 'admin', '2024-06-24 14:10:00', 'admin', '2024-06-24 14:15:00', '学生参加学校组织的活动');
# 留级/休学/退学申请表 student_application
INSERT INTO codeera_edusys.student_application (student_id, application_type, application_date, approval_status, create_by, create_time, update_by, update_time, remark)
VALUES
    (2, '休学', '2024-06-28', '已批准', 'admin', '2024-06-24 14:20:00', 'admin', '2024-06-24 14:25:00', '学生因个人原因申请休学一学期'),
    (4, '留级', '2024-06-29', '审批中', 'admin', '2024-06-24 14:30:00', 'admin', '2024-06-24 14:35:00', '学生因成绩不佳申请留级重修课程'),
    (5, '退学', '2024-06-30', '未批准', 'admin', '2024-06-24 14:40:00', 'admin', '2024-06-24 14:45:00', '学生申请退学，但学校建议其休学调整状态');
# 学生操行分表 student_conduct
INSERT INTO codeera_edusys.student_conduct (student_id, conduct_score, conduct_change_reason, record_date, create_by, create_time, update_by, update_time, remark)
VALUES
    (2, 85, '课堂表现良好，积极参与讨论', '2024-06-25', 'admin', '2024-06-24 14:50:00', 'admin', '2024-06-24 14:55:00', '操行分提升'),
    (3, 75, '迟到一次，扣除5分', '2024-06-26', 'admin', '2024-06-24 15:00:00', 'admin', '2024-06-24 15:05:00', '操行分下降'),
    (5, 90, '帮助其他学员解决问题，操行分奖励', '2024-06-27', 'admin', '2024-06-24 15:10:00', 'admin', '2024-06-24 15:15:00', '操行分奖励');
# 班级活动记录表 class_activities
INSERT INTO codeera_edusys.class_activities (class_id, activity_name, activity_date, activity_description, create_by, create_time, update_by, update_time, remark)
VALUES
    (1, 'Python编程竞赛', '2024-07-10', '班级内部Python编程技能竞赛，增进学员间的交流与合作', 'admin', '2024-06-24 15:20:00', 'admin', '2024-06-24 15:25:00', '竞赛活动已策划完成'),
    (2, 'Java技术研讨会', '2024-07-15', '邀请行业专家进行Java技术分享，提升学员专业技能', 'admin', '2024-06-24 15:30:00', 'admin', '2024-06-24 15:35:00', '研讨会嘉宾已确认'),
    (3, '前端项目展示', '2024-07-20', '学员们展示自己完成的前端项目，接受同学和老师的评价', 'admin', '2024-06-24 15:40:00', 'admin', '2024-06-24 15:45:00', '项目展示准备中');
# 老学员回访记录表 alumni_follow_up
INSERT INTO codeera_edusys.alumni_follow_up (student_id, follow_up_date, follow_up_content, follow_up_person, create_by, create_time, update_by, update_time, remark)
VALUES
    (1, '2024-07-01', '回访毕业学员张三，了解其就业情况及对我们课程的反馈', '就业指导老师', 'admin', '2024-06-24 15:50:00', 'admin', '2024-06-24 15:55:00', '学员对课程表示满意，已成功就业'),
    (3, '2024-07-02', '与毕业学员李华进行职业发展回访，探讨进一步学习的可能性', '职业规划师', 'admin', '2024-06-24 16:00:00', 'admin', '2024-06-24 16:05:00', '学员有意向参加进阶课程'),
    (5, '2024-07-03', '对毕业学员刘九进行回访，询问其对我们教学服务的满意度', '客服经理', 'admin', '2024-06-24 16:10:00', 'admin', '2024-06-24 16:15:00', '学员反馈积极，对服务表示认可');
# 班级会议记录表 class_meetings
INSERT INTO codeera_edusys.class_meetings (class_id, meeting_type, meeting_date, meeting_content, meeting_outcome, create_by, update_by, remark)
VALUES
    (1, '班会', '2024-07-05 09:00:00', '向学员说明新学期Python编程课程的安排和要求。', '会议结束后，学员对课程安排有了清晰的了解。', 'admin', 'admin', '首次课程安排会议'),
    (2, '班会', '2024-10-15 14:00:00', '收集Java开发进阶班学员对目前教学进度的反馈。', '根据学员反馈，调整了部分课程内容和教学方法。', 'admin', 'admin', '期中教学反馈会议'),
    (3, '班会', '2025-01-10 09:00:00', '对前端开发实战班一学期的教学成果进行总结。', '学员普遍反映课程实用，技能提升明显。', 'admin', 'admin', '期末教学成果总结');
# 试听学员沟通记录表 trial_student_communication
INSERT INTO codeera_edusys.trial_student_communication (trial_student_id, communication_date, communication_content, follow_up_actions, create_by, update_by, remark)
VALUES
    (1, '2024-06-25 10:00:00', '与试听学员张三沟通了课程内容和教学方法，学员表示满意。', '安排张三参加下一次的试听课程，并提供课程资料。', 'admin', 'admin', '首次沟通记录'),
    (2, '2024-06-26 11:00:00', '与试听学员李华讨论了课程安排和学习计划，学员有意向报名。', '为李华提供详细的课程安排表，并解答其疑问。', 'admin', 'admin', '学员有报名意向'),
    (3, '2024-06-27 15:00:00', '向试听学员赵六介绍了课程优势和就业前景，学员需要考虑。', '保持联系，一周后再次跟进赵六的考虑情况。', 'admin', 'admin', '学员需要时间考虑');