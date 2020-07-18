--����Ա��ϵͳ
          --��������Ա��
          CREATE TABLE administrator(
                 aid NUMBER(6) PRIMARY KEY,       --����Ա����
                 apwd VARCHAR2(16) NOT NULL,      --����Ա����
                 aname VARCHAR2(12) NOT NULL      --����Ա����
          )
          SELECT * FROM administrator
          --����������������
          CREATE SEQUENCE seq_administrator start with 100000 INCREMENT BY 1; 
          --¼����Ϣ
          INSERT INTO administrator VALUES(seq_administrator.nextval,'ad123456','����');
          INSERT INTO administrator VALUES(seq_administrator.nextval,'ad123456','����');
          INSERT INTO administrator VALUES(seq_administrator.nextval,'ad123456','����');
          INSERT INTO administrator VALUES(seq_administrator.nextval,'ad123456','����');
          --����ѧ�Ʊ�
          CREATE TABLE subject(
                 suid NUMBER(4) PRIMARY KEY,     --ѧ�Ʊ��
                 suname VARCHAR2(20) NOT NULL    --ѧ����
          )
          --������������ѧ�ƺ�
          CREATE SEQUENCE seq_subject start with 10 INCREMENT BY 10;
          --¼����Ϣ
          INSERT INTO subject VALUES(seq_subject.nextval,'����');
          INSERT INTO subject VALUES(seq_subject.nextval,'��ѧ');
          INSERT INTO subject VALUES(seq_subject.nextval,'Ӣ��');
          
          
          --�����༶��
          CREATE TABLE CLASS(
                 cid NUMBER(3) PRIMARY KEY,      --�༶���
                 NUM NUMBER(4) NOT NULL,          --�༶����
          )
          --ALTER TABLE CLASS DROP COLUMN grade
          SELECT * FROM CLASS
          --�����������а༶��
          CREATE SEQUENCE seq_class;
          --¼����Ϣ
          INSERT INTO CLASS VALUES(seq_class.nextval,30);
          INSERT INTO CLASS VALUES(seq_class.nextval,35);
          INSERT INTO CLASS VALUES(seq_class.nextval,29);
          
          
          
          --������ʦ��
          CREATE TABLE teacher(
                 tid NUMBER(7) PRIMARY KEY,       --��ʦ����
                 tpwd VARCHAR2(16) NOT NULL,      --��ʦ����
                 tname VARCHAR2(12) NOT NULL,     --��ʦ����
                 tgender VARCHAR2(2) NOT NULL,    --��ʦ�Ա�
                 suid NUMBER(4) NOT NULL,          --ѧ��id
                 cid NUMBER(3) NOT NULL           --�༶id
          )  
          --�����������н�ʦ����
          CREATE SEQUENCE seq_teacher start with 1000000 INCREMENT BY 1;
          --¼����Ϣ
          INSERT INTO teacher VALUES(seq_teacher.nextval,'t123456','����','��','10','1');
          INSERT INTO teacher VALUES(seq_teacher.nextval,'t123456','����','��','20','2');
          INSERT INTO teacher VALUES(seq_teacher.nextval,'t123456','����','��','30','3');
          INSERT INTO teacher VALUES(seq_teacher.nextval,'t123456','����','Ů','10','3');
          
          SELECT * FROM teacher  
          
          --����ѧ����
          CREATE TABLE student(
                 SID NUMBER(5) PRIMARY KEY,              --ѧ��
                 spwd VARCHAR2(16) NOT NULL,             --ѧ������
                 sname VARCHAR2(12) NOT NULL,            --ѧ������
                 sgender VARCHAR2(2) NOT NULL,           --ѧ���Ա�
                 cid NUMBER(3) NOT NULL                  --�༶id
          )
          --������������ѧ��
          CREATE SEQUENCE seq_student start with 10000 INCREMENT BY 1;
          --¼����Ϣ
          INSERT INTO student VALUES(seq_student.nextval,'s123456','һ��ѧ��','��',1)
          INSERT INTO student VALUES(seq_student.nextval,'s123456','����ѧ��','��',2)
          INSERT INTO student VALUES(seq_student.nextval,'s123456','����ѧ��','��',3)
          INSERT INTO student VALUES(seq_student.nextval,'s123456','�ĺ�ѧ��','��',1)
          INSERT INTO student VALUES(seq_student.nextval,'s123456','���ѧ��','Ů',2)
          INSERT INTO student VALUES(seq_student.nextval,'s123456','����ѧ��','Ů',3)
          INSERT INTO student VALUES(seq_student.nextval,'s123456','�ߺ�ѧ��','Ů',1)
          INSERT INTO student VALUES(seq_student.nextval,'s123456','�˺�ѧ��','Ů',2)
          
          SELECT * FROM student 
            

--��ʦ��ϵͳ
        --����ѡ�����
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
        --������������ѡ�����
        CREATE SEQUENCE seq_xzt;
        --������Ŀ

        INSERT INTO xzt VALUES(seq_xzt.nextval,'���и�������У��д����ֵ�һ����',5,'���� ִ�� ��� ��˵���','ο�� ���� ���� �ۻ��t��','���� ���� ���� �����뻯',' ���� �¡ ��� ̾Ϊ��ֹ','ο�� ���� ���� �ۻ��t��',10);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'ѡ�����мӵ���ע��ȫ�Ե�һ��',5,'˱��(sh��n) ��Ƥ��y��n�� ��죨ch���� ��������(l��i)','ڨڨ(sh��n) ����xi��ng�� ٲȻ(y��n) �ٲ�����(j��ng)','�۱���sh���� �ɱ�bi��) ����(mi��) �з�ӯ��(f��i)','������c���� ѱ��(x��n) ���̣�y��n�� ���๷�飨zh����','�۱���sh���� �ɱ�bi��) ����(mi��) �з�ӯ��(f��i)',10);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'���и����мӵ�ʵĽ��Ͳ���ȷ��һ���ǣ�',5,'����뛴�� ������','����ɥ���޺� �����ź�','���๷��֮�� �����','��ʮ���²�ʳ�� �£���','���๷��֮�� �����',10);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'���и����С�֮�����÷���ͬ��һ���ǣ�',5,'����֮�ڹ�Ҳ','������֮��','�ǹ���֮��Ҳ','Ȼ�������ߣ�δ֮��Ҳ','Ȼ�������ߣ�δ֮��Ҳ',10);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'�������ʽ��ͬ��һ���ǣ��� ��������֮��ɣ',5,'����Ҳ����Ҳ','����֮�ҿ����޼���','����ʮ������ֹ','����֮�ˣ�ս�ڳ���','����֮�ˣ�ս�ڳ���',10);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'��ĸһ�������Ӻͷ���ֵ',5,'��������','�ɷ�����','���ɱ���','���϶�����','��������',20);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'�����εı߳����������',5,'��������','�ɷ�����','���ɱ���','���϶�����','���϶�����',20);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'һ������˳�50%�����˽�ʣ�µ�50%�����ڻ�����ԭ����ı���',5,'4:3','3:4','1:1','1:2','3:4',20);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'������������10%�������ȱ�����10%���ס����������',5,'�״�','����','�׵��ڱ�','�޷�ȷ��','�޷�ȷ��',20);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'��ʾx��y����������ϵ��ʽ����',5,'x+y=6','y=2x','xy=7','x=5/y','y=2x',20);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'You can play ____ the clean dog after class',5,'with','in','at','out','with',30);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'Is your mother ____ Huizhou? Yes,she is',5,'live','goes to','visiting','in','live',30);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'Where ____ you this morning? I ____ at a meeting',5,'were,was','are,am','do,am','were,am','were,was',30);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'Her brother is a policeman.He works in a ____',5,'post office','police station','office','station','police station',30);
        INSERT INTO xzt VALUES(seq_xzt.nextval,'What is the weather like today? It is',5,'rain','windy','sun','moon','windy',30);

        
      
        
        --�����������
        CREATE TABLE zgt (
               zgtno NUMBER(7) PRIMARY KEY,
               zgtnr VARCHAR2(1000) NOT NULL,
               val NUMBER(2) NOT NULL,
               STANDARD VARCHAR2(1000)  NOT NULL,
               suid NUMBER(4) NOT NULL
        )
        --�������������������
        CREATE SEQUENCE seq_zgt;
        --������Ŀ
        INSERT INTO zgt VALUES(seq_zgt.nextval,'�й��Ĵ�������ʲô',10,'���������塷,��ˮ䰴���,����¥�Ρ�,�����μǡ�',10);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'����¥�Ρ�������������ʲô',10,'��ʯͷ�ǡ�',10);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'��ɮ������ͽ����',10,'����գ����˽䣬ɳ����',10);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'��ˮ䰴�������λ�Ǵ�Ӣ��',10,'����',10);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'����԰�����塱��ָ������λ',10,'�����������ŷ�',10);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'8�������ĵ���������',10,'64',20);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'2003�������˿���6179300000�������ʡ�ԡ��ڡ������β��Լ�Ƕ�����',10,'61',20);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'��4ǧ���ǹ�ƽ���ֳ�5�ݣ�ÿ���ǹ��ض���ǧ��',10,'0.8',20);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'�ոպ;���ӵ����Ʊ�����ı���4:3���ո�����Ʊ64�ţ���������Ʊ������',10,'48',20);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'һ��̣��ס��Һ���6����ɣ��׵�������Ҫ10�죬�Ҷӵ�������Ҫ������',10,'15',20);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'���𳵡���Ӧ��Ӣ�ĵ�����',10,'train',30);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'���ɻ�����Ӧ��Ӣ�ĵ�����',10,'airplane',30);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'����������Ӧ��Ӣ�ĵ�����',10,'subway',30);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'����ס����Ӧ��Ӣ�ĵ�����',10,'remerber',30);
        INSERT INTO zgt VALUES(seq_zgt.nextval,'����·����Ӧ��Ӣ�ĵ�����',10,'walk',30);
        
        
      --�������Ա�
        CREATE TABLE tests(
               testsno NUMBER(4) PRIMARY KEY,
               condition NUMBER(1) DEFAULT(1)NOT NULL,
               cid NUMBER(3) NOT NULL,
               suid NUMBER(4) NOT NULL
        )
        --��������  
        CREATE SEQUENCE seq_tests;
        SELECT * FROM tests FOR UPDATE
        
        --�����������Ծ���
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
       --������������
        CREATE SEQUENCE forcorrect_tests;
        SELECT * FROM forcorrect FOR UPDATE
        SELECT * FROM forcorrect WHERE testsno=16 AND SID=10000
        --������������Ծ���
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
       --��������
        CREATE SEQUENCE seq_corrected;
        SELECT * FROM forcorrect FOR UPDATE
        
