
-- Include table data insertion, updation, deletion and select scripts

-- -------------------------------------------------------------------------------------
-- Adding Admin MenuItems IN Table
-- -------------------------------------------------------------------------------------

select *from menu_item;

insert into menu_item values
(1, 'Sandwich', 99.0,'Yes','2017-03-15','Main Course','Yes');
insert into menu_item values
(2, 'Burger', 129.0, 'Yes', '2017-12-23','Main Course', 'No'),
(3, 'Pizza', 149.0, 'Yes', '2018-08-21', 'Main Course', 'No'),
(4, 'French Fries', 57.0, 'No', '2017-07-02','Starters','Yes'),
(5, 'Chocolate Brownie', 32.0, 'Yes','2022-11-02','Dessert', 'Yes');


-- Display Admin List

select *from menu_item;

-- --------------------------------------------------------------------------------------
-- Update MenuItem
-- --------------------------------------------------------------------------------------

update menu_item
set me_name ='Biryani'
where me_id= 1;

-- Display Admin List

select *from menu_item;

-- --------------------------------------------------------------------------------------
-- Creating Users
-- --------------------------------------------------------------------------------------

insert into user(us_id,us_name)
values
(1,'Yigrette'),
(2,'Jon Snow');

-- Display User List

select *from user;

-- --------------------------------------------------------------------------------------
-- Customer Menu Item List
-- --------------------------------------------------------------------------------------

 select me_name, me_free_delivery, me_price, me_category 
 from menu_item 
 where me_active='Yes' and me_date_of_launch  <= (select(curdate())); 

-- --------------------------------------------------------------------------------------
-- Inserting Items in Cart
-- --------------------------------------------------------------------------------------

insert into cart(ct_us_id,ct_pr_id)
values (1,3);
insert into cart(ct_us_id,ct_pr_id)
values (1,4);

-- insert into cart(ct_us_id,ct_pr_id) values (1,3);

-- --------------------------------------------------------------------------------------
-- To Display Cart with ID
-- --------------------------------------------------------------------------------------

select *from cart;

-- --------------------------------------------------------------------------------------
--  To View Cart after Adding
-- --------------------------------------------------------------------------------------

select me_name,me_free_delivery, me_price 
from menu_item
inner join cart on ct_pr_id=me_id
where ct_us_id=1;

-- Total Calculation

select sum(me_price) as Total 
from menu_item
inner join cart on ct_pr_id=me_id
where ct_us_id=1;


-- --------------------------------------------------------------------------------------
-- To Delete an Item From Cart
-- --------------------------------------------------------------------------------------

delete from cart
where ct_us_id=1
and ct_pr_id=3
limit 1;

-- --------------------------------------------------------------------------------------
--  To View Cart after Deleting
-- --------------------------------------------------------------------------------------

select me_name,me_free_delivery, me_price 
from menu_item
inner join cart on ct_pr_id=me_id
where ct_us_id=1;

-- Total Calculation

select sum(me_price) as Total 
from menu_item
inner join cart on ct_pr_id=me_id
where ct_us_id=1;

-- --------------------------------------------------------------------------------------
-- To Display Cart with ID After Deleting
-- --------------------------------------------------------------------------------------

select *from cart;

-- -------------------------------------------------------------------------------------