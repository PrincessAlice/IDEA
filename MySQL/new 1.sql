//创建表之前要使用库test
use test;

//创建学生表
create table student(
	sn int,
	name varchar(20),
	accout decimal(11,2),
	sgroup int
);

1.新增
//单引号''包裹字符串
insert into student(sn,name,accout,sgroup)values
(1,'孙悟空',100.50,3);

insert into student(sn,name,accout,sgroup)values
(2,'猪八戒',52.1,3),
(3,'沙和尚',99,3),
(4,'唐僧',21.01,2);

2.查询(select/from)
//查全部
select *from student;
//查询某一项
select sn,name,accout,sgroup from student;
select sn,name,accout from student;

//修改表头名称
select sn,name,accout+200 from student; 

//别名(结果集表头列的别名)：
select sn,name,accout+200 as acc from student;
select sn,name,accout+200 acc from student;

//运算
select sn,name,accout+sn acc from student;

//创建学生成绩表
create table exam_result(
	id int,
	sn int,
	name varchar(20),
	chinese decimal(3,1),
	math decimal(3,1),
	english decimal(3,1),
	history decimal(3,1),
	computer decimal(3,1)
);

insert into exam_result(name,chinese,math,english,history,computer)values
('小毛驴',98,99,98,95,99),
('小公猪',99,98,97,95,96),
('胖虎',99,96,97,98,99);

insert into exam_result(id,sn,name,chinese,math,english,history,computer)values
(115,4,'小鸡仔',98,99,98,95,99),
(115,5,'大黄',99,98,97,95,96),
(115,6,'牛宝宝',99,96,97,98,99);

//根据表头某一项进行排序
//asc 升序,desc 降序,不写默认升序
select *from exam_result order by chinese asc;
select *from exam_result order by chinease desc;

//java 排序
Collection.sort(list,new Comparetor(){...});
Comparetor

//where条件查询
select *from exam_result where id is null;
select *from exam_result where name like '小%';
select *from exam_result where name like '小_';

//多条件查询
where 条件1 or 条件2
java: if(条件1 || 条件2)

where 条件1 and (条件2 or 条件3)
java：if(条件1 &&(条件2 || 条件3))

//查询满足语文成绩大于70分并且(数学成绩小于85分或者英语成绩大于60分)
select *from exam_result where chinese>70 and (math<85 or english>60);
//满足上面条件且降序排列
select *from exam_result where chinese>70 and (math<85 or english>60) order by math desc;

//分页查询：limit
select *from exam_result limit 3;
select *from exam_result limit 2,3;
select *from exam_result limit 3 offset 2;

//查找作用相同
select *from exam_result where sn in(2,4);
select *from exam_result where sn=2 or sn=4;

//查询满足(**德或是孙**)并且(数学成绩大于75分或者英语成绩小于60分)
select *from exam_result where (name like '%德' or name like '孙%') and (math>75 or english<60);

//修改表里的值
update exam_result set id=1 where name='小毛驴';


//boolean——bit 默认值1
1.定义表
create table DaughterC(
	id int,
	name varchar(20),
	sex bit,  
	email varchar(50),
	creat_time timestamp,
	age int
);
2.插入excel数据
insert into DaughterC(id,name,sex,email,creat_time,age)values
(null,'w1',0,null,20190917,21),
(null,'w2',0,null,20190917,32),
(null,'w3',1,null,20190917,45),
(null,'w4',1,null,20190918,55),
(null,'w5',0,null,20190918,60),
(null,'w6',0,null,20190918,19),
(null,'w7',1,null,20190918,50),
(null,'w8',0,null,20190918,52),
(null,'w9',0,null,20190919,15),
(null,'w10',1,null,20190919,36),
(null,'w11',1,null,20190919,25);
3.查询：年龄在30岁以下的女孩子
select *from DaughterC where age<30 and sex=0;

4.修改：年龄在50岁以上的人，email改成50@qq.com
update DaughterC set email='50@qq.com' where age>50;

5.删除：年龄在30岁~40岁之间的女的
delete from DaughterC where (age between 30 and 40) and sex =0;


