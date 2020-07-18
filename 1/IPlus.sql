--管理员子系统
          --创建管理员表
          CREATE TABLE administrator(
                 aid NUMBER(6) PRIMARY KEY,       --管理员工号
                 apwd VARCHAR2(16) NOT NULL,      --管理员密码
                 aname VARCHAR2(12) NOT NULL      --管理员姓名
          )
          SELECT * FROM administrator
          --创建序列自增工号
          CREATE SEQUENCE seq_administrator start with 100000 INCREMENT BY 1; 
          --录入信息
          INSERT INTO administrator VALUES(seq_administrator.nextval,'ad123456','张三');
          INSERT INTO administrator VALUES(seq_administrator.nextval,'ad123456','李四');
          INSERT INTO administrator VALUES(seq_administrator.nextval,'ad123456','王五');
          INSERT INTO administrator VALUES(seq_administrator.nextval,'ad123456','刘六');
          --创建学科表
          CREATE TABLE subject(
                 suid NUMBER(4) PRIMARY KEY,     --学科编号
                 suname VARCHAR2(20) NOT NULL    --学科名
          )
          --创建序列自增学科号
          CREATE SEQUENCE seq_subject start with 10 INCREMENT BY 10;
          --录入信息
          INSERT INTO subject VALUES(seq_subject.nextval,'语文');
          INSERT INTO subject VALUES(seq_subject.nextval,'数学');
          INSERT INTO subject VALUES(seq_subject.nextval,'英语');
          
          
          --创建班级表
          CREATE TABLE CLASS(
                 cid NUMBER(3) PRIMARY KEY,      --班级编号
                 NUM NUMBER(4) NOT NULL,          --班级人数
          )
          --ALTER TABLE CLASS DROP COLUMN grade
          SELECT * FROM CLASS
          --创建自增序列班级号
          CREATE SEQUENCE seq_class;
          --录入信息
          INSERT INTO CLASS VALUES(seq_class.nextval,30);
          INSERT INTO CLASS VALUES(seq_class.nextval,35);
          INSERT INTO CLASS VALUES(seq_class.nextval,29);
          
          
          
          --创建教师表
          CREATE TABLE teacher(
                 tid NUMBER(7) PRIMARY KEY,       --教师工号
                 tpwd VARCHAR2(16) NOT NULL,      --教师密码
                 tname VARCHAR2(12) NOT NULL,     --教师姓名
                 tgender VARCHAR2(2) NOT NULL,    --教师性别
                 suid NUMBER(4) NOT NULL,          --学科id
                 cid NUMBER(3) NOT NULL           --班级id
          )  
          --创建自增序列教师工号
          CREATE SEQUENCE seq_teacher start with 1000000 INCREMENT BY 1;
          --录入信息
          INSERT INTO teacher VALUES(seq_teacher.nextval,'t123456','张三','男','10','1');
          INSERT INTO teacher VALUES(seq_teacher.nextval,'t123456','李四','男','20','2');
          INSERT INTO teacher VALUES(seq_teacher.nextval,'t123456','王五','男','30','3');
          INSERT INTO teacher VALUES(seq_teacher.nextval,'t123456','刘六','女','10','3');
          
          SELECT * FROM teacher  
          
          --创建学生表
          CREATE TABLE student(
                 SID NUMBER(5) PRIMARY KEY,              --学号
                 spwd VARCHAR2(16) NOT NULL,             --学生密码
                 sname VARCHAR2(12) NOT NULL,            --学生姓名
                 sgender VARCHAR2(2) NOT NULL,           --学生性别
                 cid NUMBER(3) NOT NULL                  --班级id
          )
          --创建自增序列学号
          CREATE SEQUENCE seq_student start with 10000 INCREMENT BY 1;
          --录入信息
          INSERT INTO student VALUES(seq_student.nextval,'s123456','一号学生','男',1)
          INSERT INTO student VALUES(seq_student.nextval,'s123456','二号学生','男',2)
          INSERT INTO student VALUES(seq_student.nextval,'s123456','三号学生','男',3)
          INSERT INTO student VALUES(seq_student.nextval,'s123456','四号学生','男',1)
          INSERT INTO student VALUES(seq_student.nextval,'s123456','五号学生','女',2)
          INSERT INTO student VALUES(seq_student.nextval,'s123456','六号学生','女',3)
          INSERT INTO student VALUES(seq_student.nextval,'s123456','七号学生','女',1)
          INSERT INTO student VALUES(seq_student.nextval,'s123456','八号学生','女',2)
          
          SELECT * FROM student 
            

--教师子系统
        --创建选择题表
        CREATE TABLE xzt(
               xztno NUMBER(7) PRIMARY KEY,
               xztnr VARCHAR2(1000) NOT NULL,
               val NUMBER(2) NOT NULL,
               A VARCHAR(100) NOT NULL,
               B VARCHAR(100) NOT NULL,
               C VARCHAR(100) NOT NULL,
               D VARCHAR(100) NOT NULL,
               answer VARCHAR(100) NOT NULL,
               suid NUMBER(4) NOT NULL
        )
        --创建自增序列选择题号
        CREATE SEQUENCE seq_xzt;
        --插入题目

        INSERT INTO xzt VALUES(seq_xzt.nextval,'下列各组词语中，有错别字的一组是',5,'寒暄 执着 踌躇 众说纷纭','慰藉 隽永 朦胧 眼花瞭乱','鞭笞 赋予 萦绕 出神入化',' 窟窿 穹隆 缥缈 叹为观止','慰藉 隽永 朦胧 眼花瞭乱',10);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'选出下列加点字注音全对的一项',5,'吮吸(shǔn) 涎皮（yán） 敕造（chì） 百无聊赖(lài)','讪讪(shàn) 庠序（xiáng） 俨然(yǎn) 少不更事(jīng)','折本（shé） 干瘪（biě) 谬种(miù) 沸反盈天(fèi)','蹙缩（cù） 驯熟(xùn) 两靥（yàn） 鸡豚狗彘（zhì）','折本（shé） 干瘪（biě) 谬种(miù) 沸反盈天(fèi)',10);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'下列各句中加点词的解释不正确的一项是：',5,'数罟不入洿池 洿：深','养生丧死无憾 憾：遗憾','鸡豚狗彘之蓄 蓄：牲畜','七十者衣帛食肉 衣：穿','鸡豚狗彘之蓄 蓄：牲畜',10);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'下列各句中“之”字用法不同的一项是：',5,'寡人之于国也','谨庠序之教','是寡人之过也','然而不王者，未之有也','然而不王者，未之有也',10);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'与例句句式相同的一句是：（ ）例：树之以桑',5,'非我也，岁也','数口之家可以无饥矣','或五十步而后止','公与之乘，战于长勺','公与之乘，战于长勺',10);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'分母一定，分子和分数值',5,'成正比例','成反比例','不成比例','以上都不对','成正比例',20);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'正方形的边长与它的面积',5,'成正比例','成反比例','不成比例','以上都不对','以上都不对',20);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'一批货物，运出50%，又运进剩下的50%，现在货物与原货物的比是',5,'4:3','3:4','1:1','1:2','3:4',20);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'甲数比乙数大10%，乙数比丙数少10%，甲、丙两数相比',5,'甲大','丙大','甲等于丙','无法确定','无法确定',20);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'表示x和y成正比例关系的式子是',5,'x+y=6','y=2x','xy=7','x=5/y','y=2x',20);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'You can play ____ the clean dog after class',5,'with','in','at','out','with',30);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'Is your mother ____ Huizhou? Yes,she is',5,'live','goes to','visiting','in','live',30);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'Where ____ you this morning? I ____ at a meeting',5,'were,was','are,am','do,am','were,am','were,was',30);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'Her brother is a policeman.He works in a ____',5,'post office','police station','office','station','police station',30);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'What is the weather like today? It is',5,'rain','windy','sun','moon','windy',30);

        
      
        
        --创建主观题表
        CREATE TABLE zgt (
               zgtno NUMBER(7) PRIMARY KEY,
               zgtnr VARCHAR2(1000) NOT NULL,
               val NUMBER(2) NOT NULL,
               STANDARD VARCHAR2(1000)  NOT NULL,
               suid NUMBER(4) NOT NULL
        )
        --创建自增序列主观题号
        CREATE SEQUENCE seq_zgt;
        --插入题目
        INSERT INTO zgt VALUES(seq_zgt.nextval,'中国四大名著是什么',10,'《三国演义》,《水浒传》,《红楼梦》,《西游记》',10);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'《红楼梦》的曾用书名是什么',10,'《石头记》',10);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'唐僧的三个徒弟是',10,'孙悟空，猪八戒，沙和尚',10);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'《水浒传》中那位是打虎英雄',10,'武松',10);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'“桃园三结义”是指的哪三位',10,'刘备，关羽，张飞',10);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'8除以它的倒数，商是',10,'64',20);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'2003年世界人口是6179300000，这个数省略“亿”后面的尾数约是多少亿',10,'61',20);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'把4千克糖果平均分成5份，每份糖果重多少千克',10,'0.8',20);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'刚刚和军军拥有邮票张数的比是4:3，刚刚有邮票64张，军军有邮票多少张',10,'48',20);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'一项工程，甲、乙合作6天完成，甲单独做需要10天，乙队单独做需要多少天',10,'15',20);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'“火车”对应的英文单词是',10,'train',30);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'“飞机”对应的英文单词是',10,'airplane',30);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'“地铁”对应的英文单词是',10,'subway',30);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'“记住”对应的英文单词是',10,'remerber',30);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'“走路”对应的英文单词是',10,'walk',30);
        
        
      --创建考试表
        CREATE TABLE tests(
               testsno NUMBER(4) PRIMARY KEY,
               condition NUMBER(1) DEFAULT(1)NOT NULL,
               cid NUMBER(3) NOT NULL,
               suid NUMBER(4) NOT NULL
        )
        --创建序列  
        CREATE SEQUENCE seq_tests;
        SELECT * FROM tests FOR UPDATE
        
        --创建待批改试卷表
        CREATE TABLE forcorrect(
               fcno NUMBER(4) PRIMARY KEY,
               xztmark NUMBER(2)NOT NULL,
               zgtno1 NUMBER(7)NOT NULL,
               zgtda1 VARCHAR2(1000)NOT NULL,
               zgtno2 NUMBER(7)NOT NULL,
               zgtda2 VARCHAR2(1000)NOT NULL,
               condition number(1)DEFAULT(1)NOT NULL,
               testsno NUMBER(4)NOT NULL,
               suid NUMBER(4)NOT NULL,
               SID NUMBER(5) NOT NULL
        )
       --创建自增序列
        CREATE SEQUENCE forcorrect_tests;
        SELECT * FROM forcorrect FOR UPDATE
        SELECT * FROM forcorrect WHERE testsno=16 AND SID=10000
        --创建批改完的试卷表
        CREATE TABLE corrected(
               cedno NUMBER(4) PRIMARY KEY,
               xztmark NUMBER(2) NOT NULL,
               zgtmark NUMBER(2) NOT NULL,
               allmarker NUMBER(2) NOT NULL,
               tid NUMBER(7) NOT NULL,
               testsno NUMBER(4)NOT NULL,
               suid NUMBER(4)NOT NULL,
               SID NUMBER(5) NOT NULL
        )
       --创建序列
        CREATE SEQUENCE seq_corrected;
        SELECT * FROM forcorrect FOR UPDATE
        

