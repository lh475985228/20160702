
create table t_user2 (

  id int primary key auto_increment,
  
  username varchar(8) not null,
  
  password  varchar(16) not null,
  
  age int not null,
  
  sex int not null,
  
  phone varchar(20),
  
  salary double(10,2)
  
)

删除表

drop table t_user2



插入数据

 insert into 
 t_user2
 (username,password,age,sex,phone,salary)
 values
 
 ('wlq','12456',34,0,'0335-3042566',233)
 

数据的删除

 
  delete from t_user2 [where 条件]

  条件表达式   = <> , >, >=, <, <= ,like,
  
   not like,is null
   
   is not null,  between and,
   
   not between and  in ,not in


   delete from t_user2 where salary is null
   
   delete from t_user2 where age between 30 and 34
   
   delete from t_user2 where username like 'j%' 

   delete from t_user2 where username in('wangwu','zsf','dddd')
   
   多个并列条件 
    
      and(与)   or(或)
      
delete from t_user2 where age between 30 and 40 or sex=0 



数据的更新

update t_user2 set username='xx',age=20 [where 条件]

update t_user2 set username='xw' where id=4



数据的查询

select username,age from t_user2

select * from t_user2

select * from t_user2 where sex=0 and age between 20 and 30

查询数据

select * from t_user2 where id=1

排序

select username,age from t_user2 order by age desc  --asc


select username,age from t_user2 where sex=0 order by age desc




聚合函数和分组

max min avg count sum // group by 

select count(*) from t_user2 where sex=0

select max(age) from t_user2 where sex=0

select count(*),sex from t_user2 group by sex

select max(age),sex from t_user2 group by sex

select count(*),max(age),sex from t_user2 group by sex

select avg(salary),sex from t_user2 group by sex


select sum(salary),avg(salary),sex from t_user2 group by sex

select avg(salary),sex from t_user2 where salary >100 group by sex


select avg(salary),sex from t_user2 where salary >100 group by sex having avg(salary)>220 order by avg(salary) desc


create table t_info (

  id int primary key auto_increment,
  
  classname varchar(20),
  
  studentname varchar(8),
  
  sex int,
  
  age int



)


create table t_class (

  id int primary key auto_increment,
  
  classname varchar(20)


)

create table t_student(
  id int primary key auto_increment,
  
  name varchar(8),
  
  age int,
  
  sex int,
  
  classid int


)

create table t_teacher(

  id int primary key auto_increment,
  
  
  teachername varchar(20)



)

create table t_t_s(

  sid int,
  
  tid int


)

alter table t_t_s add constraint primary key (sid,tid)

alter table t_t_s add constraint gbfk02 foreign key (sid) references t_student(id)

alter table t_t_s add constraint gbfk03 foreign key (tid) references t_teacher(id)


select  t_student.*  from
  t_class
 
  inner join
  
  t_student 
   
   on t_class.id = t_student.classid
   
  where t_class.classname='class1'


  select t_student.*  from t_teacher INNER join t_t_s on t_teacher.id=t_t_s.tid inner join t_student on t_t_s.sid=t_student.id
  
  where t_teacher.teachername='MR.GUAN'
  
  
  
    
  select  count(*) ,classname  from t_class inner join t_student on t_class.id=t_student.classid group by classname
  
  
    
    select * from 
    t_student 
    where classid
    
     in
     
      (select id from  t_class where classname='class1')
    
  
  
  
  
  
  select * from t_student
  where id
  
   in
  
  (select sid from t_t_s where tid
  
    in 
    
    
    (select id from t_teacher where teachername='MR.GUAN')
  )

