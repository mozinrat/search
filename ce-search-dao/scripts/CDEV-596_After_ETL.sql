--16. Deleting old entries
delete from ref_search_attributes where parentsearchattributeid  in (select searchattributeid  from ref_search_attributes where code in ('PRODUCTFAMILY', 'MANUFACTURER')) and parentsearchattributeid <> searchattributeid;

--17. INSERTing Product family options
insert into ref_search_attributes select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute  where name='PRODUCTFAMILY'), (select searchattributeid from ref_search_attributes  where CODE='PRODUCTFAMILY'),COALESCE(pro.ranking,1000), mm.productfamily, true, mm.programcategoryid, null, mm.label from
(
SELECT DISTINCT mm.productfamily AS productfamily
		,pmm.programcategoryid programcategoryid
		,mm.productfamily AS help_text
		,mm.productfamily AS label
		
	FROM ref_manufacturermodel mm
	INNER JOIN ref_program_manufacturer_model pmm ON mm.manufacturermodelid = pmm.manufacturermodelid
	INNER JOIN ref_program_category procat ON procat.programcategoryid = pmm.programcategoryid
	INNER JOIN ref_program pro ON pro.programid = procat.programid
	INNER JOIN ref_category cat ON procat.categoryid = cat.categoryid
	INNER JOIN ref_manufacturer manu on manu.manufacturerid= mm.manufacturerid
	WHERE pro.programname = 'ATT'
		AND cat.code = 'CELLPHONE' and mm.productfamily is not null and trim(mm.productfamily)!=''
		) mm
LEFT JOIN (
	SELECT distinct value, rp.ranking as ranking
	FROM ref_prioritization rp
	INNER JOIN ref_prioritizationtype rpt ON rpt.prioritizationtypeid = rp.prioritizationtypeid
	INNER JOIN ref_attribute ra ON ra.attributeid = rpt.attributeid
	WHERE ra.NAME = 'PRODUCTFAMILY'
	) pro ON mm.productfamily = pro.value;

--18. INSERTing manufacturer options
insert into ref_search_attributes select nextval('ref_search_attributes_seq'), (select attributeid from ref_attribute  where name='MANUFACTURER'), (select searchattributeid from ref_search_attributes  where CODE='MANUFACTURER'),COALESCE(pro.ranking,1000), mm.code, true, mm.programcategoryid, null, mm.label from
(
	SELECT DISTINCT manu.code AS code
		,pmm.programcategoryid programcategoryid
		,manu.description AS help_text
		,manu.description AS label
	FROM ref_manufacturermodel mm
	INNER JOIN ref_program_manufacturer_model pmm ON mm.manufacturermodelid = pmm.manufacturermodelid
	INNER JOIN ref_program_category procat ON procat.programcategoryid = pmm.programcategoryid
	INNER JOIN ref_program pro ON pro.programid = procat.programid
	INNER JOIN ref_category cat ON procat.categoryid = cat.categoryid
	INNER JOIN ref_manufacturer manu on manu.manufacturerid= mm.manufacturerid
	WHERE pro.programname = 'ATT'
		AND cat.code = 'CELLPHONE'
	) mm
LEFT JOIN (
	SELECT distinct value, rp.ranking as ranking
	FROM ref_prioritization rp
	INNER JOIN ref_prioritizationtype rpt ON rpt.prioritizationtypeid = rp.prioritizationtypeid
	INNER JOIN ref_attribute ra ON ra.attributeid = rpt.attributeid
	WHERE ra.NAME = 'MANUFACTURER'
	) pro ON mm.code = pro.value;