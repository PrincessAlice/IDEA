

1.SPU表来表示产品(1spu对多个sku)
2.SKU来表示产品具体规格型号
3.动态属性(key)(1个动态属性对应多个属性值)
4.东塔属性值(value)
	网络类型-电信/移动
	颜色-白色...
	
动态属性 KEY-Value 结果对应SKU关联，多对1的关系

create table spu(
	id
	name

)

create table sku(

)


create table att_key(
	--版本
	--网络类型
	--机身颜色
)

--attr_key 关联 attr_value
create table attr_value(
	--iphone 11 Pro
	--iphone 11 Pro Max
	--金色
	--银色
	--。。。
)

create table product_item(
	sku
	attr_value

)

