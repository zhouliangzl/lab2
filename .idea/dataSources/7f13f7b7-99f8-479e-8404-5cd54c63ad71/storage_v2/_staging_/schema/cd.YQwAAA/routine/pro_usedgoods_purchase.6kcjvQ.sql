create procedure PRO_usedGoods_Purchase(IN inuid varchar(11), IN ingid int)
  label:BEGIN
    -- 声明变量 账户余额、商品价格、商品状态
    DECLARE decoin int;
    DECLARE deprice int;
    DECLARE destate int;
    -- 获取变量值
    SELECT coin into decoin  FROM  user  WHERE uid = inuid;
    SELECT price into deprice  FROM  usedgoods  WHERE  gid  = ingid;
    SELECT gstatus into destate  FROM  usedgoods  WHERE  gid  = ingid;
    -- 账户余额小于商品价格
    IF decoin < deprice  THEN
      # '您的账户余额不足！'
      ROLLBACK;
      LEAVE label;
    END IF;
    -- 商品已被出售
    IF destate != 0 THEN
      # '该商品已出售'
      ROLLBACK;
      LEAVE label;
    END IF;
    IF decoin > deprice THEN
      -- 账户上扣除商品价格
      UPDATE user SET coin = decoin-deprice  WHERE uid = inuid;
      -- 置商品为已售
      UPDATE usedGoods SET gstatus = 1 WHERE  gid  = ingid;
      -- 添加纪录到goodsOrder商品订单表
      #       INSERT INTO goodsOrder(gid,otime,uid) VALUES(ingid,DATE(CURDATE()),inuid);
      -- 成功执行存储过程
    END IF;
  END;

