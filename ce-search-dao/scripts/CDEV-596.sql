-- Need to execute this queries after First build of main application and ETL job.
--1. Inserting PRODUCT. If not exists
insert into ref_search_attributes 
select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute  where name= 'PRODUCT'), null, 10, 'PRODUCT', true, (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'), 'This is a tooltip. Lorem ipsum dolor sit amet, consectetur adipiscing elit.<br/>Donec in mauris sed lorem tristique commodo. Mauris scelerisque pretium augue suscipit mollis.', 'What would you like to trade?'
where not exists(select * from ref_search_attributes where code= 'PRODUCT' and programcategoryid= (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'));

--2. Inserting PRODUCT-IPHONE. If not exists
insert into ref_search_attributes 
select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute where name= 'PRODUCT'), (select searchattributeid from ref_search_attributes  where code ='PRODUCT'), 10, 'IPHONE', true, (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'), null, 'iPhone'
where not exists(select * from ref_search_attributes where code= 'IPHONE' and programcategoryid= (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'));

--3. Inserting PRODUCT-SMARTPHONE. If not exists
insert into ref_search_attributes 
select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute where name= 'PRODUCT'), (select searchattributeid from ref_search_attributes  where code ='PRODUCT'), 20, 'SMARTPHONE', true, (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'), null, 'Smartphone'
where not exists(select * from ref_search_attributes where code= 'SMARTPHONE' and programcategoryid= (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'));

--4. Inserting PRODUCT-TABLET. If not exists
insert into ref_search_attributes 
select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute where name= 'PRODUCT'), (select searchattributeid from ref_search_attributes  where code ='PRODUCT'), 30, 'TABLET', true, (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'), null, 'Tablet'
where not exists(select * from ref_search_attributes where code= 'TABLET' and programcategoryid= (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'));

--5. Inserting PRODUCT-FEATUREPHONE. If not exists
insert into ref_search_attributes 
select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute where name= 'PRODUCT'), (select searchattributeid from ref_search_attributes  where code ='PRODUCT'), 40, 'FEATUREPHONE', true, (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'), null, 'Feature Phone'
where not exists(select * from ref_search_attributes where code= 'FEATUREPHONE' and programcategoryid= (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'));

--6. Inserting PRODUCT-OTHER. If not exists
insert into ref_search_attributes 
select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute where name= 'PRODUCT'), (select searchattributeid from ref_search_attributes  where code ='PRODUCT'), 50, 'OTHER', true, (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'), null, 'Other'
where not exists(select * from ref_search_attributes where code= 'OTHER' and programcategoryid= (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE') and parentsearchattributeid= (select searchattributeid from ref_search_attributes  where code ='PRODUCT'));

--7. Inserting CARRIER. If not exists
insert into ref_search_attributes 
select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute  where name= 'CARRIER'), null, 20, 'CARRIER', true, (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'), 'This is a tooltip. Lorem ipsum dolor sit amet, consectetur adipiscing elit.<br/>Donec in mauris sed lorem tristique commodo. Mauris scelerisque pretium augue suscipit mollis.', 'Who is your carrier?'
where not exists(select * from ref_search_attributes where code= 'CARRIER' and programcategoryid= (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'));

--8. Inserting CARRIER-AT&T. If not exists
insert into ref_search_attributes 
select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute  where name= 'CARRIER'), (select searchattributeid from ref_search_attributes  where code ='CARRIER'), 10, 'AT&T', true, (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'), null, 'AT&T'
where not exists(select * from ref_search_attributes where code= 'AT&T' and programcategoryid= (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'));

--9. Inserting CARRIER-Sprint. If not exists
insert into ref_search_attributes 
select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute  where name= 'CARRIER'), (select searchattributeid from ref_search_attributes  where code ='CARRIER'), 20, 'Sprint', true, (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'), null, 'Sprint'
where not exists(select * from ref_search_attributes where code= 'Sprint' and programcategoryid= (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'));

--10. Inserting CARRIER-T-Mobile. If not exists
insert into ref_search_attributes 
select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute  where name= 'CARRIER'), (select searchattributeid from ref_search_attributes  where code ='CARRIER'), 30, 'T-Mobile', true, (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'), null, 'T-Mobile'
where not exists(select * from ref_search_attributes where code= 'T-Mobile' and programcategoryid= (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'));

--11. Inserting CARRIER-Verizon. If not exists
insert into ref_search_attributes 
select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute  where name= 'CARRIER'), (select searchattributeid from ref_search_attributes  where code ='CARRIER'), 40, 'Verizon', true, (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'), null, 'Verizon'
where not exists(select * from ref_search_attributes where code= 'Verizon' and programcategoryid= (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'));

--12. Inserting CARRIER-OTHER. If not exists
insert into ref_search_attributes 
select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute  where name= 'CARRIER'), (select searchattributeid from ref_search_attributes  where code ='CARRIER'), 50, 'Other', true, (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'), null, 'Other'
where not exists(select * from ref_search_attributes where code= 'Other' and programcategoryid= (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE') and parentsearchattributeid= (select searchattributeid from ref_search_attributes  where code ='CARRIER'));

--13. Inserting CARRIER-None/wifi. If not exists
insert into ref_search_attributes 
select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute  where name= 'CARRIER'), (select searchattributeid from ref_search_attributes  where code ='CARRIER'), 60, 'None/Wifi Only', true, (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'), null, 'None/Wifi Only'
where not exists(select * from ref_search_attributes where code= 'None/Wifi Only' and programcategoryid= (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'));

--14. Inserting MANUFACTURER. If not exists
insert into ref_search_attributes 
select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute  where name= 'MANUFACTURER'), null, 30, 'MANUFACTURER', true, (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'), 'This is a tooltip. Lorem ipsum dolor sit amet, consectetur adipiscing elit.<br/>Donec in mauris sed lorem tristique commodo. Mauris scelerisque pretium augue suscipit mollis.', 'Who is your manufacturer?'
where not exists(select * from ref_search_attributes where code= 'MANUFACTURER' and programcategoryid= (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'));

--15. Inserting PRODUCTFAMILY. If not exists
insert into ref_search_attributes 
select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute  where name= 'PRODUCTFAMILY'), null, 40, 'PRODUCTFAMILY', true, (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'), 'This is a tooltip. Lorem ipsum dolor sit amet, consectetur adipiscing elit.<br/>Donec in mauris sed lorem tristique commodo. Mauris scelerisque pretium augue suscipit mollis.', 'What is your model type?'
where not exists(select * from ref_search_attributes where code= 'PRODUCTFAMILY' and programcategoryid= (select programcategoryid from ref_program_category  pc join ref_program pro on pc.programid= pro.programid join ref_category cat on pc.categoryid= cat.categoryid where pro.programname='ATT' and cat.code= 'CELLPHONE'));